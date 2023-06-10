package com.shoes.store.request;

public class DeleteProductInCartRequest {
    private Long productId;
    private String email;

    public DeleteProductInCartRequest() {
    }

    public DeleteProductInCartRequest(Long productId, String email) {
        this.productId = productId;
        this.email = email;
    }


    public Long getId() {
        return productId;
    }

    public void setId(Long id) {
        this.productId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
