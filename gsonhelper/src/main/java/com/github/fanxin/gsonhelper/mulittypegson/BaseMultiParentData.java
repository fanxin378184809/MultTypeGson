package com.github.fanxin.gsonhelper.mulittypegson;

import java.util.List;

/**
 * 作者: 范鑫
 * 时间:2019/7/29
 * 邮箱:itfanxin@163.com
 * 备注:需要动态解析上一级类,的抽象
 * 可以使用本类的实现类 {@link ImpBaseMultiParentData}
 * 调用
 * {@link MultiTypeGsonBuilder#registerTargetParentClass}方法
 */
public interface BaseMultiParentData {

    /**
     * 获取数据类型为数组的数据
     */
    public <T>List<T> getArrayData();

    /**
     * 获取数据类型为对象的数据
     */
    public <T> T getObject();
}
