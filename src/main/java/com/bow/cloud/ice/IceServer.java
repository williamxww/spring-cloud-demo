package com.bow.cloud.ice;

import org.springframework.cloud.client.ServiceInstance;

import java.net.URI;
import java.util.Map;

/**
 * @author vv
 * @since 2018/4/5.
 */
public class IceServer implements ServiceInstance {
    @Override
    public String getServiceId() {
        return null;
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public URI getUri() {
        return null;
    }

    @Override
    public Map<String, String> getMetadata() {
        return null;
    }
}
