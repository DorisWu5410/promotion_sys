package com.example.promotion.product.entity;
import java.util.*;

import com.example.promotion.EntityClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "spec")
public class Spec extends EntityClass implements Serializable {
    private static final long serialVersionUID = -66475501811467207L;
    
    // id
    @Id 
    private Long id;

    // category id, pk of category
    @Column
    private Long categoryId;
   
    // specification name
    @Column
    private String specKey;
    
    // 0-invalid 1-valid
    @Column
    private Integer status;
    
    @Column
    private Date createTime;

    @Column
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

