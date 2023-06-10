package com.shoes.store.sevice.Impl;

import com.shoes.store.repository.ProductRepository;
import com.shoes.store.repository.entity.Product;
import com.shoes.store.respone.ProductRespone;
import com.shoes.store.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductRespone> getAll() {
        List<Product> listProduct =  productRepository.findAll();
        List<ProductRespone> productRespones = new ArrayList<>();

        for(Product productEntity : listProduct){
            ProductRespone productRespone = new ProductRespone();
            productRespone.setName(productEntity.getName());
            productRespone.setPrice(productEntity.getPrice());
            productRespone.setDescription(productEntity.getDescription());
            productRespone.setImg(productEntity.getImg());
            productRespone.setId(productEntity.getId());
            productRespones.add(productRespone);
        }
        return productRespones;
    }

    @Override
    public ProductRespone getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);

        ProductRespone productRespondDTO = new ProductRespone();

        if(product.isPresent()) {
            Product pro = product.get();
            productRespondDTO.setId(pro.getId());
            productRespondDTO.setName(pro.getName());
            productRespondDTO.setPrice(pro.getPrice());
            productRespondDTO.setQuantity(pro.getQuantity());
            productRespondDTO.setImg(pro.getImg());
            productRespondDTO.setDescription(pro.getDescription());
        }

        return productRespondDTO;
    }

    @Override
    public List<ProductRespone> searchProducts(String query) {
        Optional<List<Product>> products = productRepository.searchProducts(query);
        List<ProductRespone> productRespones = new ArrayList<>();
        if(products.isPresent()) {
            for(Product product:products.get()){
                ProductRespone productRespone = new ProductRespone();
                productRespone.setId(product.getId());
                productRespone.setName(product.getName());
                productRespone.setPrice(product.getPrice());
                productRespone.setQuantity(product.getQuantity());
                productRespone.setDescription(product.getDescription());
                productRespone.setImg(product.getImg());
                productRespones.add(productRespone);
            }
            return productRespones;
        }
        return productRespones;
    }
}
