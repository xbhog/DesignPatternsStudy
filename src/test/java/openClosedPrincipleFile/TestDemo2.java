package openClosedPrincipleFile;

import combatCode.抽象工厂模式.design.CacheService;
import combatCode.抽象工厂模式.design.factory.ICacheAdapter;
import combatCode.抽象工厂模式.design.factory.JDKProxy;
import combatCode.抽象工厂模式.design.factory.impl.EGMCacheAdapter;
import combatCode.抽象工厂模式.design.impl.CacheServiceImpl;
import combatCode.抽象工厂模式.design.store.StoreFactory2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author xbhog
 * @describe:抽象工厂模式
 * @date 2022/9/3
 */
@Slf4j
public class TestDemo2 {

    @Test
    public void test_CacheService() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","xbhog");
        String value01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果："+value01);
    }
    @Test
    public void test_CacheService2() throws Exception{
        StoreFactory2 factory2 = new StoreFactory2();
        ICacheAdapter cacheMode = factory2.getCacheMode(1);
        cacheMode.set("user_name_02","xbhog测试2");
        String values02 = cacheMode.get("user_name_02");
        System.out.println("测试结果2："+values02);

    }
}
