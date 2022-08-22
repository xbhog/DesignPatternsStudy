package combatCode.工厂模式.design;

import java.util.Map;

/**
 * @author xbhog
 * @describe:定义发奖接口
 */
public interface ICommodity {
    /**
     *
     * @param uId 用户ID
     * @param commodityId　奖品ID
     * @param bizId 业务ID
     * @param extMap 扩展字段
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
