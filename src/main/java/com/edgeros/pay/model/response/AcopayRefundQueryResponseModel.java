package com.edgeros.pay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay refund query response
 *
 * @since 1.0.0
 */
public class AcopayRefundQueryResponseModel extends AcopayCommonResponse {

    private static final long serialVersionUID = 3079072318860499294L;
    /**
     * 商户订单号
     */
    @JsonProperty(value = "mch_trade_no")
    private String mchTradeNo;

    /**
     * 商户退单号
     */
    @JsonProperty(value = "mch_refund_no")
    private String mchRefundNo;

    /**
     * 翼辉订单号
     */
    @JsonProperty(value = "transaction_no")
    private String transactionNo;

    /**
     * 翼辉退单号
     */
    @JsonProperty(value = "refund_no")
    private String refundNo;

    /**
     * 退款金额
     */
    @JsonProperty(value = "refund_amount")
    private String refundAmount;

    /**
     * 业务状态代码
     */
    private String code;

    /**
     * 业务状态描述
     */
    private String description;

    /**
     * 退款原因
     */
    @JsonProperty(value = "refund_reason")
    private String refundReason;

    /**
     * 退款时间
     */
    @JsonProperty(value = "success_time")
    private String successTime;

    /**
    * 退款渠道
    * @since  2024/7/9 15:53
    */
    @JsonProperty(value = "refund_channel")
    private String refundChannel;


    public String getMchTradeNo() {
        return mchTradeNo;
    }

    public void setMchTradeNo(String mchTradeNo) {
        this.mchTradeNo = mchTradeNo;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
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

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel;
    }

    @Override
    public String toString() {
        return "AcopayRefundQueryResponseModel{" +
                super.toString() +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", mchRefundNo='" + mchRefundNo + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", refundNo='" + refundNo + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", successTime='" + successTime + '\'' +
                ", refundChannel='" + refundChannel + '\'' +
                "}";
    }
}
