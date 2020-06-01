package com.example.scaffold.config.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 测试数据库配置信息
 *
 * Created by jinglun on 2020-04-12
 */
@Configuration
@MapperScan(basePackages = "com.example.scaffold.mapper.testDB", sqlSessionTemplateRef = "testDBSqlSessionTemplate")
public class TestDBConfig {

    // 1.数据库连接信息
    @Bean(name = "testDBDataSource")
    @ConfigurationProperties(prefix = "mybatis.datasource.testdb")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // 2.该数据库MyBatis配置信息
    @Bean(name = "testDBMybatisConfig")
    @ConfigurationProperties(prefix = "mybatis.configuration.testdb")
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "testDBSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("testDBDataSource") DataSource dataSource,
                                                    @Qualifier("testDBMybatisConfig")org.apache.ibatis.session.Configuration config)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(config); // 多数据源需要在各自的SessionFactory中设置配置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/testDB/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "testDBTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("testDBDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "testDBSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mysqlSqlSessionTemplate(
            @Qualifier("testDBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
