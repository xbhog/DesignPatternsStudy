package combatCode.工厂模式.design;

import combatCode.工厂模式.design.impl.CardCommodityService;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType){
        if(null == commodityType) {
            return null;
        }
        if(3 == commodityType) {
            return new CardCommodityService();
        }
        throw  new RuntimeException("不存在的商品服务类型");
    }
}
