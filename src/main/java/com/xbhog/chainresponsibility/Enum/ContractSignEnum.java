package com.xbhog.chainresponsibility.Enum;

/**
 * @author xbhog
 * @describe:
 * @date 2023/7/15
 */
public class ContractSignEnum {
    public enum SignChannel {

        SIGN_INIT(1, "合同文本初始化"),
        SIGN_GENERATE(2, "合同文本生成"),
        SIGN_MOCK(3, "签章挡板"),
        SIGN_MQ(4, "合同签章完成发送MQ"),
        SIGN_TABLE(5, "合同签章表处理"),
        SIGN_UPLOAD(6, "合同签章完成上传服务器"),
        SIGN_TRADE(7, "签章渠道实际调用");

        private Integer code;
        private String info;

        SignChannel(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
