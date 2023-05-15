package com.example.promotion;

public class EntityClass {
    private Long id;
    private int status;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Integer getStatus(){
        return status;
    }

    public void setStatus(int s){
        this.status = s;
    }
}
