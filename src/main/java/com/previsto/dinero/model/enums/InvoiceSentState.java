package com.previsto.dinero.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum InvoiceSentState {
    @JsonProperty("unsent")
    Unsent, 
    @JsonProperty("printed")
    Printed, 
    @JsonProperty("sent")
    Sent, 
    @JsonProperty("opened")
    Opened, 
    @JsonProperty("viewed")
    Viewed
}
