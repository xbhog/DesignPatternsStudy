package SOLID5大原则.SinglePrincipleFile.impl;

import SOLID5大原则.SinglePrincipleFile.VideoUserService;

/**
 * @author xbhog
 * @describe: 访客用户
 * @date 2022/6/8
 */
public class GuestVideoUserService  implements VideoUserService {
    @Override
    public void definition() {
        System.out.println("视频不清楚");
    }

    @Override
    public void advertisement() {
        System.out.println("有广告");
    }
}
