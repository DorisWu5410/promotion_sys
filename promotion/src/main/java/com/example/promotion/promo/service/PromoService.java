package com.example.promotion.promo.service;

import java.util.List;

import com.example.promotion.promo.model.CreatePromoActivityModel;
import com.example.promotion.promo.model.CreatePromoProductModel;
import com.example.promotion.promo.model.PromoProductModel;

public interface PromoService {
    List<CreatePromoProductModel> CreatePromoActivity(CreatePromoActivityModel createActivityModel);

    PromoProductModel getpromoProductProductDetail(Long promoId, Long skuId, long spuId);
}
