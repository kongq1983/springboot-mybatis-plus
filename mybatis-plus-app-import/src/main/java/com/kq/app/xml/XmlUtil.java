package com.kq.app.xml;

import com.kq.app.entity.PmApplication;
import com.kq.app.entity.PmApplicationFunction;
import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kq
 * @date 2022-03-09 15:22
 * @since 2020-0630
 */
public class XmlUtil {

    public static void main(String[] args) throws Exception{
        String str = "APPLICATION000000000000000000001";
        System.out.println(str.length());

        String str1 = "APPLICATIONFUNCTION0000000000001";
        System.out.println(str1.length());

        List<PmApplication> list = parse();

        System.out.println("start=============================");
        for(PmApplication pm : list) {
            System.out.println(pm);
        }
        System.out.println("e-n-d=============================");
    }



    public static List<PmApplication> parse() throws Exception{

        List<PmApplication> bookList = new ArrayList();

        // 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
//            Document document = reader.read(new File("src/res/books.xml"));
            Document document = reader.read(XmlUtil.class.getResourceAsStream("/app.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = bookStore.elementIterator();
            // 遍历迭代器
            while (it.hasNext()) {
                Element book = (Element) it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> bookAttrs = book.attributes();

                PmApplication application = new PmApplication();
                bookList.add(application);

                for (Attribute attr : bookAttrs) {
                    System.out.println("PmApplication-属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                    // 设置application的id  // 设置PmApplication的id值
                    BeanUtils.copyProperty(application,attr.getName(),attr.getValue());

                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();


                    if(bookChild.getName().equals("applicationfunctions")) {
                        List<PmApplicationFunction> functionList = parseFunctions(bookChild.elementIterator());

                        if(functionList!=null) {
                            for(PmApplicationFunction pf : functionList) {
                                pf.setApplicationId(application.getId());
                            }
                        }

                        application.setFunctionList(functionList);

                    } else {
                        // 设置PmApplication的属性值(除id外)
                        BeanUtils.copyProperty(application,bookChild.getName(),bookChild.getStringValue());
//                        System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                    }

                }
                System.out.println("=====结束遍历某一本书=====");


            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    // 解析applicationfunction  id 节点
    public static List<PmApplicationFunction> parseFunctions(Iterator<Element> element) throws Exception {
        while (element.hasNext()) {
            Element itt = (Element) element.next();
            String id = itt.attributeValue("id");
//            System.out.println("child节点名：" + itt.getName() + "--节点值：" + itt.getStringValue());
            System.out.println("applicationfunction.id ：" + itt.getName() + "--节点值：" + id);

            PmApplicationFunction function = new PmApplicationFunction();
            function.setId(id);

            parseFunctionAttr(function,itt.elementIterator());

            System.out.println("===================================function = "+function);
        }
        return null;
    }


    // 解析applicationfunction attr节点
    public static void parseFunctionAttr(PmApplicationFunction function,Iterator<Element> element) throws Exception {
        while (element.hasNext()) {
            Element itt = (Element) element.next();
            System.out.println("attr节点名：" + itt.getName() + "--节点值：" + itt.getStringValue());

            BeanUtils.copyProperty(function,itt.getName(),itt.getStringValue());

//            BeanUtils.copy(itt.getName(),function);

        }
    }


}
