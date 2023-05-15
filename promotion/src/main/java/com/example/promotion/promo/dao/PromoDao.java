package com.example.promotion.promo.dao;

import com.example.promotion.AbstractHibernateDao;
import com.example.promotion.enums.PromoStatusEnum;
import com.example.promotion.promo.entity.Promo;

public class PromoDao extends AbstractHibernateDao<Promo>{

    public boolean deleteById(Long id){
        boolean result = super.deleteById(id, PromoStatusEnum.OFFLINE.getCode());
        return result;
    }
    
}
