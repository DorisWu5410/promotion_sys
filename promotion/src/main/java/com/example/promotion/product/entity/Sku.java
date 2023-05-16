package com.example.promotion.product.entity;

import java.io.Serializable;
import java.util.*;

import com.example.promotion.EntityClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sku")
public class Sku extends EntityClass implements Serializable{
    private static final long serialVersionUID = -80891613527625211L;
    // id
    @Id
    private Long id;

    // spu id
    @Column
    private Long spuId;

    //store id
    @Column
    private Long shopId;

    // specification id
    @Column
    private Long specDetailId;

    // stock
    @Column
    private Integer stock;

    // original price
    @Column
    private Integer price;

    // product status 0-invalid, 1-valid
    @Column
    private Integer status;

    // create time
    @Column
    private Date createTime;

    // update time
    @Column
    private Date updateTime;

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return this.spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getShopId() {
        return this.shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSpecDetailId() {
        return this.specDetailId;
    }

    public void setSpecDetailId(Long specDetailId) {
        this.specDetailId = specDetailId;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
