package com.previsto.dinero.repository;

import com.previsto.dinero.model.Product;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.*;
import org.springframework.test.web.client.RequestMatcher;

public class ProductResourceTest extends ResourceTestBase<Product> {

    public ProductResourceTest() {
        super(new ProductResource(buildRestTemplate(), "http://server/Api"), Product.class);
    }

    @Override
    protected DefaultResponseCreator generateExpectedGetResponse() {
        return withSuccess(Util.readResourceFromFile("products_single.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected DefaultResponseCreator generateExpectedFindAllResponse() {
        return withSuccess(Util.readResourceFromFile("products_list.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected String generateExpectedGetQueryParams() {
        return "";
    }

    @Override
    protected String generateSingularId() {
        return "ksSgZEGPQmGohQ9eWxVOoQ";
    }

    @Override
    protected List<RequestMatcher> generateExpectedSaveRequest() {
        return Arrays.asList(new RequestMatcher[]{});
    }
    

    @Override
    protected void doCheckEntity(Product entity) {
        if ("ksSgZEGPQmGohQ9eWxVOoQ".equals(entity.getId())) {
            assertEquals("WC_PREVISTO", entity.getProductNo());
            return;
        }

        
        throw new RuntimeException("Unexpected entity [id=" + entity.getId() + "]");
    }

}
