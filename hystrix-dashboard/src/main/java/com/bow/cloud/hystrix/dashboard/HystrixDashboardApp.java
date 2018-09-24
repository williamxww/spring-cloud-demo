package com.bow.cloud.hystrix.dashboard;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * http://localhost:8763/hystrix
 * 
 * @author vv
 * @since 2018/9/24.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApp {

	public static void main(String[] args) {
		YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
		yml.setResources(new ClassPathResource("dashboard.yml"));
		Properties props = yml.getObject();
		SpringApplication app = new SpringApplication(HystrixDashboardApp.class);
		app.setDefaultProperties(props);
		app.run(args);
	}
}
