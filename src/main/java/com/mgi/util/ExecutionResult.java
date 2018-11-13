package com.mgi.util;

import java.util.HashMap;
import java.util.Map;

public class ExecutionResult {
    private   int status;
    private final Map<String, Object> data = new HashMap<String, Object>();
    private  String message;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ExecutionResult(int status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }

    public ExecutionResult() {
    }

    public ExecutionResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExecutionResult{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ExecutionResult putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
