package com.example.promotion.user.entity;

import com.example.promotion.EntityClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "user")
public class User extends EntityClass{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;
    @Column
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

 

