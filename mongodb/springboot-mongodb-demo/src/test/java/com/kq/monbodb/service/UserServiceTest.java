package com.kq.monbodb.service;

import com.kq.monbodb.BaseSpringBootMongodbApplicationTest;
import com.kq.mongodb.component.UserService;
import com.kq.mongodb.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kq
 * @date 2022-04-22 14:50
 * @since 2020-0630
 */
public class UserServiceTest extends BaseSpringBootMongodbApplicationTest {

    @Autowired
    private UserService userService;


    @Test
    public void testSave() {

        for(int i=0;i<5;i++) {
            User user = new User();
            if(i==0)user.setId("62625309beab9b1345552022");
            user.setName("临时用户");
            user.setUsername("guest"+i);
            user.setHobbys(new String[]{"football", "basketball"});
            userService.saveOrUpdate(user);
        }

        List<User> list =  userService.findAll();

        System.out.println("list="+list);
    }


}
