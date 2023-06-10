package com.shoes.store.request;

public class AddProductToCartRequest {

    private Long productId;

    private String email;

    private Float price;

    private int quantity;

    public AddProductToCartRequest() {
    }

    public AddProductToCartRequest(Long productId, String email, Float price, int quantity) {
        this.productId = productId;
        this.email = email;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
