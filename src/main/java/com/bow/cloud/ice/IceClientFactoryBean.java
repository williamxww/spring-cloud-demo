package com.bow.cloud.ice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

/**
 * @see org.springframework.cloud.netflix.feign.FeignClientFactoryBean
 * @author vv
 * @since 2018/4/5.
 */
public class IceClientFactoryBean implements FactoryBean<Object>,MethodInterceptor, InitializingBean, ApplicationContextAware {

    private Class<?> type;

    private String name;

    private ApplicationContext applicationContext;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("invoke...");
        return null;
    }

    @Override
    public Object getObject() throws Exception {
        return new ProxyFactory().getProxy(type, this);
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(this.name, "Name must be set");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
