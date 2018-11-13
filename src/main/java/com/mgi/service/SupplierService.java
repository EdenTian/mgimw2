package com.mgi.service;

import com.mgi.bean.SupplyInfo;

import java.util.List;

/**
 *
 */
public interface SupplierService extends BaseService<SupplyInfo> {
    @Override
    List<SupplyInfo> getInfoInTime(String strDate, String endDate);
    @Override
    List<SupplyInfo> getInfoByIds(List<String> allIds);
}
