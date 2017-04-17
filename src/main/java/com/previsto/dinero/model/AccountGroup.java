package com.previsto.dinero.model;

public class AccountGroup extends Entity {
    private String natureId;
    private String name;
    private String description;
    private String accountNo;
    private int priority;
    
    public String getNatureId() {
        return natureId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
}
