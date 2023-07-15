package com.xbhog.combatCode.模板模式.design;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * @author xbhog
 * @describe:基础电商推广服务
 * 1. 生成最优价商品海报
 * 2. 海报含带推广邀请码
 * @date 2022/8/20
 */
@Slf4j
public abstract class NetMall {

    protected Logger logger = LoggerFactory.getLogger(NetMall.class);


    String uId;
    String upwd;

    public NetMall(String uId, String upwd) {
        this.uId = uId;
        this.upwd = upwd;
    }

    /**
     * 生成商品推广海报
     * @param skuUrl 商品地址(京东、淘宝、当当)
     * @return 海报图片base64位信息
     */
    public String generateGoodsPoster(String skuUrl){
        if(!login(uId,upwd)) return null;
        Map<String,String> reptile = reptile(skuUrl);
        return createBase64(reptile);
    }

    /**
     * 模拟用户登录
     * @param uId
     * @param upwd
     * @return
     */
    protected abstract boolean login(String uId, String upwd);
    /**
     * 爬虫提取商品信息(登录后的价格优惠)
     * @param skuUrl
     * @return
     */
    protected abstract Map<String, String> reptile(String skuUrl);


    /**
     * 生成商品海报信息
     * @param reptile
     * @return
     */
    protected abstract String createBase64(Map<String, String> reptile);


}
