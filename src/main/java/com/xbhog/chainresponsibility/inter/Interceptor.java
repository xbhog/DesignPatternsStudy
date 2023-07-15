package com.xbhog.chainresponsibility.inter;

/**
 * @author xbhog
 * @describe: 合同拦截器
 * @date 2023/7/11
 */
public interface Interceptor <T,R>{
    /**
     * 合同拦截器的处理流程
     * @param chain 节点信息
     * @return 处理结果
     */
    R process(Chain<T,R> chain);
}
