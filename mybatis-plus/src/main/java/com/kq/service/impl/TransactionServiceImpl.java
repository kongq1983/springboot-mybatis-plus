package com.kq.service.impl;

import com.kq.dto.User;
import com.kq.entity.Application;
import com.kq.service.IApplicationService;
import com.kq.service.ITransactionService;
import com.kq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author kq
 * @date 2022-08-29 15:25
 * @since 2020-0630
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private IApplicationService applicationService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITransactionService transactionService;

    @Override
    public void saveNoTransaction(Application application, User user) {

        this.saveWithTransaction(application,user); // 有Transactional

        // 结论: 不会回滚  代理问题,通过this调用

    }

    /**
     * 外层没事务
     * 里层有事务
     * 最终结论: 还是有事务
     * @param application
     * @param user
     */
    @Override
    public void saveNoTransaction1(Application application, User user) {
        // 有事务  最终也有事务
        transactionService.saveWithTransaction(application,user); // 有Transactional

        // 结论: 会回滚 (2个save，在同个有Transactional的service方法)

    }

    /**
     *
     * @param application
     * @param user
     */
    @Override
    public void saveNoTransaction2(Application application, User user) {

        this.applicationService.saveApp(application); // 有Transactional

        this.userService.saveUser(user); // 有Transactional

        // 结论：   user报错， application不会回滚
    }

    @Override
    public void saveNoTransaction3(Application application, User user) {

        this.applicationService.saveAppNo(application);

        this.userService.saveUser(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveWithTransaction(Application application, User user) {

        Date date = new Date();
        application.setId(this.applicationService.getMaxId());


        applicationService.save(application);

        user.setId(null);
        userService.save(user);

    }
}
