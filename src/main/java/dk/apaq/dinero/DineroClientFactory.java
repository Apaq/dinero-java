package dk.apaq.dinero;

public class DineroClientFactory {

    private final String clientId;
    private final String clientSecret;

    private final String serviceUrl;
    private final String authUrl;

    public DineroClientFactory(String clientId, String clientSecret, String authUrl, String serviceUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authUrl = authUrl;
        this.serviceUrl = serviceUrl;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public DineroClient create(String organizationId, String apiKey) {
        return new DineroClient(clientId, clientSecret, organizationId, apiKey, authUrl, serviceUrl);
    }
}
