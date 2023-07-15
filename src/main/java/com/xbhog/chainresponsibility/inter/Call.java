package com.xbhog.chainresponsibility.inter;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/11
 */
public interface Call<T, R> {
    /**
     * 请求
     * @return T
     */
    T request();

    /**
     * 执行
     * @return R
     */
    R exectue();

}
