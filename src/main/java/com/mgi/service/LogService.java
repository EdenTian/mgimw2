package com.mgi.service;

import com.mgi.bean.MgiLog;

import java.util.List;

public interface LogService {
     void loginsert(MgiLog log);
     List<MgiLog> logSelectLogIntime();
     List<MgiLog> logSelectLogIntime(String date);
}
