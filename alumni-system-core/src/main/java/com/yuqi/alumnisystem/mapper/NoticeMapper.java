package com.yuqi.alumnisystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.NoticeDto;
import com.yuqi.alumnisystem.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【notice】的数据库操作Mapper
* @createDate 2022-04-19 19:15:40
* @Entity com.yuqi.alumnisystem.entity.Notice
*/
public interface NoticeMapper extends BaseMapper<Notice> {

    List<NoticeDto> list(@Param("page") Page<NoticeDto> page, @Param("userId") Long userId);
}




