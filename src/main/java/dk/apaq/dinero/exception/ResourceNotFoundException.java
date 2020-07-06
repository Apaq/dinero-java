package dk.apaq.dinero.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceNotFoundException extends DineroException {
    
    @JsonCreator
    public ResourceNotFoundException(@JsonProperty(value = "code") int code, @JsonProperty(value = "message") String message) {
        super(message, code);
    }
    
}
