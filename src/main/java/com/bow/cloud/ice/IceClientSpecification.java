package com.bow.cloud.ice;

import java.beans.ConstructorProperties;

import org.springframework.cloud.context.named.NamedContextFactory;

/**
 * @author vv
 * @since 2018/4/5.
 */
public class IceClientSpecification implements NamedContextFactory.Specification {

    private String name;

    private Class<?>[] configuration;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Class<?>[] getConfiguration() {
        return this.configuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfiguration(Class<?>[] configuration) {
        this.configuration = configuration;
    }

    @ConstructorProperties({"name", "configuration"})
    public IceClientSpecification(String name, Class<?>[] configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    public IceClientSpecification() {
    }
}
