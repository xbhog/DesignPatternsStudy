package com.xbhog;

import com.xbhog.chainresponsibility.inter.Processor;
import com.xbhog.chainresponsibility.pojo.ContractRequest;
import com.xbhog.chainresponsibility.pojo.ContractResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author xbhog
 * @describe:
 * @date 2023/7/15
 */
@SpringBootTest
public class signTest {
    @Autowired
    @Qualifier("contractSignProcessor")
    private Processor<ContractRequest,ContractResponse> contractSignProcessor;

    @Test
    void contextLoads() {
        ContractRequest contractRequest = new ContractRequest();
        contractRequest.setName("xbhog");
        contractRequest.setAge("12");
        ContractResponse process = contractSignProcessor.process(contractRequest);
        System.out.println(process);
    }
}
