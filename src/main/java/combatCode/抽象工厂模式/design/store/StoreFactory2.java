package combatCode.抽象工厂模式.design.store;

import combatCode.抽象工厂模式.design.factory.ICacheAdapter;
import combatCode.抽象工厂模式.design.factory.impl.EGMCacheAdapter;
import combatCode.抽象工厂模式.design.factory.impl.IIRCacheAdapter;
import combatCode.抽象工厂模式.design.matter.RedisUtils;

/**
 * @author xbhog
 * @describe:
 * @date 2022/9/3
 */
public class StoreFactory2 {
    public ICacheAdapter getCacheMode(Integer modeyType){
        if(1 == modeyType){
            return new EGMCacheAdapter();
        }else if(2 == modeyType){
            return new IIRCacheAdapter();
        }
        return new RedisUtils();
    }
}
