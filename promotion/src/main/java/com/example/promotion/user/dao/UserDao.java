package com.example.promotion.user.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.promotion.user.entity.User;
import com.example.promotion.user.model.LoginRequest;
import com.example.promotion.user.model.LoginResponse;
import com.example.promotion.user.model.RegisterRequest;
import com.example.promotion.user.model.RegisterResponse;
import com.example.promotion.AbstractHibernateDao;
import com.example.promotion.tools.TokenGenerator;

@Component
public class UserDao extends AbstractHibernateDao<User>{

    @Autowired
    private static TokenGenerator tokenGenerator;



    public LoginResponse login(LoginRequest req){
        LoginResponse resp = new LoginResponse();
        Session session = factory.openSession();

        if(!req.validate()){
            resp.setStatus(false);
            resp.setMsg("null value in requied field");
            return resp;
        }
        String email = req.getEmail();
        String password = req.getPassword();

        Transaction tx =  session.beginTransaction();
        try{
            User user = session.get(User.class, email);
            if(user == null){
                resp.setStatus(false);
                resp.setMsg("no user found");
                return resp;
            }
            if(!user.getPassword().equals(password)){
                resp.setStatus(false);
                resp.setMsg("incorrect password");
                return resp;
            }

            // success login
            resp.setStatus(true);
            resp.setMsg("success");
            String token = tokenGenerator.generteToken(email, password);
            resp.setToken(token);
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            resp.setStatus(false);
            resp.setMsg(e.getMessage()); 
         } finally {
            session.close();
         }
        return resp;
    }
}
