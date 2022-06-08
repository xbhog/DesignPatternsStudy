package BaseDemo;

import java.util.List;

/**
 * describe:订单总额
 * @author xbhog
 * @date 2022/6/7
 */
public class OrderTotal {
    /**
     * 第一版：税率计算代码和方法的其他代码混杂在一起
     * @param orders
     * @return
     */
    public double getOrderToal(List<Order> orders){
        double total = 0;
        for(Order order : orders){
            total += order.getPrice() * order.getQuantity();
            if("US".equals(order.getCountry())){
                total += total * 0.07;
            } else if ("EU".equals(order.getCountry())) {
                total += total * 0.20;
            }
        }
        return total;
    }

    /**
     * 第二版：将计算税金的逻辑抽取到一个单独的方法中，并对原
     * 始方法隐藏该逻辑
     * @param orders
     * @return
     */
    public double getOrderToalTwo(List<Order> orders){
        double total = 0;
        for(Order order : orders){
            total += order.getPrice() * order.getQuantity();
            total += getTaxRate(order.getCountry());
        }
        return total;
    }
    public double getTaxRate(String country){
        if("US".equals(country)){
           return 0.07;
        } else if ("EU".equals(country)) {
            return  0.20;
        }
        return 0;
    }
}
