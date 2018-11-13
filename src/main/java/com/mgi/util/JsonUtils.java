package com.mgi.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * 处理json转换
 */
public class JsonUtils {
    /**
     * 将list数据转换成json数据
     * @param list 需要转换的集合
     * @param jsonTitleName  转换的json头名称，在常量中定义
     * @param <T>
     * @return
     */
    public static <T> String parseListToJson(List<T> list,String jsonTitleName){
        return  jsonTitleName+JSON.toJSONString(list,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty)+ "}";
    }
    /**
     * 将json数据转换成list数据
     * @param <T>
     * @return
     */
    public static <T> T parseJSONToList(String json, Class<T> clazz){
       return JSON.parseObject(json,clazz);
    }
}
