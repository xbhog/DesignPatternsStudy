package combatCode.策略模式.design.impl;

import combatCode.策略模式.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author xbhog
 * @describe:直减
 * @date 2022/8/21
 */
public class ZjCouponDiscount implements ICouponDiscount<Double> {
    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if(discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
