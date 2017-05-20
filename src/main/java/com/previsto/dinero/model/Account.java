package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Account implements Entity {

    private Integer accountNumber;
    private String name;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return accountNumber == null;
    }

    @Override
    @JsonIgnore
    public String getId() {
        return accountNumber == null ? null : accountNumber.toString();
    }

    @Override
    @JsonIgnore
    public void setId(String id) {
        this.accountNumber = Integer.parseInt(id);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
