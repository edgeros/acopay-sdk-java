package com.edgeros.pay.model;

import java.io.Serializable;

/**
 * Acopay API: Acopay notify response
 *
 * @since 1.0.0
 */
public class AcopayNotifyResponseModel implements Serializable {

    private static final long serialVersionUID = -6506509864609575509L;
    /**
     * 支付异步通知返回状态码
     */
    private String status;
    /**
     * 支付异步通知返回信息
     */
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotifyResponseModel{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
