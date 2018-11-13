package com.mgi.bean.orderstatus;

/**
 *
 */
public class OrderStatus {
    private String OrderNumber;				//订单编号
    private String OrderStatus;				//订单状态

    @Override
    public String toString() {
        return "OrderStatus{" +
                "OrderNumber='" + OrderNumber + '\'' +
                ", OrderStatus='" + OrderStatus + '\'' +
                '}';
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public OrderStatus() {
    }

    public OrderStatus(String orderNumber, String orderStatus) {
        OrderNumber = orderNumber;
        OrderStatus = orderStatus;
    }
}
