package com.yuqi.alumnisystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.AlumniDto;
import com.yuqi.alumnisystem.entity.Alumni;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【alumni】的数据库操作Mapper
* @createDate 2022-04-19 19:15:24
* @Entity com.yuqi.alumnisystem.entity.Alumni
*/
public interface AlumniMapper extends BaseMapper<Alumni> {

    List<AlumniDto> listByUserId(@Param("page") Page<AlumniDto> page, @Param("userId") Long userId);

}




