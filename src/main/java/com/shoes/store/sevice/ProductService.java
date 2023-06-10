package com.shoes.store.sevice;

import com.shoes.store.respone.ProductRespone;

import java.util.List;

public interface ProductService {
    List<ProductRespone> getAll();
    public ProductRespone getProductById(long id);

    public List<ProductRespone> searchProducts(String query);
}
