package com.xbhog.chainresponsibility;





import com.xbhog.chainresponsibility.inter.Call;
import com.xbhog.chainresponsibility.inter.Interceptor;
import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;

import java.util.List;

/**
 * @author xbhog
 * @describe: 合同数据请求及节点的封装
 * @date 2023/7/11
 */
public class ContractCall<T extends ContractRequest> implements Call<T, ContractResponse> {
    private final T originalRequest;
    private final List<Interceptor<T,ContractRequest>> interceptorList;

    public ContractCall(T originalRequest, List<Interceptor<T, ContractRequest>> interceptorList) {
        this.originalRequest = originalRequest;
        this.interceptorList = interceptorList;
    }

    @Override
    public T request() {
        return this.originalRequest;
    }

    @Override
    public ContractResponse exectue() {
        //实例化流程节点
        ContractChain<T> chain = new ContractChain(0,this.originalRequest,this.interceptorList);
        return chain.proceed(this.originalRequest);
    }
}
