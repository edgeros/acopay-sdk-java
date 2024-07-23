package com.edgeros.pay.constant;

/**
 * Acopay API: Acopay Constant
 *
 * @since 1.0.0
 */
public class AcopayConstant {
    /**
    * sdk 版本号
    * @since  2024/7/11 10:43
    */
    public static final String ACO_PAY_SDK_VERSION = "2.0.0";
    
    /**
    * 接口版本
    * @since  2024/7/11 10:43
    */

    public static final String VERSION = "1.0";

    /**
     * 业务结果成功状态码
     */
    public static final String RESPONSE_SUCCESS_STATUS = "200";
    /**
     * 签名算法
     */
    public static final String SIGN_TYPE = "SHA256withRSA";
    /**
     * 异步通知返回失败
     */
    public static final String NOTIFY_FAIL = "FAIL";
    /**
     * 异步通知返回成功
     */
    public static final String NOTIFY_SUCCESS = "SUCCESS";
    /**
     * 业务数据字段
     */
    public static final String DATA = "data";
    /**
     * 签名值字段
     */
    public static final String SIGN = "sign";
    /**
     * 密钥算法名称
     */
    public static final String ALGORITHM = "RSA";
    /**
     * 签名方法请求头
     */
    public static final String HEADERS_SIGN_TYPE = "x-acopay-sign-type";
    /**
     * 签名值请求头
     */
    public static final String HEADERS_SIGN = "x-acopay-sign";
    /**
     * 随机数请求头
     */
    public static final String HEADERS_NONCE = "x-acopay-nonce";
    /**
     * 商户号请求头
     */
    public static final String HEADERS_MCH_NO = "x-acopay-mch-no";
    /**
     * 查询订单接口地址
     */
    public static final String TRADE_QUERY_URL = "https://api.edgeros.com/pay/v1/transactions/trade";
    /**
     * 关闭订单接口地址
     */
    public static final String TRADE_CLOSE_URL = "https://api.edgeros.com/pay/v1/transactions/close";
    /**
     * 退款接口地址
     */
    public static final String REFUND_URL = "https://api.edgeros.com/pay/v1/transactions/refund";
    /**
     * 退款查询接口地址
     */
    public static final String REFUND_QUERY_URL = "https://api.edgeros.com/pay/v1/transactions/refund";
    /**
     * 获取对账单信息接口
     */
    public static final String BILL_URL = "https://api.edgeros.com/pay/v1/transactions/bill";

}
