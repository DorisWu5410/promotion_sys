package com.example.promotion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractHibernateDao<T extends EntityClass>{
    private Class<T> c;

    @Autowired
    protected SessionFactory factory;

    public void setClass(final Class<T> classToSet){
        if(classToSet == null){
            return;
        }
        this.c = classToSet;
    }

    public T queryById(Long id) {
        if(id == null){
            return null;
        }
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            T t = session.get(c, id);
            if(t == null){
                return null;
            }
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
         } finally {
            session.close();
         }
        return null;
    }

    public List<T> queryByIdList(List<Long> ids){
        List<T> result = new ArrayList<>();
        if(ids == null){
            return result;
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            for(Long id: ids){
                T t = session.get(c, id);
                result.add(t);
            }
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
         } finally {
            session.close();
         }
        return result;
    }

    public T insert(T t){
        if(t == null){
            return null;
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(t);
            tx.commit();
        }
        catch (Exception e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
         }
        return t;
    }

    public T update(T t){
        if(t == null){
            return null;
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.merge(t);
            tx.commit();
            return t;
        }
        catch(Exception e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
         }
        return null;
    }

    public int insertOrUpdateBatch(List<T> ts){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            int count = 0;
            for(T t : ts){
                session.merge(t);
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
        return ts.size();
    }

    public int insertBatch(List<T> ts){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            int count = 0;
            for(T t : ts){
                session.persist(t);
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
        return ts.size();
    }
    

    public boolean deleteById(Long id, int deleteCode){
        if(id == null){
            return false;
        } 
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            T t = session.get(c, id);
            if(t == null){
                return false;
            }
            t.setStatus(deleteCode);
            session.merge(t);
            tx.commit();
            return true;
        }        
        catch(Exception e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
         }
        return false;

    }
}
