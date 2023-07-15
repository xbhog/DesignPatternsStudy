package com.xbhog.chainresponsibility.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractResponse {
    private String status;

    private String mas;
}
