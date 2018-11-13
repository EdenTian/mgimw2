package com.mgi.bean.payment;

import java.util.List;

/**
 *
 */
public class PaymentLineInfoInput {
    private List<PaymentLineInfo> PaymentLineInfoList;

    @Override
    public String toString() {
        return "PaymentLineInfoInput{" +
                "PaymentLineInfoList=" + PaymentLineInfoList +
                '}';
    }

    public List<PaymentLineInfo> getPaymentLineInfoList() {
        return PaymentLineInfoList;
    }

    public void setPaymentLineInfoList(List<PaymentLineInfo> paymentLineInfoList) {
        PaymentLineInfoList = paymentLineInfoList;
    }

    public PaymentLineInfoInput() {
    }

    public PaymentLineInfoInput(List<PaymentLineInfo> paymentLineInfoList) {
        PaymentLineInfoList = paymentLineInfoList;
    }
}
