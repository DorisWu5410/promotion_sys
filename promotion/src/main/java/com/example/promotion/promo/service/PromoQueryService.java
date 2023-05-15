package com.example.promotion.promo.service;

import com.example.promotion.promo.entity.Promo;

public interface PromoQueryService {

    // query promotion through id
    Promo queryById(Long id);

    /**
     * add promotion
     *
     * @param Promo object
     * @return Promo object
     */
    Promo insert(Promo promo);

    /**
     * update
     *
     * @param Promo object
     * @return Promo object
     */
    Promo update(Promo hPromo);

    /**
     * delete by id
     *
     * @param id pk
     * @return success or not
     */
    boolean deleteById(Long id);
}
