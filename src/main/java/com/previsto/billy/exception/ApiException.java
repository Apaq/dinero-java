package com.previsto.billy.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;



public class ApiException extends BillyException {

    @JsonCreator
    public ApiException(@JsonProperty(value = "errorCode") String errorCode, @JsonProperty(value = "errorMessage") String errorMessage, @JsonProperty("helpUrl") String helpUrl, @JsonProperty("meta") ExceptionMeta meta) {
        super(errorMessage, errorCode, meta);
    }
    
    private static final long serialVersionUID = 1L;

}
