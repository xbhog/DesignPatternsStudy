package com.xbhog.BaseDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xbhog
 * @describe:
 * @date 2022/6/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long price;
    private Long quantity;
    private String country;
    private String demo;
}
