package combatCode.工厂模式.design;

import combatCode.工厂模式.design.impl.CardCommodityService;
import combatCode.工厂模式.design.impl.CouponCommodityService;
import combatCode.工厂模式.design.impl.GoodsCommodityService;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType){
        if(null == commodityType) {
            return null;
        }
        if(1 == commodityType){
            return new CouponCommodityService();
        }
        if(2 == commodityType){
            return new GoodsCommodityService();
        }
        if(3 == commodityType) {
            return new CardCommodityService();
        }
        throw  new RuntimeException("不存在的商品服务类型");
    }
}
