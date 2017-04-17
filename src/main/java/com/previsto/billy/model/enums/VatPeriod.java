package com.previsto.billy.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VatPeriod {
    @JsonProperty("quarterly")
    Quarterly,
    @JsonProperty("semianually")
    SemiAnnually;
}
