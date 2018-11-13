package com.mgi.dao;

import com.mgi.bean.SupplyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper extends BaseMapper<SupplyInfo> {
    @Override
    List<SupplyInfo> getInfoInTime(@Param("strDate") String strDate,@Param("endDate") String endDate);
     @Override
    List<SupplyInfo> getInfoByIds(@Param("supplierIds") List<String> supplierIds);
}
