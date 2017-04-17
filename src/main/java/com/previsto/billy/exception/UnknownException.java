package com.previsto.billy.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



public class UnknownException extends BillyException {

    @JsonCreator
    public UnknownException(@JsonProperty(value = "Message") String message) {
        super(message);
    }

    
    private static final long serialVersionUID = 1L;

}
