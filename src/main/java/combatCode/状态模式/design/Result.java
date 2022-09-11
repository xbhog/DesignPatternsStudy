package combatCode.状态模式.design;

import lombok.Data;

@Data
public class Result {

    private String code; // 编码
    private String info; // 描述

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
