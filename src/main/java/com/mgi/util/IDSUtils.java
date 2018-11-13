package com.mgi.util;

import com.mgi.bean.delivery.DeliveryInfoInput;
import com.mgi.bean.order.Order;
import com.mgi.bean.SupplyInfo;
import com.mgi.bean.orderstatus.OrderStatus;
import com.mgi.bean.payment.PaymentLineInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *解析失败的ids
 */
public class IDSUtils {


    /**
     *  将list中的ids取出来放到一个新的list中
     * @param list
     * @return
     */
    public static List<String> getIdsListBySupplyInfos(List<SupplyInfo> list){
        ArrayList<String> strings = new ArrayList<>();
        StringBuffer str = null;
        for (int i = 0; i < list.size(); i++) {
            strings.add(list.get(i).getSupplierNum());

        }
        return strings;

    }

    /**
     *  将list中的ids取出来放到一个新的list中
     * @return
     */
    public static List<String> getIdsListByDelivery(DeliveryInfoInput deliveryInfoInput){
        ArrayList<String> strings = new ArrayList<>();
        StringBuffer str = null;
        for (int i = 0; i < deliveryInfoInput.getDeliveryInfoList().size(); i++) {
            strings.add(deliveryInfoInput.getDeliveryInfoList().get(i).getDeliveryOrderNO());

        }
        return strings;

    }

    /**
     *  将list中的ids取出来放到一个新的list中
     * @return
     */
    public static List<String> getIdsListByOrderStatus(List<OrderStatus> list){
        ArrayList<String> strings = new ArrayList<>();
        StringBuffer str = null;
        for (int i = 0; i < list.size(); i++) {
            strings.add(list.get(i).getOrderNumber());

        }
        return strings;

    }
    /**
     *  将list中的ids取出来放到一个新的list中
     * @return
     */
    public static List<String> getIdsListByPayment(List<PaymentLineInfo> list){
        ArrayList<String> strings = new ArrayList<>();
        StringBuffer str = null;
        for (int i = 0; i < list.size(); i++) {
            strings.add(list.get(i).getOrderId());

        }
        return strings;

    }
    /**
     *  将list中的ids取出来放到一个新的list中
     * @param list
     * @return
     */
    public static List<String> getIdsListByOrder(List<Order> list){
        ArrayList<String> strings = new ArrayList<>();
        StringBuffer str = null;
        for (int i = 0; i < list.size(); i++) {
//            strings.add(list.get(i).getSupplierNum());

        }
        return strings;

    }


    public static StringBuffer getIdsStrByList(List<String> idsTem) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < idsTem.size(); i++) {
            buffer.append(idsTem.get(i)+",");
        }
        return buffer;

    }

}
