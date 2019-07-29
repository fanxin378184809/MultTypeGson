package com.github.fanxin.gsonhelper.gson;

import com.github.fanxin.gsonhelper.mulittypegson.MultiTypeGsonBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 作者: 范鑫
 * 时间:2019/7/29
 * 邮箱:itfanxin@163.com
 * 备注: gson 的默认值处理
 *
 * gson的注解
 * @Expose 是否序列化与反序列化
 * @SerializedName 序列化时候的名称
 */
public class GsonHelper {

    public static Gson getGson(){
        return getBuilder().create();
    }

    public static GsonBuilder getBuilder(){
        //registerTypeAdapter 注册到适配器
        return new GsonBuilder()
                .registerTypeAdapter(int.class,new JsonTypeAdapter.IntegerTypeAdapter())
                .registerTypeAdapter(long.class,new JsonTypeAdapter.LongTypeAdapter())
                .registerTypeAdapter(String.class,new JsonTypeAdapter.StringTypeAdapter())
                .registerTypeAdapter(float.class,new JsonTypeAdapter.FloatTypeAdapter())
                .registerTypeAdapter(double.class,new JsonTypeAdapter.DoubleTypeAdapter())
                .registerTypeAdapter(short.class,new JsonTypeAdapter.ShortTypeAdapter())
                .serializeNulls();

    }

    /**
     * 获取解析多种格式的gson
     */
    public static MultiTypeGsonBuilder getMultiType(){
        return new MultiTypeGsonBuilder(getBuilder());
    }

    /**
     * 处理String为null的情况返回""
     */
    public static Gson getGsonNotNull(){
        return getBuilderNotNull().create();
    }
    public static GsonBuilder getBuilderNotNull(){
        return new GsonBuilder()
                .registerTypeAdapter(int.class, new JsonTypeAdapter.IntegerTypeAdapter())
                .registerTypeAdapter(long.class, new JsonTypeAdapter.LongTypeAdapter())
                .registerTypeAdapter(float.class, new JsonTypeAdapter.FloatTypeAdapter())
                .registerTypeAdapter(double.class, new JsonTypeAdapter.DoubleTypeAdapter())
                .registerTypeAdapter(short.class, new JsonTypeAdapter.ShortTypeAdapter())
                .registerTypeAdapterFactory(StringNullAdapter.newFactory())
                .serializeNulls();
    }

    /**
     * 获取解析多钟格式的gson
     * 处理String 为 null 的情况返回 ""
     */
    public static MultiTypeGsonBuilder getMultiTypeNotNull(){
        return new MultiTypeGsonBuilder(getBuilderNotNull());
    }
}
