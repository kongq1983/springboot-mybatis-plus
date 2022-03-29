package com.kq.app.excel;

import com.kq.app.dto.PmApplicationDto;

import com.github.crab2died.ExcelUtils;


import java.util.List;

/**
 * @author kq
 * @date 2022-03-29 15:48
 * @since 2020-0630
 */
public class ExcelTest {


    public static void main(String[] args) throws Exception{

        String path = "E:\\k12_doc\\trunk\\01.开发库\\050.编码\\01_数据库脚本\\K12\\K12应用数据.xlsx";

//        List<PmApplicationDto> students = ExcelUtils.getInstance().readExcel2ObjsByClasspath(path, PmApplicationDto.class);

        List<PmApplicationDto> students = ExcelUtils.getInstance().readExcel2Objects(path, PmApplicationDto.class,0,0);

        students.stream().forEach(c->{
            System.out.println(c);
        });

    }


}
