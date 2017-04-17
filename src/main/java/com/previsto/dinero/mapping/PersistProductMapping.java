package com.previsto.dinero.mapping;

import com.previsto.dinero.model.Product;

public class PersistProductMapping implements PersistMapping<Product> {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void setEntity(Product entity) {
        this.product = entity;
    }
    
    
}
