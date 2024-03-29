package com.xbhog.combatCode.工厂模式.design.impl;

import com.alibaba.fastjson.JSON;
import com.xbhog.combatCode.工厂模式.design.ICommodity;
import com.xbhog.combatCode.工厂模式.design.card.IQiYiCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author xbhog
 * 第三方兑换卡
 */
public class CardCommodityService implements ICommodity {
    private final Logger logger = LoggerFactory.getLogger(CardCommodityService.class);
    //模拟注入
    private final IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId,
                              Map<String, String> extMap) throws Exception {
        String userMobile = queryUserMobile(uId);
        iQiYiCardService.granToken(userMobile,bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }
    //查询手机号
    private String queryUserMobile(String uId){
        return "123456789";
    }
}
