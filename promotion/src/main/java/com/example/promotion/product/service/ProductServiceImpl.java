package com.example.promotion.product.service;
import java.util.*;

import com.example.promotion.product.dao.ProductDao;
import com.example.promotion.product.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;



public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    public Product queryById(Long id){
        if(id == null){
            return null;
        }
        Product product = productDao.queryById(id);
        return product;
    }

    public List<Product> queryByIdList(List<Long> ids){
        if(ids == null){
            return null;
        }
        List<Product> productList = productDao.queryByIdList(ids);
        return productList;
    }


    public Product insert(Product product){
        if(product == null){
            return null;
        }
        Product result = productDao.insert(product);
        return result;
    }

    public Product update(Product product){
        if(product == null){
            return null;
        }
        Product result = productDao.update(product);
        return result;
    }

    public boolean deleteById(Long id){
        if(id == null){
            return false;
        }
        boolean result = productDao.deleteById(id);
        return result;
    }
}
