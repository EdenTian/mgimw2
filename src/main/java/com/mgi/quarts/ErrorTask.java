package com.mgi.quarts;

import com.alibaba.fastjson.JSON;
import com.mgi.bean.delivery.DeliveryInfoInput;
import com.mgi.bean.ErrorData;
import com.mgi.bean.SupplyInfos;
import com.mgi.bean.orderstatus.OrderStatusInput;
import com.mgi.service.*;
import com.mgi.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务获取失败的数据并进行处理
 */
@Component
public class ErrorTask {
    @Autowired
    private ErrorDataService errorDataService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private CrmService crmService;
    @Autowired
    private ErrorMechService errorMechService;

    public void errorTask() throws IOException {
        System.out.println("============错误扫描开始===========" + DateUtil.getNow());
        //从数据库中获取失败的数据
        List<ErrorData> list = errorDataService.mysqlSelectErrorData();
        if (list.size() > 0) {
            //将失败的数据从ERP中获取所有数据
            ArrayList<String> supplierIds = new ArrayList<>();
            ArrayList<String> deliveryIds = new ArrayList<>();
            ArrayList<String> orderStatsIds = new ArrayList<>();
            for (ErrorData errorData : list) {
                //获取所有的供应商的数据
                if (MyConstant.SUPPLIER_TYPE.equals(errorData.getType().toString())) {
                    supplierIds.add(errorData.getErrorId());
                }
                //获取所有发货单的数据
                if (MyConstant.DELIVERYINFO_TYPE.equals(errorData.getType().toString())) {
                    deliveryIds.add(errorData.getErrorId());
                }
                //获取所有订单状态的数据
                if (MyConstant.ORDERSTATUS_TYPE.equals(errorData.getType().toString())) {
                    orderStatsIds.add(errorData.getErrorId());
                }
            }
            //供应商的处理
            if (supplierIds.size() > 0){
                //根据失败的ids从erp中获取所有数据 并推送
                ExecuteResult2 result = sendData(supplierIds, MyConstant.SUPPLIER_JSON_TITLE, supplierService, "aaa");
                List<String> errorIdsList = null;
                if (result.getStatus() == 501){
                    errorIdsList = IDSUtils.getIdsListBySupplyInfos(JSON.parseObject(MyConstant.SUPPLIER_JSON_TITLE2+result.getMessage()+"}", SupplyInfos.class).getSupplyInfo());
                }
                //执行之后的数据处理
                errorMechService.mysqlUpdateData(supplierIds, result, MyConstant.SUPPLIER_LOG_NAME, errorIdsList);
            }
            //订单信息的处理。
            if (deliveryIds.size() > 0){
                ExecuteResult2 result = sendData(deliveryIds, MyConstant.DELIVERY_JSON_TITLE, deliveryService, "aaa");
                List<String> errorIdsList = null;
                if (result.getStatus() == 501){
                    errorIdsList = IDSUtils.getIdsListByDelivery(JSON.parseObject(MyConstant.DELIVERY_JSON_TITLE+result.getMessage()+"}", DeliveryInfoInput.class));
                }
                //执行之后的数据处理
                errorMechService.mysqlUpdateData(deliveryIds, result, MyConstant.DELIVERY_LOG_NAME, errorIdsList);
            }
            //订单状态信息的处理。
            if (orderStatsIds.size() > 0){
                ExecuteResult2 result = sendData(orderStatsIds, MyConstant.ORDERSTATUS_JSON_TITLE, orderStatusService, "aaa");
                List<String> errorIdsList = null;
                if (result.getStatus() == 501){
                    errorIdsList = IDSUtils.getIdsListByOrderStatus(JSON.parseObject(MyConstant.ORDERSTATUS_JSON_TITLE+result.getMessage()+"}", OrderStatusInput.class).getOrderStatusList());
                }
                //执行之后的数据处理
                errorMechService.mysqlUpdateData(orderStatsIds, result, MyConstant.ORDERSTATUS_LOG_NAME, errorIdsList);
            }
        }

        System.out.println("============错误扫描结束===========" + DateUtil.getNow());


    }

    /**
     * 公共发送错误数据
     * @param errorIds 失败的ids集合
     * @param jsonTitle  json头
     * @param service  service层
     * @param url     url地址
     * @param <T>    泛型指定具体的实现类
     * @return
     * @throws IOException
     */
    public <T> ExecuteResult2  sendData(ArrayList<String> errorIds, String jsonTitle, BaseService<T> service,String url) throws IOException {
       return  crmService.sendInfo(url,JsonUtils.parseListToJson(service.getInfoByIds(errorIds), jsonTitle));
    }


}
