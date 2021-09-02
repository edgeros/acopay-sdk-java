package com.edgeros.pay;

import com.edgeros.pay.constant.AcopayConstant;
import com.edgeros.pay.exception.AcopayException;
import com.edgeros.pay.model.request.*;
import com.edgeros.pay.model.response.*;
import com.edgeros.pay.util.AcopayCommonUtil;
import com.edgeros.pay.util.AcopayHttpClientUtil;
import com.edgeros.pay.util.AcopaySignUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import static com.edgeros.pay.constant.AcopayConstant.DATA;
import static com.edgeros.pay.constant.AcopayConstant.SIGN_TYPE;

/**
 * Acopay Client Default
 *
 * @since 1.0.0
 */
public class DefaultAcopayClient implements AcopayClient {

    private static final Log log = LogFactory.getLog(DefaultAcopayClient.class);

    /**
     * 翼辉支付平台公钥
     */
    private final String publicKey;
    /**
     * 商户私钥
     */
    private final String privateKey;
    /**
     * 商户号
     */
    private final String mchNo;


    public DefaultAcopayClient(String publicKey, String privateKey, String mchNo) {
        if (StringUtils.isBlank(publicKey)) {
            throw new IllegalArgumentException("DefaultAcopayClient.publicKey is null or empty");
        }
        if (StringUtils.isBlank(privateKey)) {
            throw new IllegalArgumentException("DefaultAcopayClient.privateKey is null or empty");
        }
        if (StringUtils.isBlank(mchNo)) {
            throw new IllegalArgumentException("DefaultAcopayClient.mchNo is null or empty");
        }
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.mchNo = mchNo;
    }


    @Override
    public AcopayResponse<AcopayBillResponseModel> bill(AcopayBillRequestModel acopayBillRequestModel)
            throws AcopayException {

        log.debug("Get bill request:" + acopayBillRequestModel);

        String requestUrl = getRequestUrl(acopayBillRequestModel, AcopayConstant.BILL_URL);

        AcopayRequestHeadersModel acopayRequestHeadersModel = this.getHeaders(acopayBillRequestModel, privateKey, mchNo);

        if (StringUtils.isBlank(acopayBillRequestModel.getBillDate())) {
            throw new AcopayException("Parameter cannot be empty");
        }

        try {
            AcopayResponse<AcopayBillResponseModel> acopayResponse = AcopayHttpClientUtil.doGet(acopayRequestHeadersModel,
                    requestUrl, AcopayCommonUtil.beanToLowerUnderscoreMap(acopayBillRequestModel),
                    new TypeReference<AcopayResponse<AcopayBillResponseModel>>() {
                    });
            log.debug("Get bill response:" + acopayResponse);

            // 验证签名
            verify(acopayResponse, publicKey);
            return acopayResponse;

        } catch (URISyntaxException | IOException e) {
            throw new AcopayException(e);
        }
    }

    @Override
    public AcopayResponse<AcopayRefundResponseModel> refund(AcopayRefundRequestModel acopayRefundRequestModel)
            throws AcopayException {

        log.debug("Refund request:" + acopayRefundRequestModel);

        String requestUrl = getRequestUrl(acopayRefundRequestModel, AcopayConstant.REFUND_URL);

        AcopayRequestHeadersModel acopayRequestHeadersModel = this.getHeaders(acopayRefundRequestModel, privateKey, mchNo);

        try {
            AcopayResponse<AcopayRefundResponseModel> acopayResponse = AcopayHttpClientUtil.doPost(acopayRequestHeadersModel,
                    requestUrl,
                    AcopayCommonUtil.beanToLowerUnderscoreMap(acopayRefundRequestModel),
                    new TypeReference<AcopayResponse<AcopayRefundResponseModel>>() {
                    });
            log.debug("Refund response:" + acopayResponse);

            // 验证签名
            verify(acopayResponse, publicKey);

            return acopayResponse;
        } catch (IOException e) {
            throw new AcopayException(e);
        }
    }


    @Override
    public AcopayResponse<AcopayRefundQueryResponseModel> refundQuery(AcopayRefundQueryRequestModel acopayRefundQueryRequestModel)
            throws AcopayException {

        log.debug("Refund query request:" + acopayRefundQueryRequestModel);

        String requestUrl = getRequestUrl(acopayRefundQueryRequestModel, AcopayConstant.REFUND_QUERY_URL);

        AcopayRequestHeadersModel acopayRequestHeadersModel = this.getHeaders(acopayRefundQueryRequestModel, privateKey, mchNo);

        if (StringUtils.isBlank(acopayRefundQueryRequestModel.getMchRefundNo())
                && StringUtils.isBlank(acopayRefundQueryRequestModel.getRefundNo())) {
            throw new AcopayException("MchRefundNo and refundNo cannot be all empty");
        }
        try {
            AcopayResponse<AcopayRefundQueryResponseModel> acopayResponse = AcopayHttpClientUtil
                    .doGet(acopayRequestHeadersModel,
                            requestUrl,
                            AcopayCommonUtil.beanToLowerUnderscoreMap(acopayRefundQueryRequestModel),
                            new TypeReference<AcopayResponse<AcopayRefundQueryResponseModel>>() {
                            });
            log.debug("Refund query response:" + acopayResponse);

            // 验证签名
            verify(acopayResponse, publicKey);

            return acopayResponse;
        } catch (URISyntaxException | IOException e) {
            throw new AcopayException(e);
        }

    }

    @Override
    public AcopayResponse<AcopayTradeCloseResponseModel> tradeClose(AcopayTradeCloseRequestModel acopayTradeCloseRequestModel)
            throws AcopayException {

        log.debug("Trade close request:" + acopayTradeCloseRequestModel);

        String requestUrl = getRequestUrl(acopayTradeCloseRequestModel, AcopayConstant.TRADE_CLOSE_URL);
        AcopayRequestHeadersModel acopayRequestHeadersModel = this.getHeaders(acopayTradeCloseRequestModel, privateKey, mchNo);

        try {
            AcopayResponse<AcopayTradeCloseResponseModel> acopayResponse = AcopayHttpClientUtil
                    .doPost(acopayRequestHeadersModel, requestUrl,
                            AcopayCommonUtil.beanToLowerUnderscoreMap(acopayTradeCloseRequestModel),
                            new TypeReference<AcopayResponse<AcopayTradeCloseResponseModel>>() {
                            });
            log.debug("Trade close response:" + acopayResponse);

            // 验证签名
            verify(acopayResponse, publicKey);

            return acopayResponse;
        } catch (IOException e) {
            throw new AcopayException(e);
        }

    }

    @Override
    public AcopayResponse<AcopayTradeQueryResponseModel> tradeQuery(AcopayTradeQueryRequestModel acopayTradeQueryRequestModel)
            throws AcopayException {

        log.debug("Trade query request:" + acopayTradeQueryRequestModel);

        String requestUrl = getRequestUrl(acopayTradeQueryRequestModel, AcopayConstant.TRADE_QUERY_URL);

        // 获取请求头部信息
        AcopayRequestHeadersModel acopayRequestHeadersModel = this.getHeaders(acopayTradeQueryRequestModel, privateKey, mchNo);
        // 发送请求
        if (StringUtils.isBlank(acopayTradeQueryRequestModel.getMchTradeNo())
                && StringUtils.isBlank(acopayTradeQueryRequestModel.getTransactionNo())) {
            throw new AcopayException("MchTradeNo and transactionNo can not be all empty");
        }
        try {
            AcopayResponse<AcopayTradeQueryResponseModel> acopayResponse = AcopayHttpClientUtil
                    .doGet(acopayRequestHeadersModel,
                            requestUrl,
                            AcopayCommonUtil.beanToLowerUnderscoreMap(acopayTradeQueryRequestModel),
                            new TypeReference<AcopayResponse<AcopayTradeQueryResponseModel>>() {
                            });

            log.debug("Trade query response:" + acopayTradeQueryRequestModel);

            // 验证签名
            verify(acopayResponse, publicKey);

            return acopayResponse;
        } catch (URISyntaxException | IOException e) {
            throw new AcopayException(e);
        }
    }

    /**
     * 获取接口调用所需要的请求头参数
     *
     * @param commonRequest 请求参数
     * @param privateKey    商户私钥
     * @param mchNo         商户号
     * @return AcopayRequestHeadersModel 翼辉支付请求参数
     * @throws AcopayException 翼辉支付异常信息
     */
    public AcopayRequestHeadersModel getHeaders(AcopayRequest commonRequest, String privateKey, String mchNo) throws AcopayException {

        // 添加随机数请求头
        String nonce = AcopayCommonUtil.getRandomString(32);

        String sign = null;
        try {
            Map<String, Object> signParamMap = AcopayCommonUtil.beanToLowerUnderscoreMap(commonRequest);
            signParamMap.put("nonce", nonce);
            signParamMap.put("mch_no", mchNo);
            signParamMap.put("sign_type", SIGN_TYPE);
            sign = AcopaySignUtil.getSign(signParamMap, privateKey);
        } catch (Exception e) {
            throw new AcopayException("Generate headers error:" + e);
        }
        // 添加签名请求头
        AcopayRequestHeadersModel acopayRequestHeadersModel = new AcopayRequestHeadersModel();
        // 签名值
        acopayRequestHeadersModel.setSign(sign);
        // 随机串
        acopayRequestHeadersModel.setNonce(nonce);
        // 商户号
        acopayRequestHeadersModel.setMchNo(mchNo);
        // 签名方法
        acopayRequestHeadersModel.setSignType(SIGN_TYPE);

        return acopayRequestHeadersModel;
    }


    /**
     * 验证签名
     *
     * @param acopayResponse 翼辉支付返回参数
     * @param publicKey      翼辉支付平台公钥
     * @throws AcopayException 翼辉支付异常信息
     */
    public void verify(AcopayResponse acopayResponse, String publicKey) throws AcopayException {
        if (acopayResponse.statusSuccessful()
                || (!acopayResponse.statusSuccessful() && acopayResponse.getData() != null
                && StringUtils.isNotBlank(acopayResponse.getData().getSign()))) {
            AcopayCommonResponse commonResponse = acopayResponse.getData();
            String signType = commonResponse.getSignType();
            if (!StringUtils.equals(signType, SIGN_TYPE)) {
                throw new AcopayException("Sign type is not supported：" + signType);
            }
            try {
                Map<String, Object> dataMap = AcopayCommonUtil.beanToLowerUnderscoreMap(commonResponse);
                Map<String, Object> acopayResponseMap = AcopayCommonUtil.beanToMap(acopayResponse);
                acopayResponseMap.put(DATA, dataMap);
                AcopaySignUtil.verifySign(acopayResponseMap, publicKey);
            } catch (Exception e) {
                throw new AcopayException(e);
            }
        }
    }
    /**
     * @Description: 获取请求 url
     * @param acopayRequest 用户配置的请求参数
     * @param defaultUrl 默认的请求 url
     * @return 请求接口的 url 地址
     */
    private String getRequestUrl(AcopayRequest acopayRequest, String defaultUrl) {
        String requestUrl = defaultUrl;
        if (StringUtils.isNotBlank(acopayRequest.getRequestUrl())) {
            requestUrl = acopayRequest.getRequestUrl();
            acopayRequest.setRequestUrl(null);
        }
        return requestUrl;
    }
}
