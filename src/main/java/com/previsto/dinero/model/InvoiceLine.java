package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.previsto.dinero.model.enums.DiscountMode;

public class InvoiceLine {

    private String productId;
    private String description;
    private float quantity = 1;
    private float unitPrice;
    private float amount;
    private float tax;
    private String taxRateId;
    private String discountText;
    private DiscountMode discountMode;
    private Float discountValue;
    private int priority;

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

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonIgnore
    public float getAmount() {
        return amount;
    }

    @JsonProperty
    public void setAmount(float amount) {
        this.amount = amount;
    }

    @JsonIgnore
    public float getTax() {
        return tax;
    }

    @JsonProperty
    public void setTax(float tax) {
        this.tax = tax;
    }

    @JsonIgnore
    public String getTaxRateId() {
        return taxRateId;
    }

    @JsonProperty
    public void setTaxRateId(String taxRateId) {
        this.taxRateId = taxRateId;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public DiscountMode getDiscountMode() {
        return discountMode;
    }

    public void setDiscountMode(DiscountMode discountMode) {
        this.discountMode = discountMode;
    }

    public Float getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Float discountValue) {
        this.discountValue = discountValue;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
}
