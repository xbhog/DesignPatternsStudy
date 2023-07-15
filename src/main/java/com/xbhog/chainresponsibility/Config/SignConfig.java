package com.xbhog.chainresponsibility.Config;



import com.xbhog.chainresponsibility.annotations.ContractSign;
import com.xbhog.chainresponsibility.inter.Interceptor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/15
 */

public class SignConfig {
    @Resource
    private List<Interceptor> contractSignList;

    protected static final Map<Integer,Interceptor> CONTRACT_SIGN_MAP = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
       contractSignList.forEach(interceptor -> {
           ContractSign sign = AnnotationUtils.findAnnotation(interceptor.getClass(), ContractSign.class);
           if(!Objects.isNull(sign)){
               CONTRACT_SIGN_MAP.put(sign.SIGN_CHANNEL().getCode(),interceptor);
           }
       });
    }

}
