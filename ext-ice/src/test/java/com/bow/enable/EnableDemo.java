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
 * 此注解中最有价值的是Import， 将DemoConfig中定义的所有bean都进行了注册<br/>
 *
 * {@link SpringFactoriesLoader}可以通过key为{@link EnableAutoConfiguration}
 * 从META-INF/spring.factories文件中找出所有的{@link Configuration}然后注册bean，但与此处演示无关，即便是没有配置spring.factories，
 * demo也能正常运行
 *
 * @see ContentImportSelector 根据{@link #policy()}有选择性的注册bean
 * @author vv
 * @since 2018/4/2.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DemoConfig.class, ContentImportSelector.class})
public @interface EnableDemo {
    /**
     * 支持 demo  dev 两种
     * @return DemoConfig or DevConfig
     */
    String policy() default "demo";
}
