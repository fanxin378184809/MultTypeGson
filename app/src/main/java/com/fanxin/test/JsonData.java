package com.fanxin.test;


import java.util.List;

/**
 * 作者: 范鑫
 * 时间:2019/7/29
 * 邮箱:itfanxin@163.com
 * 备注:
 */
public class JsonData {


    /**
     * code : 1
     * msg : 操作成功
     * types : [{"id":"1","name":"测试1"},{"id":"2","name":"测试2"},{"id":"5","name":"汽车"}]
     * info : {"id":"5","name":"汽车"}
     * currentPage : 1
     * pageCount : 1
     * pageOffset : 15
     * currentRows : 1
     * list : {}
     */


    public int code;
    public String msg;
    public InfoBean info;
    public int currentPage;
    public int pageCount;
    public int pageOffset;
    public int currentRows;
    public ListBean list;
    public List<TypesBean> types;

    public static class InfoBean {
        /**
         * id : 5
         * name : 汽车
         */

        public String id;
        public String name;

    }

    public static class ListBean {
    }

    public static class TypesBean {
        /**
         * id : 1
         * name : 测试1
         */

        public String id;
        public String name;

    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", info=" + info +
                ", currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", pageOffset=" + pageOffset +
                ", currentRows=" + currentRows +
                ", list=" + list +
                ", types=" + types +
                '}';
    }
}
