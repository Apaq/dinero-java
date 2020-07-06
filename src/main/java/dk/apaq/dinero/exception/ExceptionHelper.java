package dk.apaq.dinero.exception;

import java.util.Map;

public class ExceptionHelper {

    public static String resolveMessage(String message, Map<String, Object> validationErrors) {
        if(message == null) {
            message = "";
        }
        
        if(validationErrors != null) {
            String errorMsg = " [";
            for(Map.Entry<String, Object> entry : validationErrors.entrySet()) {
                errorMsg += entry.getKey() + ": " + entry.getValue() + ", ";
            }
            errorMsg += "]";
            message += errorMsg;
        }
        return message;
    }
}
