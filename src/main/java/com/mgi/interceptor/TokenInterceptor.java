package com.mgi.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.mgi.util.ExecutionResult;
import com.mgi.util.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.isEmpty;

/**
 *  验证拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Value("${uname}")
    private String uName;
    @Value("${upassword}")
    private String uPassword;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("拦截器执行了");
        String token = request.getHeader("Authorization");
        if (!isEmpty(token)){
            Map<String, Claim> map = null;
            try {
                map = JWTUtil.verifyToken(token);
                Claim password = map.get("password");
                Claim username = map.get("username");
                Claim exp = map.get("exp");
                System.out.println("username = " + username.asString());
                System.out.println("password = " + password.asString());
                if (uName.equals(username.asString().trim()) && uPassword.equals(password.asString().trim())){
                    Integer time = exp.asInt();
                    System.out.println("time = " + time);
                    if (time > 0){
                        Date date = new Date(time);
                        System.out.println("date = " + date);
                        System.out.println("通过了拦截");
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = null;
        String str = JSON.toJSONString(new ExecutionResult(500, "请获取最新token"));
        System.out.println("返回的json "+str);
        try {
            writer = response.getWriter();
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }


        System.out.println("没通过拦截");
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}