package com.example.promotion.user.model;
import org.springframework.stereotype.Component;

@Component
public class RegisterResponse {
    private boolean status;
    private String msg;

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
} 
