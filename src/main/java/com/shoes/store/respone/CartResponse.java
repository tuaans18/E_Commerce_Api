package com.shoes.store.respone;

import com.shoes.store.repository.entity.ProducOfInvoice;
import com.shoes.store.repository.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {

    private Float totalPrice = 0f;

    private List<ProductOfInvoiceRespone> products = new ArrayList<>();

    public CartResponse() {
    }

    public CartResponse(Float totalPrice, List<ProductOfInvoiceRespone> products) {
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductOfInvoiceRespone> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOfInvoiceRespone> products) {
        this.products = products;
    }
}
