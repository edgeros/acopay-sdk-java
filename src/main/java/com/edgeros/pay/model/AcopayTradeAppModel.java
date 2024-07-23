package com.edgeros.pay.model;

import com.edgeros.pay.constant.AcopayConstant;

import java.io.Serializable;

/**
 * Acopay API: Acopay trade Web-SDK request
 *
 * @since 1.0.0
 */
public class AcopayTradeAppModel implements Serializable {

    private static final long serialVersionUID = -2018896032067445935L;
    /**
     * 支付金额币种
     */
    private String amountCurrency;

    /**
     * 支付金额
     */
    private String amountTotal;
    /**
     * 支付应用号
     */
    private String appNo;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 附加数据
     */
    private String extra;
    /**
     * 商户号
     */
    private String mchNo;
    /**
     * 商户订单号
     */
    private String mchTradeNo;
    /**
     * 通知地址
     */
    private String notifyUrl;
    /**
     * 随机串
     */
    private String nonce;
    /**
     * 签名
     */
    private String sign;
    /**
     * 签名方式
     */
    private String signType;
    /**
     * 订单过期时间
     */
    private String timeExpire;

    /**
     * java sdk版本号
     */
    private String acoPaySdk = AcopayConstant.ACO_PAY_SDK_VERSION;

    /**
    * 调用接口版本号
    * @since  2024/7/11 10:44
    */
    private String version = AcopayConstant.VERSION;

    public String getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public String getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(String amountTotal) {
        this.amountTotal = amountTotal;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
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

    public String getMchNo() {
        return mchNo;
    }

    public void setMchNo(String mchNo) {
        this.mchNo = mchNo;
    }

    public String getMchTradeNo() {
        return mchTradeNo;
    }

    public void setMchTradeNo(String mchTradeNo) {
        this.mchTradeNo = mchTradeNo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getAcoPaySdk() {
        return acoPaySdk;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "AcopayTradeAppModel{" +
                "amountCurrency='" + amountCurrency + '\'' +
                ", amountTotal='" + amountTotal + '\'' +
                ", appNo='" + appNo + '\'' +
                ", description='" + description + '\'' +
                ", extra='" + extra + '\'' +
                ", mchNo='" + mchNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                ", timeExpire='" + timeExpire + '\'' +
                ", acoPaySdk='" + acoPaySdk + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
