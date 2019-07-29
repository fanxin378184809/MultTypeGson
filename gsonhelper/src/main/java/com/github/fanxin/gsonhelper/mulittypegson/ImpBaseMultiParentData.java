package com.github.fanxin.gsonhelper.mulittypegson;

import java.util.List;

/**
 * 作者: 范鑫
 * 时间:2019/7/29
 * 邮箱:itfanxin@163.com
 * 备注:需要动态解析上一级类,实现
 */
public class ImpBaseMultiParentData implements BaseMultiParentData {
    @Override
    public <T> List<T> getArrayData() {
        return null;
    }

    @Override
    public <T> T getObject() {
        return null;
    }
}
