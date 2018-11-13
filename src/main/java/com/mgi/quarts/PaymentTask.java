package com.mgi.quarts;

import com.alibaba.fastjson.JSON;
import com.mgi.bean.payment.PaymentLineInfo;
import com.mgi.bean.payment.PaymentLineInfoInput;
import com.mgi.service.CrmService;
import com.mgi.service.ErrorMechService;
import com.mgi.service.PaymentService;
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
public class PaymentTask {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Autowired
    private ErrorMechService errorMechService;
    @Autowired
    private CrmService crmService;
    @Value("${payment.url}")
    private String paymentUrl;
    public void getPayment() throws IOException {
        System.out.println("============付款信息数据同步开始===========" + DateUtil.getNow());
      //从redis中获取时间
        String strDate = jedisCacheClient.get(MyConstant.PAYMENT_STR_TIME);
        List<PaymentLineInfo> infoInTime = paymentService.getInfoInTime(strDate, DateUtil.getNow());
        List<String> idsList = IDSUtils.getIdsListByPayment(infoInTime);
        String s = JsonUtils.parseListToJson(infoInTime, MyConstant.PAYMENT_JSON_TITLE);
        //将数据传给crm
        ExecuteResult2 result = crmService.sendInfo(paymentUrl, s);
        List<String> errorIdsList = null;
        if (result.getStatus() == 501){
            String text = MyConstant.PAYMENT_JSON_TITLE + result.getMessage() + "}";
            errorIdsList = IDSUtils.getIdsListByPayment(JSON.parseObject(text, PaymentLineInfoInput.class).getPaymentLineInfoList());
        }
        //执行结束后的日志操作
        errorMechService.mysqlSaveData(idsList,result,MyConstant.PAYMENT_LOG_NAME,
                MyConstant.PAYMENT_TYPE,errorIdsList);


        System.out.println("============付款信息数据同步结束===========" + DateUtil.getNow());


    }


}
