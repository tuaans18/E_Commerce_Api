package com.shoes.store.request;

public class InvoiceRequest {

    private String deliveryAddress;

    private String email;

    public InvoiceRequest() {
    }

    public InvoiceRequest(String deliveryAddress, String email) {
        this.deliveryAddress = deliveryAddress;
        this.email = email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
