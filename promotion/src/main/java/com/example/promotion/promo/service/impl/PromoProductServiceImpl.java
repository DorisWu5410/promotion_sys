package com.example.promotion.promo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.promotion.promo.dao.PromoDao;
import com.example.promotion.promo.entity.PromoProduct;
import com.example.promotion.promo.service.PromoProductService;

public class PromoProductServiceImpl implements PromoProductService{
    
    @Autowired
    private PromoDao promoProductDao;

    public PromoProduct queryByIdAndSkuId(Long promoId, Long skuId, Long spuId){

    }

    int decreaseStock(Long promoId, Long skuId, Integer quantity);

    int insertBatch(List<PromoProduct> promoProducts);

    PromoProduct queryById(Long id);

    // add product
    PromoProduct insert(PromoProduct promoProduct);

    PromoProduct update(PromoProduct PromoProduct);

    boolean deleteById(Long id);
}
