package com.previsto.dinero.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum InvoiceTaxMode {
    @JsonProperty("incl")
    Including,
    @JsonProperty("excl")
    Excluding
}
