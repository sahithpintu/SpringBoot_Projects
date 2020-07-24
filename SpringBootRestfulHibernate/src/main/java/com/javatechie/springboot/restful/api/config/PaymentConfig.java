package com.javatechie.springboot.restful.api.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PaymentConfig {
	
	@Autowired
    private Environment env;
	
	
	//@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource  ds = new DriverManagerDataSource ();
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        ds.setUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
 
        return ds;
	}
	
	     @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(datasource());
	        sessionFactory.setPackagesToScan("com.javatechie.springboot.restful.api");
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        hibernateProperties.put("hibernate.show_sql", "true");
	        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	        sessionFactory.setHibernateProperties(hibernateProperties);
	        return sessionFactory;
	    }
	     
	     @Bean
	     public HibernateTransactionManager transactionManager() {
	         HibernateTransactionManager txManager = new HibernateTransactionManager();
	         txManager.setSessionFactory(sessionFactory().getObject());
	         return txManager;
	     }


}
