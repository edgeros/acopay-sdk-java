package com.edgeros.pay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay bill response
 *
 * @since 1.0.0
 */
public class AcopayBillResponseModel extends AcopayCommonResponse {

    private static final long serialVersionUID = -2559510990407075444L;
    /**
     * 业务状态代码
     */
    private String code;
    /**
     * 业务状态描述
     */
    private String description;
    /**
     * 下载对账单 URL
     */
    private String url;
    /**
     * 哈希值
     */
    @JsonProperty(value = "hash_code")
    private String hashCode;
    /**
     * 哈希算法
     */
    @JsonProperty(value = "hash_type")
    private String hashType;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    @Override
    public String toString() {
        return "AcopayBillResponseModel{" +
                super.toString() +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", hashType='" + hashType + '\'' +
                "}";
    }
}
