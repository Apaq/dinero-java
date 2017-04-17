package com.previsto.billy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.previsto.billy.model.enums.AttachmentDeliveryMode;
import com.previsto.billy.model.enums.InvoiceMode;
import com.previsto.billy.model.enums.PaymentTermsMode;
import com.previsto.billy.model.enums.SubscriptionPeriod;
import com.previsto.billy.model.enums.VatPeriod;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Organization extends Entity {

    private String ownerUserId;
    private LocalDateTime createdTime;
    private String name;
    private String url;
    private String street;
    private String zipcode;
    private String city;
    private String countryId;
    private String phone;
    private String fax;
    private String email;
    private String registrationNo;
    private String baseCurrencyId;
    private String logoFileId;
    private String logoPdfFileId;
    private String logoUrl;
    private String iconFileId;
    private String iconUrl;
    private String icon48Url;
    private int fiscalYearEndMonth;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate firstFiscalYearStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate firstFiscalYearEnd;
    private boolean hasBillVoucherNo;
    private String subscriptionCardNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate subscriptionCardExpires;
    private String subscriptionTransactionId;
    private boolean isSubscriptionBankPayer;
    private float subscriptionPrice;
    private SubscriptionPeriod subscriptionPeriod;
    private float subscriptionDiscount;
    private LocalDate subscriptionExpires;
    private boolean trial;
    private boolean terminated;
    private LocalDateTime terminationTime;
    private String localeId;
    private String billEmailAddress;
    private boolean unmigrated;
    private boolean locked;
    private String lockedReason;
    private String appUrl;
    private AttachmentDeliveryMode emailAttachmentDeliveryMode;
    private boolean hasVat;
    private VatPeriod vatPeriod;
    private InvoiceMode invoiceMode;
    private int nextInvoiceNo;
    private PaymentTermsMode paymentTermsMode = PaymentTermsMode.Net;
    private int paymentTermsDays = 7;
    private String defaultSalesAccountId;
    private String defaultSalesTaxRulesetId;
    private LocalDate bankSyncStartDate;
    private String defaultBankFeeAccountId;
    private String defaultBillAccountId;

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(String baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public String getLogoFileId() {
        return logoFileId;
    }

    public void setLogoFileId(String logoFileId) {
        this.logoFileId = logoFileId;
    }

    @JsonIgnore
    public String getLogoPdfFileId() {
        return logoPdfFileId;
    }

    @JsonProperty
    public void setLogoPdfFileId(String logoPdfFileId) {
        this.logoPdfFileId = logoPdfFileId;
    }

    @JsonIgnore
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId;
    }

    @JsonIgnore
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonIgnore
    public String getIcon48Url() {
        return icon48Url;
    }

    @JsonProperty
    public void setIcon48Url(String icon48Url) {
        this.icon48Url = icon48Url;
    }

    public int getFiscalYearEndMonth() {
        return fiscalYearEndMonth;
    }

    public void setFiscalYearEndMonth(int fiscalYearEndMonth) {
        this.fiscalYearEndMonth = fiscalYearEndMonth;
    }

    public LocalDate getFirstFiscalYearStart() {
        return firstFiscalYearStart;
    }

    public void setFirstFiscalYearStart(LocalDate firstFiscalYearStart) {
        this.firstFiscalYearStart = firstFiscalYearStart;
    }

    public LocalDate getFirstFiscalYearEnd() {
        return firstFiscalYearEnd;
    }

    public void setFirstFiscalYearEnd(LocalDate firstFiscalYearEnd) {
        this.firstFiscalYearEnd = firstFiscalYearEnd;
    }

    public boolean isHasBillVoucherNo() {
        return hasBillVoucherNo;
    }

    public void setHasBillVoucherNo(boolean hasBillVoucherNo) {
        this.hasBillVoucherNo = hasBillVoucherNo;
    }

    public String getSubscriptionCardNumber() {
        return subscriptionCardNumber;
    }

    public void setSubscriptionCardNumber(String subscriptionCardNumber) {
        this.subscriptionCardNumber = subscriptionCardNumber;
    }

    public LocalDate getSubscriptionCardExpires() {
        return subscriptionCardExpires;
    }

    public void setSubscriptionCardExpires(LocalDate subscriptionCardExpires) {
        this.subscriptionCardExpires = subscriptionCardExpires;
    }

    public String getSubscriptionTransactionId() {
        return subscriptionTransactionId;
    }

    public void setSubscriptionTransactionId(String subscriptionTransactionId) {
        this.subscriptionTransactionId = subscriptionTransactionId;
    }

    public boolean isIsSubscriptionBankPayer() {
        return isSubscriptionBankPayer;
    }

    public void setIsSubscriptionBankPayer(boolean isSubscriptionBankPayer) {
        this.isSubscriptionBankPayer = isSubscriptionBankPayer;
    }

    public float getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(float subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public SubscriptionPeriod getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    public void setSubscriptionPeriod(SubscriptionPeriod subscriptionPeriod) {
        this.subscriptionPeriod = subscriptionPeriod;
    }

    public float getSubscriptionDiscount() {
        return subscriptionDiscount;
    }

    public void setSubscriptionDiscount(float subscriptionDiscount) {
        this.subscriptionDiscount = subscriptionDiscount;
    }

    public LocalDate getSubscriptionExpires() {
        return subscriptionExpires;
    }

    public void setSubscriptionExpires(LocalDate subscriptionExpires) {
        this.subscriptionExpires = subscriptionExpires;
    }

    @JsonIgnore
    public boolean isTrial() {
        return trial;
    }

    @JsonProperty("isTrial")
    public void setTrial(boolean trial) {
        this.trial = trial;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @JsonIgnore
    public LocalDateTime getTerminationTime() {
        return terminationTime;
    }

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public void setTerminationTime(LocalDateTime terminationTime) {
        this.terminationTime = terminationTime;
    }

    public String getLocaleId() {
        return localeId;
    }

    public void setLocaleId(String localeId) {
        this.localeId = localeId;
    }

    @JsonIgnore
    public String getBillEmailAddress() {
        return billEmailAddress;
    }

    public void setBillEmailAddress(String billEmailAddress) {
        this.billEmailAddress = billEmailAddress;
    }

    @JsonIgnore
    public boolean isUnmigrated() {
        return unmigrated;
    }

    @JsonProperty("isUnmigrated")
    public void setUnmigrated(boolean unmigrated) {
        this.unmigrated = unmigrated;
    }

    @JsonIgnore
    public boolean isLocked() {
        return locked;
    }

    @JsonProperty("isLocked")
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @JsonIgnore
    public String getLockedReason() {
        return lockedReason;
    }

    @JsonProperty
    public void setLockedReason(String lockedReason) {
        this.lockedReason = lockedReason;
    }

    @JsonIgnore
    public String getAppUrl() {
        return appUrl;
    }

    @JsonProperty
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public AttachmentDeliveryMode getEmailAttachmentDeliveryMode() {
        return emailAttachmentDeliveryMode;
    }

    public void setEmailAttachmentDeliveryMode(AttachmentDeliveryMode emailAttachmentDeliveryMode) {
        this.emailAttachmentDeliveryMode = emailAttachmentDeliveryMode;
    }

    public boolean isHasVat() {
        return hasVat;
    }

    public void setHasVat(boolean hasVat) {
        this.hasVat = hasVat;
    }

    public VatPeriod getVatPeriod() {
        return vatPeriod;
    }

    public void setVatPeriod(VatPeriod vatPeriod) {
        this.vatPeriod = vatPeriod;
    }

    public InvoiceMode getInvoiceMode() {
        return invoiceMode;
    }

    public void setInvoiceMode(InvoiceMode invoiceMode) {
        this.invoiceMode = invoiceMode;
    }

    public int getNextInvoiceNo() {
        return nextInvoiceNo;
    }

    public void setNextInvoiceNo(int nextInvoiceNo) {
        this.nextInvoiceNo = nextInvoiceNo;
    }

    public PaymentTermsMode getPaymentTermsMode() {
        return paymentTermsMode;
    }

    public void setPaymentTermsMode(PaymentTermsMode paymentTermsMode) {
        this.paymentTermsMode = paymentTermsMode;
    }

    public int getPaymentTermsDays() {
        return paymentTermsDays;
    }

    public void setPaymentTermsDays(int paymentTermsDays) {
        this.paymentTermsDays = paymentTermsDays;
    }

    public String getDefaultSalesAccountId() {
        return defaultSalesAccountId;
    }

    public void setDefaultSalesAccountId(String defaultSalesAccountId) {
        this.defaultSalesAccountId = defaultSalesAccountId;
    }

    public String getDefaultSalesTaxRulesetId() {
        return defaultSalesTaxRulesetId;
    }

    public void setDefaultSalesTaxRulesetId(String defaultSalesTaxRulesetId) {
        this.defaultSalesTaxRulesetId = defaultSalesTaxRulesetId;
    }

    public LocalDate getBankSyncStartDate() {
        return bankSyncStartDate;
    }

    public void setBankSyncStartDate(LocalDate bankSyncStartDate) {
        this.bankSyncStartDate = bankSyncStartDate;
    }

    public String getDefaultBankFeeAccountId() {
        return defaultBankFeeAccountId;
    }

    public void setDefaultBankFeeAccountId(String defaultBankFeeAccountId) {
        this.defaultBankFeeAccountId = defaultBankFeeAccountId;
    }

    public String getDefaultBillAccountId() {
        return defaultBillAccountId;
    }

    public void setDefaultBillAccountId(String defaultBillAccountId) {
        this.defaultBillAccountId = defaultBillAccountId;
    }
    
}
