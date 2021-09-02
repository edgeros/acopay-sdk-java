package com.edgeros.pay.model.request;

/**
 * Acopay API: Acopay trade close request
 *
 * @since 1.0.0
 */
public class AcopayTradeCloseRequestModel extends AcopayRequest {

    private static final long serialVersionUID = -3453935011116492746L;
    /**
     * 翼辉订单号
     */
    private String transactionNo;
    /**
     * 商户订单号
     */
    private String mchTradeNo;


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

    @Override
    public String toString() {
        return "AcopayTradeCloseRequestModel{" +
                "transactionNo='" + transactionNo + '\'' +
                ", mchTradeNo='" + mchTradeNo + '\'' +
                '}';
    }
}
