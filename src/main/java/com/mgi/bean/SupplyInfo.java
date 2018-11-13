package com.mgi.bean;

import java.io.Serializable;

/**
 *供应商实体类
 */
public class SupplyInfo implements Serializable {
    public String supplierName;               // 供应商名称
    public String supplierNum;                // 供应商编号
    public String supplierLocation;           // 供应商地址
    public String supplierPhone;              // 供应商电话

    @Override
    public String toString() {
        return "SupplyInfo{" +
                "supplierName='" + supplierName + '\'' +
                ", supplierNum='" + supplierNum + '\'' +
                ", supplierLocation='" + supplierLocation + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                '}';
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(String supplierNum) {
        this.supplierNum = supplierNum;
    }

    public String getSupplierLocation() {
        return supplierLocation;
    }

    public void setSupplierLocation(String supplierLocation) {
        this.supplierLocation = supplierLocation;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public SupplyInfo() {
    }

    public SupplyInfo(String supplierName, String supplierNum, String supplierLocation, String supplierPhone) {
        this.supplierName = supplierName;
        this.supplierNum = supplierNum;
        this.supplierLocation = supplierLocation;
        this.supplierPhone = supplierPhone;
    }
}
