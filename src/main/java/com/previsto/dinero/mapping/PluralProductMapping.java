package com.previsto.dinero.mapping;

import com.previsto.dinero.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;

public class PluralProductMapping extends ProductMapping implements PluralMapping<Product>{
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public Page<Product> getPage() {
        products.forEach(c -> resolveExtraData(c));
        return BaseMapping.resolvePage(getMeta(), products);
    }
    
}
