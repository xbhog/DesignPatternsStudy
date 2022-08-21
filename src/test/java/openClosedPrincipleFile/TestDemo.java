package openClosedPrincipleFile;

import SOLID5大原则.DependencyInversionPrinciple.BudgetReport;
import SOLID5大原则.DependencyInversionPrinciple.MySQLDatabase;
import SOLID5大原则.openClosedPrincipleFile.ICalculationArea;
import SOLID5大原则.openClosedPrincipleFile.impl.CalculationAreaExt;
import combatCode.模板模式.design.NetMall;
import combatCode.模板模式.design.group.JDNetMall;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
    @Test
    public void demo(){
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        log.info("测试结果：{}", base64);
    }
}
