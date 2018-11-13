package com.mgi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mgi.bean.MgiLog;
import com.mgi.service.LogService;
import com.mgi.service.UserService;
import com.mgi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;


   
    
    @GetMapping("index")
    public ModelAndView adminindex() {

        ModelAndView view = new ModelAndView();
        try {
            List<MgiLog> list = logService.logSelectLogIntime();
            String s = JSON.toJSONString(list, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
            view.addObject("list",s);
            String[] split = DateUtil.getNow().split(" ");
            System.out.println("split = " + split[0]);
            if (s!= null){
                view.setViewName("logindex");
            }else {
                view.setViewName("index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  view;
    }
    @GetMapping("getLog")
    public ModelAndView getLog(@RequestParam("date")String date) {
        ModelAndView view = new ModelAndView();
        try {
            List<MgiLog> list = logService.logSelectLogIntime(date);
            String s = JSON.toJSONString(list, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
            view.addObject("list",s);
            view.addObject("adminChooseDate",date);
            if (s!= null){
                view.setViewName("logindex");
            }else {
                view.setViewName("index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  view;
    }


}
