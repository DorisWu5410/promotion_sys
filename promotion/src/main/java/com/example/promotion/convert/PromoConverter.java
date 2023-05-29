package com.example.promotion.convert;

import java.util.Date;

import com.example.promotion.enums.PromoStatusEnum;
import com.example.promotion.product.entity.Product;
import com.example.promotion.product.entity.Sku;
import com.example.promotion.promo.entity.Promo;
import com.example.promotion.promo.entity.PromoProduct;
import com.example.promotion.promo.model.CreatePromoActivityModel;
import com.example.promotion.promo.model.CreatePromoProductModel;
import com.example.promotion.promo.model.PromoProductModel;
import com.example.promotion.promo.model.PromoSkuModel;
import com.example.promotion.promo.model.PromoSpuModel;

public class PromoConverter {
    
    public static PromoSpuModel convertToPromoSpuModel(Product product){
        PromoSpuModel promoSpuModel = PromoSpuModel.builder()
            .spuId(product.getId())
            .categoryId(product.getCategoryId())
            .shopId(product.getShopId())
            .title(product.getTitle())
            .subtitle(product.getSubtitle())
            .mainImage(product.getMainImage())
            .subImages(product.getSubImages())
            .detail(product.getDetail())
            .price(product.getPrice())
            .categoryData(product.getCategoryData())
            .specData(product.getSpecData())
            .status(product.getStatus())
            .build();
        return promoSpuModel;
    }

    public static PromoSkuModel convertToPromoSkuModel(PromoProduct promoProduct, Sku sku){
        PromoSkuModel promoSkuModel = PromoSkuModel.builder()
            .spuId(promoProduct.getSpuId())
            .skuId(promoProduct.getSkuId())
            .promoStock(promoProduct.getPromoStock())
            .price(sku.getPrice())
            .shopId(sku.getShopId())
            .specDetailId(sku.getSpecDetailId())
            .build();
        return promoSkuModel;
    }

    public static PromoProductModel convertToPromoProductModel(Promo promo){
        PromoProductModel promoProductModel = PromoProductModel.builder()
            .promoId(promo.getId())
            .promoName(promo.getPromoName())
            .startDate(promo.getStartDate())
            .endDate(promo.getEndDate())
            .status(promo.getStatus())
            .build();
        return promoProductModel;
    }

    public static Promo convertToPromo(CreatePromoActivityModel model){
        Promo promo = new Promo();
        promo.setPromoName(model.getPromoName());
        promo.setCreateTime(new Date(model.getStartTime()));
        promo.setEndDate(new Date(model.getEndTime()));
        promo.setStatus(PromoStatusEnum.ONLINE.getCode());

        Date now = new Date();
        promo.setCreateTime(now);
        promo.setEndDate(now);

        return promo;
    }

    public static PromoProduct convertToPromoProduct(CreatePromoProductModel model){
        PromoProduct promoProduct = new PromoProduct();
        promoProduct.setPromoId(model.getPromoId());
        promoProduct.setPromoName(model.getPromoName());
        promoProduct.setSpuId(model.getSpuId());
        promoProduct.setSkuId(model.getSkuId());
        promoProduct.setPromoStock(model.getPromoStock());
        promoProduct.setPromoPrice(model.getPromoPrice());

        Date now = new Date();
        promoProduct.setCreateTime(now);
        promoProduct.setUpdateTime(now);
        return promoProduct;
    }
}
