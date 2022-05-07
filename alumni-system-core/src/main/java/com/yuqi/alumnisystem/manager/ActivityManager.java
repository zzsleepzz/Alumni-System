package com.yuqi.alumnisystem.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuqi.alumnisystem.dto.ActivityDto;
import com.yuqi.alumnisystem.entity.Activity;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.ActivityService;
import com.yuqi.alumnisystem.util.DateUtils;
import com.yuqi.alumnisystem.vo.CreateOrUpdateActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:49
 */
@Service
public class ActivityManager {

    @Autowired
    private ActivityService activityService;

    /**
     * 活动详情
     * @param id
     * @return ActivityDto
     */
    public ActivityDto detail(Long id){
        Activity activity = activityService.getByIdAndUserId(id, null);
        if (Objects.isNull(activity)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        ActivityDto dto = ActivityDto.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .content(activity.getContent())
                .time(activity.getTime())
                .build();
        return dto;
    }

    /**
     * 活动列表
     * @param userId
     * @return List<ActivityDto>
     */
    public List<ActivityDto> list(Long userId){
        return activityService.listByUserId(userId);
    }

    /**
     * 创建或修改活动
     * @param vo
     * @return Long
     */
    public Long createOrUpdate(CreateOrUpdateActivityVo vo) {
        //todo 若业务需求活动名不可重复需要校验（所有活动名不可重复或该用户创建的活动名不可重复）
        Activity activity = Activity.builder()
                .title(vo.getTitle())
                .userId(vo.getUserId())
                .content(vo.getContent())
                .time(DateUtils.StringToDate(vo.getTime()))
                .build();
        if(Objects.isNull(vo.getId())){
            //创建活动
            if (!activityService.save(activity)) {
                throw new BusinessException(StatusEnum.CREATE_ACTIVITY_FAIL);
            }
            return activity.getId();
        } else {
            //修改活动
            if (Objects.isNull(activityService.getByIdAndUserId(vo.getId(), vo.getUserId()))) {
                throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
            }
            QueryWrapper<Activity> queryWrapper = new QueryWrapper(Activity.builder()
                    .id(vo.getId())
                    .deleted(false)
                    .build());
            if (!activityService.update(activity, queryWrapper)) {
                throw new BusinessException(StatusEnum.UPDATE_ACTIVITY_FAIL);
            }
            return vo.getId();
        }
    }

    /**
     * 删除活动
     * @param id
     * @param userId
     * @return Boolean
     */
    public Boolean delete(Long id, Long userId) {
        Activity existActivity = activityService.getByIdAndUserId(id, null);
        if (Objects.isNull(existActivity)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
//        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>(Activity.builder()
//                .id(id)
//                .userId(userId)
//                .deleted(false)
//                .build());
        existActivity.setDeleted(true);
        return activityService.updateById(existActivity);
    }
}
