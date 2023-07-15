package com.xbhog.combatCode.工厂模式.design.impl;

import com.alibaba.fastjson.JSON;
import com.xbhog.combatCode.工厂模式.design.Coupon.CouponResult;
import com.xbhog.combatCode.工厂模式.design.Coupon.CouponService;
import com.xbhog.combatCode.工厂模式.design.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author xbhog
 * 优惠卷服务
 */
@Slf4j
public class CouponCommodityService implements ICommodity {
    private final CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId,
                              String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if(!("0000".equals(couponResult.getCode()))) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}
