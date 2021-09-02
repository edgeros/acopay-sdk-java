package com.edgeros.pay.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Acopay API: Acopay bill request
 *
 * @since 1.0.0
 */
public class AcopayBillRequestModel extends AcopayRequest {

    private static final long serialVersionUID = 3725014350854525382L;

    /**
     * 账单日期
     */
    @JsonProperty(value = "bill_date")
    private String billDate;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    @Override
    public String toString() {
        return "AcopayBillRequestModel{" +
                "billDate='" + billDate + '\'' +
                '}';
    }
}
