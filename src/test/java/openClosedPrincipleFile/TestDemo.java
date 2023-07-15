package openClosedPrincipleFile;

import com.xbhog.SOLID5大原则.openClosedPrincipleFile.ICalculationArea;
import com.xbhog.SOLID5大原则.openClosedPrincipleFile.impl.CalculationAreaExt;
import com.xbhog.combatCode.工厂模式.design.ICommodity;
import com.xbhog.combatCode.工厂模式.design.StoreFactory;
import com.xbhog.combatCode.模板模式.design.NetMall;
import com.xbhog.combatCode.模板模式.design.group.JDNetMall;
import com.xbhog.combatCode.策略模式.design.Context;
import com.xbhog.combatCode.策略模式.design.impl.MJCouponDiscount;
import com.xbhog.combatCode.策略模式.design.impl.NYGCouponDiscount;
import com.xbhog.combatCode.策略模式.design.impl.ZKCouponDiscount;
import com.xbhog.combatCode.策略模式.design.impl.ZjCouponDiscount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbhog
 * @describe:模板、策略、工厂模式
 * @date 2022/6/8
 */
@Slf4j
public class TestDemo {

    @Test
    public void test(){
        ICalculationArea calculationAreaExt = new CalculationAreaExt();
        double circular = calculationAreaExt.circular(2);
        System.out.println(circular);
    }

    /**
     * 模板模式
     */
    @Test
    public void demo(){
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        log.info("测试结果：{}", base64);
    }
    /**
     * 测试策略模式
     */
    @Test
    public void Strategy_mj(){
        Context<Map<String, String>> mjActivity = new Context<>(new MJCouponDiscount());
        HashMap<String, String> map = new HashMap<>();
        map.put("x","100");
        map.put("y","10");
        BigDecimal discountAmount = mjActivity.discountAmount(map, new BigDecimal(100));
        log.info("测试结果，满减优惠后的金额：{}",discountAmount);
    }
    @Test
    public void Strategy_zj(){
        Context<Double> context = new Context<>(new ZjCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(9D, new BigDecimal(100));
        log.info("测试结果，直减优惠后的金额：{}",discountAmount);
    }
    @Test
    public void Strategy_zk(){
        Context<Double> context = new Context<>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.8D, new BigDecimal(100));
        log.info("测试结果，折扣优惠后的金额：{}",discountAmount);
    }
    @Test
    public void Strategy_nyg(){
        Context<Double> context = new Context<>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(80D, new BigDecimal(100));
        log.info("测试结果，N元购优惠后的金额：{}",discountAmount);
    }

    /**
     * 工厂模式-第三方兑换卡
     * @throws Exception
     */
    @Test
    public void  test_commodity() throws Exception{
        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService = storeFactory.getCommodityService(3);
        commodityService.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }
    @Test
    public void Test_coupon() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService = storeFactory.getCommodityService(1);
        commodityService.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
    }
    @Test
    public void Test_Goods() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService = storeFactory.getCommodityService(2);
        HashMap<String, String> extMap = new HashMap<>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        commodityService.sendCommodity("10001","9820198721311","1023000020112221113",extMap);
    }
}
