package com.example.promotion.promo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.promotion.enums.ProductStatusEnum;
import com.example.promotion.promo.dao.PromoProductDao;
import com.example.promotion.promo.entity.PromoProduct;
import com.example.promotion.promo.service.PromoProductService;

public class PromoProductServiceImpl implements PromoProductService{
    
    @Autowired
    private PromoProductDao promoProductDao;

    public PromoProduct queryByIdAndSkuId(Long promoId, Long skuId, Long spuId){
        if(promoId == null || skuId == null || spuId == null){
            return null;
        }
        return promoProductDao.queryByIdAndSkuId(promoId, skuId, spuId);
    }

    public int decreaseStock(Long promoId, Long skuId, Integer quantity){
        if(promoId == null || skuId == null){
            return 0;
        }
        return promoProductDao.decreaseStock(promoId, skuId, quantity);
    }

    public int insertOrUpdateBatch(List<PromoProduct> promoProducts){
        if(promoProducts == null){
            return 0;
        }
        return promoProductDao.insertOrUpdateBatch(promoProducts);
    }

    public int insertBatch(List<PromoProduct> promoProducts){
        if(promoProducts == null){
            return 0;
        }
        return promoProductDao.insertBatch(promoProducts);
    }

    public PromoProduct queryById(Long id){
        if(id == null){
            return null;
        }
        return promoProductDao.queryById(id);
    }

    // add product
    public PromoProduct insert(PromoProduct promoProduct){
        if(promoProduct == null){
            return null;
        }
        return promoProductDao.insert(promoProduct);
    }

    public PromoProduct update(PromoProduct promoProduct){
        if(promoProduct == null){
            return null;
        }
        return promoProductDao.update(promoProduct);
    }

    public boolean deleteById(Long id){
        if(id == null){
            return false;
        }
        return promoProductDao.deleteById(id, ProductStatusEnum.DELETE.getCode());
    }
}
