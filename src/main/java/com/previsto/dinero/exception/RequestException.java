package com.previsto.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class RequestException extends DineroException {

    private Map<String, Object> validationErrors = null;
    
    @JsonCreator
    public RequestException(@JsonProperty(value = "code") int code,
            @JsonProperty(value = "message") String message,
            @JsonProperty("languageSpecificMessages") List<LanguageSpecificMessage> languageSpecificMessages,
            @JsonProperty("validationErrors") Map<String, Object> validationErrors) {
        super(ExceptionHelper.resolveMessage(message, validationErrors), code, languageSpecificMessages);
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
