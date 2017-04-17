package com.previsto.dinero.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DiscountMode {
    @JsonProperty("cash")
    CashDiscount,
    @JsonProperty("percent")
    PercentageDiscount
}
