package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice extends ArchivableEntity implements Entity {

    private LocalDate paymentDate;
    private PaymentStatus paymentStatus = PaymentStatus.Draft;
    private int paymentConditionNumberOfDays;
    private PaymentConditionType paymentConditionType = PaymentConditionType.Netto;
    private InvoiceStatus status = InvoiceStatus.Draft;
    @JsonProperty("ContactGuid")
    private String contactId;
    @JsonProperty("Guid")
    private String id;
    private long number;
    private String contactName;
    private boolean showLinesInclVat;
    private double totalExclVat;
    private double totalVatableAmount;
    private double totalInclVat;
    private double totalNonVatableAmount;
    private double totalVat;
    private List<InvoiceTotalLine> totalLines = new ArrayList<>();
    private String currency;
    private String language;
    private String externalReference;
    private String description;
    private String comment;
    private LocalDate date;
    private List<InvoiceProductLine> productLines = new ArrayList<>();
    private String address;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentConditionNumberOfDays() {
        return paymentConditionNumberOfDays;
    }

    public void setPaymentConditionNumberOfDays(int paymentConditionNumberOfDays) {
        this.paymentConditionNumberOfDays = paymentConditionNumberOfDays;
    }

    public PaymentConditionType getPaymentConditionType() {
        return paymentConditionType;
    }

    public void setPaymentConditionType(PaymentConditionType paymentConditionType) {
        this.paymentConditionType = paymentConditionType;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public boolean isShowLinesInclVat() {
        return showLinesInclVat;
    }

    public void setShowLinesInclVat(boolean showLinesInclVat) {
        this.showLinesInclVat = showLinesInclVat;
    }

    public double getTotalExclVat() {
        return totalExclVat;
    }

    public void setTotalExclVat(double totalExclVat) {
        this.totalExclVat = totalExclVat;
    }

    public double getTotalVatableAmount() {
        return totalVatableAmount;
    }

    public void setTotalVatableAmount(double totalVatableAmount) {
        this.totalVatableAmount = totalVatableAmount;
    }

    public double getTotalInclVat() {
        return totalInclVat;
    }

    public void setTotalInclVat(double totalInclVat) {
        this.totalInclVat = totalInclVat;
    }

    public double getTotalNonVatableAmount() {
        return totalNonVatableAmount;
    }

    public void setTotalNonVatableAmount(double totalNonVatableAmount) {
        this.totalNonVatableAmount = totalNonVatableAmount;
    }

    public double getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(double totalVat) {
        this.totalVat = totalVat;
    }

    public List<InvoiceTotalLine> getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(List<InvoiceTotalLine> totalLines) {
        this.totalLines = totalLines;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<InvoiceProductLine> getProductLines() {
        return productLines;
    }

    public void setProductLines(List<InvoiceProductLine> productLines) {
        this.productLines = productLines;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
