package com.example.promotion.order.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderModel {

    private Long orderId;

    private Long userId;

    private Long spuId;

    private Long skuId;

    private Long shopId;
    
    // payment amount
    private Integer payment;

    private Integer paymentType;

    private Integer postage;
    
    private Integer quantity;

    // order status: 0-canceled; 1-unpaid; 2-paid; 3-shipped; 4-finished; 5-closed
    private Integer status;

    private Long addressId;

    private String shippingAddress;

    private Long activityId;

}
