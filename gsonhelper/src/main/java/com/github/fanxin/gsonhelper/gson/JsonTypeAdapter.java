package com.github.fanxin.gsonhelper.gson;

import android.text.TextUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * 作者: 范鑫
 * 时间:2019/7/29
 * 邮箱:itfanxin@163.com
 * 备注:Json 转为对象时调用，实现JsonDeserializer<>接口
 */
public class JsonTypeAdapter {

    public static class IntegerTypeAdapter implements JsonDeserializer<Integer>{

        @Override
        public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
           if (json == null){
               return null;
           }
           try {
               if (json.isJsonNull()){
                   return null;
               }else{
                   return json.getAsInt();
               }
           }catch (Exception s){
               return null;
           }
        }
    }


    public static class StringTypeAdapter implements JsonDeserializer<String>{

        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json == null){
                return null;
            }
            try {
                //将json转成实体的对象
                String value = json.getAsJsonPrimitive().getAsString();
                if (value == null || TextUtils.equals(value.toUpperCase(),"NULL")){
                    return null;
                }else if(value.length() == 0){
                    return StringNullAdapter.NULL;
                }else {
                    return value;
                }
            }catch (Exception e){
                return null;
            }
        }
    }

    public static class LongTypeAdapter implements JsonDeserializer<Long>{

        @Override
        public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json == null){
                return null;
            }
            try {
                if (json.isJsonNull()){
                    return null;
                }else {
                    return json.getAsLong();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }


    public static class DoubleTypeAdapter implements JsonDeserializer<Double>{

        @Override
        public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json == null){
                return null;
            }
            try {
                if (json.isJsonNull()){
                    return null;
                }else {
                    return json.getAsDouble();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }


    public static class FloatTypeAdapter implements JsonDeserializer<Float>{

        @Override
        public Float deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json == null){
                return null;
            }
            try {
                if (json.isJsonNull()){
                    return null;
                }else {
                    return json.getAsFloat();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static class ShortTypeAdapter implements JsonDeserializer<Short>{

        @Override
        public Short deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json == null){
                return null;
            }
            try {
                if (json.isJsonNull()){
                    return null;
                }else {
                    return json.getAsShort();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

}
