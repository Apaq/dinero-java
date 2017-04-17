package com.previsto.billy.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DiscountMode {
    @JsonProperty("cash")
    CashDiscount,
    @JsonProperty("percent")
    PercentageDiscount
}
