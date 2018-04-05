package com.bow.cloud.eureka.server;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

/**
 * 启动Eureka Server
 */
@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackageClasses = EurekaServerApp.class)
public class EurekaServerApp {

    public static void main(String[] args) {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("eureka.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(EurekaServerApp.class);
        app.setDefaultProperties(props);
        app.run(args);
    }
}
