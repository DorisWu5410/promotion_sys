package com.example.promotion.user.entity;

import com.example.promotion.EntityClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
@Table(name = "user")
public class User{
    @Id
    @GenerateValue
    private Long id;
    private String email;

    private String password;
    

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

 

