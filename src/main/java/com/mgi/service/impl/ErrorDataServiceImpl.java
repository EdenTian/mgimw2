package com.mgi.service.impl;

import com.mgi.bean.ErrorData;
import com.mgi.bean.ErrorDataExample;
import com.mgi.dao.ErrorDataMapper;
import com.mgi.service.ErrorDataService;
import com.mgi.util.MyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 失败数据
 */
@Service
public class ErrorDataServiceImpl implements ErrorDataService {
    @Autowired
    private ErrorDataMapper errorDataMapper;

    /**
     * 将失败数据保存到数据库
     *
     * @param list         失败数据集合
     * @param supplierType 失败数据类型 1 -- 供应商
     */
    @Override
    public int mysqlSaveData(List<String> list, String supplierType, String now) {
        int i = 0;
        if (list.size() > 0){
           i =  errorDataMapper.insertByBatch(list,supplierType,now);
        }
        return i;
    }

    /**
     * 获取所有失败数据
     * @return
     */
    @Override
    public List<ErrorData> mysqlSelectErrorData() {
        ErrorDataExample ex = new ErrorDataExample();
        ex.createCriteria().andFlagEqualTo(MyConstant.ERROR_DATA_FLAG_ERROR).andTimesLessThan(3);
        //去重

        ex.setDistinct(true);
        return errorDataMapper.selectByExample(ex);
    }

    /**
     * 更新失败数据
     * @param list 需要更新的数据集合
     * @param s    需要更新的状态
     * @param now  时间
     */
    @Override
    public void mysqlUpdate(List<String> list, String s, String now) {
        if (list.size() > 0){
            errorDataMapper.updateByBatch(list,s,now);
        }
    }
}
