package com.bow.cloud.ice;

import java.io.IOException;
import java.net.URI;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @see RibbonLoadBalancerClient
 * @author vv
 * @since 2018/4/5.
 */
@Deprecated
public class IceLoadBalancerClient implements LoadBalancerClient {

    private SpringClientFactory clientFactory;

    public IceLoadBalancerClient(SpringClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public <T> T execute(String serviceId, LoadBalancerRequest<T> request) throws IOException {
        return null;
    }

    @Override
    public <T> T execute(String serviceId, ServiceInstance serviceInstance, LoadBalancerRequest<T> request) throws IOException {
        return null;
    }

    @Override
    public URI reconstructURI(ServiceInstance instance, URI original) {
        return original;
    }

    @Override
    public ServiceInstance choose(String serviceId) {
        Server server = getServer(serviceId);
        if (server == null) {
            return null;
        }
        return new IceServer();
    }

    protected Server getServer(String serviceId) {
        return getServer(getLoadBalancer(serviceId));
    }

    protected Server getServer(ILoadBalancer loadBalancer) {
        if (loadBalancer == null) {
            return null;
        }
        return loadBalancer.chooseServer("default"); // TODO: better handling of key
    }

    protected ILoadBalancer getLoadBalancer(String serviceId) {
        return this.clientFactory.getLoadBalancer(serviceId);
    }
}
