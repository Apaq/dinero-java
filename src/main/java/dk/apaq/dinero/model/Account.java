package dk.apaq.dinero.model;

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

    /**
     * Account number e.g. 1000 or 55000
     * @param accountNumber
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    /**
     * Name of the account
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
