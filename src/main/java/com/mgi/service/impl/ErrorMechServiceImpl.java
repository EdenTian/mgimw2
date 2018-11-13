package com.mgi.service.impl;

import com.mgi.bean.MgiLog;
import com.mgi.service.ErrorDataService;
import com.mgi.service.ErrorMechService;
import com.mgi.service.LogService;
import com.mgi.util.DateUtil;
import com.mgi.util.ExecuteResult2;
import com.mgi.util.IDSUtils;
import com.mgi.util.MyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送完成之后的日志记录操作
 */
@Service
public class ErrorMechServiceImpl implements ErrorMechService {
    @Autowired
    private LogService logService;
    @Autowired
    private ErrorDataService errorDataService;

    /**
     * 错误机制保存数据
     * @param allSupplierIds  所有的ids
     * @param result   传输返回的结果           c
     * @param logType   常量中的日志类型 c
     * @param errorType 错误类型      c
     * @param errorIdsList   失败的ids
     */
    @Override
    public void mysqlSaveData(List<String> allSupplierIds, ExecuteResult2 result,
                              String logType, String errorType, List<String> errorIdsList) {
        //根据结果执行不同的操作
        //不管是否成功失败，获取所有传输数据的ids\

        StringBuffer allIdsStr = IDSUtils.getIdsStrByList(allSupplierIds);
        //200 成功
        if (result.getStatus() == 200) {
            //获取所有成功的ids
            logService.loginsert(MgiLog.insertSuccessLog(allSupplierIds.size(), allIdsStr,logType));
            return;
        }
        //501 部分失败
        if (result.getStatus() == 501) {
            //解析失败的ids，从所有的ids中除去失败的ids，获取成功的ids

            StringBuffer errorIdsStr = IDSUtils.getIdsStrByList(errorIdsList);
            //所有的减去失败的，得到成功的ids
            allSupplierIds.removeAll(errorIdsList);
            StringBuffer successIdsStr = IDSUtils.getIdsStrByList(allSupplierIds);


            logService.loginsert(MgiLog.insertErrorLog(allSupplierIds.size() + errorIdsList.size(), result.getMessage(), errorIdsStr, successIdsStr,logType));
            //将失败的数据保存到数据库
            errorDataService.mysqlSaveData(errorIdsList,errorType,DateUtil.getNow());
            return;
        }
        //500 全部失败
        if (result.getStatus() == 500) {
            //获取所有失败的ids

            //将所有失败的id保存，每两个小时同步一次，直到同步成功
            int i = errorDataService.mysqlSaveData(allSupplierIds, errorType, DateUtil.getNow());
            logService.loginsert(MgiLog.insertErrorLog(allSupplierIds.size(), result.getMessage(), allIdsStr, null,logType));
            return;
        }
    }

    /**
     *  错误日志更新数据
     * @param list      所有的数据ids
     * @param result    执行的结果 z
     * @param logType   日志类型   r
     * @param errorIdsList 失败的ids list
     */
    @Override
    public void mysqlUpdateData(List<String> list, ExecuteResult2 result, String logType,
                                List<String> errorIdsList) {
        StringBuffer ids =  new StringBuffer();
        ArrayList<String> successIds = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ids.append(list.get(i) + ",");
        }
        //200 成功 更新flag为S，时间为now
        if (result.getStatus() == 200) {
            //获取所有成功的ids
            logService.loginsert(MgiLog.insertSuccessLog(list.size(), ids,logType));
            errorDataService.mysqlUpdate(list,MyConstant.ERROR_DATA_FLAG_SUCCESS,DateUtil.getNow());

            return;
        }
        //501 部分失败
        if (result.getStatus() == 501) {
            StringBuffer errorIdsStr = IDSUtils.getIdsStrByList(errorIdsList);
            // 从所有的ids中除去失败的ids，获取成功的ids
            list.removeAll(errorIdsList);
            StringBuffer successIdsStr = IDSUtils.getIdsStrByList(list);


            logService.loginsert(MgiLog.insertErrorLog(list.size()+errorIdsList.size(), result.getMessage(), errorIdsStr, successIdsStr,logType));
            //更新数据
            errorDataService.mysqlUpdate(errorIdsList, MyConstant.ERROR_DATA_FLAG_ERROR,DateUtil.getNow());
            errorDataService.mysqlUpdate(list, MyConstant.ERROR_DATA_FLAG_SUCCESS,DateUtil.getNow());
            return;
        }
        //500 全部失败
        if (result.getStatus() == 500) {
            //获取所有失败的ids

            //将所有失败的id保存，每两个小时同步一次，直到同步成功
            errorDataService.mysqlUpdate(list, MyConstant.ERROR_DATA_FLAG_ERROR,DateUtil.getNow());
            logService.loginsert(MgiLog.insertErrorLog(list.size(), result.getMessage(), ids, null,logType));
            return;
        }
    }
}
