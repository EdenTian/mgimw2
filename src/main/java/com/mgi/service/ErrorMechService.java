package com.mgi.service;

import com.mgi.util.ExecuteResult2;

import java.util.List;

public interface ErrorMechService  {
    void mysqlSaveData(List<String> list, ExecuteResult2 result, String logType, String errorType, List<String> errorIdsList);
    void mysqlUpdateData(List<String> list, ExecuteResult2 result, String logType, List<String> errorIdsList);
}
