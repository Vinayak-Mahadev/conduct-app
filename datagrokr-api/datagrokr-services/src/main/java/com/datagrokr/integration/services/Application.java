package com.datagrokr.integration.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application 
{
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) 
	{
		SpringApplication application = null;
		ApplicationContext _ApplicationContext_ = null;
		try 
		{
			application = new SpringApplication(Application.class);
			_ApplicationContext_ = application.run(args);
			LOGGER.info("Starting Application : " + _ApplicationContext_);

//			for(String str : _ApplicationContext_.getBeanDefinitionNames())
//				LOGGER.info("Bean :: " + str + " :: [ " + _ApplicationContext_.getBean(str) + " ]\n");

			LOGGER.info("Application started...");
		}
		catch (Exception e) 
		{
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		finally 
		{
			application = null;
			_ApplicationContext_ = null;
			System.gc();
		}
	}
}
