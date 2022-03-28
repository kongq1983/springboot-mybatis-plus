package com.kq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kq.entity.Application;
import com.kq.mapper.ApplicationMapper;
import com.kq.service.IApplicationService;
import org.springframework.stereotype.Service;

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

}
