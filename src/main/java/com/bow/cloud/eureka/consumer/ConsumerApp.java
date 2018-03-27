package com.bow.cloud.eureka.consumer;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import com.bow.cloud.eureka.provider.ProviderApp;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackageClasses = ConsumerApp.class)
public class ConsumerApp {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("consumer.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(ConsumerApp.class);
        app.setDefaultProperties(props);
        app.run(args);
    }
}
