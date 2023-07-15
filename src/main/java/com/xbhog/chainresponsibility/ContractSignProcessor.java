package com.xbhog.chainresponsibility;



import com.xbhog.chainresponsibility.inter.Interceptor;
import com.xbhog.chainresponsibility.inter.Processor;
import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xbhog
 * @describe: 责任链+组合+过滤器实现合同签章
 * @date 2023/7/11
 */
@Slf4j
@Component
public class ContractSignProcessor <T extends ContractRequest> implements Processor<T, ContractResponse> {

    @Resource(name = "contractSignCompactInitImpl")
    private Interceptor<T,ContractResponse> contractCompactInitImpl;

    @Resource(name = "contractSignGenerateImpl")
    private Interceptor<T,ContractResponse> contractGenerateImpl;

    @Resource(name = "contractSignMockImpl")
    private Interceptor<T,ContractResponse> contractSignMockImpl;

    @Resource(name = "contractSignMqImpl")
    private Interceptor<T,ContractResponse> contractSignMqImpl;

    @Resource(name = "contractSignSaveUploadImpl")
    private Interceptor<T,ContractResponse> contractSignSaveUploadImpl;

    @Resource(name = "contractSignSerialImpl")
    private Interceptor<T,ContractResponse> contractSignSerialImpl;

    @Resource(name = "contractSignTradeImpl")
    private Interceptor<T,ContractResponse> ContractSignTradeImpl;


    public ContractSignProcessor() {
    }

    @Override
    public ContractResponse process(T paramter) {
        //获取所有的监听器
        List<Interceptor<T,ContractResponse>> interceptorList = new ArrayList<>();
        interceptorList.add(contractCompactInitImpl);
        interceptorList.add(contractGenerateImpl);
        interceptorList.add(contractSignMockImpl);
        interceptorList.add(contractSignMqImpl);
        interceptorList.add(contractSignSaveUploadImpl);
        interceptorList.add(contractSignSerialImpl);
        interceptorList.add(ContractSignTradeImpl);
        //开始签章
        log.info("签章开始");
        return new ContractCall(paramter,interceptorList).exectue();
    }
}
