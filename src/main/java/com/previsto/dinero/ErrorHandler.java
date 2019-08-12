package com.previsto.dinero;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previsto.dinero.exception.ApiException;
import com.previsto.dinero.exception.AuthenticationException;
import com.previsto.dinero.exception.RequestException;
import com.previsto.dinero.exception.UnknownException;
import com.previsto.dinero.exception.DineroException;
import com.previsto.dinero.exception.ResourceNotFoundException;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class ErrorHandler implements ResponseErrorHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getRawStatusCode() >= 300;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        Class<? extends DineroException> clazz;

        String content = IOUtils.toString(response.getBody());

        if (response.getRawStatusCode() >= 500) {
            clazz = ApiException.class;
        } else if (response.getRawStatusCode() == 400 && content.contains("_grant")) {
            clazz = AuthenticationException.class;
            content = "{\"code\": 401, \"message\": \"Unable to acquire grant.\"}";
        } else if (response.getRawStatusCode() == 401 || response.getRawStatusCode() == 403) {
            clazz = AuthenticationException.class;
        } else if (response.getRawStatusCode() == 404) {
            // Dinero just throws HTML back at 404's. Do not try to parse json
            throw new ResourceNotFoundException(404, "The requested resource was not found.");
        } else {
            clazz = RequestException.class;
        }

        DineroException ex;
        try {
            ex = objectMapper.readValue(content, clazz);
        }
        catch (Throwable t) {
            ex = objectMapper.readValue(content, UnknownException.class);

            switch (ex.getCode()) {
                case 40:
                case 63:
                case 65:
                    ex = new ResourceNotFoundException(ex.getCode(), ex.getMessage());
                    break;
            }
        }
        throw ex;
    }

}
