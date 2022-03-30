package com.kq.app;


import com.kq.app.service.ApplicatiionService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kq
 * @date 2022-03-29 16:49
 * @since 2020-0630
 */


public class MybatisPlusImportApplicationTest extends MybatisPlusImportApplicationBaseTest{

    String path = "E:\\k12_doc\\trunk\\01.开发库\\050.编码\\01_数据库脚本\\K12\\K12应用数据.xlsx";

    @Autowired
    private ApplicatiionService applicatiionService;

//    @BeforeClass // 全局只会执行一次，而且是第一个运行  需要static

    @Before // 在测试方法运行之前运行
    public void before() {
        applicatiionService.delete();
    }

    @Test
    public void testSaveRBApplication() throws Exception{

        System.out.println("applicatiionService="+applicatiionService);

        applicatiionService.save(path);

    }

}
