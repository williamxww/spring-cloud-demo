package com.bow.cloud.ice;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import com.netflix.client.ClientException;
import com.netflix.client.IResponse;

/**
 * @author vv
 * @since 2018/4/5.
 */
public class IceResponse implements IResponse {
    @Override
    public Object getPayload() throws ClientException {
        return null;
    }

    @Override
    public boolean hasPayload() {
        return false;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public URI getRequestedURI() {
        return null;
    }

    @Override
    public Map<String, ?> getHeaders() {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
