package com.yuqi.alumnisystem.mapper;

import com.yuqi.alumnisystem.dto.ActivityDto;
import com.yuqi.alumnisystem.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【activity】的数据库操作Mapper
* @createDate 2022-04-19 19:15:12
* @Entity com.yuqi.alumnisystem.entity.Activity
*/
public interface ActivityMapper extends BaseMapper<Activity> {

    List<ActivityDto> listByUserId(@Param("userId") Long userId);

}




