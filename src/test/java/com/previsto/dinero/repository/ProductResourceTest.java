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
        return "?page=0&pageSize=1000&fields=ProductGuid,Name,Quantity,Unit,AccountNumber,BaseAmountValue,BaseAmountValueInclVat,TotalAmount,TotalAmountInclVat,CreatedAt,UpdatedAt,DeletedAt,ProductNumber";
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
        if ("eb4b43d4-1996-475f-8b9f-782be605227c".equals(entity.getId())) {
            assertEquals(null, entity.getProductNumber());
            return;
        }

        if ("bea45ed0-df16-4fd3-84de-8249c4ab23cf".equals(entity.getId())) {
            assertEquals("TEST_CODE", entity.getProductNumber());
            return;
        }

        
        throw new RuntimeException("Unexpected entity [id=" + entity.getId() + "]");
    }

}
