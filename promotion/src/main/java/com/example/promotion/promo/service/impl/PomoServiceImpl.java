package com.example.promotion.promo.service.impl;

import java.util.List;

import com.example.promotion.promo.model.CreatePromoActivityModel;
import com.example.promotion.promo.model.CreatePromoProductModel;
import com.example.promotion.promo.model.PromoProductModel;
import com.example.promotion.promo.service.PromoService;

public class PomoServiceImpl implements PromoService{
    public List<CreatePromoProductModel> CreatePromoActivity(CreatePromoActivityModel createActivityModel){
        return createActivityModel.getPromoProducts();
    }

    public PromoProductModel getPromoProductDetail(Long promoId, Long skuId, long spuId){
        
    }
}
