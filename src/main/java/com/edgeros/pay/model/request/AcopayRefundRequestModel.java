package com.edgeros.pay.model.request;

import com.edgeros.pay.model.response.AcopayRefundResponseModel;

/**
 * Acopay API: Acopay refund request
 *
 * @since 1.0.0
 */
public class AcopayRefundRequestModel extends AcopayRequest {

    private static final long serialVersionUID = -8142578428281619565L;
    /**
     * 翼辉订单号
     */
    private String transactionNo;

    /**
     * 商户订单号
     */
    private String mchTradeNo;

    /**
     * 商户退款单号
     */
    private String mchRefundNo;

    /**
     * 退款金额
     */
    private String refundAmount;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 支付金额币种
     */
    private String notifyUrl;

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

    public String getMchRefundNo() {
        return mchRefundNo;
    }

    public void setMchRefundNo(String mchRefundNo) {
        this.mchRefundNo = mchRefundNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "AcopayRefundRequestModel{" +
                "transactionNo='" + transactionNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", mchRefundNo='" + mchRefundNo + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
