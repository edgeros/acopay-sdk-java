package com.edgeros.pay.model.request;

/**
 * Acopay API: Acopay refund query request
 *
 * @since 1.0.0
 */
public class AcopayRefundQueryRequestModel extends AcopayRequest  {

    private static final long serialVersionUID = -3491932336235191194L;

    /**
     * 商户退单号
     */
    private String mchRefundNo;

    /**
     * 翼辉退单号
     */
    private String refundNo;

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

    @Override
    public String toString() {
        return "AcopayRefundQueryRequestModel{" +
                "mchRefundNo='" + mchRefundNo + '\'' +
                ", refundNo='" + refundNo + '\'' +
                '}';
    }

}
