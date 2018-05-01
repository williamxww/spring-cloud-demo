package com.bow.cloud.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * server 启动后通过
 * http://localhost:8888/provider-service/dev/0.1
 * 将resources/config下的文件通过服务展示出来
 * 请求格式：appId/profile/label(版本)
 */

@SpringBootApplication
//@EnableDiscoveryClient
@EnableConfigServer
public class ConfigApp {

    public static void main(String[] args) throws IOException {
        InputStream is = ConfigApp.class.getClassLoader().getResourceAsStream("configServer.properties");
        Properties props = new Properties();
        props.load(is);
        SpringApplication app = new SpringApplication(ConfigApp.class);
        app.setDefaultProperties(props);
        app.run(args);
    }
}
