package com.kq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kq.entity.Application;

/**
 * <p>
 * 平台应用表 服务类
 * </p>
 *
 * @author hzsun
 * @since 2022-03-26
 */
public interface IApplicationService extends IService<Application> {


    public Long getMaxId();

    public void saveApp(Application app);


    public void saveAppNo(Application app);

}
