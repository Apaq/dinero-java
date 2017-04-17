package com.previsto.dinero.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SubscriptionPeriod {
    @JsonProperty("monthly")
    Monthly, 
    @JsonProperty("yearly")
    Yearly
}
