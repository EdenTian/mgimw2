package com.mgi.service;

import com.mgi.util.ExecuteResult2;

import java.io.IOException;

public interface CrmService {
    public ExecuteResult2 sendInfo(String supplierUrl, String s) throws IOException;
    public ExecuteResult2 sendSupplierInfo(String s) throws IOException;
}
