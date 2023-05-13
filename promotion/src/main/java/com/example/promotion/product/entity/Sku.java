package com.example.promotion.product.entity;

import java.io.Serializable;
import java.util.*;

public class Sku implements Serializable{
    private static final long serialVersionUID = -80891613527625211L;
    // id
    private Long id;

    // spu id
    private Long spuId;

    //store id
    private Long storeId;

    // specification id
    private Long specDetailId;

    // stock
    private Integer stock;

    // original price
    private Integer price;

    // product status 0-invalid, 1-valid
    private Integer status;

    // create time
    private Date createTime;

    // update time
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

    public Long getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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
