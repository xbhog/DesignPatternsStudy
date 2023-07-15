package com.xbhog.chainresponsibility.impl;


import com.xbhog.chainresponsibility.Enum.ContractSignEnum;
import com.xbhog.chainresponsibility.annotations.ContractSign;
import com.xbhog.chainresponsibility.inter.Chain;
import com.xbhog.chainresponsibility.inter.Interceptor;
import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xbhog
 * @describe: 签章挡板
 * @date 2023/7/15
 */
@Slf4j
@ContractSign(SIGN_CHANNEL = ContractSignEnum.SignChannel.SIGN_MOCK)
@Component
public class ContractSignMockImpl<T extends ContractRequest> implements Interceptor<T, ContractResponse> {
    @Value("signMock")
    private String signMock;
    @Override
    public ContractResponse process(Chain<T, ContractResponse> chain) {
        log.info("=============执行签章挡板拦截器开始");
        //获取处理的请求参数
        T request = chain.request();
        //挡板设置可通过配置中心配置
       if("true".equals(signMock)){
           return ContractResponse.builder().status("success").mas("挡板开啦").build();
       }
        //其他处理
        log.info("=============执行签章挡板拦截器结束");
        return chain.proceed(request);
    }
}
