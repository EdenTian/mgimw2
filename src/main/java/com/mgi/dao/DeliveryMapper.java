package com.mgi.dao;

import com.mgi.bean.delivery.DeliveryInfoInput;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryMapper {
    List<DeliveryInfoInput> getInfoInTime(@Param("strDate") String strDate, @Param("endDate") String now);

    List<DeliveryInfoInput> getInfoByIds(@Param("allIds") List<String> allIds);
}
