package com.previsto.dinero.model;

import java.util.ArrayList;
import java.util.List;

public class Product extends ArchivableEntity {
    private String name;
    private String description;
    private String accountId;
    private String productNo;
    private String suppliersProductNo;
    private String salesTaxRulesetId;
    private List<ProductPrice> prices = new ArrayList<>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSalesTaxRulesetId() {
        return salesTaxRulesetId;
    }

    public void setSalesTaxRulesetId(String salesTaxRulesetId) {
        this.salesTaxRulesetId = salesTaxRulesetId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getSuppliersProductNo() {
        return suppliersProductNo;
    }

    public void setSuppliersProductNo(String suppliersProductNo) {
        this.suppliersProductNo = suppliersProductNo;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ProductPrice> prices) {
        this.prices = prices;
    }
    
}
