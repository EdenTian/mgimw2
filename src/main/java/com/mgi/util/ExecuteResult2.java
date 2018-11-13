package com.mgi.util;

public class ExecuteResult2 {
    private   int status;
    private  String message;
    private String token;

    @Override
    public String toString() {
        return "ExecuteResult2{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ExecuteResult2() {
    }

    public ExecuteResult2(int status, String message) {

        this.status = status;
        this.message = message;

    }public ExecuteResult2(int status, String message, String token) {

        this.status = status;
        this.message = message;
        this.token = token;
    }
}
