package com.previsto.billy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previsto.billy.exception.ApiException;
import com.previsto.billy.exception.AuthenticationException;
import com.previsto.billy.exception.RequestException;
import com.previsto.billy.exception.UnknownException;
import com.previsto.billy.exception.BillyException;
import com.previsto.billy.exception.ResourceNotFoundException;
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
        Class<? extends BillyException> clazz;

        if (response.getRawStatusCode() >= 500) {
            clazz = ApiException.class;
        } else if (response.getRawStatusCode() == 401 || response.getRawStatusCode() == 403) {
            clazz = AuthenticationException.class;
        } else if (response.getRawStatusCode() == 404) {
            clazz = ResourceNotFoundException.class;
        } else {
            clazz = RequestException.class;
        }

        String content = IOUtils.toString(response.getBody());
        BillyException ex;
        try {
            ex = objectMapper.readValue(content, clazz);
        }
        catch (Throwable t) {
            ex = objectMapper.readValue(content, UnknownException.class);
        }
        throw ex;
    }

}
