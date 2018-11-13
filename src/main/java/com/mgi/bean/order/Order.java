package com.mgi.bean.order;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class Order implements Serializable {
    private List<OrderInfo> orders;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orders=" + orders +
                '}';
    }

    public List<OrderInfo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderInfo> orders) {
        this.orders = orders;
    }

    public Order(List<OrderInfo> orders) {
        this.orders = orders;
    }
}
