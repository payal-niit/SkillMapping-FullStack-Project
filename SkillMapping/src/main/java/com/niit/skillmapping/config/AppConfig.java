package com.niit.skillmapping.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages="com.niit.skillmapping")
@Import(DBConfig.class)
public class AppConfig {
	
	//<context:property-placeholder location="classpath:application.properties"></context:property-placeholder>
    /*@Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("db.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }*/
}
