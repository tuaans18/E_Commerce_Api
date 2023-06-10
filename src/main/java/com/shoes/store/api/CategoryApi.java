package com.shoes.store.api;


import com.shoes.store.respone.CategoryRespone;
import com.shoes.store.respone.ProductRespone;
import com.shoes.store.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categorys")
    public ResponseEntity<?> getAllCategory(){
        List<CategoryRespone> categorys = categoryService.getAllCategorys();
        return ResponseEntity.ok(categorys);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable(value = "id") long id){
        List<ProductRespone> productRespones = categoryService.getProductByCategory(id);
        return ResponseEntity.ok(productRespones);
    }
}
