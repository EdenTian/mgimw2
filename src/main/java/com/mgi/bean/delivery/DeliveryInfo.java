package com.mgi.bean.delivery;

import java.util.List;

/**
 *
 */
public class DeliveryInfo {
    private String DeliveryOrderName;                    //发货单名称

    public String getDeliveryOrderName() {
        return DeliveryOrderName;
    }

    public void setDeliveryOrderName(String deliveryOrderName) {
        DeliveryOrderName = deliveryOrderName;
    }

    public String getDeliveryOrderNO() {
        return DeliveryOrderNO;
    }

    public void setDeliveryOrderNO(String deliveryOrderNO) {
        DeliveryOrderNO = deliveryOrderNO;
    }

    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }

    public String getRelatedOrder() {
        return RelatedOrder;
    }

    public void setRelatedOrder(String relatedOrder) {
        RelatedOrder = relatedOrder;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        DeliveryAddress = deliveryAddress;
    }

    public List<DeliveryProduct> getDeliveryProductList() {
        return DeliveryProductList;
    }

    public void setDeliveryProductList(List<DeliveryProduct> deliveryProductList) {
        DeliveryProductList = deliveryProductList;
    }

    private String DeliveryOrderNO;                      //发货单编号
    private String DeliveryStatus;                       //发货状态
    private String RelatedOrder;                         //相关订单
    private String DeliveryAddress;                        //发货地址
    private List<DeliveryProduct> DeliveryProductList;   //发货产品明细

    @Override
    public String toString() {
        return "DeliveryInfo{" +
                "DeliveryOrderName='" + DeliveryOrderName + '\'' +
                ", DeliveryOrderNO='" + DeliveryOrderNO + '\'' +
                ", DeliveryStatus='" + DeliveryStatus + '\'' +
                ", RelatedOrder='" + RelatedOrder + '\'' +
                ", DeliveryAddress='" + DeliveryAddress + '\'' +
                ", DeliveryProductList=" + DeliveryProductList +
                '}';
    }

    public DeliveryInfo() {
    }

    public DeliveryInfo(String deliveryOrderName, String deliveryOrderNO, String deliveryStatus, String relatedOrder, String deliveryAddress, List<DeliveryProduct> deliveryProductList) {
        DeliveryOrderName = deliveryOrderName;
        DeliveryOrderNO = deliveryOrderNO;
        DeliveryStatus = deliveryStatus;
        RelatedOrder = relatedOrder;
        DeliveryAddress = deliveryAddress;
        DeliveryProductList = deliveryProductList;
    }
}

