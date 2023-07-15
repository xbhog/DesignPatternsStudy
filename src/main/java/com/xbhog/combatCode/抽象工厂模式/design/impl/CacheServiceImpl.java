package com.xbhog.combatCode.抽象工厂模式.design.impl;

import com.xbhog.combatCode.抽象工厂模式.design.CacheService;
import com.xbhog.combatCode.抽象工厂模式.design.matter.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author xbhog
 * @describe:
 * @date 2022/9/3
 */
public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
