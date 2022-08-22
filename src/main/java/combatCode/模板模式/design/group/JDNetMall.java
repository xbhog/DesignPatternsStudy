package combatCode.模板模式.design.group;

import com.alibaba.fastjson.JSON;
import combatCode.模板模式.design.HttpClient;
import combatCode.模板模式.design.NetMall;

import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class JDNetMall extends NetMall {

    public JDNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }
    @Override
    public boolean login(String uId, String uPwd) {
        logger.info("模拟京东用户登录 uId：{} uPwd：{}", uId, uPwd);
        return true;
    }
    @Override
    public Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "5999.00");
        logger.info("模拟京东商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }
    @Override
    public String createBase64(Map<String, String> goodsInfo) {
        Base64.Encoder  encoder = Base64.getEncoder ();
        logger.info("模拟生成京东商品base64海报");
        return encoder.encodeToString(JSON.toJSONString(goodsInfo).getBytes());
    }

}
