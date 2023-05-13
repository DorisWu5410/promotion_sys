package com.example.promotion.promo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class PromoSpuModel implements Serializable {

    private static final long serialVersionUID = 258795279137834888L;
    
    // product id 
    private Long spuId;
    
    //category id, pk of category
    private Long categoryId;
    
    // store id
    private Long shopId;
    
    // name of product
    private String title;
    
    private String subtitle;
    
    // image url
    private String mainImage;
    
    // image address in json (used for scaling)
    private String subImages;
    
    // product detail
    private String detail;
    
    // original price
    private Integer price;
    
    // category info in json
    private String categoryData;
    
    // specification info in json
    private String specData;
   
    // 1-on sale; 2-offline; 3-deleted
    private Integer status;

}
