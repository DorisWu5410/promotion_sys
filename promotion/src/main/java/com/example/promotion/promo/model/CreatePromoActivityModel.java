package com.example.promotion.promo.model;

import java.util.List;
import java.util.function.Function;

import com.example.promotion.convert.Converter;
import com.example.promotion.promo.entity.Promo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePromoActivityModel implements Converter<CreatePromoActivityModel, Promo>{
    /**
     * 活动名称
     */
    private String promoName;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;
    /**
     * 参与秒杀的商品
     */
    private List<CreatePromoProductModel> promoProducts;

    @Override
    public Promo convert(Function<CreatePromoActivityModel, Promo> f) {
        return f.apply(this);
    }
}
