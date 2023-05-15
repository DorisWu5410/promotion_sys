package com.example.promotion.promo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.promotion.promo.dao.PromoDao;
import com.example.promotion.promo.entity.Promo;
import com.example.promotion.promo.service.PromoQueryService;

public class PromoQueryServiceImpl implements PromoQueryService{
    @Autowired
    private PromoDao promoDao;

    // query promotion through id
    public Promo queryById(Long id){
        if(id == null){
            return null;
        }
        return promoDao.queryById(id);
    }

    /**
     * add promotion
     *
     * @param Promo object
     * @return Promo object
     */
    public Promo insert(Promo promo){
        if(promo == null){
            return null;
        }
        return promoDao.insert(promo);
    }

    /**
     * update
     *
     * @param Promo object
     * @return Promo object
     */
    public Promo update(Promo promo){
        if(promo == null){
            return null;
        }
        return promoDao.update(promo);
    }

    /**
     * delete by id
     *
     * @param id pk
     * @return success or not
     */
    public boolean deleteById(Long id){
        if(id == null){
            return false;
        }
        return promoDao.deleteById(id);
    }
}
