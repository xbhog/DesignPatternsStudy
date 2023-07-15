package com.xbhog.combatCode.抽象工厂模式.design.matter;

import com.xbhog.combatCode.抽象工厂模式.design.factory.ICacheAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RedisUtils implements ICacheAdapter {

    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();
    @Override
    public String get(String key) {
        logger.info("Redis获取数据 key：{}", key);
        return dataMap.get(key);
    }
    @Override
    public void set(String key, String value) {
        logger.info("Redis写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }
    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("Redis写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }
    @Override
    public void del(String key) {
        logger.info("Redis删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
