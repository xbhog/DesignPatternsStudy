package com.xbhog.chainresponsibility.channel;


import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/15
 */
public interface ContractSignChannel {
    /**
     * 节点值
     * @return 字符串
     */
    String channelCode();

    /**
     * 签章具体方法
     * @param request 请求
     * @return 合同结果处理
     * @throws Exception 捕获
     */
    ContractResponse contractSign(ContractRequest request) throws Exception;
}
