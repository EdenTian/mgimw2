package com.mgi.dao;

import java.util.List;

public interface BaseMapper<T> {

    List<T> getInfoInTime( String strDate,  String endDate);

    List<T> getInfoByIds( List<String> supplierIds);
}
