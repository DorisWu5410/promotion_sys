package com.example.promotion.product.entity;

import java.io.Serializable;
import java.util.Date;

import com.example.promotion.EntityClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spec_detail")
public class SpecDetail extends EntityClass implements Serializable {
    private static final long serialVersionUID = 148396565009656432L;
    
    @Id 
    private Long id;

    @Column
    private Long specId;

    /**
     * specification name
     */
    @Column
    private String specKey;

    @Column
    private String specValue;

    /**
     * specification status 0-expired，1-normal
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

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
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
