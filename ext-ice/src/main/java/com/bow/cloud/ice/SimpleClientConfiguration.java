package com.bow.cloud.ice;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vv
 * @see IceClientConfiguration
 * @since 2018/4/6.
 */
@Configuration
public class SimpleClientConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties("simple");
        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public IRule rule(IClientConfig config) {
        RandomRule rule = new RandomRule();
        rule.initWithNiwsConfig(config);
        return rule;
    }

    @Bean
    @ConditionalOnMissingBean
    public IPing ping(IClientConfig config) {
        return new NoOpPing();
    }

	@Bean
	@ConditionalOnMissingBean
	@SuppressWarnings("unchecked")
	public ServerList<Server> serverList(IClientConfig config) {
		// Server server = new Server("ice","127.0.0.1",10000);
		Server server = new Server("127.0.0.1", 10000);
		StaticServerList serverList = new StaticServerList(server);
		return serverList;
	}
}
