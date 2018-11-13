package com.mgi.quarts;

import com.mgi.service.CrmService;
import com.mgi.service.ErrorMechService;
import com.mgi.service.OrderService;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.DateUtil;
import com.mgi.util.MyConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 订单定时任务   订单信息同步（SFDC—>ERP）
 */
@Component
public class OrderTask {
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Autowired
    private ErrorMechService errorMechService;
    @Autowired
    private CrmService crmService;
    @Autowired
    private OrderService orderService;

    public void orderTask() throws IOException {
        System.out.println("============订单定时任务开始===========" + DateUtil.getNow());
        //从redis中获取订单开始时间
        String strDate = jedisCacheClient.get(MyConstant.SUPPLIER_STR_TIME);
        //为空
        if (StringUtils.isEmpty(strDate)){
              jedisCacheClient.set(MyConstant.SUPPLIER_STR_TIME,DateUtil.getNow());
        }
        //从erp中获取需要传的数据
//        List<Order> allOrders = orderService.getOrderInTime(strDate,DateUtil.getNow());

        //转换成json
//        String s = JsonUtils.parseListToJson(allOrders,MyConstant.ORDER_JSON_TITLE);
//        System.out.println("s = " + s);
//
//        //将json传给crm
//        ExecuteResult2 result =  crmService.sendSupplierInfo(s);
//
//        //根据结果执行日志以及失败记录保存
//        System.out.println("result = " + result);
//        List<String> errorIdsList = null;
//        if (result.getStatus() == 501){
//            Order order = JSON.parseObject(result.getMessage(), Order.class);
//             String text =  result.getMessage();
////            errorIdsList = IDSUtils.getIdsListByOrder(JSON.parseObject(text, Order.class));
//        }
//
////        errorMechService.mysqlSaveData(IDSUtils.getIdsListBySupplyInfos(),result,MyConstant.ORDER_LOG_NAME,
////                MyConstant.ORDER_TYPE,errorIdsList);
//        System.out.println("============订单商数据同步结束===========" + DateUtil.getNow());


    }
}
