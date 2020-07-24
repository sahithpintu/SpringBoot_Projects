package com.javaguides.multipledatasources.api.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef ="bookEntityManagerFactory",transactionManagerRef = "bookTransactionManager",basePackages = {"com.javaguides.multipledatasources.api.repositories"})
public class BookDBConfig {
	
	@Bean(name="bookDataSource")
	@ConfigurationProperties(prefix = "spring.book.datasource")
	public DataSource datasource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean  bookEntityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("bookDataSource") DataSource dataSource)
	{
		Map<String,Object> hm=new HashMap<String,Object>();
		hm.put("hibernate.hbm2ddl.auto", "update");
		hm.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		return builder.dataSource(dataSource).properties(hm).packages("com.javaguides.multipledatasources.api.model.book").persistenceUnit("Book").build();
		
	}
	
	public PlatformTransactionManager bookTransactionManager(@Qualifier("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory)
	{
		return new JpaTransactionManager(bookEntityManagerFactory);
	}

}
