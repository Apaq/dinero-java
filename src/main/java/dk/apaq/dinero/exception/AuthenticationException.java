package dk.apaq.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationException extends DineroException {

    @JsonCreator
    public AuthenticationException(@JsonProperty(value = "code") int code, @JsonProperty(value = "message") String message) {
        super(message, code);
    }

    
    private static final long serialVersionUID = 1L;

    
}
