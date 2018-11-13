package com.mgi.bean.delivery;

/**
 *
 */
public class DeliveryProductLineOrder {
    private String DeliveryProductLineOrderName;                      //发货单产品名称

    public String getDeliveryProductLineOrderName() {
        return DeliveryProductLineOrderName;
    }

    public void setDeliveryProductLineOrderName(String deliveryProductLineOrderName) {
        DeliveryProductLineOrderName = deliveryProductLineOrderName;
    }

    public String getDeliveryProductLineOrderSerialNO() {
        return DeliveryProductLineOrderSerialNO;
    }

    public void setDeliveryProductLineOrderSerialNO(String deliveryProductLineOrderSerialNO) {
        DeliveryProductLineOrderSerialNO = deliveryProductLineOrderSerialNO;
    }

    private String DeliveryProductLineOrderSerialNO;                  //序列号

    @Override
    public String toString() {
        return "DeliveryProductLineOrder{" +
                "DeliveryProductLineOrderName='" + DeliveryProductLineOrderName + '\'' +
                ", DeliveryProductLineOrderSerialNO='" + DeliveryProductLineOrderSerialNO + '\'' +
                '}';
    }

    public DeliveryProductLineOrder() {
    }

    public DeliveryProductLineOrder(String deliveryProductLineOrderName, String deliveryProductLineOrderSerialNO) {
        DeliveryProductLineOrderName = deliveryProductLineOrderName;
        DeliveryProductLineOrderSerialNO = deliveryProductLineOrderSerialNO;
    }
}
