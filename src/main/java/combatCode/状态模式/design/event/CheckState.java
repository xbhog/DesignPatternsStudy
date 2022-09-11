package combatCode.状态模式.design.event;

import combatCode.状态模式.design.ActivityService;
import combatCode.状态模式.design.Result;
import combatCode.状态模式.design.State;
import combatCode.状态模式.design.Status;

/**
 * @author xbhog
 * @describe: 活动状态；待审核
 * @date 2022/9/11
 */
public class CheckState extends State {
    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001","待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        ActivityService.exectStatus(activityId,currentStatus,Status.Pass);
        return new Result("0000","活动审核通过完成");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.exectStatus(activityId,currentStatus,Status.Refuse);
        return new Result("0000", "活动审核拒绝完成");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        ActivityService.exectStatus(activityId, currentStatus, Status.Editing);
        return new Result("0000", "活动审核撤销回到编辑中");
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.exectStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动审核关闭完成");
    }

    @Override
    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }

    @Override
    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "待审核活动不可执行活动中变更");
    }
}
