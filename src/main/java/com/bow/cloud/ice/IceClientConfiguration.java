package com.bow.cloud.ice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.DummyPing;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

/**
 *
 * @see RibbonClientConfiguration
 * @author vv
 * @since 2018/4/5.
 */
@Configuration
@EnableConfigurationProperties
public class IceClientConfiguration {

    @Value("${ice.client.name}")
    private String name = "client";

    @Autowired
    private PropertiesFactory propertiesFactory;

    @Bean
    @ConditionalOnMissingBean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(this.name);
        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public IRule ribbonRule(IClientConfig config) {
        if (this.propertiesFactory.isSet(IRule.class, name)) {
            return this.propertiesFactory.get(IRule.class, config, name);
        }
        ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
        rule.initWithNiwsConfig(config);
        return rule;
    }

    @Bean
    @ConditionalOnMissingBean
    public IPing ribbonPing(IClientConfig config) {
        if (this.propertiesFactory.isSet(IPing.class, name)) {
            return this.propertiesFactory.get(IPing.class, config, name);
        }
        return new DummyPing();
    }

    @Bean
    @ConditionalOnMissingBean
    @SuppressWarnings("unchecked")
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        if (this.propertiesFactory.isSet(ServerList.class, name)) {
            return this.propertiesFactory.get(ServerList.class, config, name);
        }
        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);
        return serverList;
    }
}
