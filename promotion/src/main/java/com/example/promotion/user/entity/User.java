package com.example.promotion.user.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id 
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
