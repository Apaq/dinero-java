package dk.apaq.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product extends ArchivableEntity {

    @JsonProperty("ProductGuid")
    private String id;
    private double baseAmountValueInclVat;
    private double totalAmount;
    private double totalAmountInclVat;
    private String productNumber;
    private String name;
    private double baseAmountValue;
    private double quantity;
    private int accountNumber;
    private UnitType unit = UnitType.Parts;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getTotalAmountInclVat() {
        return totalAmountInclVat;
    }

    public void setTotalAmountInclVat(double totalAmountInclVat) {
        this.totalAmountInclVat = totalAmountInclVat;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseAmountValue() {
        return baseAmountValue;
    }

    public void setBaseAmountValue(double baseAmountValue) {
        this.baseAmountValue = baseAmountValue;
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
}
