package com.xbhog.chainresponsibility.inter;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/11
 */
public interface Processor <T,R>{
    /**
     * 合同流程
     * @param paramter 请求参数
     * @return 处理结果
     */
    R process(T paramter);
}
