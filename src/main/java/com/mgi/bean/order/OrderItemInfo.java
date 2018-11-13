package com.mgi.bean.order;

/**
 *
 */
public class OrderItemInfo {
    private String ProductName;                                      //产品名称
    private String ProductNO;                                        //产品货号
    private String ProductAmount;                                    //数量
    private String ProductSalesPrice;                                //销售价格
    private String ProductExpectDeliveryDate;                            //客户期望发货日期
    private String ContractExpectDeliveryDate;                           //合同客户发货日期
    private String UnitPrice;                                        //单价

    @Override
    public String toString() {
        return "OrderItemInfo{" +
                "ProductName='" + ProductName + '\'' +
                ", ProductNO='" + ProductNO + '\'' +
                ", ProductAmount='" + ProductAmount + '\'' +
                ", ProductSalesPrice='" + ProductSalesPrice + '\'' +
                ", ProductExpectDeliveryDate='" + ProductExpectDeliveryDate + '\'' +
                ", ContractExpectDeliveryDate='" + ContractExpectDeliveryDate + '\'' +
                ", UnitPrice='" + UnitPrice + '\'' +
                '}';
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductNO() {
        return ProductNO;
    }

    public void setProductNO(String productNO) {
        ProductNO = productNO;
    }

    public String getProductAmount() {
        return ProductAmount;
    }

    public void setProductAmount(String productAmount) {
        ProductAmount = productAmount;
    }

    public String getProductSalesPrice() {
        return ProductSalesPrice;
    }

    public void setProductSalesPrice(String productSalesPrice) {
        ProductSalesPrice = productSalesPrice;
    }

    public String getProductExpectDeliveryDate() {
        return ProductExpectDeliveryDate;
    }

    public void setProductExpectDeliveryDate(String productExpectDeliveryDate) {
        ProductExpectDeliveryDate = productExpectDeliveryDate;
    }

    public String getContractExpectDeliveryDate() {
        return ContractExpectDeliveryDate;
    }

    public void setContractExpectDeliveryDate(String contractExpectDeliveryDate) {
        ContractExpectDeliveryDate = contractExpectDeliveryDate;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public OrderItemInfo() {
    }

    public OrderItemInfo(String productName, String productNO, String productAmount, String productSalesPrice, String productExpectDeliveryDate, String contractExpectDeliveryDate, String unitPrice) {
        ProductName = productName;
        ProductNO = productNO;
        ProductAmount = productAmount;
        ProductSalesPrice = productSalesPrice;
        ProductExpectDeliveryDate = productExpectDeliveryDate;
        ContractExpectDeliveryDate = contractExpectDeliveryDate;
        UnitPrice = unitPrice;
    }
}
