package com.bow.module;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * context在refresh之前的回调接口，{@link Order}可以指明多个Initializer的顺序。
 * 
 * @author vv
 * @since 2018/4/1.
 */
@Order(2)
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Bean count --> " + applicationContext.getBeanDefinitionCount());
    }
}
