package com.example.promotion.promo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.promotion.AbstractHibernateDao;
import com.example.promotion.promo.entity.PromoProduct;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;



public class PromoProductDao extends AbstractHibernateDao<PromoProduct>{

    @Autowired
    protected SessionFactory factory;

    public PromoProduct queryByIdAndSkuId(Long promoId, Long skuId, Long spuId){
        Session session = factory.openSession();
        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PromoProduct> cr = cb.createQuery(PromoProduct.class);
            Root<PromoProduct> root = cr.from(PromoProduct.class);
    
            Predicate[] predicates = new Predicate[3];
            predicates[0] = cb.equal(root.get("promoId"), promoId);
            predicates[1] = cb.equal(root.get("skuId"), skuId);
            predicates[2] = cb.equal(root.get("spuId"), spuId);
            cr.select(root).where(predicates);
    
            Query<PromoProduct> query = session.createQuery(cr);
            PromoProduct result = query.getResultList().get(0);
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return null;
    }

    public int decreaseStock(Long promoId, Long skuId, Integer quantity){
        Session session = factory.openSession();
        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PromoProduct> cr = cb.createQuery(PromoProduct.class);
            Root<PromoProduct> root = cr.from(PromoProduct.class);
    
            Predicate[] predicates = new Predicate[3];
            predicates[0] = cb.equal(root.get("promoId"), promoId);
            predicates[1] = cb.equal(root.get("skuId"), skuId);
            cr.select(root).where(predicates);
    
            Query<PromoProduct> query = session.createQuery(cr);
            List<PromoProduct> result = query.getResultList();
            
            for(PromoProduct p: result){
                int current = p.getPromoPrice();
                if(current >= quantity ){
                    p.setPromoStock(current - quantity);
                }
            }

            return insertOrUpdateBatch(result);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return 0;
    }

    public int insertOrUpdateBatch(List<PromoProduct> promoProducts){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            int count = 0;
            for(PromoProduct p : promoProducts){
                session.merge(p);
                count++;

                if(count % 50 == 0){
                    //flush a batch of inserts and release memory:
                    session.flush();;
                    session.clear();
                }
            }
            tx.commit();
        }
        catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return promoProducts.size();
    }

    public int insertBatch(List<PromoProduct> promoProducts){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            int count = 0;
            for(PromoProduct p : promoProducts){
                session.persist(p);
                count++;

                if(count % 50 == 0){
                    //flush a batch of inserts and release memory:
                    session.flush();;
                    session.clear();
                }
            }
            tx.commit();
        }
        catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return promoProducts.size();
    }
}
