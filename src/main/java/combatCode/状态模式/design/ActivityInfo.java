package combatCode.状态模式.design;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author xbhog
 * @describe: 活动对象
 * @date 2022/9/11
 */
@Data
@Builder
public class ActivityInfo {
    private String activityId;    // 活动ID
    private String activityName;  // 活动名称
    private Enum<Status> status;  // 活动状态
    private Date beginTime;       // 开始时间
    private Date endTime;         // 结束时间
}
