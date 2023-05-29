package com.example.promotion.promo.entity;
import java.io.Serializable;
import java.util.function.Function;

import com.example.promotion.EntityClass;
import com.example.promotion.convert.Converter;
import com.example.promotion.promo.model.PromoProductModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "promo")
public class Promo extends EntityClass implements Serializable, Converter<Promo, PromoProductModel>{
    private static final long serialVersionUID = 765691746086102277L;

    @Override
    public PromoProductModel convert(Function<Promo, PromoProductModel> f) {
        return f.apply(this);
    }

    // id
    @Id
    @GeneratedValue
    private Long id;
    
    // promotion name
    @Column
    private String promoName;
    @Column
    private Date startDate;
    @Column
    private Date endDate;

    @Column
    // 0-created 1-online 2-offline
    private Integer status;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromoName() {
        return this.promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
