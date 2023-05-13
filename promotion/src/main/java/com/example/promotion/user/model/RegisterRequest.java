package com.example.promotion.user.model;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequest {
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(){
        if(email != null && password != null){
            return true;
        }
        return false;
    }
    
}
