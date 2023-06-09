package com.example.promotion.promo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.promotion.promo.entity.PromoProduct;

@Service
public interface PromoProductService {

    PromoProduct queryByIdAndSkuId(Long promoId, Long skuId, Long spuId);

    int decreaseStock(Long promoId, Long skuId, Integer quantity);

    int insertBatch(List<PromoProduct> promoProducts);

    int insertOrUpdateBatch(List<PromoProduct> promoProducts);

    PromoProduct queryById(Long id);

    // add product
    PromoProduct insert(PromoProduct promoProduct);

    PromoProduct update(PromoProduct PromoProduct);

    boolean deleteById(Long id);
}
