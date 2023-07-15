package com.xbhog.SOLID5大原则.SinglePrincipleFile.impl;

import com.xbhog.SOLID5大原则.SinglePrincipleFile.VideoUserService;

/**
 * @author xbhog
 * @describe: 普通用户
 * @date 2022/6/8
 */
public class OrdinaryVideoUserService implements VideoUserService {
    @Override
    public void definition() {
        System.out.println("720P");
    }

    @Override
    public void advertisement() {
        System.out.println("50s广告");
    }
}
