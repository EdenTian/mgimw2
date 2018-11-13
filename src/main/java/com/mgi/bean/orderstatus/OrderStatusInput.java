package com.mgi.bean.orderstatus;

import java.util.List;

/**
 *
 */
public class OrderStatusInput {
    private List<OrderStatus> OrderStatusList;

    public List<OrderStatus> getOrderStatusList() {
        return OrderStatusList;
    }

    @Override
    public String toString() {
        return "OrderStatusInput{" +
                "OrderStatusList=" + OrderStatusList +
                '}';
    }

    public void setOrderStatusList(List<OrderStatus> orderStatusList) {
        OrderStatusList = orderStatusList;
    }

    public OrderStatusInput() {
    }

    public OrderStatusInput(List<OrderStatus> orderStatusList) {
        OrderStatusList = orderStatusList;
    }
}
