package com.edgeros.pay.model.request;

/**
 * Acopay API: Acopay trade query request
 *
 * @since 1.0.0
 */
public class AcopayTradeQueryRequestModel extends AcopayRequest {

    private static final long serialVersionUID = -4260302984011044215L;
    /**
     * 商户订单号
     */
    private String mchTradeNo;

    /**
     * 翼辉订单号
     */
    private String transactionNo;

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

    @Override
    public String toString() {
        return "AcopayTradeQueryRequestModel{" +
                "mchTradeNo='" + mchTradeNo + '\'' +
                ", transactionNo='" + transactionNo + '\'' +
                '}';
    }
}
