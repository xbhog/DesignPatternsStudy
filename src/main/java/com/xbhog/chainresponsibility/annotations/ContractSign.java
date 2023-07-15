package com.xbhog.chainresponsibility.annotations;



import com.xbhog.chainresponsibility.Enum.ContractSignEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContractSign {
    ContractSignEnum.SignChannel SIGN_CHANNEL();

}
