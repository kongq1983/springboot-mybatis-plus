package com.kq.app.excel;

import com.github.crab2died.ExcelUtils;
import com.kq.app.dto.PmApplicationDto;

import java.util.List;

/**
 * @author kq
 * @date 2022-03-29 16:20
 * @since 2020-0630
 */
public class ExcelUtil {

    public static List<PmApplicationDto> getRBApplicationList(String path) throws Exception{

        List<PmApplicationDto> students = ExcelUtils.getInstance().readExcel2Objects(path, PmApplicationDto.class,0,0);

        return students;

    }

    public static List<PmApplicationDto> getXYApplicationList(String path) throws Exception{

    List<PmApplicationDto> students = ExcelUtils.getInstance().readExcel2Objects(path, PmApplicationDto.class,0,1);

        return students;

    }

}
