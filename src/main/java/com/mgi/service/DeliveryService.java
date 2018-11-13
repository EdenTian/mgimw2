package com.mgi.service;

import com.mgi.bean.delivery.DeliveryInfoInput;

import java.util.List;

public interface DeliveryService extends BaseService<DeliveryInfoInput> {
    @Override
    List<DeliveryInfoInput> getInfoInTime(String strDate, String now);
    @Override
    List<DeliveryInfoInput> getInfoByIds(List<String> allIds);


}
