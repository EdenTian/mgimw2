package com.mgi.service;

import com.mgi.bean.ErrorData;

import java.util.List;

public interface ErrorDataService {

    int mysqlSaveData(List<String> list, String supplierType, String now);

    List<ErrorData> mysqlSelectErrorData();

    void mysqlUpdate(List<String> list, String s, String now);
}
