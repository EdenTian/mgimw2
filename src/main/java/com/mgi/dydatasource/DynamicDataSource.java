package com.mgi.dydatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
// 使用DynamicDataSourceHolder保证线程安全，并且得到当前线程中的数据源key
        String key = DynamicDataSourceHolder.getDataSourceKey();
        return key;

    }
}
