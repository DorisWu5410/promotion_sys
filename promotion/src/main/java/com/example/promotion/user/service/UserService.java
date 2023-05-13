package com.example.promotion.user.service;
import com.example.promotion.user.model.LoginRequest;
import com.example.promotion.user.model.LoginResponse;
import com.example.promotion.user.model.RegisterRequest;
import com.example.promotion.user.model.RegisterResponse;

public interface UserService{

    LoginResponse login(LoginRequest req);

    RegisterResponse register(RegisterRequest req);

}