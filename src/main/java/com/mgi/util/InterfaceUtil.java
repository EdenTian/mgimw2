package com.mgi.util;

import java.util.HashMap;
import java.util.Map;

public class InterfaceUtil {
    /**
     *
     */
    public static final Map<String,Integer> OrganizationMap =  new HashMap<>();

    static{
        OrganizationMap.put("武汉智造",7219);
        OrganizationMap.put("深圳智造",6958);
        OrganizationMap.put("香港智造",9471);
        OrganizationMap.put("MGI Latvia",9468);
    }
    public static final Map<Integer,String> OrganizationMap2 =  new HashMap<>();

    static{
        OrganizationMap2.put(7219,"武汉智造");
        OrganizationMap2.put(6958,"深圳智造");
        OrganizationMap2.put(9471,"香港智造");
        OrganizationMap2.put(9468,"MGI Latvia");
    }

}
