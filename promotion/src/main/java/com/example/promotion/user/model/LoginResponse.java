package com.example.promotion.user.model;
import org.springframework.stereotype.Component;


@Component
public class LoginResponse {
    private boolean status;
    private String msg;
    private String token;

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
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
