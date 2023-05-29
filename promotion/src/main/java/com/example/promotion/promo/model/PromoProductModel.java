package com.example.promotion.promo.model;

import java.io.Serializable;
import java.util.Date;

import com.example.promotion.enums.PromoStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromoProductModel implements Serializable {

    private static final long serialVersionUID = -81907624022631674L;
    
    // id
    private Long  id;

    private Long promoId;

    private String promoName;

    private Date startDate;

    private Date endDate;
    /**
     * 活动状态.0-创建，1-上线中，2-已下线
     */
    // 0-created; 1-online; 2-closed
    private Integer status;
    
    // spu info
    private PromoSpuModel spuModel;
   
    //sku info
    private PromoSkuModel skuModel;

    // check promotion activity status
    public boolean checkPromo() {
        Date now = new Date();
        if (this.getStatus() != PromoStatusEnum.ONLINE.getCode()
                || this.getEndDate().before(now) || this.getStartDate().after(now)) {
            return false;
        }
        return true;
    }
}
