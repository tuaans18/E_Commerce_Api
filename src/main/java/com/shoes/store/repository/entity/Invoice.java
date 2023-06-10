package com.shoes.store.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private Float total;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private int status;

    @Column(name = "deliveryaddress")
    private String deliveryAddress;

    @Column(name = "shippingfee")
    private Float shippingFee;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @OneToMany(mappedBy = "invoice")
    private List<ProducOfInvoice> producOfInvoices = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<ProducOfInvoice> getProducOfInvoices() {
        return producOfInvoices;
    }

    public void setProducOfInvoices(List<ProducOfInvoice> producOfInvoices) {
        this.producOfInvoices = producOfInvoices;
    }
}
