package com.kq.config.mybatis;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author kq
 * @date 2022-11-17 10:22
 * @since 2020-0630
 */

@Configuration
@MapperScan(basePackages = "com.kq.mapper.user",sqlSessionTemplateRef = "userDbSqlSessionTemplate")
public class UserDbConfig {

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.user-ds")
//    @RefreshScope
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory userDbSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource)
            throws Exception{
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/user/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        //构造方法，解决动态数据源循环依赖问题。
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.addInterceptor(new PaginationInterceptor());
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager userDbTransactionManager(@Qualifier("userDataSource")
                                                                               DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate userDbSqlSessionTemplate(@Qualifier("userDbSqlSessionFactory")
                                                                     SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
