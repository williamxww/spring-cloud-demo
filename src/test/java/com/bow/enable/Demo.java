package com.bow.enable;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 开启EnableDemo注解
 *
 * @author vv
 * @since 2018/4/2.
 */
@EnableDemo
public class Demo {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);
        ContentService service = context.getBean(ContentService.class);
        service.doSomething();
        System.in.read();
    }
}
