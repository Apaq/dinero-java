package com.previsto.billy.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PaymentTermsMode {

    @JsonProperty("date")
    Date,
    @JsonProperty("netEndOfMonth")
    NetEndOfMonth,
    @JsonProperty("net")
    Net
    
}
