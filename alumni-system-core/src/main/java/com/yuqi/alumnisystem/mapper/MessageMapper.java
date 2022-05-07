package com.yuqi.alumnisystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.MessageDto;
import com.yuqi.alumnisystem.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【message】的数据库操作Mapper
* @createDate 2022-04-19 19:15:36
* @Entity com.yuqi.alumnisystem.entity.Message
*/
public interface MessageMapper extends BaseMapper<Message> {

    List<MessageDto> list(@Param("page") Page<MessageDto> page, @Param("userId") Long userId);
}




