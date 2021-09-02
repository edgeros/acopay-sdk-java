package com.edgeros.pay.util;

import com.edgeros.pay.constant.AcopayConstant;
import com.edgeros.pay.exception.AcopayException;
import com.edgeros.pay.model.request.AcopayRequestHeadersModel;
import com.edgeros.pay.model.response.AcopayCommonResponse;
import com.edgeros.pay.model.response.AcopayResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 * Acopay httpclient util
 *
 * @since 1.0.0
 */
public class AcopayHttpClientUtil {


    /**
     * 通过 httpClient 发送 GET 请求
     *
     * @param acopayRequestHeadersModel 请求头参数
     * @param requestUrl                请求url
     * @param parameterMap              请求参数
     * @param typeRef                   返回值类型
     * @return 翼辉支付平台响应信息
     * @throws AcopayException 翼辉支付异常信息
     * @throws URISyntaxException URI Syntax Exception
     * @throws IOException  IO Exception
     */
    public static <T extends AcopayCommonResponse> AcopayResponse<T> doGet(AcopayRequestHeadersModel acopayRequestHeadersModel,
                                                                           String requestUrl, Map<String, Object> parameterMap,
                                                                           TypeReference<AcopayResponse<T>> typeRef)
            throws AcopayException, URISyntaxException, IOException {
        // 创建 httpClient 实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(requestUrl);

            if (parameterMap != null && !parameterMap.isEmpty()) {
                for (Iterator<Map.Entry<String, Object>> iterator = parameterMap.entrySet().iterator();
                     iterator.hasNext(); ) {
                    Map.Entry<String, Object> next = iterator.next();
                    if (StringUtils.isBlank(next.getKey()) || next.getValue() == null) {
                        continue;
                    }
                    uriBuilder.addParameter(next.getKey(), next.getValue().toString());
                }
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("Accept", "application/json");
            httpGet.addHeader(AcopayConstant.HEADERS_MCH_NO, acopayRequestHeadersModel.getMchNo());
            httpGet.addHeader(AcopayConstant.HEADERS_NONCE, acopayRequestHeadersModel.getNonce());
            httpGet.addHeader(AcopayConstant.HEADERS_SIGN_TYPE, acopayRequestHeadersModel.getSignType());
            httpGet.addHeader(AcopayConstant.HEADERS_SIGN, acopayRequestHeadersModel.getSign());

            RequestConfig requestConfig = getRequestConfig();

            httpGet.setConfig(requestConfig);

            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                // 获取Response状态码 判断是否请求成功
                if (response.getStatusLine() == null || response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    throw new AcopayException("Request error,http response:" + response.toString());
                }
                // 获取响应实体, 响应内容
                HttpEntity entity = response.getEntity();
                // 将返回值结果转换为对象
                AcopayResponse<T> acopayResponse = new ObjectMapper().readValue(EntityUtils.toString(entity), typeRef);
                return acopayResponse;
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }

    /**
     * 获取请求配置
     *
     * @return org.apache.http.client.config.RequestConfig
     */
    private static RequestConfig getRequestConfig() {
        return RequestConfig.custom().setConnectTimeout(5 * 1000)
                .setConnectionRequestTimeout(10 * 1000)
                .setSocketTimeout(10 * 1000)
                .build();
    }

    /**
     * 通过 httpClient 发送 POST 请求
     *
     * @param acopayRequestHeadersModel 请求头参数
     * @param requestUrl                请求url
     * @param parameterMap              请求参数
     * @param typeRef                   返回值类型
     * @return 翼辉支付平台响应信息
     * @throws AcopayException 翼辉支付异常信息
     * @throws IOException  IO Exception
     */
    public static <T extends AcopayCommonResponse> AcopayResponse<T> doPost(AcopayRequestHeadersModel acopayRequestHeadersModel,
                                                                            String requestUrl, Map<String, Object> parameterMap,
                                                                            TypeReference<AcopayResponse<T>> typeRef)
            throws AcopayException, IOException {

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // 创建httpPost远程连接实例
        HttpPost post = new HttpPost(requestUrl);
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        try {
            HttpEntity entity = new StringEntity(AcopayCommonUtil.GSON.toJson(parameterMap), StandardCharsets.UTF_8);
            post.setEntity(entity);

            post.setHeader("Content-type", "application/json");
            post.setHeader("Accept", "application/json");
            post.setHeader(AcopayConstant.HEADERS_MCH_NO, acopayRequestHeadersModel.getMchNo());
            post.setHeader(AcopayConstant.HEADERS_NONCE, acopayRequestHeadersModel.getNonce());
            post.setHeader(AcopayConstant.HEADERS_SIGN_TYPE, acopayRequestHeadersModel.getSignType());
            post.setHeader(AcopayConstant.HEADERS_SIGN, acopayRequestHeadersModel.getSign());

            RequestConfig requestConfig = getRequestConfig();

            post.setConfig(requestConfig);
            HttpResponse response = closeableHttpClient.execute(post);
            // 获取Response状态码 判断是否请求成功
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcopayException("Request error,http status:" + response);
            }
            HttpEntity respEntity = response.getEntity();
            AcopayResponse<T> acopayResponse = new ObjectMapper().readValue(EntityUtils.toString(respEntity), typeRef);
            return acopayResponse;
        } finally {
            closeableHttpClient.close();
        }
    }
}
