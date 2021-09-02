package com.edgeros.pay.util;

import com.edgeros.pay.exception.AcopayException;
import com.google.common.base.CaseFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Acopay common util
 *
 * @since 1.0.0
 */
public class AcopayCommonUtil {

    public static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    /**
     * 生成随机数
     *
     * @param length 随机数长度
     * @return 指定长度的随机数
     */
    public static String getRandomString(int length) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom random = new SecureRandom();
        StringBuilder nonce = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            nonce.append(str.charAt(number));
        }
        return nonce.toString();
    }

    /**
     * 将 java bean 转换为 Map, 并把驼峰命名字段转换为下划线格式的 key
     *
     * @param bean Java 对象
     * @return 返回 key 值带有下划线的 map
     * @throws AcopayException 翼辉支付异常信息
     */
    public static <T> Map<String, Object> beanToLowerUnderscoreMap(T bean) throws AcopayException {
        return beanToMap(bean, true);
    }

    /**
     * 将 java bean 转换为 Map
     *
     * @param bean Java 对象
     * @return 返回 map
     * @throws AcopayException 翼辉支付异常信息
     */
    public static <T> Map<String, Object> beanToMap(T bean) throws AcopayException {
        return beanToMap(bean, false);
    }

    /**
     * bean 转换为 map
     *
     * @param bean            要转换的 bean
     * @param lowerUnderscore 是否驼峰转下划线
     * @return bean 属性的 map 集合
     * @throws AcopayException 翼辉支付异常信息
     */
    private static <T> Map<String, Object> beanToMap(T bean, boolean lowerUnderscore) throws AcopayException {
        Map<String, Object> map = new HashMap<>(16);
        try {
            Map<String, Object> beanMap = PropertyUtils.describe(bean);
            Iterator<Map.Entry<String, Object>> iterator = beanMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                if (StringUtils.equals(next.getKey(), "class")) {
                    continue;
                }
                if (lowerUnderscore) {
                    map.put(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, next.getKey()),
                            next.getValue());
                } else {
                    map.put(next.getKey(), next.getValue());
                }
            }
        } catch (Exception e) {
            throw new AcopayException("Bean to map error: " + e.getMessage());
        }
        return map;
    }
}
