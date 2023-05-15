package com.example.promotion.product.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import com.example.promotion.EntityClass;
import com.example.promotion.convert.Converter;
import com.example.promotion.promo.model.PromoSpuModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends EntityClass implements Serializable, Converter<Product, PromoSpuModel>{
    private static final long serialVersionUID = -39693500405111662L;

    @Override
    public PromoSpuModel convert(Function<Product, PromoSpuModel> f) {
        return f.apply(this);
    }
    @Id
    private Long id;
    @Column
    private Long categoryId;
    @Column
    private Long shopId;
    @Column
    private String title;
    @Column
    private String subtitle;
    /**
     * product image url
     */
    @Column
    private String mainImage;
    /**
     * image address(json)
     */
    @Column
    private String subImages;
    /**
     * pruduct detail
     */
    @Column
    private String detail;
    /**
     * original price
     */
    @Column
    private Integer price;

    @Column
    private String categoryData;

    @Column
    private String specData;
    /**
     * 1-onsale 2-expired 3-deleted
     */
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategoryData() {
        return categoryData;
    }

    public void setCategoryData(String categoryData) {
        this.categoryData = categoryData;
    }

    public String getSpecData() {
        return specData;
    }

    public void setSpecData(String specData) {
        this.specData = specData;
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
