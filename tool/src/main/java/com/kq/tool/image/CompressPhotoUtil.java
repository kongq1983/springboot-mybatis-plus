package com.kq.tool.image;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;

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

    public static void main(String[] args) throws Exception{
        File from = new File("D:\\back\\photo","r.jpg");
        File to = new File("D:\\back\\photo","r_to.jpg");
        File to2 = new File("D:\\back\\photo","r_to2.jpg");

        simpleCompress(from,to);
        simpleCompress(from,to2,800,600);
        simpleCompress("D:\\back\\photo\\r.jpg","D:\\back\\photo\\r_to1.jpg");

        // https://github.com/coobird/thumbnailator/wiki/Examples

    }

}
