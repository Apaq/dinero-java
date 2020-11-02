package dk.apaq.dinero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    /**
     * Name of the contact person or the company name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Email address
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    /**
     * Phone number
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPerson() {
        return isPerson;
    }

    /**
     * Boolean to indicate whether the contact is a private person or a company. If true, the contact is a person.
     * @param person
     */
    public void setPerson(boolean person) {
        isPerson = person;
    }

    public String getExternalReference() {
        return externalReference;
    }

    /**
     * Your external id This can be used for ID'ing in external apps/services e.g. a web shop. The maximum length is
     * 128 characters
     * @param externalReference
     */
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getCountryKey() {
        return countryKey;
    }

    /**
     * Country key Two character string e.g. DK for Denmark, DE for Germany or SE for Sweden
     * @param countryKey
     */
    public void setCountryKey(String countryKey) {
        this.countryKey = countryKey;
    }

    public String getStreet() {
        return street;
    }

    /**
     * Street name
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    /**
     * Zip code
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    /**
     * City
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    public String getAttPerson() {
        return attPerson;
    }

    /**
     * Name of the att. person in cases here the contact is a company. If IsPerson this should be NULL.
     * @param attPerson
     */
    public void setAttPerson(String attPerson) {
        this.attPerson = attPerson;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * VAT number. If IsPerson this should be NULL.
     * @param vatNumber
     */
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public PaymentConditionType getPaymentConditionType() {
        return paymentConditionType;
    }

    /**
     * Type of the payment condition for the contact. Netto, NettoCash or CurrentMonthOut. If NettoCash, then
     * PaymentConditionNumberOfDays should be null. Defaults to Netto.
     * @param paymentConditionType
     */
    public void setPaymentConditionType(PaymentConditionType paymentConditionType) {
        this.paymentConditionType = paymentConditionType;
    }

    public Integer getPaymentConditionNumberOfDays() {
        return paymentConditionNumberOfDays;
    }

    /**
     * Number of days for payment for the contact. E.g. that the contact has 7 days until payment has to be made.
     * This field depends on PaymentConditionType. If left empty, defaults to 8 for all other payment types then
     * NettoCash.
     * @param paymentConditionNumberOfDays
     */
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

    /**
     * Webpage address
     * @param webpage
     */
    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getEanNumber() {
        return eanNumber;
    }

    /**
     * EAN number. This number is used for digital invoicing. If IsPerson this should be NULL.
     * @param eanNumber
     */
    public void setEanNumber(String eanNumber) {
        this.eanNumber = eanNumber;
    }
}
