package com.mgi.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mgi.bean.User;
import com.mgi.service.impl.JedisCacheClient;
import com.mgi.util.ExecutionResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 接口验证拦截器
 */
public class UserInteceptor implements HandlerInterceptor {
    private Logger logger = Logger.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private JedisCacheClient jedisCacheClient;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && !"".equals(token)){
            String s = jedisCacheClient.get(token);
            User user = JSON.parseObject(s, User.class);
            System.out.println("user ====== " + user);
            if(user != null){
                logger.info("用户登录成功,token = " + token +" user = " + user) ;
                return true;
            }
        }
        response.setStatus(401);
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JSONObject.toJSONString(new ExecutionResult(401,"请获取最新token"),
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
        logger.error("用户登录失败,token = " + token);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
