package com.xbhog.chainresponsibility.inter;

/**
 * @author xbhog
 */
public interface Chain<T,R>{
    /**
     * 请求
     */
    T request();

    /**
     * 节点处理
     * @param request 数据请求
     * @return 处理结果
     */
    R proceed(T request);
}