package com.edgeros.pay;

import com.edgeros.pay.exception.AcopayException;
import com.edgeros.pay.model.request.*;
import com.edgeros.pay.model.response.*;

/**
 * Acopay Client
 *
 * @since 1.0.0
 */
public interface AcopayClient {

    /**
     * 获取商户账单信息
     *
     * @param acopayBillRequestModel 请求账单信息参数
     * @return 账单信息
     * @throws AcopayException 翼辉支付异常信息
     */
    AcopayResponse<AcopayBillResponseModel> bill(AcopayBillRequestModel acopayBillRequestModel) throws AcopayException;

    /**
     * 对指定的订单进行退款申请
     *
     * @param acopayRefundRequestModel 申请退款请求参数
     * @return 退款申请结果
     * @throws AcopayException 翼辉支付异常信息
     */
    AcopayResponse<AcopayRefundResponseModel> refund(AcopayRefundRequestModel acopayRefundRequestModel) throws AcopayException;

    /**
     * 查询退款结果
     *
     * @param acopayRefundQueryRequestModel 退款查询请求参数
     * @return 退款订单查询结果
     * @throws AcopayException 翼辉支付异常信息
     */
    AcopayResponse<AcopayRefundQueryResponseModel> refundQuery(AcopayRefundQueryRequestModel acopayRefundQueryRequestModel) throws AcopayException;

    /**
     * 关闭订单
     *
     * @param acopayTradeCloseRequestModel 关闭订单请求参数
     * @return 关单结果
     * @throws AcopayException 翼辉支付异常信息
     */
    AcopayResponse<AcopayTradeCloseResponseModel> tradeClose(AcopayTradeCloseRequestModel acopayTradeCloseRequestModel)
            throws AcopayException;

    /**
     * 交易查询
     *
     * @param acopayTradeQueryRequestModel 查询订单参数
     * @return 查询订单结果
     * @throws AcopayException 翼辉支付异常信息
     */
    AcopayResponse<AcopayTradeQueryResponseModel> tradeQuery(AcopayTradeQueryRequestModel acopayTradeQueryRequestModel) throws AcopayException;


}
