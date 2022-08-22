package openClosedPrincipleFile;

import SOLID5大原则.DependencyInversionPrinciple.BudgetReport;
import SOLID5大原则.DependencyInversionPrinciple.MySQLDatabase;
import SOLID5大原则.openClosedPrincipleFile.ICalculationArea;
import SOLID5大原则.openClosedPrincipleFile.impl.CalculationAreaExt;
import combatCode.工厂模式.design.ICommodity;
import combatCode.工厂模式.design.StoreFactory;
import combatCode.模板模式.design.NetMall;
import combatCode.模板模式.design.group.JDNetMall;
import combatCode.策略模式.design.Context;
import combatCode.策略模式.design.impl.MJCouponDiscount;
import combatCode.策略模式.design.impl.NYGCouponDiscount;
import combatCode.策略模式.design.impl.ZKCouponDiscount;
import combatCode.策略模式.design.impl.ZjCouponDiscount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbhog
 * @describe:
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
     * 工厂模式
     * @throws Exception
     */
    @Test
    public void  test_commodity() throws Exception{
        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService = storeFactory.getCommodityService(3);
        commodityService.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }
}
