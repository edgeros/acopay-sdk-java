package com.edgeros.pay.model;

import com.edgeros.pay.model.response.AcopayCommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay refund notify receive
 *
 * @since 1.0.0
 */
public class AcopayRefundNotifyReceiveModel extends AcopayCommonResponse {

    private static final long serialVersionUID = 6476264605597720247L;
    /**
     * 异步通知时间
     */
    @JsonProperty(value = "notify_time")
    private String notifyTime;

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
     * 翼辉退款单号
     */
    @JsonProperty(value = "refund_no")
    private String refundNo;

    /**
     * 商户退款单号
     */
    @JsonProperty(value = "mch_refund_no")
    private String mchRefundNo;

    /**
     * 业务状态代码
     */
    private String code;

    /**
     * 业务状态描述
     */
    private String description;

    /**
     * 退款金额
     */
    @JsonProperty(value = "refund_amount")
    private String refundAmount;

    /**
     * 退款成功时间
     */
    @JsonProperty(value = "success_time")
    private String successTime;

    /**
     * 退款原因
     */
    @JsonProperty(value = "refund_reason")
    private String refundReason;

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
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

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
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

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    @Override
    public String toString() {
        return "AcopayRefundNotifyReceiveModel{" +
                super.toString() +
                ", notifyTime='" + notifyTime + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", refundNo='" + refundNo + '\'' +
                ", mchRefundNo='" + mchRefundNo + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", successTime='" + successTime + '\'' +
                ", refundReason='" + refundReason + '\'' +
                "} ";
    }
}
