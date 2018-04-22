package com.niit.skillmapping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.skillmapping.daoimpl.UserDAOImpl;
import com.niit.skillmapping.model.User;

@Configuration
@EnableTransactionManagement
//@PropertySource(value = { "file:db.properties" })
public class DBConfig {
	
	@Autowired
    private Environment environment;
	
	/*@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));

		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		connectionProperties.setProperty("hibernate.use_sql_comments", "true");
		return dataSource;
	}*/
	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/SkillMappingDB");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		connectionProperties.setProperty("hibernate.use_sql_comments", "true");
		return dataSource;
	}
	
	 private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.use_sql_comments", "true");
	    	//properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(User.class);
	    	return sessionBuilder.buildSessionFactory();
	    }
	    
	     @Autowired
	    @Bean (name = "sessionFactory")
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(getH2DataSource());
	      sessionFactory.setPackagesToScan("com.niit.skillmapping.model");
	      sessionFactory.setHibernateProperties(getHibernateProperties());	 
	      return sessionFactory;
	   }
	    
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
		
		/*@Autowired
	    @Bean
	    public UserDAOImpl getUserDAO(SessionFactory sessionFactory) {
	    	return new UserDAOImpl(sessionFactory);
	    }*/

}
