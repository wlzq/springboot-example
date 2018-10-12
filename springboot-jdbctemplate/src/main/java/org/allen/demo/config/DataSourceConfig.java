package org.allen.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:dbSource.properties")
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DataSource dataSource(){
        System.out.println("初始化数据源start。。。");
        //HikariDataSource dataSource = new HikariDataSource();//springboot中默认使用的数据源
        DruidDataSource dataSource = new DruidDataSource();
        String driver = env.getProperty("jdbc.driverClassName").trim();
        String url = env.getProperty("jdbc.url").trim();
        String username = env.getProperty("jdbc.username").trim();
        String password = env.getProperty("jdbc.password").trim();
        dataSource.setDriverClassName(driver);
        //dataSource.setJdbcUrl(url);//Hikar url
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println("初始化数据源end。。。");
        return dataSource;
    }

}
