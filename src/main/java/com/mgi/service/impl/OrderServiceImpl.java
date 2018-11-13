package com.mgi.service.impl;

import com.mgi.bean.order.Order;
import com.mgi.bean.order.OrderInfo;
import com.mgi.dao.OrderMapper;
import com.mgi.service.OrderService;
import com.mgi.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *    订单定时任务的业务层
 */
@Service
public class OrderServiceImpl implements OrderService {
   @Autowired
   private OrderMapper orderMapper;


    @Override
    public void insertOederInfo(String str) {
        //解析订单数据，
        System.out.println("str = " + str);
        Order order = JsonUtils.parseJSONToList(str, Order.class);

        System.out.println("order = " + order);
        System.out.println(order.getOrders());
        List<OrderInfo> orders = order.getOrders();
        //将数据插入到erp的表中
        orderMapper.insert(orders);


    }
}
