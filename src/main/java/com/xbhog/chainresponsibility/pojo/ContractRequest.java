package com.xbhog.chainresponsibility.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractRequest {

    private String name;

    private String age;

    private String status;
}
