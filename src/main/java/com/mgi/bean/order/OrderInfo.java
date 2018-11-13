package com.mgi.bean.order;

import java.util.List;

/**
 *
 */
public class OrderInfo {
        private String OrderNO;                      //订单编号
        private String OrderStatus;                  //订单状态
        private String OrderAccount;                 //客户
        private String OrderInExAccount;             //内外部客户
        private String OrderContract;                //合同
        private String OrderOpp;                     //业务机会
        private String OrderSalesRep;                //销售代表
        private String OrderRegion;                  //销售所属区域
        private String OrderAccountAdd;              //客户地址
        private String OrderBusinessConfirmPerson;   //商务确认人
        private String OrderAmount;                  //订单金额
        private String OrderBillingAdd;              //开票地址
        private String OrderPaymentMethod;           //付款方式
        private String OrderCompleteDate;            //订单完成日期
        private String OrderPromotion;               //促销单
        private String OrderRemark;                  //备注
        private List<OrderItemInfo> orderItemInfoList;

    public OrderInfo() {
    }

    public OrderInfo(String orderNO, String orderStatus, String orderAccount, String orderInExAccount, String orderContract, String orderOpp, String orderSalesRep, String orderRegion, String orderAccountAdd, String orderBusinessConfirmPerson, String orderAmount, String orderBillingAdd, String orderPaymentMethod, String orderCompleteDate, String orderPromotion, String orderRemark, List<OrderItemInfo> orderItemInfoList) {
        OrderNO = orderNO;
        OrderStatus = orderStatus;
        OrderAccount = orderAccount;
        OrderInExAccount = orderInExAccount;
        OrderContract = orderContract;
        OrderOpp = orderOpp;
        OrderSalesRep = orderSalesRep;
        OrderRegion = orderRegion;
        OrderAccountAdd = orderAccountAdd;
        OrderBusinessConfirmPerson = orderBusinessConfirmPerson;
        OrderAmount = orderAmount;
        OrderBillingAdd = orderBillingAdd;
        OrderPaymentMethod = orderPaymentMethod;
        OrderCompleteDate = orderCompleteDate;
        OrderPromotion = orderPromotion;
        OrderRemark = orderRemark;
        this.orderItemInfoList = orderItemInfoList;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "OrderNO='" + OrderNO + '\'' +
                ", OrderStatus='" + OrderStatus + '\'' +
                ", OrderAccount='" + OrderAccount + '\'' +
                ", OrderInExAccount='" + OrderInExAccount + '\'' +
                ", OrderContract='" + OrderContract + '\'' +
                ", OrderOpp='" + OrderOpp + '\'' +
                ", OrderSalesRep='" + OrderSalesRep + '\'' +
                ", OrderRegion='" + OrderRegion + '\'' +
                ", OrderAccountAdd='" + OrderAccountAdd + '\'' +
                ", OrderBusinessConfirmPerson='" + OrderBusinessConfirmPerson + '\'' +
                ", OrderAmount='" + OrderAmount + '\'' +
                ", OrderBillingAdd='" + OrderBillingAdd + '\'' +
                ", OrderPaymentMethod='" + OrderPaymentMethod + '\'' +
                ", OrderCompleteDate='" + OrderCompleteDate + '\'' +
                ", OrderPromotion='" + OrderPromotion + '\'' +
                ", OrderRemark='" + OrderRemark + '\'' +
                ", orderItemInfoList=" + orderItemInfoList +
                '}';
    }

    public String getOrderNO() {
        return OrderNO;
    }

    public void setOrderNO(String orderNO) {
        OrderNO = orderNO;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getOrderAccount() {
        return OrderAccount;
    }

    public void setOrderAccount(String orderAccount) {
        OrderAccount = orderAccount;
    }

    public String getOrderInExAccount() {
        return OrderInExAccount;
    }

    public void setOrderInExAccount(String orderInExAccount) {
        OrderInExAccount = orderInExAccount;
    }

    public String getOrderContract() {
        return OrderContract;
    }

    public void setOrderContract(String orderContract) {
        OrderContract = orderContract;
    }

    public String getOrderOpp() {
        return OrderOpp;
    }

    public void setOrderOpp(String orderOpp) {
        OrderOpp = orderOpp;
    }

    public String getOrderSalesRep() {
        return OrderSalesRep;
    }

    public void setOrderSalesRep(String orderSalesRep) {
        OrderSalesRep = orderSalesRep;
    }

    public String getOrderRegion() {
        return OrderRegion;
    }

    public void setOrderRegion(String orderRegion) {
        OrderRegion = orderRegion;
    }

    public String getOrderAccountAdd() {
        return OrderAccountAdd;
    }

    public void setOrderAccountAdd(String orderAccountAdd) {
        OrderAccountAdd = orderAccountAdd;
    }

    public String getOrderBusinessConfirmPerson() {
        return OrderBusinessConfirmPerson;
    }

    public void setOrderBusinessConfirmPerson(String orderBusinessConfirmPerson) {
        OrderBusinessConfirmPerson = orderBusinessConfirmPerson;
    }

    public String getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        OrderAmount = orderAmount;
    }

    public String getOrderBillingAdd() {
        return OrderBillingAdd;
    }

    public void setOrderBillingAdd(String orderBillingAdd) {
        OrderBillingAdd = orderBillingAdd;
    }

    public String getOrderPaymentMethod() {
        return OrderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        OrderPaymentMethod = orderPaymentMethod;
    }

    public String getOrderCompleteDate() {
        return OrderCompleteDate;
    }

    public void setOrderCompleteDate(String orderCompleteDate) {
        OrderCompleteDate = orderCompleteDate;
    }

    public String getOrderPromotion() {
        return OrderPromotion;
    }

    public void setOrderPromotion(String orderPromotion) {
        OrderPromotion = orderPromotion;
    }

    public String getOrderRemark() {
        return OrderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        OrderRemark = orderRemark;
    }

    public List<OrderItemInfo> getOrderItemInfoList() {
        return orderItemInfoList;
    }

    public void setOrderItemInfoList(List<OrderItemInfo> orderItemInfoList) {
        this.orderItemInfoList = orderItemInfoList;
    }
}
