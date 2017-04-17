package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionMeta {
    private int statusCode;
    private boolean success;

    @JsonCreator
    public ExceptionMeta(@JsonProperty("statusCode") int statusCode, @JsonProperty("success") boolean success, @JsonProperty("meta") ExceptionMeta meta) {
        this.statusCode = statusCode;
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return success;
    }
    
    
}
