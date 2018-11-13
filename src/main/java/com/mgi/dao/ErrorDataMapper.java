package com.mgi.dao;

import com.mgi.bean.ErrorData;
import com.mgi.bean.ErrorDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErrorDataMapper {
    long countByExample(ErrorDataExample example);

    int deleteByExample(ErrorDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrorData record);

    int insertSelective(ErrorData record);

    List<ErrorData> selectByExample(ErrorDataExample example);

    ErrorData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrorData record, @Param("example") ErrorDataExample example);

    int updateByExample(@Param("record") ErrorData record, @Param("example") ErrorDataExample example);

    int updateByPrimaryKeySelective(ErrorData record);

    int updateByPrimaryKey(ErrorData record);

    int insertByBatch(@Param("list") List<String> list,@Param("type") String type, @Param("createDate") String createDate);

    void updateByBatch(@Param("list")List<String> list,@Param("flag") String s,@Param("updateDate") String now);
}