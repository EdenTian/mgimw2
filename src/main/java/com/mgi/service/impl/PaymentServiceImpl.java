package com.mgi.service.impl;

import com.mgi.bean.payment.PaymentLineInfo;
import com.mgi.dao.PaymentMapper;
import com.mgi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public List<PaymentLineInfo> getInfoInTime(String strDate, String endDate) {
        return paymentMapper.getInfoInTime(strDate,endDate);
    }

    @Override
    public List<PaymentLineInfo> getInfoByIds(List<String> allIds) {
        return paymentMapper.getInfoByIds(allIds);
    }
}
