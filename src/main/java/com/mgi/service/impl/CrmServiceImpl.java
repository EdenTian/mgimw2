package com.mgi.service.impl;

import com.mgi.service.CrmService;
import com.mgi.service.HttpClientService;
import com.mgi.util.ExecuteResult2;
import com.mgi.util.SendToSF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 操作向crm传数据
 *
 **/
@Service
public class CrmServiceImpl implements CrmService {
    @Value("${supplier.url}")
    private String supplierUrl;
    @Autowired
    private SendToSF sendToSF;
    @Autowired
    private HttpClientService httpClientService;

    /**
     * 通用的方法：将json数据传给crm
     * @param s
     * @return
     */
    @Override
    public ExecuteResult2 sendInfo(String supplierUrl, String s) throws IOException {
        return  httpClientService.doPostHeader(supplierUrl,s,sendToSF.getToken());
    }
    /**
     * 将供应商json数据传给crm
     * @param s
     * @return
     */
    @Override
    public ExecuteResult2 sendSupplierInfo(String s) throws IOException {
        return  httpClientService.doPostHeader(supplierUrl,s,sendToSF.getToken());
    }


}
