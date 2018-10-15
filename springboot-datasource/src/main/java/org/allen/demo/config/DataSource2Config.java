package org.allen.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
@MapperScan(basePackages = "org.allen.demo.dao.dbTwo", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSource2Config {

    @Autowired
    private Environment env;

    @Bean("dataSource2")
    public DataSource dataSource(){
        System.out.println("初始化数据源2开始。。。");
        HikariDataSource ds = new HikariDataSource ();
        ds.setDriverClassName(env.getProperty("spring.datasource.two.driver-class-name").trim());
        ds.setJdbcUrl(env.getProperty("spring.datasource.two.url").trim());
        ds.setUsername(env.getProperty("spring.datasource.two.username").trim());
        ds.setPassword(env.getProperty("spring.datasource.two.password").trim());
        System.out.println("初始化数据源2结束。。。");
        return ds;
    }

    @Bean("sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource2) throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource2);
        return sfb.getObject();
    }

    @Bean("sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory2){
        SqlSessionTemplate sft = new SqlSessionTemplate(sqlSessionFactory2);
        return sft;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource2") DataSource dataSource2){
        return new DataSourceTransactionManager(dataSource2);
    }

}
