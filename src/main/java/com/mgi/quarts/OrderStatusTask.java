package com.mgi.quarts;

import com.alibaba.fastjson.JSON;
import com.mgi.bean.orderstatus.OrderStatus;
import com.mgi.bean.orderstatus.OrderStatusInput;
import com.mgi.service.CrmService;
import com.mgi.service.ErrorMechService;
import com.mgi.service.OrderStatusService;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 定时任务，在ERP系统中，回传订单状态并同步至CRM。
 */
@Component
public class OrderStatusTask {
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Autowired
    private ErrorMechService errorMechService;
    @Autowired
    private CrmService crmService;
    @Value("${orderstatus.url}")
    private String orderStatusUrl;
    public void orderStatus() throws IOException {
        System.out.println("============订单状态数据同步开始===========" + DateUtil.getNow());
      //从redis中获取时间
        String strDate = jedisCacheClient.get(MyConstant.ORDERSTATUS_STR_TIME);
        List<OrderStatus> infoInTime = orderStatusService.getInfoInTime(strDate, DateUtil.getNow());
        List<String> idsList = IDSUtils.getIdsListByOrderStatus(infoInTime);
        String s = JsonUtils.parseListToJson(infoInTime, MyConstant.ORDERSTATUS_JSON_TITLE);
        //将数据传给crm
        ExecuteResult2 result = crmService.sendInfo(orderStatusUrl, s);
        List<String> errorIdsList = null;
        if (result.getStatus() == 501){
            String text = MyConstant.ORDERSTATUS_JSON_TITLE + result.getMessage() + "}";
            errorIdsList = IDSUtils.getIdsListByOrderStatus(JSON.parseObject(text, OrderStatusInput.class).getOrderStatusList());
        }
        //执行结束后的日志操作
        errorMechService.mysqlSaveData(idsList,result,MyConstant.ORDERSTATUS_LOG_NAME,
                MyConstant.ORDERSTATUS_TYPE,errorIdsList);

        System.out.println("============订单状态数据同步结束===========" + DateUtil.getNow());


    }


}
