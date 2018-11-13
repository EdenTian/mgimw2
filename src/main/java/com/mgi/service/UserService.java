package com.mgi.service;

import com.mgi.util.ExecutionResult;

public interface UserService {
    ExecutionResult getToken(String username, String password) throws Exception;
}
