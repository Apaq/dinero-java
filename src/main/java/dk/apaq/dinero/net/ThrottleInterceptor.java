package dk.apaq.dinero.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * This interceptor makes sure we don't do more than one request per second.
 */
public class ThrottleInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(ThrottleInterceptor.class);
    private static final long TIME_BETWEEN_REQUESTS = 500;

    private long lastRequest = -1;

    @Override
    public synchronized ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);

        if(lastRequest >= System.currentTimeMillis() - TIME_BETWEEN_REQUESTS) {
            try {
                long msToSleep = TIME_BETWEEN_REQUESTS - (System.currentTimeMillis() - lastRequest);
                LOG.debug("Throttling request. [sleep={}ms]", msToSleep);
                Thread.sleep(msToSleep);
            } catch (InterruptedException e) {
                LOG.error("Thread sleep interrupted.", e);
            }
        }

        lastRequest = System.currentTimeMillis();

        return response;
    }
}
