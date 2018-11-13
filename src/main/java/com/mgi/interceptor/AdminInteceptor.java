package com.mgi.interceptor;

import com.alibaba.fastjson.JSON;
import com.mgi.bean.User;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员登录拦截器
 */
public class AdminInteceptor implements HandlerInterceptor {
    private Logger logger = Logger.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
            String s = jedisCacheClient.get("admin");


        User user = JSON.parseObject(s, User.class);
            if(user != null){
                logger.info("管理员登录成功, user = " + user + DateUtil.getNow()) ;
                return true;
            }
            response.sendRedirect("http://10.50.10.121:7080/");
        logger.error("管理员登录失败,Date = " + DateUtil.getNow());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
