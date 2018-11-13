package com.mgi.dydatasource;

import org.aspectj.lang.JoinPoint;

public class DataSourceAspect {

    /**
     * 在进入Service方法之前执行
     *
     * @param point 切面对象
     */
    public void before(JoinPoint point) {
        // 获取到当前执行的方法名
        if (DataSourceAspect.isMYSQL(point.getSignature().getName())) {
            DynamicDataSourceHolder.markMysql();
        } else {
            DynamicDataSourceHolder.markOracle();
        }
    }

    /**
     * 判断是否为读库
     *
     * @param methodName
     * @return
     */
    private static Boolean isMYSQL(String methodName) {
        if (methodName.startsWith("mysql") || methodName.startsWith("log")){
            return  true;
        }
            return false;
        

    }


}
