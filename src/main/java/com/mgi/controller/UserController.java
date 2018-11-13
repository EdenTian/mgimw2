package com.mgi.controller;

import com.mgi.service.UserService;
import com.mgi.util.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/service/user")
////所有的数据校验
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("getToken")
    public ExecutionResult getToken(String username,String password){
        ExecutionResult result = null;
        try {
            result = userService.getToken(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
