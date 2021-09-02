package com.edgeros.pay.model.request;

import java.io.Serializable;

/**
 * Acopay API: Acopay Request Headers
 *
 * @since 1.0.0
 */
public class AcopayRequestHeadersModel implements Serializable {

    private static final long serialVersionUID = 862975841817356614L;
    /**
     * 商户号
     */
    private String mchNo;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 签名
     */
    private String sign;

    /**
     * 签名类型
     */
    private String signType;

    public String getMchNo() {
        return mchNo;
    }

    public void setMchNo(String mchNo) {
        this.mchNo = mchNo;
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

    @Override
    public String toString() {
        return "AcopayRequestHeadersModel{" +
                "mchNo='" + mchNo + '\'' +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", signType='" + signType + '\'' +
                '}';
    }
}
