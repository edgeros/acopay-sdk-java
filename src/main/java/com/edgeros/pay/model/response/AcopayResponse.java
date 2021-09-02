package com.edgeros.pay.model.response;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

import static com.edgeros.pay.constant.AcopayConstant.RESPONSE_SUCCESS_STATUS;

/**
 * Acopay API: Acopay response
 *
 * @since 1.0.0
 */
public class AcopayResponse<T extends AcopayCommonResponse> implements Serializable {

    private static final long serialVersionUID = 6934052924476575531L;

    /**
     * 业务状态
     */
    private Integer status;

    /**
     * 状态描述信息
     */
    private String message;

    /**
     * 错误信息
     */
    private String fieldErrors;

    /**
     * 业务数据
     */
    private T data;

    /**
     * 判断翼辉支付平台是否返回成功状态码
     *
     * @return boolean
     */
    public boolean statusSuccessful() {
        return StringUtils.equals(status + "", RESPONSE_SUCCESS_STATUS);
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(String fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AcopayResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", fieldErrors='" + fieldErrors + '\'' +
                ", data[" + data +
                "]}";
    }
}
