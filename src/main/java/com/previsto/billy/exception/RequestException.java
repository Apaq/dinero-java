package com.previsto.billy.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class RequestException extends BillyException {

    private Map<String, Object> validationErrors = null;
    
    @JsonCreator
    public RequestException(@JsonProperty(value = "errorCode") String errorCode, 
            @JsonProperty(value = "errorMessage") String errorMessage, 
            @JsonProperty("helpUrl") String helpUrl, 
            @JsonProperty("meta") ExceptionMeta meta,
            @JsonProperty("validationErrors") Map<String, Object> validationErrors) {
        super(ExceptionHelper.resolveMessage(errorMessage, validationErrors), errorCode, meta);
        this.validationErrors = validationErrors;
    }

    public RequestException(String message) {
        super(message);
    }

    public Map<String, Object> getValidationErrors() {
        return validationErrors;
    }

    private static final long serialVersionUID = 1L;

    
}
