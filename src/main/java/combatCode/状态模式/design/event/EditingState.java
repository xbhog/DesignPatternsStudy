package combatCode.状态模式.design.event;

import combatCode.状态模式.design.ActivityService;
import combatCode.状态模式.design.Result;
import combatCode.状态模式.design.State;
import combatCode.状态模式.design.Status;

/**
 * @author xbhog
 * @describe:活动状态；编辑中
 * @date 2022/9/11
 */
public class EditingState extends State {
    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        ActivityService.exectStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "活动提审成功");
    }
    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可审核通过");
    }
    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可撤销审核");
    }
    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.exectStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭成功");
    }
    @Override
    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }
    @Override
    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中活动不可执行活动中变更");
    }

}
