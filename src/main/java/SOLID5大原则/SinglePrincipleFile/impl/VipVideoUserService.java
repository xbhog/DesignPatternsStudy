package SOLID5大原则.SinglePrincipleFile.impl;

import SOLID5大原则.SinglePrincipleFile.VideoUserService;

/**
 * @author xbhog
 * @describe: Vip用户
 * @date 2022/6/8
 */
public class VipVideoUserService implements VideoUserService {
    @Override
    public void definition() {
        System.out.println("爷，里边请！氪金yyds");
    }

    @Override
    public void advertisement() {
        System.out.println("您随便看");
    }
}
