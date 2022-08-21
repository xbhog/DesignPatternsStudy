package combatCode.策略模式.design;

import java.math.BigDecimal;

/**
 * @author xbhog
 * @describe:优惠卷折扣计算接口
 * 1. 直减卷
 * 2. 满减卷
 * 3. 折扣卷
 * 4. N元购
 * @date 2022/8/21
 */
public interface ICouponDiscount<T> {
    /**
     *
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice 商品价格
     * @return 优惠后金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}
