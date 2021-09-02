package com.edgeros.pay.model;

import com.edgeros.pay.model.response.AcopayCommonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay trade notify receive
 *
 * @since 1.0.0
 */
public class AcopayTradeNotifyReceiveModel extends AcopayCommonResponse {

    private static final long serialVersionUID = -3967574040476433793L;
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
     * 支付应用号
     */
    @JsonProperty(value = "app_no")
    private String appNo;

    /**
     * 附加数据
     */
    private String extra;

    /**
     * 业务状态代码
     */
    private String code;

    /**
     * 业务状态描述
     */
    private String description;

    /**
     * 支付金额
     */
    @JsonProperty(value = "amount_total")
    private String amountTotal;

    /**
     * 支付成功时间
     */
    @JsonProperty(value = "success_time")
    private String successTime;

    /**
     * 支付金额币种
     */
    @JsonProperty(value = "amount_currency")
    private String amountCurrency;

    /**
     * 翼辉 ID
     */
    private String acoid;


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

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
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

    public String getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(String amountTotal) {
        this.amountTotal = amountTotal;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public String getAcoid() {
        return acoid;
    }

    public void setAcoid(String acoid) {
        this.acoid = acoid;
    }

    @Override
    public String toString() {
        return "AcopayTradeNotifyReceiveModel{" +
                super.toString() +
                ", notifyTime='" + notifyTime + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", appNo='" + appNo + '\'' +
                ", extra='" + extra + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", amountTotal='" + amountTotal + '\'' +
                ", successTime='" + successTime + '\'' +
                ", amountCurrency='" + amountCurrency + '\'' +
                ", acoid='" + acoid + '\'' +
                "} ";
    }
}
