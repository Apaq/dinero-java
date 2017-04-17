package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AuthenticationException extends DineroException {

    @JsonCreator
    public AuthenticationException(@JsonProperty(value = "errorCode") String errorCode, @JsonProperty(value = "errorMessage") String errorMessage, @JsonProperty("helpUrl") String helpUrl, @JsonProperty("meta") ExceptionMeta meta) {
        super(errorMessage, errorCode, meta);
    }

    
    private static final long serialVersionUID = 1L;

    
}
