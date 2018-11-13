package com.mgi.quarts;

import com.alibaba.fastjson.JSON;
import com.mgi.bean.SupplyInfo;
import com.mgi.bean.SupplyInfos;
import com.mgi.service.CrmService;
import com.mgi.service.ErrorMechService;
import com.mgi.service.SupplierService;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时任务获取供应商信息从ERP到SF
 */
@Component
public class SupplierTask {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Autowired
    private ErrorMechService errorMechService;
    @Autowired
    private CrmService crmService;

    public void sendSupplierInfoToCrm() {
         try {
             System.out.println("============供应商数据同步开始===========" + DateUtil.getNow());
             //从CRM获取供应商数据
             //从redis中获取开始时间
             String strDate = jedisCacheClient.get(MyConstant.SUPPLIER_STR_TIME);
             List<SupplyInfo> allSuppliers = supplierService.getInfoInTime(strDate, "2011-04-09 00:30:00");

             //将供应商信息转换成CRM需要的数据格式
             List<String> idsList = IDSUtils.getIdsListBySupplyInfos(allSuppliers);
             String s = JsonUtils.parseListToJson(allSuppliers,MyConstant.SUPPLIER_JSON_TITLE);
             System.out.println("s = " + s);
             // String ss = "{\"supplyInfos\":[{\"supplierLocation\":\"\",\"supplierName\":\"北京耐鑫商贸有限公司\",\"supplierNum\":\"253\",\"supplierPhone\":\"\"},{\"supplierLocation\":\"\",\"supplierName\":\"北京诺思杰科技有限公司\",\"supplierNum\":\"253\",\"supplierPhone\":\"\"}]}";

             //将转换好的数据发送给CRM并获取返回的结果
             ExecuteResult2 result =  crmService.sendSupplierInfo(s);
             System.out.println("result = " + result);
             List<String> errorIdsList = null;
             if (result.getStatus() == 501){
                 String text = "{\"supplyInfo\":" + result.getMessage() + "}";
                 errorIdsList = IDSUtils.getIdsListBySupplyInfos(JSON.parseObject(text, SupplyInfos.class).getSupplyInfo());
             }
             //执行结束后的日志操作
             errorMechService.mysqlSaveData(idsList,result,MyConstant.SUPPLIER_LOG_NAME,
                     MyConstant.SUPPLIER_TYPE,errorIdsList);
             System.out.println("============供应商数据同步结束===========" + DateUtil.getNow());
             throw new RuntimeException("111111");
             //更新redis中的时间
         }   catch (Exception e){
             e.printStackTrace();
              EmailUtil.sendEmail(MyConstant.SUPPLIER_LOG_NAME,e.getStackTrace().toString());
         }

        
    }
}
