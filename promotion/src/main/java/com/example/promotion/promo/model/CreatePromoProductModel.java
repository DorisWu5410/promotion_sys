package com.example.promotion.promo.model;

import java.util.function.Function;

import com.example.promotion.convert.Converter;
import com.example.promotion.promo.entity.PromoProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePromoProductModel implements Converter<CreatePromoProductModel, PromoProduct>{
    
    private Long promoId;

    private String promoName;
 
    private Long spuId;

    private Long skuId;
 
    private Integer promoStock;

    private Integer promoPrice;

    @Override
    public PromoProduct convert(Function<CreatePromoProductModel, PromoProduct> f) {
        return f.apply(this);
    }
}
