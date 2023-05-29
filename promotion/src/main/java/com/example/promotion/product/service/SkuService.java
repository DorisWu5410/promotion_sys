package com.example.promotion.product.service;

import java.util.List;

import com.example.promotion.product.entity.Sku;

public interface SkuService {
    int decreaseStock(Long id, Integer stock);

    Sku queryById(Long id);

    Sku insert(Sku sku);

    Sku update(Sku sku);

    int batchUpdate(List<Sku> hSkus);

    boolean deleteById(Long id);
}
