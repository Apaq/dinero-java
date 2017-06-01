package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceProductLine {

    private String accountName;
    private double baseAmountValue;
    private double baseAmountValueInclVat;
    private double totalAmount;
    private double totalAmountInlVat;
    @JsonProperty("ProductGuid")
    private String productId;
    private String description;
    private String comments;
    private double quantity;
    private int accountNumber;
    private UnitType unit;
    private double discount;
    private String lineType;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBaseAmountValue() {
        return baseAmountValue;
    }

    public void setBaseAmountValue(double baseAmountValue) {
        this.baseAmountValue = baseAmountValue;
    }

    public double getBaseAmountValueInclVat() {
        return baseAmountValueInclVat;
    }

    public void setBaseAmountValueInclVat(double baseAmountValueInclVat) {
        this.baseAmountValueInclVat = baseAmountValueInclVat;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmountInlVat() {
        return totalAmountInlVat;
    }

    public void setTotalAmountInlVat(double totalAmountInlVat) {
        this.totalAmountInlVat = totalAmountInlVat;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }
}
