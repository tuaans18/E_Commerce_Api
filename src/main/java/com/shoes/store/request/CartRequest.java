package com.shoes.store.request;

public class CartRequest {

    private String email;

    public CartRequest() {
    }

    public CartRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
