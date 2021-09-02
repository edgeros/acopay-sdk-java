package com.edgeros.pay.model.request;

import java.io.Serializable;

/**
 * Acopay API: Acopay common request
 *
 * @since 1.0.0
 */
public class AcopayRequest implements Serializable {

    private static final long serialVersionUID = -7435958989660392186L;

    /**
     * 请求 url
     */
    protected String requestUrl;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
