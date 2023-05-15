package com.example.promotion.product.service;

import java.util.List;


import com.example.promotion.product.entity.Product;

public interface ProductService {
    Product queryById(Long id);
    
    List<Product> queryByIdList(List<Long> ids);

    Product insert(Product product);

    Product update(Product product);

    boolean deleteById(Long id);
}
