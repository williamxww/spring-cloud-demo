package com.bow.cloud.ice;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * @author vv
 * @since 2018/4/5.
 */
//@SpringBootApplication
@EnableIceClients(basePackages = "com.bow.cloud.ice", defaultConfiguration = SimpleClientConfiguration.class)
@PropertySource(value = { "classpath:simple.properties" })
public class SimpleDemo {

    public static void simple() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IceApp.class);
        IPrinter service = context.getBean(IPrinter.class);
        service.printer("Thank god");
        System.in.read();
    }

    public static void main(String[] args)throws IOException {
        simple();
    }
}
