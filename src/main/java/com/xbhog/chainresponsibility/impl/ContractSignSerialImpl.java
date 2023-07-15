package com.xbhog.chainresponsibility.impl;


import com.xbhog.chainresponsibility.Enum.ContractSignEnum;
import com.xbhog.chainresponsibility.annotations.ContractSign;
import com.xbhog.chainresponsibility.inter.Chain;
import com.xbhog.chainresponsibility.inter.Interceptor;
import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author xbhog
 * @describe: 合同签章表处理
 * @date 2023/7/15
 */
@Slf4j
@ContractSign(SIGN_CHANNEL = ContractSignEnum.SignChannel.SIGN_TABLE)
@Component
public class ContractSignSerialImpl <T extends ContractRequest> implements Interceptor<T, ContractResponse> {
    @Override
    public ContractResponse process(Chain<T, ContractResponse> chain) {
        log.info("=============执行合同签章流水处理拦截器开始");
        //获取处理的请求参数
        T request = chain.request();
        //进入下一个责任链节点
        ContractResponse response =  chain.proceed(request);
        if(Objects.isNull(response)){
            log.error("返回值的为空");
            response = ContractResponse.builder().status("fail").mas("处理失败").build();
        }
        //处理合同表的流水等
        //其他处理
        log.info("=============执行合同签章流水处理拦截器结束");
        return response;
    }
}
