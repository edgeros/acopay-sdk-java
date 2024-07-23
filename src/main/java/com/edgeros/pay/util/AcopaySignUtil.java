package com.edgeros.pay.util;

import com.edgeros.pay.exception.AcopayException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static com.edgeros.pay.constant.AcopayConstant.*;

/**
 * Acopay sign util
 *
 * @since 1.0.0
 */
public class AcopaySignUtil {

    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    /**
     * 根据请求参数与私钥字符串获取签名值
     *
     * @param signMap 加签参数
     * @param privateKey 私钥
     * @return java.lang.String
     * @throws Exception 签名异常信息
     */
    public static String getSign(Map<String, Object> signMap, String privateKey) throws Exception {

        if (StringUtils.isBlank(privateKey)) {
            throw new IllegalArgumentException("Private key can not be empty");
        }
        if (signMap == null || signMap.isEmpty()) {
            throw new IllegalArgumentException("Sign parameter can not be empty");
        }
        // 过滤空值
        filterEntries(signMap);
        //过滤不参与签名的参数
        filterNotSignEntries(signMap);
        // 进行排序
        TreeMap<String, Object> sortedMap = new TreeMap<>();
        sortedMap.putAll(signMap);
        // 序列化为 json
        String signJson = GSON.toJson(sortedMap);
        // 进行签名
        String sign = sign(signJson.getBytes(StandardCharsets.UTF_8), privateKey);
        return sign;
    }


    /**
     * 对数据进行签名
     *
     * @param message
     * @param privateKeyString
     * @return java.lang.String
     * @throws Exception
     */
    private static String sign(byte[] message, String privateKeyString) throws Exception {
        // 把私钥字符串转换为 PrivateKey
        byte[] buffer = Base64.decodeBase64(privateKeyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 获取 PrivateKey
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // 用换好的 PrivateKey 进行签名
        Signature signature = Signature.getInstance(SIGN_TYPE);
        signature.initSign(privateKey);
        signature.update(message);
        return Base64.encodeBase64String(signature.sign());
    }

    /**
     * 根据返回参数校验签名值
     *
     * @param verifyMap 验签参数
     * @param publicKey 公钥
     * @throws Exception 返回验签异常信息
     */
    public static void verifySign(Map<String, Object> verifyMap, String publicKey) throws Exception {

        if (StringUtils.isBlank(publicKey)) {
            throw new IllegalArgumentException("Public key can not be empty");
        }
        if (verifyMap == null || verifyMap.isEmpty()) {
            throw new IllegalArgumentException("Verify parameter can not be empty");
        }
        // 过滤空值
        filterEntries(verifyMap);

        // 利用 TreeMap 进行自然排序
        TreeMap<String, Object> sortedMap = new TreeMap<>();
        sortedMap.putAll(verifyMap);
        // 签名值
        String sign = "";
        if (verifyMap.containsKey(DATA) && verifyMap.get(DATA) != null) {
            // 获取业务信息
            Map<String, Object> dataMap = (Map) verifyMap.get(DATA);
            // 取 data 字段中的签名值
            sign = (String) dataMap.get(SIGN);
            dataMap.remove(SIGN);
            // 过滤空值和 sign 字段
            filterEntries(dataMap);
            // 业务数据进行排序
            TreeMap<String, Object> dataSortedMap = new TreeMap<>();
            dataSortedMap.putAll(dataMap);
            // 排好后放入 sortedMap 替换原来的无序 data
            sortedMap.put(DATA, dataSortedMap);
        } else {
            sign = (String) sortedMap.get(SIGN);
            sortedMap.remove(SIGN);
        }
        if (StringUtils.isBlank(sign)) {
            throw new AcopayException("Signature can not be empty");
        }
        // 序列化为 json
        String verifyJson = GSON.toJson(sortedMap);
        if (!verify(sign, verifyJson, publicKey)) {
            throw new AcopayException("Invalid signature:" + GSON.toJson(verifyMap));
        }
    }

    /**
     * 验证签名是否正确
     *
     * @param sign 签名值
     * @param verifyJson 验签字符串
     * @param publicKeyString 公钥字符串
     * @return 验签结果
     * @throws Exception 返回验签异常信息
     */
    private static boolean verify(String sign, String verifyJson, String publicKeyString) throws Exception {
        // 把翼辉支付平台公钥字符串转换为 PublicKey
        byte[] buffer = Base64.decodeBase64(publicKeyString);

        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        // 进行验签操作
        Signature signature = Signature.getInstance(SIGN_TYPE);
        signature.initVerify(publicKey);
        signature.update(verifyJson.getBytes(StandardCharsets.UTF_8));
        // 签名参数 sign 的值经过 base64 解码后验签
        return signature.verify(Base64.decodeBase64(sign));
    }

    /**
     * 过滤空值
     *
     * @param signParamMap 参数集合
     */
    private static void filterEntries(Map<String, Object> signParamMap) {
        if (signParamMap != null && !signParamMap.isEmpty()) {
            Iterator<Map.Entry<String, Object>> iterator = signParamMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                if (StringUtils.isBlank(next.getKey()) || next.getValue() == null) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * 过滤不参与签名的参数
     *
     * @param signParamMap 参数集合
     */
    private static void filterNotSignEntries(Map<String, Object> signParamMap) {
        if (signParamMap != null && !signParamMap.isEmpty()) {
            signParamMap.remove("aco_pay_sdk");
            signParamMap.remove("version");
        }
    }
}
