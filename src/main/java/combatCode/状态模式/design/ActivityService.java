package combatCode.状态模式.design;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xbhog
 * @describe: 活动服务
 * @date 2022/9/11
 */
public class ActivityService {
    private static Map<String,Enum<Status>> statusMap = new ConcurrentHashMap<String,Enum<Status>>();

    /**
     *初始化活动数据。实际的开发中这类信息基本都是从数据库或者Redis中获取
     * @param activityId
     * @param status
     */
    public static void init(String activityId,Enum<Status> status){
        //模拟查询活动信息
        ActivityInfo info = ActivityInfo.builder()
                .activityId(activityId)
                .activityName("早起学习打开")
                .status(status)
                .beginTime(new Date())
                .endTime(new Date())
                .build();
        statusMap.put(activityId,status);

    }

    /**
     * 查询活动信息
     * @param activityId 活动ID
     * @return 查询结果
     */
    public static ActivityInfo queryActivityInfo(String activityId){
        //模拟查询活动信息
        ActivityInfo info = ActivityInfo.builder()
                .activityId(activityId)
                .activityName("早起学习打开")
                .status(statusMap.get(activityId))
                .beginTime(new Date())
                .endTime(new Date())
                .build();
        return info;
    }

    /**
     * 查询活动状态
     * @param activityId 活动ID
     * @return 查询结果
     */
    public static Enum<Status> queryActivityStatus(Status activityId){
        return statusMap.get(activityId);
    }
    /**
     * 执行状态变更
     *
     * @param activityId   活动ID
     * @param beforeStatus 变更前状态
     * @param afterStatus  变更后状态 b
     */
    public static synchronized void exectStatus(String activityId,
                                                Enum<Status> beforeStatus, Enum<Status> afterStatus){
        if(!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId,afterStatus);
    }

}
