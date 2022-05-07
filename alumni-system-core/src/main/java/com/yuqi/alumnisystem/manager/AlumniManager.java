package com.yuqi.alumnisystem.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.AlumniDto;
import com.yuqi.alumnisystem.entity.Alumni;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.AlumniService;
import com.yuqi.alumnisystem.vo.CreateOrUpdateAlumniVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:50
 */
@Service
public class AlumniManager {

    @Autowired
    private AlumniService alumniService;

    /**
     * 优秀校友信息详情
     * @param id
     * @return AlumniDto
     */
    public AlumniDto detail(Long id) {
        Alumni alumni = alumniService.getByIdAndUserId(id, null);
        AlumniDto dto = AlumniDto.builder()
                .name(alumni.getName())
                .description(alumni.getDescription())
                .url(alumni.getUrl())
                .build();
        return dto;
    }

    /**
     * 优秀校友信息列表
     * @return List<AlumniDto>
     */
    public Page<AlumniDto> listByUserId(Integer pageNo, Long userId) {
        return alumniService.listByUserId(pageNo, userId);
    }

    /**
     * 创建或修改优秀校友信息
     * @param vo
     * @return Long
     */
    public Long createOrUpdate(CreateOrUpdateAlumniVo vo) {
        Alumni alumni = Alumni.builder()
                .userId(vo.getUserId())
                .name(vo.getName())
                .description(vo.getDescription())
                .url(vo.getUrl())
                .build();
        if (Objects.isNull(vo.getId())) {
            if (!alumniService.save(alumni)) {
                throw new BusinessException(StatusEnum.CREATE_ALUMNI_FAIL);
            }
            return alumni.getId();
        } else {
            if (Objects.isNull(alumniService.getByIdAndUserId(vo.getId(), vo.getUserId()))){
                throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
            }
//            QueryWrapper<Alumni> queryWrapper = new QueryWrapper<>(Alumni.builder()
//                    .id(vo.getId())
//                    .deleted(false)
//                    .build());
            if (!alumniService.updateById(alumni)) {
                throw new BusinessException(StatusEnum.UPDATE_ALUMNI_FAIL);
            }
            return vo.getId();
        }
    }

    /**
     * 删除优秀校友信息
     * @param id
     * @param userId
     * @return Boolean
     */
    public Boolean delete(Long id, Long userId) {
        Alumni existAlumni = alumniService.getByIdAndUserId(id, userId);
        if (Objects.isNull(existAlumni)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
//        QueryWrapper<Alumni> queryWrapper = new QueryWrapper<>(Alumni.builder()
//                .id(id)
//                .userId(userId)
//                .deleted(false)
//                .build());
        existAlumni.setDeleted(true);
        return alumniService.updateById(existAlumni);
    }
}
