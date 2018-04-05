package com.bow.cloud.eureka.fegin;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.core.io.ClassPathResource;

/**
 * @author vv
 * @since 2018/3/27.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApp {

    public static void main(String[] args) {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("feign.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(FeignApp.class);
        app.setDefaultProperties(props);
        app.run(args);
    }
}
