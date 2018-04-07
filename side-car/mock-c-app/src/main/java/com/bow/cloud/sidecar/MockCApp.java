package com.bow.cloud.sidecar;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

/**
 * @author vv
 * @since 2018/4/7.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = MockCApp.class)
@RestController
public class MockCApp {

    public static void main(String[] args) throws IOException {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("mock-c-app.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(MockCApp.class);
        app.setDefaultProperties(props);
        app.run(args);
        System.in.read();
    }
}