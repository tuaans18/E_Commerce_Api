package com.shoes.store.repository;

import com.shoes.store.repository.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findByStatusAndUser_Email(int status, String email);
}
