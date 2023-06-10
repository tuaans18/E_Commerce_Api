package com.shoes.store.sevice.Impl;

import com.shoes.store.repository.CategoryRepository;
import com.shoes.store.repository.ProductRepository;
import com.shoes.store.repository.entity.Category;
import com.shoes.store.repository.entity.Product;
import com.shoes.store.respone.CategoryRespone;
import com.shoes.store.respone.ProductRespone;
import com.shoes.store.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<CategoryRespone> getAllCategorys() {
        List<Category> categorys = categoryRepository.findAll();
        List<CategoryRespone> categoryListResponds = new ArrayList<>();
        if(!categorys.isEmpty()) {
            categoryListResponds = categorys.stream().map(
                    category -> new CategoryRespone(category.getId(),category.getName(),category.getImg()))
                    .collect(Collectors.toList());
        }
        return categoryListResponds;
    }

    @Override
    public List<ProductRespone> getProductByCategory(long id) {
        List<Product> products = productRepository.getProductByCategory_Id(id);
        List<ProductRespone> productResponeList = products.stream()
                                                .map(product -> new ProductRespone(product.getId(),product.getName(),product.getPrice(),product.getQuantity(),product.getImg(),product.getDescription()))
                .collect(Collectors.toList());
        return productResponeList;
    }

}
