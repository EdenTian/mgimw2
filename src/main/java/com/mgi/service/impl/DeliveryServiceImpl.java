package com.mgi.service.impl;

import com.mgi.bean.delivery.DeliveryInfoInput;
import com.mgi.dao.DeliveryMapper;
import com.mgi.service.DeliveryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 接口描述：ERP中创建好发运集后，系统将发运信息同步至CRM
 */
@Service
public class DeliveryServiceImpl implements DeliveryService{
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Override
    public List<DeliveryInfoInput> getInfoInTime(String strDate, String now) {
        if (!StringUtils.isEmpty(strDate) && !StringUtils.isEmpty(now)){
            return deliveryMapper.getInfoInTime(strDate,now);
        }
        return null;

    }

    @Override
    public List<DeliveryInfoInput> getInfoByIds(List<String> allIds) {
        List<DeliveryInfoInput> deliveryInfoInputList = null;
        if (allIds.size() > 0){
            deliveryInfoInputList = deliveryMapper.getInfoByIds(allIds);
        }
        return deliveryInfoInputList;
    }
}
