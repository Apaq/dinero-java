package com.previsto.dinero.model;

import java.time.LocalDate;

public class PaymentData {
    String timestamp;
    int depositAccountNumber;
    String externalReference;
    LocalDate paymentDate;
    String description;
    double amount;
    double amountInForeignCurrency;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getDepositAccountNumber() {
        return depositAccountNumber;
    }

    public void setDepositAccountNumber(int depositAccountNumber) {
        this.depositAccountNumber = depositAccountNumber;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountInForeignCurrency() {
        return amountInForeignCurrency;
    }

    public void setAmountInForeignCurrency(double amountInForeignCurrency) {
        this.amountInForeignCurrency = amountInForeignCurrency;
    }
}
