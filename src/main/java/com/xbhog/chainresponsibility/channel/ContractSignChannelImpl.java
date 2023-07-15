package com.xbhog.chainresponsibility.channel;


import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/15
 */
@Slf4j
@Component
public class ContractSignChannelImpl implements ContractSignChannel{
    @Override
    public String channelCode() {
        return "contractChannel";
    }

    @Override
    public ContractResponse contractSign(ContractRequest request) throws Exception {
        log.info("签章处理开始");

        return ContractResponse.builder().status("success").mas("处理成功").build();
    }
}
