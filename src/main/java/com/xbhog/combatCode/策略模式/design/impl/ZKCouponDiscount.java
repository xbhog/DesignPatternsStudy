package com.xbhog.combatCode.策略模式.design.impl;

import com.xbhog.combatCode.策略模式.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author xbhog
 * @describe:
 * @date 2022/8/21
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {
    /**
     * 折扣计算
     * 1. 使用商品价格乘以折扣比例，为最后支付金额
     * 2. 保留两位小数
     * 3. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        //保留两位小数，并向上取整
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if(discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
