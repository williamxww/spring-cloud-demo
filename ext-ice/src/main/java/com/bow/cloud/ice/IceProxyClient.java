package com.bow.cloud.ice;

import com.netflix.client.ClientException;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

/**
 * @see LoadBalancerFeignClient
 * @author vv
 * @since 2018/4/5.
 */
public class IceProxyClient {

    private SpringClientFactory clientFactory;

    public IceProxyClient(SpringClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public void execute(IceRequest request) throws ClientException {
        IceLoadBalancingClient lbClient = new IceLoadBalancingClient(clientFactory.getLoadBalancer("ice"));
        lbClient.executeWithLoadBalancer(request);
    }
}
