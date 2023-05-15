package com.example.promotion.product.dao;
import org.springframework.stereotype.Component;

import com.example.promotion.AbstractHibernateDao;
import com.example.promotion.enums.ProductStatusEnum;
import com.example.promotion.product.entity.Product;

@Component
public class ProductDao extends AbstractHibernateDao<Product>{
    public boolean deleteById(Long id){
        return super.deleteById(id, ProductStatusEnum.DELETE.getCode());
    }

}
