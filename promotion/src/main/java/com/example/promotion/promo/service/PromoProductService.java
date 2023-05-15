package com.example.promotion.promo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.promotion.promo.entity.PromoProduct;

public interface PromoProductService {

    PromoProduct queryByIdAndSkuId(Long promoId, Long skuId, Long spuId);

    int decreaseStock(Long promoId, Long skuId, Integer quantity);

    int insertBatch(List<PromoProduct> promoProducts);

    PromoProduct queryById(Long id);

    // query by page
    Page<PromoProduct> queryByPage(PromoProduct promoProduct, PageRequest pageRequest);

    // add product
    PromoProduct insert(PromoProduct promoProduct);

    PromoProduct update(PromoProduct PromoProduct);

    boolean deleteById(Long id);
}
