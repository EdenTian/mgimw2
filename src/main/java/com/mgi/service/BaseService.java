package com.mgi.service;

import java.util.List;

public interface BaseService<T> {
    List<T> getInfoInTime(String strDate, String endDate);
    List<T> getInfoByIds(List<String> allIds);
}
