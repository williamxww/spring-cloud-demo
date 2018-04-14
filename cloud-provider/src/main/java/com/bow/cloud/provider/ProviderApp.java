package com.bow.cloud.provider;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackageClasses = ProviderApp.class)
public class ProviderApp {

    public static void main(String[] args) {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("provider.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(ProviderApp.class);
        app.setDefaultProperties(props);
        app.run(args);
    }
}
