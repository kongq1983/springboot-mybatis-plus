package com.kq.config.mybatis;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * https://www.javaclub.cn/java/57050.html
 * @author kq
 * @date 2022-11-17 10:22
 * @since 2020-0630
 */

@Configuration
@MapperScan(basePackages = "com.kq.mapper.article",sqlSessionTemplateRef = "articleDbSqlSessionTemplate")
public class ArticleDbConfig {

    @Autowired
    private MyMetaObjectHandler myMetaObjectHandler;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.article-ds")
    @Primary
//    @RefreshScope
    public DataSource articleDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public SqlSessionFactory articleDbSqlSessionFactory(@Qualifier("articleDataSource") DataSource dataSource)
            throws Exception {
        // 解决多数据源baseMapper 用问题  sqlSessionMapper==>MybatisSqlSessionMapper
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sgis.one.map.micro.model.entity");
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/article/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        //构造方法，解决多数据源导致mybatis-config配置失效的问题
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.addInterceptor(new PaginationInterceptor());
        // mybatis添加实体类字段为空报错问题
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactoryBean.setConfiguration(configuration);


        //多数据源 myMetaObjectHandler不起作用问题解决
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(myMetaObjectHandler);
        globalConfig.setDbConfig(new GlobalConfig.DbConfig());
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager articleDbTranscationManager(@Qualifier("articleDataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate articleDbSqlSessionTemplate(@Qualifier("articleDbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
