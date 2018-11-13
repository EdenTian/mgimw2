package com.mgi.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class SupplyInfos implements Serializable {
    private List<SupplyInfo> supplyInfos;
    public void setSupplyInfo(List<SupplyInfo> supplyInfos) {
        this.supplyInfos = supplyInfos;
    }
    public List<SupplyInfo> getSupplyInfo() {
        return supplyInfos;
    }

    @Override
    public String toString() {
        return "SupplyInfos{" +
                "supplyInfo=" + supplyInfos +
                '}';
    }
}
