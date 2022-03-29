package com.kq.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kq.app.dao.PmAppFuncMapper;
import com.kq.app.dao.PmApplicationMapper;
import com.kq.app.dto.PmApplicationDto;
import com.kq.app.entity.PmAppFunc;
import com.kq.app.entity.PmApplication;
import com.kq.app.service.ApplicatiionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.kq.app.excel.ExcelUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kq
 * @date 2022-03-29 16:17
 * @since 2020-0630
 */

@Service
public class ApplicatiionServiceImpl extends ServiceImpl<PmApplicationMapper, PmApplication> implements ApplicatiionService {

    Map<String,String> map = new HashMap<>();


    @Override
    public void delete() {
        this.baseMapper.delete(null);
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(String path) throws Exception{

        List<PmApplicationDto> applications = ExcelUtil.getRBApplicationList(path);


        for(PmApplicationDto pm : applications) {
            pm.setId(pm.getAppId());
            pm.setCategoryId("rbyy00c0af6d11ec8cb8005056bd1f63");
            pm.setAppType("1"); // 管理系统
            pm.setDeployType("1"); // 本地部署
            pm.setIsDeleted(0);
            pm.setVersion(1);
            pm.setShortName(pm.getName());
            pm.setIsUsing(1);
            pm.setCreateUser("0");
            pm.setEditUser("0");

            PmApplication application = new PmApplication();
            BeanUtils.copyProperties(pm,application);

            this.baseMapper.insert(application);
        }

        // getXYApplicationList


        List<PmApplicationDto> xyapplications = ExcelUtil.getXYApplicationList(path);


        for(PmApplicationDto pm : xyapplications) {
            pm.setId(pm.getAppId());
            pm.setCategoryId("xyyy57e2af6d11ec8cb8005056bd1f63");
            pm.setAppType("1"); // 管理系统
            pm.setDeployType("2"); // 本地部署
            pm.setIsDeleted(0);
            pm.setVersion(1);
            pm.setShortName(pm.getName());
            pm.setIsUsing(1);
            pm.setCreateUser("0");
            pm.setEditUser("0");

            PmApplication application = new PmApplication();
            BeanUtils.copyProperties(pm,application);

            this.baseMapper.insert(application);
        }


    }


}
