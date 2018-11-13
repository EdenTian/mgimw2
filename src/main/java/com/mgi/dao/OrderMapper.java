package com.mgi.dao;

import com.mgi.bean.order.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {


    void insert(@Param("orders") List<OrderInfo> orders);
}
