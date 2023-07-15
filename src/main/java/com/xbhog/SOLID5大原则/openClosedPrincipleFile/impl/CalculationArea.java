package com.xbhog.SOLID5大原则.openClosedPrincipleFile.impl;

import com.xbhog.SOLID5大原则.openClosedPrincipleFile.ICalculationArea;

/**
 * @author xbhog
 * @describe: 圆面积计算:标准
 * @date 2022/6/8
 */
public class CalculationArea implements ICalculationArea {
    private final static double π = 3.14D;
    @Override
    public double rectangle(double x, double y) {
        return x * y;
    }
    @Override
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }
    @Override
    public double circular(double r) {
        return π * r * r;
    }
}
