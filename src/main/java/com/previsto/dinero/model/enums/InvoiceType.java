package com.previsto.dinero.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum InvoiceType {
    @JsonProperty("invoice")
    Invoice, 
    @JsonProperty("credit_note")
    CreditNote
}
