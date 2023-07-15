package com.xbhog.combatCode.工厂模式.design.card;

/**
 * @author xbhog
 */
public class IQiYiCardService {
    /**
     * @param bindMobileNumber 手机号
     * @param cardId 会员卡号
     */
    public void granToken(String bindMobileNumber,String cardId){
        System.out.println("模拟发方爱奇艺会员卡一张："+bindMobileNumber+","+cardId);
    }
}
