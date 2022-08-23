package combatCode.工厂模式.design.Coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xbhog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponResult {
    // 编码
    private String code;

    // 描述
    private String info;
}
