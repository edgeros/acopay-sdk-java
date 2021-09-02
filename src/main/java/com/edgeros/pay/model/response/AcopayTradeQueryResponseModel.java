package com.edgeros.pay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay trade query response
 *
 * @since 1.0.0
 */
public class AcopayTradeQueryResponseModel extends AcopayCommonResponse {

    private static final long serialVersionUID = 6805757064833006224L;
    /**
     * 支付应用号
     */
    @JsonProperty(value = "app_no")
    private String appNo;
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
    /**
     * 附加数据
     */
    private String extra;
    /**
     * 成功时间
     */
    @JsonProperty(value = "success_time")
    private String successTime;
    /**
     * 翼辉 ID
     */
    private String acoid;
    /**
     * 支付金额
     */
    @JsonProperty(value = "amount_total")
    private String amountTotal;

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getAcoid() {
        return acoid;
    }

    public void setAcoid(String acoid) {
        this.acoid = acoid;
    }

    public String getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(String amountTotal) {
        this.amountTotal = amountTotal;
    }

    @Override
    public String toString() {
        return "AcopayTradeQueryResponseModel{" +
                super.toString() +
                ", appNo='" + appNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", extra='" + extra + '\'' +
                ", successTime='" + successTime + '\'' +
                ", acoid='" + acoid + '\'' +
                ", amountTotal='" + amountTotal + '\'' +
                "}";
    }
}
