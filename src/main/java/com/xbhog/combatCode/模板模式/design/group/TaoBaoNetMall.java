package com.xbhog.combatCode.模板模式.design.group;

import com.alibaba.fastjson.JSON;
import com.xbhog.combatCode.模板模式.design.HttpClient;
import com.xbhog.combatCode.模板模式.design.NetMall;


import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xbhog
 * @describe:
 * @date 2022/8/21
 */
public class TaoBaoNetMall extends NetMall {


    public TaoBaoNetMall(String uId, String upwd) {
        super(uId, upwd);
    }

    @Override
    protected boolean login(String uId, String upwd) {
        logger.info("登录成功，{}，{}",uId,upwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "4799.00");
        logger.info("模拟淘宝商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        Base64.Encoder  encoder = Base64.getEncoder ();
        logger.info("模拟生成淘宝商品base64海报");
        return encoder.encodeToString(JSON.toJSONString(goodsInfo).getBytes());
    }
}
