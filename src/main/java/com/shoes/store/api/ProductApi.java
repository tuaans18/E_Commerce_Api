package com.shoes.store.api;


import com.shoes.store.respone.ProductRespone;
import com.shoes.store.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductApi {

    @Autowired
    private ProductService productService;


    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        List<ProductRespone> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable(value = "id") long id)
    {
        ProductRespone product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

}
