package com.shoes.store.sevice;

import com.shoes.store.request.AddProductToCartRequest;
import com.shoes.store.request.DeleteProductInCartRequest;
import com.shoes.store.request.InvoiceRequest;
import com.shoes.store.request.UpdateCartRequest;
import com.shoes.store.respone.CartResponse;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {
    CartResponse getCart(String email);
    void addProductToCart(AddProductToCartRequest addProductToCartRequest);
    void deleteProductInCart(DeleteProductInCartRequest deleteProductInCartRequest);
    void updateProductInCart(UpdateCartRequest updateCartRequest);
    void payInvoice(InvoiceRequest invoiceRequest);
}
