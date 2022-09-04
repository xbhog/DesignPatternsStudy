package combatCode.抽象工厂模式.design.factory.impl;

import combatCode.抽象工厂模式.design.factory.ICacheAdapter;
import combatCode.抽象工厂模式.design.matter.IIR;
import java.util.concurrent.TimeUnit;

/**
 * 服务方法命名统一
 */
public class IIRCacheAdapter implements ICacheAdapter {
    /**
     * 模拟注入服务
     */
    private IIR iir = new IIR();
    @Override
    public String get(String key) {
        return iir.get(key);
    }
    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }
    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }
    @Override
    public void del(String key) {
        iir.del(key);
    }

}
