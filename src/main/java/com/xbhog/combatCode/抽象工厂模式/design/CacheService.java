package com.xbhog.combatCode.抽象工厂模式.design;

import java.util.concurrent.TimeUnit;

public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
