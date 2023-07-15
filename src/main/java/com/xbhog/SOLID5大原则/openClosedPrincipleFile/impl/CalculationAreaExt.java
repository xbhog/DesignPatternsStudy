package com.xbhog.SOLID5大原则.openClosedPrincipleFile.impl;


/**
 * @author xbhog
 * @describe:圆面积扩展，采用精度更高Π实现,继承标准类，并做出有别于父类的行为
 * @date 2022/6/8
 */
public class CalculationAreaExt  extends CalculationArea {
    private final static double π = 3.141592653D;

    @Override
    public double circular(double r) {
        return π * r * r;
    }
}
