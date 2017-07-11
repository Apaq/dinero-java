package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Persistable;

import java.time.Instant;

public class Contact extends ArchivableEntity {

    @JsonProperty("ContactGuid")
    private String id;
    private String name;
    private String email;
    private String phone;
    @JsonProperty("IsPerson")
    private boolean isPerson;
    private String externalReference;
    private String countryKey = "DK";
    private String street;
    private String zipCode;
    private String city;
    private String attPerson;
    private String vatNumber;
    private PaymentConditionType paymentConditionType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer paymentConditionNumberOfDays;
    private boolean isDebitor;
    private boolean isCreditor;
    private String webpage;
    private String eanNumber;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(String countryKey) {
        this.countryKey = countryKey;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAttPerson() {
        return attPerson;
    }

    public void setAttPerson(String attPerson) {
        this.attPerson = attPerson;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public PaymentConditionType getPaymentConditionType() {
        return paymentConditionType;
    }

    public void setPaymentConditionType(PaymentConditionType paymentConditionType) {
        this.paymentConditionType = paymentConditionType;
    }

    public Integer getPaymentConditionNumberOfDays() {
        return paymentConditionNumberOfDays;
    }

    public void setPaymentConditionNumberOfDays(Integer paymentConditionNumberOfDays) {
        this.paymentConditionNumberOfDays = paymentConditionNumberOfDays;
    }

    public boolean isDebitor() {
        return isDebitor;
    }

    public void setDebitor(boolean debitor) {
        isDebitor = debitor;
    }

    public boolean isCreditor() {
        return isCreditor;
    }

    public void setCreditor(boolean creditor) {
        isCreditor = creditor;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getEanNumber() {
        return eanNumber;
    }

    public void setEanNumber(String eanNumber) {
        this.eanNumber = eanNumber;
    }
}
