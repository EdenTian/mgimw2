package com.mgi.dydatasource;

public class DynamicDataSourceHolder {
    //写库对应的数据源key
    private static final String ORACLE = "oracle";

    //读库对应的数据源key
    private static final String MYSQL = "mysql";

    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 设置数据源key
     * @paramkey
     */
    public static void putDataSourceKey(String key) {
        holder.set(key);
    }

    /**
     * 获取数据源key
     * @return
     */
    public static String getDataSourceKey() {
        return holder.get();
    }

    /**
     * 标记写库
     */
    public static void markOracle(){
        putDataSourceKey(ORACLE);
    }

    /**
     * 标记读库
     */
    public static void markMysql(){
        putDataSourceKey(MYSQL);
    }

}
