package combatCode.工厂模式.design.Coupon;

/**
 * 模拟优惠卷服务
 * @author xbhog
 */
public class CouponService {
    public CouponResult sendCoupon(String uId,String conponNumber,String uuid){
        System.out.println("模拟发放优惠卷一张："+uId+","+conponNumber+","+uuid);
        return new CouponResult("0000","发放成功");
    }
}
