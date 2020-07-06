package dk.apaq.dinero.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class PaymentData {

    String timestamp;
    int depositAccountNumber;
    String externalReference;
    LocalDate paymentDate;
    String description;
    double amount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Double amountInForeignCurrency;

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

    public Double getAmountInForeignCurrency() {
        return amountInForeignCurrency;
    }

    public void setAmountInForeignCurrency(Double amountInForeignCurrency) {
        this.amountInForeignCurrency = amountInForeignCurrency;
    }
}
