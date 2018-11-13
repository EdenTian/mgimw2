package com.mgi.controller;

import com.mgi.service.OrderService;
import com.mgi.util.ExecuteResult2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单信息crm--> erp
 */
@RequestMapping("/service/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/info")
    public ExecuteResult2 orderInfo(@RequestBody String str){
        try {
            orderService.insertOederInfo(str);
            return new ExecuteResult2(200,"接收成功");
        }catch (Exception e){
            return new ExecuteResult2(500,"接收失败");
        }

    }
}
