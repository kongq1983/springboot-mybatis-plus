package com.kq.tool.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;

/**
 * @author kq
 * @date 2022-05-10 17:40
 * @since 2020-0630
 */
public class CompressPhotoUtil {

    public static void  simpleCompress(File from,File to) throws Exception{
        Thumbnails.of(from)
                .size(160, 160)
                .toFile(to);
    }

    public static void  simpleCompress(File from,File to,int width,int height) throws Exception{
        Thumbnails.of(from)
                .size(width, height)
                .toFile(to);
    }

    public static void  simpleCompress(String from,String to) throws Exception{

        Thumbnails.of(from)
                .size(160, 160)
                .toFile(to);

    }

    public static void compressDirectory(File directory) throws Exception{

        Thumbnails.of(directory.listFiles()).size(640, 480)
                .outputFormat("jpg")
                .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

    }


    public static String commpressPicForSize(String srcPath, String desPath,
                                             long desFileSize, double accuracy) {

        if(srcPath==null||srcPath.trim().length()==0) {

        }

        if(desPath==null||desPath.trim().length()==0) {

        }

        if (!new File(srcPath).exists()) {
            return null;
        }
        try {
            File srcFile = new File(srcPath);
            long srcFileSize = srcFile.length();
            System.out.println("源图片：" + srcPath + "，大小：" + srcFileSize / 1024
                    + "kb");

            // 1、先转换成jpg
            Thumbnails.of(srcPath).scale(1f).toFile(desPath);
            // 递归压缩，直到目标文件大小小于desFileSize
            commpressPicCycle(desPath, desFileSize, accuracy);

            File desFile = new File(desPath);
            System.out.println("目标图片：" + desPath + "，大小" + desFile.length()
                    / 1024 + "kb");
            System.out.println("图片压缩完成！");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return desPath;
    }



    /**
     * 图片压缩:按指定大小把图片进行缩放（会遵循原图高宽比例）
     * 并设置图片文件大小
     */
    private static void commpressPicCycle(String desPath, long desFileSize,
                                          double accuracy) throws Exception {
        File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = srcFileJPG.length();
        // 2、判断大小，如果小于指定大小，不压缩；如果大于等于指定大小，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(srcFileJPG);
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        int desWidth = new BigDecimal(srcWdith).multiply(
                new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeigth).multiply(
                new BigDecimal(accuracy)).intValue();

        Thumbnails.of(desPath).size(desWidth, desHeight)
                .outputQuality(accuracy).toFile(desPath);
        commpressPicCycle(desPath, desFileSize, accuracy);
    }


    public static void main(String[] args) throws Exception{
        File from = new File("D:\\back\\photo","r.jpg");
        File to = new File("D:\\back\\photo","r_to.jpg");
        File to2 = new File("D:\\back\\photo","r_to2.jpg");
        File to3 = new File("D:\\back\\photo","r_to3.jpg");
        File to4 = new File("D:\\back\\photo","r_to4.jpg");
        File to5 = new File("D:\\back\\photo","r_to5.jpg");

        simpleCompress(from,to);
        simpleCompress(from,to2,800,600);
        simpleCompress("D:\\back\\photo\\r.jpg","D:\\back\\photo\\r_to1.jpg");

        compressDirectory(new File("D:\\back\\photo1"));

        commpressPicForSize(from.getAbsolutePath(),to3.getAbsolutePath(),50,0.25);
        commpressPicForSize(from.getAbsolutePath(),to4.getAbsolutePath(),50,0.5);
        commpressPicForSize(from.getAbsolutePath(),to5.getAbsolutePath(),50,1);

        // https://github.com/coobird/thumbnailator/wiki/Examples

    }

}
