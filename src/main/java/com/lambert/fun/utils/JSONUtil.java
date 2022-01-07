package com.lambert.fun.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: JSON 工具类
 * @Author: liyupeng
 * @Date: 2021/2/25
 */
public class JSONUtil {

    /**
     * json转对象
     * @param json
     * @param clazz<T>
     * @return
     */
    public final static <T> T parseObject(String json, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        try {
            //忽略未知属性的反序列化
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转json
     * @param obj
     * @return
     */
    public final static String toJSONString(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
