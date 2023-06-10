package com.shoes.store.api;


import com.shoes.store.repository.entity.Invoice;
import com.shoes.store.repository.entity.Users;
import com.shoes.store.request.*;
import com.shoes.store.sevice.InvoiceService;
import com.shoes.store.sevice.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class InvoiceApi {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private UserService userService;

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(@RequestBody CartRequest cartRequest) {
       return ResponseEntity.status(HttpStatus.OK).body(invoiceService.getCart(cartRequest.getEmail()));
    }

    @PostMapping("/cart/product")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductToCartRequest addProductToCartRequest){
        invoiceService.addProductToCart(addProductToCartRequest);
        return ResponseEntity.status(HttpStatus.OK).body("add product to cart successfully!!!");
    }

    @DeleteMapping("/cart/product/{id}")
    public ResponseEntity<?> deleteProductToCart(@PathVariable(value = "id") long id, @RequestBody DeleteProductInCartRequest deleteProductInCartRequest){
        deleteProductInCartRequest.setId(id);
        invoiceService.deleteProductInCart(deleteProductInCartRequest);
        return ResponseEntity.status(HttpStatus.OK).body("delete product to cart successfully!!!");
    }
    @PutMapping("/cart/product/{id}")
    public ResponseEntity<?> updateProductToCart(@PathVariable(value = "id") long id,@RequestBody UpdateCartRequest updateCartRequest){
        updateCartRequest.setId(id);
        invoiceService.updateProductInCart(updateCartRequest);
        return ResponseEntity.status(HttpStatus.OK).body("update product to cart successfully!!!");
    }

    @PostMapping("/invoice")
    public ResponseEntity<?>  payInvoice(@RequestBody InvoiceRequest invoiceRequest){
        invoiceService.payInvoice(invoiceRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Payment successfully!!!");
    }

}
