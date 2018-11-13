package com.mgi.service.impl;

import com.mgi.bean.orderstatus.OrderStatusInput;
import com.mgi.dao.OrderStatusMapper;
import com.mgi.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService<OrderStatusInput> {
    @Autowired
    private OrderStatusMapper orderStatusMapper;
    @Override
    public List<OrderStatusInput> getInfoInTime(String strDate, String endDate) {
        return  orderStatusMapper.getInfoInTime(strDate, endDate);
    }

    @Override
    public List<OrderStatusInput> getInfoByIds(List<String> allIds) {
        return  orderStatusMapper.getInfoByIds(allIds);
    }
}
