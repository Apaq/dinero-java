package dk.apaq.dinero.autoconfigure;

import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

@ConfigurationProperties("dinero")
public class DineroProperties {

    private String clientId;
    private String clientSecret;

    private String organizationId;

    /**
     * The API key for dinero.
     */
    private String apiKey;

    private String authUrl;

    /**
     * The API url for dinero.
     */
    private String serviceUrl;


    @PostConstruct
    protected void init() {
        Assert.notNull(this.serviceUrl, "Service url must be specified via 'dinero.serviceUrl'.");
    }


    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}
