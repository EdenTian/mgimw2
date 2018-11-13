package com.mgi.util;

/**
 * 系统中的常量
 */
public class MyConstant {
    //数据库中成功失败的标记
    public static final String ERROR_DATA_FLAG_SUCCESS = "S";//成功
    public static final String ERROR_DATA_FLAG_ERROR = "E";//失败

     //redis中控制开始时间的key
     public static final String SUPPLIER_STR_TIME = "supplierStrTime";//获取供应商开始时间key
    public static final String ORDER_STR_TIME = "orderStrTime";//获取供应商开始时间key
    public static final String DELIVERYINFO_STR_TIME = "deliveryInfoStrTime";//获取发货信息开始时间key
    public static final String ORDERSTATUS_STR_TIME = "orderStatusStrTime";//获取发货信息开始时间key
    public static final String PAYMENT_STR_TIME = "paymentStrTime";//获取付款信息开始时间key

    //错误机制数据库中type的标记
    public static final String SUPPLIER_TYPE = "1";//1 代表 供应商
    public static final String ORDER_TYPE = "2";//2 代表 订单信息
    public static final String DELIVERYINFO_TYPE = "3";//3 代表 发货信息
    public static final String ORDERSTATUS_TYPE = "4";//4 代表 订单状态
    public static final String PAYMENT_TYPE = "5";//5 代表 付款信息

    //日志关键字
    public static final String SUPPLIER_LOG_NAME = "供应商(ERP->CRM)";//供应商
    public static final String ORDER_LOG_NAME = "订单信息(CRM->ERP)";//订单
    public static final String DELIVERY_LOG_NAME = "发货信息(ERP->CRM)";//发货信息
    public static final String ORDERSTATUS_LOG_NAME = "订单状态信息(ERP->CRM)";//订单状态
    public static final String PAYMENT_LOG_NAME = "付款信息(ERP->CRM)";//付款信息

    //转换json头
    public static final String SUPPLIER_JSON_TITLE ="{\"supplyInfos\":";//供应商
    public static final String SUPPLIER_JSON_TITLE2 ="{\"supplyInfo\":";//供应商2
    public static final String ORDER_JSON_TITLE ="{\"orders\":";//订单
    public static final String DELIVERY_JSON_TITLE ="{\"deliveryinfo\":";//发货信息
    public static final String ORDERSTATUS_JSON_TITLE ="{\"deliveryinfo\":";//订单状态
    public static final String PAYMENT_JSON_TITLE ="{\"paymentinfo\":";//付款信息

}

