package com.example.promotion.promo.service;

import com.example.promotion.order.model.CreateOrderModel;
import com.example.promotion.order.model.OrderModel;

public interface PromoOrderService {
    OrderModel createOrder(CreateOrderModel createOrderModel);
}
