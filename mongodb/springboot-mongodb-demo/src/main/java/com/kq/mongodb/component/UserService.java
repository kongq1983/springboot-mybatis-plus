package com.kq.mongodb.component;

import com.kq.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kq
 * @date 2022-04-22 14:34
 * @since 2020-0630
 */
@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveOrUpdate(User user) {
        mongoTemplate.save(user);
    }


    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

}
