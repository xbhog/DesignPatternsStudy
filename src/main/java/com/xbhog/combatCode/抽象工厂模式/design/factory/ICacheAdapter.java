package com.xbhog.combatCode.抽象工厂模式.design.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author xbhog
 * @describe: 定义接口适配器
 * 主要作用是让所有集群的提供方，能在统一的方法名称下进行操作。也方面后续的拓展
 * @date 2022/9/3
 */
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
