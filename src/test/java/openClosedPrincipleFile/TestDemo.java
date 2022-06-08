package openClosedPrincipleFile;

import SOLID5大原则.openClosedPrincipleFile.ICalculationArea;
import SOLID5大原则.openClosedPrincipleFile.impl.CalculationAreaExt;
import org.junit.Test;

/**
 * @author xbhog
 * @describe:
 * @date 2022/6/8
 */
public class TestDemo {
    @Test
    public void test(){
        ICalculationArea calculationAreaExt = new CalculationAreaExt();
        double circular = calculationAreaExt.circular(2);
        System.out.println(circular);
    }
}
