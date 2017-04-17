package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class UnknownException extends DineroException {

    @JsonCreator
    public UnknownException(@JsonProperty(value = "Message") String message) {
        super(message);
    }

    
    private static final long serialVersionUID = 1L;

}
