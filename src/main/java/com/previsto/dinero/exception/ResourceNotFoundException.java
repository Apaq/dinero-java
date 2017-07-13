package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceNotFoundException extends DineroException {
    
    @JsonCreator
    public ResourceNotFoundException(@JsonProperty(value = "code") int code, @JsonProperty(value = "message") String message) {
        super(message, code);
    }
    
}