package com.example.promotion.promo.service;

import com.example.promotion.promo.entity.Promo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PromoQueryService {

    // query promotion through id
    Promo queryById(Long id);

    /**
     * query by page
     *
     * @param hPromo      filter condition
     * @param pageRequest 分页对象
     * @return result
     */
    // 
    Page<Promo> queryByPage(Promo promo, PageRequest pageRequest);

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
