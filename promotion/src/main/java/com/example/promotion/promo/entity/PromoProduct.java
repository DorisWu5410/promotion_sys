package com.example.promotion.promo.entity;

import java.io.Serializable;
import java.util.*;

import com.example.promotion.EntityClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "promo_product")
public class PromoProduct extends EntityClass implements Serializable{
    private static final long serialVersionUID = -72847303198394301L;
    // id
    @Id
    @GeneratedValue
    private Long id;

    // promo id
    private Long promoId;

    // promo name
    private String promoName;

    //stock keeping unit
    private Long skuId;
    
    // product Id
    private Long spuId;

    // stock
    private Integer promoStock;

    // price for promotion
    private Integer promoPrice;

    // createTime
    private Date createTime;

    // update
    private Date updateTime;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPromoId() {
        return this.promoId;
    }

    public void setPromoId(Long promoId) {
        this.promoId = promoId;
    }

    public String getPromoName() {
        return this.promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public Long getSkuId() {
        return this.skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSpuId() {
        return this.spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Integer getPromoStock() {
        return this.promoStock;
    }

    public void setPromoStock(Integer promoStock) {
        this.promoStock = promoStock;
    }

    public Integer getPromoPrice() {
        return this.promoPrice;
    }

    public void setPromoPrice(Integer promoPrice) {
        this.promoPrice = promoPrice;
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
