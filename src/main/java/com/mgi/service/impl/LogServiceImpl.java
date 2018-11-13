package com.mgi.service.impl;

import com.mgi.bean.MgiLog;
import com.mgi.dao.LogMapper;
import com.mgi.service.LogService;
import com.mgi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    public void loginsert(MgiLog log){

        try {
            logMapper.insertLog(log);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public List<MgiLog> logSelectLogIntime(){
       return  logMapper.selectLogIntime(DateUtil.getNow().split(" ")[0]);
    }
    public List<MgiLog> logSelectLogIntime(String date){

       return  logMapper.selectLogIntime(date);
    }
}
