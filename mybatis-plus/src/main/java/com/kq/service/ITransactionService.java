package com.kq.service;

import com.kq.dto.User;
import com.kq.entity.Application;

/**
 * @author kq
 * @date 2022-08-29 15:23
 * @since 2020-0630
 */
public interface ITransactionService {

    /**
     * 无事务注解
     * @param application
     * @param user
     */
    public void saveNoTransaction(Application application, User user);


    /**
     * 代理有事务
     * 无事务注解
     * @param application
     * @param user
     */
    public void saveNoTransaction1(Application application, User user);

    /**
     * 最外层没事务
     * 里面每个servciey有事务
     * @param application
     * @param user
     */
    public void saveNoTransaction2(Application application, User user);

    /**
     * 最外层没事务
     * 最后1个有servcie有事务
     * @param application
     * @param user
     */
    public void saveNoTransaction3(Application application, User user);


    /**
     * 有事务注解
     * @param application
     * @param user
     */
    public void saveWithTransaction(Application application, User user);


}
