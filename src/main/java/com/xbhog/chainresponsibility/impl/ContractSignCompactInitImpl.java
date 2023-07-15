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
 * @describe: 合同文本初始化
 * @date 2023/7/12
 */
@Slf4j
@ContractSign(SIGN_CHANNEL = ContractSignEnum.SignChannel.SIGN_INIT)
@Component
public class ContractSignCompactInitImpl<T extends ContractRequest> implements Interceptor<T, ContractResponse> {
    public ContractSignCompactInitImpl() {
    }

    @Override
    public ContractResponse process(Chain<T,ContractResponse> chain) {
        log.info("=============执行合同文本初始化拦截器开始");
        //获取处理的请求参数
        T request = chain.request();
        request.setStatus("1");
        log.info("=============执行合同文本初始化拦截器结束");
        //进入下一个责任链节点
        ContractResponse response =  chain.proceed(request);
        if(Objects.isNull(response)){
            log.error("返回值的为空");
            response = ContractResponse.builder().status("fail").mas("处理失败").build();
        }
        //其他处理
        return response;
    }
}
