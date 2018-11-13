package com.mgi.dao;

import com.mgi.bean.MgiLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    public int insertLog(@Param("log") MgiLog log);

    public List<MgiLog> selectLogIntime(@Param("date") String date);
}
