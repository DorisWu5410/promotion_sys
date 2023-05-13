package com.example.promotion.user.service;

import com.example.promotion.user.dao.UserDao;
import com.example.promotion.user.model.LoginRequest;
import com.example.promotion.user.model.LoginResponse;
import com.example.promotion.user.model.RegisterRequest;
import com.example.promotion.user.model.RegisterResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao; 

    public LoginResponse login(LoginRequest req){
        LoginResponse resp = new LoginResponse();
        if(!req.validate()){
            resp.setStatus(false);
            resp.setMsg("null value in requied field");
            return resp;
        }

        resp = userDao.login(req);
        return resp;
    }
    
    public RegisterResponse register(RegisterRequest req){
        RegisterResponse resp = new RegisterResponse();
        if(!req.validate()){
            resp.setStatus(false);
            resp.setMsg("null value in requied field");
            return resp;
        }

        resp = userDao.register(req);
        return resp;
    }
}
