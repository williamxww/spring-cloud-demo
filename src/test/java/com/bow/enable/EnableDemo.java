package com.bow.enable;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ConfigurationClassBeanDefinitionReader#
 * registerBeanDefinitionForImportedConfigurationClass<br/>
 * 
 * 此注解中最有价值的是Import， 将DemoConfig中定义的所有bean都进行了注册
 *
 * {@link SpringFactoriesLoader}通过key为{@link EnableAutoConfiguration}
 * 从META-INF/spring.factories文件中找出所有的{@link Configuration}然后注册bean
 * 
 * @author vv
 * @since 2018/4/2.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(DemoConfig.class)
public @interface EnableDemo {
}
