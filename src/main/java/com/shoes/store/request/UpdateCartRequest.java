package com.shoes.store.request;

public class UpdateCartRequest
{
    private Long productId;
    private String email;
    private int quantity;
    public UpdateCartRequest() {
    }

    public UpdateCartRequest(Long productId, String email, int quantity) {
        this.productId = productId;
        this.email = email;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
