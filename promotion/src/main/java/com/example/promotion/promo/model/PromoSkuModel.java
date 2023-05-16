package com.example.promotion.promo.model;

import java.io.Serializable;

import com.example.promotion.convert.ConvertFunction;
import com.example.promotion.convert.MultiConverter;
import com.example.promotion.product.entity.Sku;
import com.example.promotion.promo.entity.PromoProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromoSkuModel implements Serializable, MultiConverter<PromoProduct, Sku, PromoSkuModel> {

    private static final long serialVersionUID = 5555514090859900792L;
    private PromoProduct promoProduct;
    private Sku sku;

    public PromoSkuModel convert(ConvertFunction<PromoProduct, Sku, PromoSkuModel> f) {
        return f.apply(this.promoProduct, this.sku);
    }

    public PromoSkuModel(PromoProduct promoProduct, Sku sku) {
        this.promoProduct = promoProduct;
        this.sku = sku;
    }

    /**
     * 活动spu id
     */
    private Long spuId;
    /**
     * 活动sku id
     */
    private Long skuId;
    /**
     * 活动库存
     */
    private Integer promoStock;
    /**
     * 价格,秒杀价
     */
    private Integer promoPrice;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 规格信息
     */
    private Long specDetailId;
    /**
     * 价格,销售价
     */
    private Integer price;
}
