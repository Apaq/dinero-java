package com.previsto.dinero.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.previsto.dinero.model.enums.ContactType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.previsto.dinero.model.enums.AttachmentDeliveryMode;
import com.previsto.dinero.model.enums.PaymentTermsMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contact extends ArchivableEntity {

    private ContactType type;
    private String name;
    private String countryId;
    private String street;
    private String cityId;
    private String cityText;
    private String stateText;
    private String zipcodeId;
    private String zipcodeText;
    private String contactNo;
    private String phone;
    private String fax;
    private String currencyId;
    private String registrationNo;
    private String localeId;
    private String ean;
    private LocalDateTime createdTime;
    
    @JsonProperty("isCustomer")
    private boolean customer;
    @JsonProperty("isSupplier")
    private boolean supplier;

    private PaymentTermsMode paymentTermsMode;
    private Integer paymentTermsDays;

    private String accessCode;
    private AttachmentDeliveryMode emailAttachmentDeliveryMode;
    
    private List<ContactPerson> contactPersons = new ArrayList<>();
    
    public Contact() {
    }

    
    public Contact(ContactType type, String name, String countryId) {
        this.type = type;
        this.name = name;
        this.countryId = countryId;
    }

    @JsonIgnore
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getZipcodeId() {
        return zipcodeId;
    }

    public void setZipcodeId(String zipcodeId) {
        this.zipcodeId = zipcodeId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public String getStateText() {
        return stateText;
    }

    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

    public String getZipcodeText() {
        return zipcodeText;
    }

    public void setZipcodeText(String zipcodeText) {
        this.zipcodeText = zipcodeText;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currency) {
        this.currencyId = currency;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getLocaleId() {
        return localeId;
    }

    public void setLocaleId(String localeId) {
        this.localeId = localeId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public boolean isCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }

    public PaymentTermsMode getPaymentTermsMode() {
        return paymentTermsMode;
    }

    public void setPaymentTermsMode(PaymentTermsMode paymentTermsMode) {
        this.paymentTermsMode = paymentTermsMode;
    }

    public Integer getPaymentTermsDays() {
        return paymentTermsDays;
    }

    public void setPaymentTermsDays(Integer paymentTermsDays) {
        this.paymentTermsDays = paymentTermsDays;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public AttachmentDeliveryMode getEmailAttachmentDeliveryMode() {
        return emailAttachmentDeliveryMode;
    }

    public void setEmailAttachmentDeliveryMode(AttachmentDeliveryMode emailAttachmentDeliveryMode) {
        this.emailAttachmentDeliveryMode = emailAttachmentDeliveryMode;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }
    
}
