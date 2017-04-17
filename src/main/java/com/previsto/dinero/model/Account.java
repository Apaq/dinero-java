package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account extends ArchivableEntity {
    private String name;
    private int accountNo;
    private String description;
    private String groupId;
    private String natureId;
    private String currencyId;
    private String taxRateId;
    private boolean paymentEnabled;
    private boolean bankAccount;
    private String bankName;
    private String bankRoutingNo;
    private String bankAccountNo;
    private String bankSwift;
    private String bankIBan;
    private AccountGroup group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public AccountGroup getGroup() {
        return group;
    }

    public void setGroup(AccountGroup group) {
        this.group = group;
    }

    public String getNatureId() {
        return natureId;
    }

    public void setNatureId(String natureId) {
        this.natureId = natureId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getTaxRateId() {
        return taxRateId;
    }

    public void setTaxRateId(String taxRateId) {
        this.taxRateId = taxRateId;
    }

    public boolean isPaymentEnabled() {
        return paymentEnabled;
    }

    public void setPaymentEnabled(boolean paymentEnabled) {
        this.paymentEnabled = paymentEnabled;
    }

    public boolean isBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(boolean bankAccount) {
        this.bankAccount = bankAccount;
    }

    @JsonIgnore
    public String getBankName() {
        return bankName;
    }

    @JsonProperty
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @JsonIgnore
    public String getBankRoutingNo() {
        return bankRoutingNo;
    }

    @JsonProperty
    public void setBankRoutingNo(String bankRoutingNo) {
        this.bankRoutingNo = bankRoutingNo;
    }

    @JsonIgnore
    public String getBankAccountNo() {
        return bankAccountNo;
    }

    @JsonProperty
    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    @JsonIgnore
    public String getBankSwift() {
        return bankSwift;
    }

    @JsonProperty
    public void setBankSwift(String bankSwift) {
        this.bankSwift = bankSwift;
    }

    @JsonIgnore
    public String getBankIBan() {
        return bankIBan;
    }

    @JsonProperty
    public void setBankIBan(String bankIBan) {
        this.bankIBan = bankIBan;
    }
    
    
}
