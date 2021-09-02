package com.edgeros.pay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay trade close response
 *
 * @since 1.0.0
 */
public class AcopayTradeCloseResponseModel extends AcopayCommonResponse {

    private static final long serialVersionUID = 8003205336883093589L;
    /**
     * 商户订单号
     */
    @JsonProperty(value = "mch_trade_no")
    private String mchTradeNo;

    /**
     * 翼辉订单号
     */
    @JsonProperty(value = "transaction_no")
    private String transactionNo;

    /**
     * 业务状态代码
     */
    private String code;

    /**
     * 业务状态描述
     */
    private String description;

    public String getMchTradeNo() {
        return mchTradeNo;
    }

    public void setMchTradeNo(String mchTradeNo) {
        this.mchTradeNo = mchTradeNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

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

    @Override
    public String toString() {
        return "AcopayTradeCloseResponseModel{" +
                super.toString() +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                "}";
    }
}
