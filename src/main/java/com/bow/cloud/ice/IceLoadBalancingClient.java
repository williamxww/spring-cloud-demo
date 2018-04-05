package com.bow.cloud.ice;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.cloud.netflix.feign.ribbon.FeignLoadBalancer;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.cloud.netflix.ribbon.okhttp.OkHttpLoadBalancingClient;

import com.netflix.client.AbstractLoadBalancerAwareClient;
import com.netflix.client.RequestSpecificRetryHandler;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

/**
 * 定制LoadBalancer，使其能够处理ice request
 * @see FeignLoadBalancer
 * @see OkHttpLoadBalancingClient
 * @see RibbonLoadBalancingHttpClient
 * @author vv
 * @since 2018/4/5.
 */
public class IceLoadBalancingClient extends AbstractLoadBalancerAwareClient<IceRequest, IceResponse> {

    /**
     * 将LoadBalancer包装后使其能够处理ICE请求
     * @param lb 默认实现类 {@link ZoneAwareLoadBalancer}
     */
    public IceLoadBalancingClient(ILoadBalancer lb) {
        super(lb);
    }

    @Override
    public RequestSpecificRetryHandler getRequestSpecificRetryHandler(IceRequest iceRequest,
            IClientConfig iClientConfig) {
        return null;
    }

    @Override
    public IceResponse execute(IceRequest iceRequest, IClientConfig iClientConfig) throws Exception {
        // call remote ice server
        System.out.println("hello I'm here.");
        return null;
    }

    @Override
    public URI reconstructURIWithServer(Server server, URI original) {
//        URI uri = super.reconstructURIWithServer(server, original);
        try {
            return new URI("ice://"+ server.getHost()+":"+server.getPort());
        } catch (URISyntaxException e) {
           throw new RuntimeException(e);
        }
    }
}
