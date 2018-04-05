package com.bow.cloud.ice;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author vv
 * @since 2018/4/5.
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableIceClients
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

    public static void simple() throws IOException{
        // @PropertySource(value = { "classpath:application.properties" }) 怎么设置
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IceApp.class);
        IPrinter service = context.getBean(IPrinter.class);
        service.printer("Thank god");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        boot();
    }
}
