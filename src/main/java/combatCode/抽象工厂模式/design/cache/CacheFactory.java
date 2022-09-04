package combatCode.抽象工厂模式.design.cache;

import combatCode.抽象工厂模式.design.factory.ICacheAdapter;
import combatCode.抽象工厂模式.design.factory.impl.EGMCacheAdapter;
import combatCode.抽象工厂模式.design.factory.impl.IIRCacheAdapter;
import combatCode.抽象工厂模式.design.matter.RedisUtils;

/**
 * @author xbhog
 * @describe:代理类2(采用的简单工厂模式)
 * @date 2022/9/3
 */
public class CacheFactory {
    public ICacheAdapter getCacheMode(Integer modeyType){
        if(1 == modeyType){
            return new EGMCacheAdapter();
        }else if(2 == modeyType){
            return new IIRCacheAdapter();
        }
        return new RedisUtils();
    }
}
