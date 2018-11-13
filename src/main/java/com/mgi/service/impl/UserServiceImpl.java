package com.mgi.service.impl;

import com.mgi.service.UserService;
import com.mgi.util.ExecutionResult;
import com.mgi.util.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Value("${uname}")
    private String uName;
    @Value("${upassword}")
    private String uPassword;

    @Override
    public ExecutionResult getToken(String username, String password) throws Exception {
        String token = null;
        if (uName.equals(username) && uPassword.equals(password)) {
            token = JWTUtil.createToken();
            System.out.println("用户获取token成功 ：" + token);
            return new ExecutionResult(200, "token获取成功").putDataValue("token", token);

        }
        System.out.println("用户获取token失败：" + username + "   " + password);
        return new ExecutionResult(400, "用户名密码不正确");

    }

}
