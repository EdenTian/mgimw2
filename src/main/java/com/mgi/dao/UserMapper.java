package com.mgi.dao;

import com.mgi.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    
    User login(@Param("uName") String uName, @Param("uPassword") String uPassword);
}
