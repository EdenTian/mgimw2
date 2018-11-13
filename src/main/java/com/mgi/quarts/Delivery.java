package com.mgi.quarts;

import com.mgi.bean.delivery.DeliveryInfoInput;
import com.mgi.service.CrmService;
import com.mgi.service.DeliveryService;
import com.mgi.service.ErrorMechService;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 定时任务，ERP中创建好发运集后，系统将发运信息同步至CRM。
 */
@Component
public class Delivery {

    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private CrmService crmService;
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Autowired
    private ErrorMechService errorMechService;
    @Value("${delivery.url}")
    private String deliveryUrl;
    public void   getDeliveryInfoFromERPToCRM() throws IOException {
        //从erp中获取发运数据
        //获取时间
        String strDate = jedisCacheClient.get(MyConstant.DELIVERYINFO_STR_TIME);
        List<DeliveryInfoInput> deliveryInfo = deliveryService.getInfoInTime(strDate,DateUtil.getNow());

        //将数据转换成json
        String json = JsonUtils.parseListToJson(deliveryInfo, MyConstant.DELIVERY_JSON_TITLE);

        //将json数据发送至crm
        ExecuteResult2 result = crmService.sendInfo(deliveryUrl, json);
        List<String> allIdsList = IDSUtils.getIdsListByDelivery(deliveryInfo.get(1));
        //部分成功部分失败
        List<String> errorIdsList = null;
        if (result.getStatus() == 501){
            DeliveryInfoInput deliveryInfoInput = JsonUtils.parseJSONToList(result.getMessage(), DeliveryInfoInput.class);
            errorIdsList = IDSUtils.getIdsListByDelivery(deliveryInfoInput);
        }

        //执行完成之后的记录操作
        errorMechService.mysqlSaveData(allIdsList,result,MyConstant.DELIVERY_LOG_NAME,
                MyConstant.DELIVERYINFO_TYPE,errorIdsList);

    }
}
