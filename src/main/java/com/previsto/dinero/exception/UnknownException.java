package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UnknownException extends DineroException {

    @JsonCreator
    public UnknownException(@JsonProperty(value = "message") String message) {
        super(message);
    }

    
    private static final long serialVersionUID = 1L;

}
