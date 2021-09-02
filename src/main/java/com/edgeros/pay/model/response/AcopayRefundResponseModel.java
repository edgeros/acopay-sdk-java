package com.edgeros.pay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay refund response
 *
 * @since 1.0.0
 */
public class AcopayRefundResponseModel extends AcopayCommonResponse {

    private static final long serialVersionUID = -3428511225805288764L;
    /**
     * 支付应用号
     */
    @JsonProperty(value = "app_no")
    private String appNo;

    /**
     * 商户退款单号
     */
    @JsonProperty(value = "mch_refund_no")
    private String mchRefundNo;

    /**
     * 翼辉退款单号
     */
    @JsonProperty(value = "refund_no")
    private String refundNo;

    /**
     * 翼辉订单号
     */
    @JsonProperty(value = "transaction_no")
    private String transactionNo;

    /**
     * 商户订单号
     */
    @JsonProperty(value = "mch_trade_no")
    private String mchTradeNo;

    /**
     * 退款金额
     */
    @JsonProperty(value = "refund_amount")
    private String refundAmount;

    /**
     * 业务状态描述
     */
    private String description;

    /**
     * 业务状态代码
     */
    private String code;

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getMchTradeNo() {
        return mchTradeNo;
    }

    public void setMchTradeNo(String mchTradeNo) {
        this.mchTradeNo = mchTradeNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AcopayRefundResponseModel{" +
                super.toString() +
                ", appNo='" + appNo + '\'' +
                ", mchRefundNo='" + mchRefundNo + '\'' +
                ", refundNo='" + refundNo + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                "}";
    }
}
