package com.mgi.bean.delivery;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class DeliveryProduct {
    private String DeliveryProductOrderName;                                                //发货单行名称
    private String DeliveryProductName;                                                    //产品名称
    private String DeliveryProductNO;                                                        //产品货号
    private Integer DeliveryProductAmount;                                                    //发货数量
    private Date DeliveryDate;                                                                //发货日期
    private String DeliveryLogisticsCompany;                                                //物流公司
    private String DeliveryWaybillNumber;                                                    //物流运单号
    private List<DeliveryProductLineOrder> DeliveryProductLineOrderList;                    //物流运单号

    @Override
    public String toString() {
        return "DeliveryProduct{" +
                "DeliveryProductOrderName='" + DeliveryProductOrderName + '\'' +
                ", DeliveryProductName='" + DeliveryProductName + '\'' +
                ", DeliveryProductNO='" + DeliveryProductNO + '\'' +
                ", DeliveryProductAmount=" + DeliveryProductAmount +
                ", DeliveryDate=" + DeliveryDate +
                ", DeliveryLogisticsCompany='" + DeliveryLogisticsCompany + '\'' +
                ", DeliveryWaybillNumber='" + DeliveryWaybillNumber + '\'' +
                ", DeliveryProductLineOrderList=" + DeliveryProductLineOrderList +
                '}';
    }

    public DeliveryProduct() {
    }

    public DeliveryProduct(String deliveryProductOrderName, String deliveryProductName, String deliveryProductNO, Integer deliveryProductAmount, Date deliveryDate, String deliveryLogisticsCompany, String deliveryWaybillNumber, List<DeliveryProductLineOrder> deliveryProductLineOrderList) {
        DeliveryProductOrderName = deliveryProductOrderName;
        DeliveryProductName = deliveryProductName;
        DeliveryProductNO = deliveryProductNO;
        DeliveryProductAmount = deliveryProductAmount;
        DeliveryDate = deliveryDate;
        DeliveryLogisticsCompany = deliveryLogisticsCompany;
        DeliveryWaybillNumber = deliveryWaybillNumber;
        DeliveryProductLineOrderList = deliveryProductLineOrderList;
    }

    public String getDeliveryProductOrderName() {
        return DeliveryProductOrderName;
    }

    public void setDeliveryProductOrderName(String deliveryProductOrderName) {
        DeliveryProductOrderName = deliveryProductOrderName;
    }

    public String getDeliveryProductName() {
        return DeliveryProductName;
    }

    public void setDeliveryProductName(String deliveryProductName) {
        DeliveryProductName = deliveryProductName;
    }

    public String getDeliveryProductNO() {
        return DeliveryProductNO;
    }

    public void setDeliveryProductNO(String deliveryProductNO) {
        DeliveryProductNO = deliveryProductNO;
    }

    public Integer getDeliveryProductAmount() {
        return DeliveryProductAmount;
    }

    public void setDeliveryProductAmount(Integer deliveryProductAmount) {
        DeliveryProductAmount = deliveryProductAmount;
    }

    public Date getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getDeliveryLogisticsCompany() {
        return DeliveryLogisticsCompany;
    }

    public void setDeliveryLogisticsCompany(String deliveryLogisticsCompany) {
        DeliveryLogisticsCompany = deliveryLogisticsCompany;
    }

    public String getDeliveryWaybillNumber() {
        return DeliveryWaybillNumber;
    }

    public void setDeliveryWaybillNumber(String deliveryWaybillNumber) {
        DeliveryWaybillNumber = deliveryWaybillNumber;
    }

    public List<DeliveryProductLineOrder> getDeliveryProductLineOrderList() {
        return DeliveryProductLineOrderList;
    }

    public void setDeliveryProductLineOrderList(List<DeliveryProductLineOrder> deliveryProductLineOrderList) {
        DeliveryProductLineOrderList = deliveryProductLineOrderList;
    }
}
