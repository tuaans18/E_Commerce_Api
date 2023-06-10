package com.shoes.store.sevice;

import com.shoes.store.respone.CategoryRespone;
import com.shoes.store.respone.ProductRespone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryRespone> getAllCategorys();
    List<ProductRespone> getProductByCategory(long id);
}
