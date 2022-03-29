package com.kq.app;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kq
 * @date 2022-03-29 16:52
 * @since 2020-0630
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MybatisPlusImportApplication.class})
@WebAppConfiguration
@Transactional
@Rollback(value=false) // 要回滚，默认值就可以了
public class MybatisPlusImportApplicationBaseTest {

}
