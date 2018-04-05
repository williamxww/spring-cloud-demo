package com.bow.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author vv
 * @since 2018/4/1.
 */
@SpringBootApplication
public class AppDemo {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AppDemo.class);
        application.addInitializers(new MyApplicationContextInitializer());
        ConfigurableApplicationContext context = application.run(args);
        context.close();
    }

}
