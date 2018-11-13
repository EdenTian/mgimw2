package com.mgi.service.impl;

import com.mgi.bean.SupplyInfo;
import com.mgi.dao.SupplierMapper;
import com.mgi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商服务层
 */
@Service
public class SupplierServiceImpl  implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 从erp中获取数据
     */
    @Override
    public List<SupplyInfo> getInfoInTime(String strDate, String endDate) {
        return supplierMapper.getInfoInTime(strDate, endDate);

    }
    /**
     * 通过ids从erp获取供应商信息
     * @param supplierIds
     * @return
     */
    @Override
    public List<SupplyInfo> getInfoByIds(List<String> supplierIds) {
        List<SupplyInfo> supplierInfoByIds = null;
        if (supplierIds.size() > 0){
            supplierInfoByIds = supplierMapper.getInfoByIds(supplierIds);
        }
        return supplierInfoByIds;
    }






}
