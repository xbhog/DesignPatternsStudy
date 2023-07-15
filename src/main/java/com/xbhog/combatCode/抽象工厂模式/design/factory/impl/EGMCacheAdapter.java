package com.xbhog.combatCode.抽象工厂模式.design.factory.impl;

import com.xbhog.combatCode.抽象工厂模式.design.factory.ICacheAdapter;
import com.xbhog.combatCode.抽象工厂模式.design.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @author xbhog
 * @describe:服务方法命名统一
 * @date 2022/9/3
 */
public class EGMCacheAdapter implements ICacheAdapter {
    /**
     * 模拟注入
     */
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
