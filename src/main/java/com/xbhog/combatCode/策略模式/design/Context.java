package com.xbhog.combatCode.策略模式.design;

import java.math.BigDecimal;

/**
 * @author xbhog
 * @describe:策略控制器
 * @date 2022/8/21
 */
public class Context <T>{

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }
    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice){
        return couponDiscount.discountAmount(couponInfo,skuPrice);
    }
}
