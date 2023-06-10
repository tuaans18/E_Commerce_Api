package com.shoes.store.repository;

import com.shoes.store.repository.entity.ProducOfInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOfInvoiceRepository extends JpaRepository<ProducOfInvoice, Long> {
    void deleteByInvoice_IdAndProduct_Id(Long invoiceId, Long productId);
    ProducOfInvoice findByInvoice_IdAndProduct_Id(Long invoiceId, Long productId);
}
