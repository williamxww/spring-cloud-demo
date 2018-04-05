package com.bow.cloud.ice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @see org.springframework.cloud.netflix.feign.EnableFeignClients
 * @author vv
 * @since 2018/4/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(IceClientsRegistrar.class)
public @interface EnableIceClients {

    String[] basePackages() default {};

    Class<?>[] defaultConfiguration() default {};
}
