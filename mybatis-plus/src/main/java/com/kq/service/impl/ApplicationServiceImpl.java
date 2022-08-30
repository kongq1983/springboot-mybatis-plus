package com.kq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kq.entity.Application;
import com.kq.mapper.ApplicationMapper;
import com.kq.service.IApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 平台应用表 服务实现类
 * </p>
 *
 * @author hzsun
 * @since 2022-03-26
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements IApplicationService {


    @Override
    public Long getMaxId() {
        LambdaQueryWrapper<Application> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Application :: getId).last("LIMIT 1");

        Application application = this.getOne(lambdaQueryWrapper,false);
        if(application==null) {
            return 1L;
        }

        return  application.getId()+1L;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveApp(Application app) {
        app.setId(this.getMaxId());
        this.save(app);
    }

    @Override
    public void saveAppNo(Application app) {
        app.setId(this.getMaxId());
        this.save(app);
    }
}
