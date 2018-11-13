package com.mgi.bean.payment;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class PaymentLineInfo {
    private String PaymentLineInfoName;                //付款信息名称
    private String PaymentLineNumber;                //付款行编号
    private String AccountNumber;                    //客户Id
    private BigDecimal ReceivableAmount;                //应收金额
    private BigDecimal PaymentAmount;                    //付款金额
    private String OrderId;                            //订单
    private Date PaymentDate;                        //付款日期
    private String paymemtContractNO;                //合同

    @Override
    public String toString() {
        return "PaymentLineInfo{" +
                "PaymentLineInfoName='" + PaymentLineInfoName + '\'' +
                ", PaymentLineNumber='" + PaymentLineNumber + '\'' +
                ", AccountNumber='" + AccountNumber + '\'' +
                ", ReceivableAmount=" + ReceivableAmount +
                ", PaymentAmount=" + PaymentAmount +
                ", OrderId='" + OrderId + '\'' +
                ", PaymentDate=" + PaymentDate +
                ", paymemtContractNO='" + paymemtContractNO + '\'' +
                '}';
    }

    public String getPaymentLineInfoName() {
        return PaymentLineInfoName;
    }

    public void setPaymentLineInfoName(String paymentLineInfoName) {
        PaymentLineInfoName = paymentLineInfoName;
    }

    public String getPaymentLineNumber() {
        return PaymentLineNumber;
    }

    public void setPaymentLineNumber(String paymentLineNumber) {
        PaymentLineNumber = paymentLineNumber;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public BigDecimal getReceivableAmount() {
        return ReceivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        ReceivableAmount = receivableAmount;
    }

    public BigDecimal getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }

    public String getPaymemtContractNO() {
        return paymemtContractNO;
    }

    public void setPaymemtContractNO(String paymemtContractNO) {
        this.paymemtContractNO = paymemtContractNO;
    }

    public PaymentLineInfo() {

    }

    public PaymentLineInfo(String paymentLineInfoName, String paymentLineNumber, String accountNumber, BigDecimal receivableAmount, BigDecimal paymentAmount, String orderId, Date paymentDate, String paymemtContractNO) {
        PaymentLineInfoName = paymentLineInfoName;
        PaymentLineNumber = paymentLineNumber;
        AccountNumber = accountNumber;
        ReceivableAmount = receivableAmount;
        PaymentAmount = paymentAmount;
        OrderId = orderId;
        PaymentDate = paymentDate;
        this.paymemtContractNO = paymemtContractNO;
    }
}
