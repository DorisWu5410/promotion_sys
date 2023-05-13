package com.example.promotion.order.model;

import java.util.function.Function;

import com.example.promotion.convert.Converter;
import com.example.promotion.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderModel implements Converter<CreateOrderModel, Order>{

    public Order convert(Function<CreateOrderModel, Order> f){
        return f.apply(this);
    }

    private Long userId;

    private Long promoId;

    private Long spuId;

    private Long skuId;

    private Integer quantity;

    private Long addressId;

    private String shippingAddress;
}
