package org.allen.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
@MapperScan(basePackages = "org.allen.demo.dao.dbOne", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSource1Config {

    @Autowired
    private Environment env;

    @Bean("dataSource1")
    @Primary
    public DataSource dataSource(){
        System.out.println("初始化数据源1开始。。。");
        HikariDataSource ds = new HikariDataSource ();
        ds.setDriverClassName(env.getProperty("spring.datasource.one.driver-class-name").trim());
        ds.setJdbcUrl(env.getProperty("spring.datasource.one.url").trim());
        ds.setUsername(env.getProperty("spring.datasource.one.username").trim());
        ds.setPassword(env.getProperty("spring.datasource.one.password").trim());
        System.out.println("初始化数据源1结束。。。");
        return ds;
    }

    @Bean("sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        return sfb.getObject();
    }

    @Bean("sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sft = new SqlSessionTemplate(sqlSessionFactory);
        return sft;
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource1") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
