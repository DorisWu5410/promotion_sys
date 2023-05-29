package com.example.promotion.promo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.promotion.PromoException;
import com.example.promotion.convert.PromoConverter;
import com.example.promotion.enums.PromoStatusEnum;
import com.example.promotion.enums.ResponseEnum;
import com.example.promotion.product.entity.Product;
import com.example.promotion.product.entity.Sku;
import com.example.promotion.product.service.ProductService;
import com.example.promotion.product.service.SkuService;
import com.example.promotion.promo.dao.PromoDao;
import com.example.promotion.promo.entity.Promo;
import com.example.promotion.promo.entity.PromoProduct;
import com.example.promotion.promo.model.CreatePromoActivityModel;
import com.example.promotion.promo.model.CreatePromoProductModel;
import com.example.promotion.promo.model.PromoProductModel;
import com.example.promotion.promo.model.PromoSkuModel;
import com.example.promotion.promo.model.PromoSpuModel;
import com.example.promotion.promo.service.PromoProductService;
import com.example.promotion.promo.service.PromoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PomoServiceImpl implements PromoService{

    @Autowired 
    private PromoDao promoDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private SkuService skuService;

    @Autowired
    private PromoProductService promoProductService;


    @Transactional(rollbackFor = Exception.class)
    public List<CreatePromoProductModel> CreatePromoActivity(CreatePromoActivityModel createActivityModel) throws PromoException{
        Promo promo = createActivityModel.convert(PromoConverter::convertToPromo);
        Promo result = promoDao.insert(promo);
        if(result == null){
            throw new PromoException(ResponseEnum.CREATE_ACTIVITY_FAIL);
        }

        List<CreatePromoProductModel> promoProducts = createActivityModel.getPromoProducts();
        // get distinct spuId of all promoProduct
        Set<Long> spuIds = promoProducts.stream()
            .map(CreatePromoProductModel::getSpuId).collect(Collectors.toSet());
        if(spuIds.isEmpty()){
            throw new PromoException(ResponseEnum.CREATE_ACTIVITY_FAIL);
        }

        // get products by spuIds
        List<Product> products = productService.queryByIdList(List.copyOf(spuIds));
        if(products.isEmpty()){
            throw new PromoException(ResponseEnum.CREATE_ACTIVITY_FAIL);
        }

        // filter out offline products
        List<Long> resultSpuIds = products.stream()
                                        .map(Product::getId)
                                        .collect(Collectors.toList());
        promoProducts = promoProducts.stream()
                                        .map(
                                            p -> {
                                                p.setPromoId(promo.getId());
                                                p.setPromoName(promo.getPromoName());
                                                return p;
                                            }
                                        ).filter(
                                            p -> resultSpuIds.contains(p.getSpuId())
                                        ).collect(Collectors.toList());

        
        //decrease stock from original sku
        List<CreatePromoProductModel> finalList = new ArrayList<>(promoProducts.size());
        for(CreatePromoProductModel model: promoProducts){
            int amount = skuService.decreaseStock(model.getSkuId(), model.getPromoStock());
            if(amount == model.getPromoStock()){
                //
                //   to do
                //
                // set new promo and stock in redis
                finalList.add(model);
            }
        }
        if(finalList.isEmpty()){
            throw new PromoException(ResponseEnum.CREATE_ACTIVITY_FAIL);
        }

        // insert promoProducts
        List<PromoProduct> promoProductsList = finalList.stream()
                .map(PromoConverter::convertToPromoProduct)
                .collect(Collectors.toList());
                
        int count = promoProductService.insertBatch(promoProductsList);
        if(count < promoProducts.size()){
            throw new PromoException(ResponseEnum.CREATE_ACTIVITY_FAIL);
        }

        return finalList;
    }   



    public PromoProductModel getPromoProductDetail(Long promoId, Long skuId, long spuId) throws PromoException{
        Date now = new Date();
        
        // get promo and validate
        Promo promo = promoDao.queryById(promoId);
        if(promo == null){
            log.error("promo activity not exist, promoId = {}", promoId);
            throw new PromoException(ResponseEnum.ACTIVITY_NOT_EXIST);
        }
        if(promo.getStatus() != PromoStatusEnum.ONLINE.getCode() || promo.getStartDate().after(now) || promo.getEndDate().before(now)){
            log.error("promo activity not exist, promoId = {}", promoId);
            throw new PromoException(ResponseEnum.ACTIVITY_NOT_EXIST);
        }

        // get promoProductModel and validate
        PromoProductModel promoProductModel = promo.convert(PromoConverter::convertToPromoProductModel);
        if(promoProductModel == null){
            log.error("promo activity not exist, promoId = {}, skuId = {}, spuId = {}", promoId, skuId, spuId);
            throw new PromoException(ResponseEnum.ACTIVITY_NOT_EXIST);
        }

        // get sku and validate
        Sku sku = skuService.queryById(skuId);
        if(sku == null){
            log.error("promo sku not exist, promoId = {}, skuId = {}, spuId = {}", promoId, skuId, spuId);
            throw new PromoException(ResponseEnum.ACTIVITY_NOT_EXIST);
        }

        // get spu and validate
        Product spu = productService.queryById(spuId);
        if(spu == null){
            log.error("promo spu not exist, promoId = {}, skuId = {}, spuId = {}", promoId, skuId, spuId);
            throw new PromoException(ResponseEnum.ACTIVITY_NOT_EXIST);
        }

        //get promoProduct
        PromoProduct promoProduct = promoProductService.queryByIdAndSkuId(promoId, skuId, skuId);
        if(promoProduct == null){
            log.error("promo activity not exist, promoId = {}, skuId = {}, spuId = {}", promoId, skuId, spuId);
            throw new PromoException(ResponseEnum.ACTIVITY_NOT_EXIST);
        }

        PromoSpuModel promoSpuModel = spu.convert(PromoConverter::convertToPromoSpuModel);

        PromoSkuModel promoSkuModel = new PromoSkuModel(promoProduct, sku);
        promoSkuModel = promoSkuModel.convert(PromoConverter::convertToPromoSkuModel);

        promoProductModel.setSkuModel(promoSkuModel);
        promoProductModel.setSpuModel(promoSpuModel);

        return promoProductModel;
    }
}
