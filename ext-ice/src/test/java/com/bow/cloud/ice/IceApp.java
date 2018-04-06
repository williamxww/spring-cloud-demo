package com.bow.cloud.ice;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

/**
 * @author vv
 * @since 2018/4/5.
 */
@SpringBootApplication
@EnableIceClients(basePackages = "com.bow.cloud.ice", defaultConfiguration = SimpleClientConfiguration.class)
public class IceApp {


    public static void boot() {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("ice.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(IceApp.class);
        app.setDefaultProperties(props);
        app.run();
    }



    public static void main(String[] args) throws IOException {
        boot();
    }
}
