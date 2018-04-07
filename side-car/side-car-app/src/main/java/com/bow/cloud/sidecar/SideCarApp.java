package com.bow.cloud.sidecar;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:9003/hosts/sidecarTest 访问所代理服务的信息
 * 注意consumer 用feign访问
 *
 * @author vv
 * @since 2018/4/6.
 */
@SpringBootApplication
@EnableSidecar
@RestController
public class SideCarApp {

    public static void main(String[] args) {
        // 指定配置文件的位置
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("sidecar.yml"));
        Properties props = yml.getObject();
        SpringApplication app = new SpringApplication(SideCarApp.class);
        app.setDefaultProperties(props);
        app.run(args);
    }
}
