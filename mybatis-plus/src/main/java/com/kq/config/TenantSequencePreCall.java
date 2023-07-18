package com.kq.config;

import com.kq.service.ITenantSequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: kq
 * @date: 2023-07-18 15:08:46
 * @since: 1.0.0
 * @description:
 */
@Component
@Slf4j
public class TenantSequencePreCall implements ApplicationContextAware, SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {

        ITenantSequenceService tenantSequenceService = applicationContext.getBean(ITenantSequenceService.class);

        Runnable runnable = ()->{

            log.debug("start before callDefaultSequence");

            tenantSequenceService.callDefaultSequence();
        };

        new Thread(runnable).start();

    }

    /**
     * applicationContext
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TenantSequencePreCall.applicationContext = applicationContext;
    }
}
