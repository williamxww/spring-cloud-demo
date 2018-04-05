package com.bow.cloud.ice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ServerListFilter;

/**
 *
 * @see FeignClient
 * @see RibbonClient
 * @author vv
 * @since 2018/4/5.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IceClient {
    /**
     * service id
     * @return service id
     */
    String name() default "";

    /**
     * 支持自定义构成客户端的组件, for instance
     * {@link ILoadBalancer}, {@link ServerListFilter}, {@link IRule}.
     *
     * @see IceClientConfiguration for the defaults
     */
    Class<?>[] configuration() default {};

    /**
     * Whether to mark the feign proxy as a primary bean. Defaults to true.
     */
    boolean primary() default true;

    /**
     * Sets the <code>@Qualifier</code> value for the feign client.
     * 使用地方通过@Qualifier(此值)引入此代理的
     */
    String qualifier() default "";
}
