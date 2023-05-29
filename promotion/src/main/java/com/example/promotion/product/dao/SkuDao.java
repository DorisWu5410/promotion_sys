package com.example.promotion.product.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.example.promotion.AbstractHibernateDao;
import com.example.promotion.product.entity.Sku;




@Component
public class SkuDao extends AbstractHibernateDao<Sku>{

    //return decrease amount if success
    public int decreaseStock(Long id, Integer quantity){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Sku sku = session.get(Sku.class, id);
            int currentStock = sku.getStock();
            if(currentStock >= quantity){
                sku.setStock(currentStock - quantity);
            }
            Sku result = super.update(sku);
            if(result == null){
                tx.rollback();
                return 0;
            }
            return quantity;
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
        return 0;
    }
}
