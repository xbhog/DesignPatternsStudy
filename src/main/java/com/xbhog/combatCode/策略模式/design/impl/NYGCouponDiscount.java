package com.xbhog.combatCode.策略模式.design.impl;

import com.xbhog.combatCode.策略模式.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author xbhog
 * @describe:N元购
 * @date 2022/8/21
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {
    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
