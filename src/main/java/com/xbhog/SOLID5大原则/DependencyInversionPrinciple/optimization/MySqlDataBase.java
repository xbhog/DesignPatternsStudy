package com.xbhog.SOLID5大原则.DependencyInversionPrinciple.optimization;

/**
 * @author xbhog
 * @describe:
 * @date 2022/6/13
 */
public interface MySqlDataBase {
    void select();
    void insert();
    void update();
    void delete();
}
