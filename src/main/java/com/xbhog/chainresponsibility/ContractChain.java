package com.xbhog.chainresponsibility;





import com.xbhog.chainresponsibility.inter.Chain;
import com.xbhog.chainresponsibility.inter.Interceptor;
import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 * @author xbhog
 * @describe: 合同节点
 * @date 2023/7/11
 */
@Slf4j
public class ContractChain<T extends ContractRequest> implements Chain<T, ContractResponse> {
    private final Integer index;

    private final T request;

    private final List<Interceptor<T,ContractResponse>> interceptors;

    public ContractChain(Integer index, T request, List<Interceptor<T, ContractResponse>> interceptors) {
        this.index = index;
        this.request = request;
        this.interceptors = interceptors;
    }

    @Override
    public T request() {
        return this.request;
    }

    @Override
    public ContractResponse proceed(T request) {
        //控制节点流程
        if(this.index >= this.interceptors.size()){
            throw  new IllegalArgumentException("index越界");
        }
        //下一个节点参数设置
        Chain<T,ContractResponse> nextChain = new ContractChain(this.index + 1, request, this.interceptors);
        //获取节点信息
        Interceptor<T, ContractResponse> interceptor = this.interceptors.get(this.index);
        Class<? extends Interceptor> aClass = interceptor.getClass();
        log.info("下一个节点类：{}",aClass.getSimpleName());
        ContractResponse response = interceptor.process(nextChain);
        if(Objects.isNull(response)){
            throw new NullPointerException("intercetor"+interceptor+"return null");
        }
        return response;
    }
}
