package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AuthenticationException extends DineroException {

    @JsonCreator
    public AuthenticationException(int code, String message) {
        super(message, code);
    }

    
    private static final long serialVersionUID = 1L;

    
}
