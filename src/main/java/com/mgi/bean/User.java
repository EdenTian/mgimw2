package com.mgi.bean;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private String uName;
    private String uPassword;
    private int uId;

    public User(String uName, String uPassword, int uId) {
        this.uName = uName;
        this.uPassword = uPassword;
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uId=" + uId +
                '}';
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public User() {
    }
}
