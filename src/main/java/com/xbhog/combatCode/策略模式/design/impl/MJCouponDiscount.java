package com.xbhog.combatCode.策略模式.design.impl;

import com.xbhog.combatCode.策略模式.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author xbhog
 * @describe:满减
 * @date 2022/8/21
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {
    /**
     * 满减计算
     *1. 判断满足x元后-n元，否则不减
     *2. 最低支付金额1元
     * @param couponInfo
     * @param skuPrice
     * @return
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        //满100
        String x = couponInfo.get("x");
        //减10
        String y = couponInfo.get("y");
        //小于商品金额条件，直接返回
        if(skuPrice.compareTo(new BigDecimal(x)) < 0){
            return skuPrice;
        }
        //减去优惠金额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(y));
        //满减后价格小于等于0，那么支付最低1元
        if(discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
