package com.bow.cloud.config.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * http://localhost:8083/config-demo/dev
 * 此demo独立启动，能够将resources/config下的文件通过服务展示出来
 */
@SpringBootApplication
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
