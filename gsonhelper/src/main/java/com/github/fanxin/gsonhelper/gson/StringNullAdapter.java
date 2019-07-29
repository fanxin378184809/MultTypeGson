package com.github.fanxin.gsonhelper.gson;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * 作者: 范鑫
 * 时间:2019/7/29
 * 邮箱:itfanxin@163.com
 * 备注:Gson 类型适配器
 * 保证json的String不会返回null
 */
public class StringNullAdapter extends TypeAdapter<String> {
    public static String NULL = "";

    //序列化
    @Override
    public void write(JsonWriter out, String value) throws IOException {
        if (value == null){
            out.nullValue();
            return;
        }
        out.value(value);
    }

    //反序列化
    @Override
    public String read(JsonReader in) throws IOException {
        try {
            JsonElement value = Streams.parse(in);
            if (value.isJsonNull() || TextUtils.isEmpty(value.getAsString()) || TextUtils.equals(value.getAsString(), "NULL")) {
                return NULL;
            }
            return value.getAsString();
        } catch (JsonParseException e) {
            return NULL;
        }
    }

    private static class NullStringToEmptyAdapterFactory implements TypeAdapterFactory{
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class){
                return null;
            }
            //匹配成功
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }

    public static TypeAdapterFactory newFactory(){
        return new NullStringToEmptyAdapterFactory();
    }
}
