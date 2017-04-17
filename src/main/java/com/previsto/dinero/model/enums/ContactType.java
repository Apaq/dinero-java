package com.previsto.dinero.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ContactType {
    @JsonProperty("company")
    Company,
    @JsonProperty("person")
    Person
}
