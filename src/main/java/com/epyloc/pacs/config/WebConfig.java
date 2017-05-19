package com.epyloc.pacs.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAsync
@ComponentScan("com.epyloc")
public class WebConfig extends WebMvcConfigurerAdapter {

	/*
	 * @Bean(name = "dataSource") public DriverManagerDataSource dataSource() {
	 * DriverManagerDataSource driverManagerDataSource = new
	 * DriverManagerDataSource();
	 * driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * driverManagerDataSource.setUrl("jdbc:mysql://localhost:36523/PACS");
	 * driverManagerDataSource.setUsername("suday");
	 * driverManagerDataSource.setPassword("Infy$123"); return
	 * driverManagerDataSource; }
	 */

	@Bean(name = "dataSource")
	DataSource dataSource() {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = jndi.lookup("java:jboss/paccs", DataSource.class);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
