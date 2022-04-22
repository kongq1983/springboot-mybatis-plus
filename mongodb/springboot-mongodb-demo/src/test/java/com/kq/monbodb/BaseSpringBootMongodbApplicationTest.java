package com.kq.monbodb;

import com.kq.mongodb.SpringBootMongodbApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author kq
 * @date 2022-04-22 14:49
 * @since 2020-0630
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootMongodbApplication.class})
@WebAppConfiguration
//@Transactional
//@Rollback(value=false) // 要回滚，默认值就可以了
public class BaseSpringBootMongodbApplicationTest {



}
