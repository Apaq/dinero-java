package dk.apaq.dinero.net;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.AbstractClientHttpResponse;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PagedResultAdapterResponse extends AbstractClientHttpResponse {

    private static final JsonFactory JSON_FACTORY = new JsonFactory();
    private static final String ENTITIES_FIELD = "Collection";
    private static final String PAGINATION_FIELD = "Pagination";

    private final ClientHttpResponse wrappedResponse;
    private final HttpHeaders headers;
    private final ByteArrayOutputStream storage = new ByteArrayOutputStream();

    public PagedResultAdapterResponse(ClientHttpResponse wrappedResponse) throws IOException {
        this.wrappedResponse = wrappedResponse;
        this.headers = wrappedResponse.getHeaders();

        JsonParser jParser = JSON_FACTORY.createParser(wrappedResponse.getBody());
        JsonGenerator jGenerator = JSON_FACTORY.createGenerator(storage);

        while (jParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jParser.getCurrentName();
            if (PAGINATION_FIELD.equals(fieldname)) {
                jParser.nextToken();
                headers.add("Count", parseCount(jParser));
            }

            if (ENTITIES_FIELD.equals(fieldname)) {
                jParser.nextToken();
                jGenerator.copyCurrentStructure(jParser);
            }
        }
        jGenerator.flush();
    }

    private String parseCount(JsonParser jParser) throws IOException {
        String count = "";
        while(jParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jParser.getCurrentName();
            if ("Result".equals(fieldname)) {
                jParser.nextToken();
                count = jParser.getText();
            }
        }
        return count;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return wrappedResponse.getRawStatusCode();
    }

    @Override
    public String getStatusText() throws IOException {
        return wrappedResponse.getStatusText();
    }

    @Override
    public void close() {
        wrappedResponse.close();
    }

    @Override
    public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(storage.toByteArray());
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }

}
