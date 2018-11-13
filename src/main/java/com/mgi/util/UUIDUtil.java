package com.mgi.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        String replace = uuid.replace("-", "");
        return replace;
    }
}
