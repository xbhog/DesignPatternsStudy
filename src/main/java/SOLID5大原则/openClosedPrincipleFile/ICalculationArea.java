package SOLID5大原则.openClosedPrincipleFile;

/**
 * 面积计算
 * @author xbhog
 */
public interface ICalculationArea {

    /**
     * 计算面积，长方形
     *
     * @param x 长
     * @param y 宽
     * @return 面积
     */
    double rectangle(double x, double y);

    /**
     * 计算面积，三角形
     * @param x 边长x
     * @param y 边长y
     * @param z 边长z
     * @return  面积
     *
     * 海伦公式：S=√[p(p-a)(p-b)(p-c)] 其中：p=(a+b+c)/2
     */
    double triangle(double x, double y, double z);

    /**
     * 计算面积，圆形
     * @param r 半径
     * @return 面积
     *
     * 圆面积公式：S=πr²
     */
    double circular(double r);

}