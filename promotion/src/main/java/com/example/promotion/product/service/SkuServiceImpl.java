package com.example.promotion.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.promotion.enums.ProductStatusEnum;
import com.example.promotion.product.dao.SkuDao;
import com.example.promotion.product.entity.Sku;

public class SkuServiceImpl implements SkuService{

    @Autowired
    private SkuDao skuDao;

    // return decrease amount if success
    public int decreaseStock(Long id, Integer stock){
        if(id == null || stock == null || stock <= 0){
            return 0;
        }
        return skuDao.decreaseStock(id, stock);
    }

    public Sku queryById(Long id){
        if(id == null){
            return null;
        }
        return skuDao.queryById(id);
    }

    public Sku insert(Sku sku){
        if(sku == null){
            return null;
        }
        return skuDao.insert(sku);
    }

    public Sku update(Sku sku){
        if(sku == null){
            return null;
        }
        return skuDao.update(sku);
    }

    public int batchUpdate(List<Sku> skus){
        if(skus == null){
            return 0;
        }
        return skuDao.insertOrUpdateBatch(skus);
    }

    public boolean deleteById(Long id){
        if(id == null){
            return false;
        }
        return skuDao.deleteById(id, ProductStatusEnum.DELETE.getCode());
    }
}
