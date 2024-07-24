package com.edgeros.pay.model.request;

import com.edgeros.pay.constant.AcopayConstant;

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

    /**
     * java sdk版本号
     */
    protected String acoPaySdk = AcopayConstant.ACO_PAY_SDK_VERSION;

    /**
     * 调用接口版本号
     */
    protected String version = AcopayConstant.VERSION;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getAcoPaySdk() {
        return acoPaySdk;
    }

    public String getVersion() {
        return version;
    }
}
