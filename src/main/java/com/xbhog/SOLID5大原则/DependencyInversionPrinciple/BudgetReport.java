package com.xbhog.SOLID5大原则.DependencyInversionPrinciple;

/**
 * @author xbhog
 * @describe:高层次的预算报告类
 * @date 2022/6/13
 */
public class BudgetReport {
    private MySQLDatabase mySQLDatabase;

    public void open(String data){
        System.out.println("读取数据");
    }
    public void save(){
        System.out.println("保存数据");
    }
}
