package com.yuqi.alumnisystem.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.NoticeDto;
import com.yuqi.alumnisystem.entity.Notice;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.NoticeService;
import com.yuqi.alumnisystem.util.DateUtils;
import com.yuqi.alumnisystem.vo.CreateOrUpdateNoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:52
 */
@Service
public class NoticeManager {

    @Autowired
    private NoticeService noticeService;

    public NoticeDto detail(Long id) {
        Notice notice = noticeService.getByIdAndUserId(id, null);
        if (Objects.isNull(notice)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        NoticeDto dto = NoticeDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .time(notice.getTime())
                .build();
        return dto;
    }

    public Page<NoticeDto> list(Integer pageNo, Long userId) {
        return noticeService.listByUserId(pageNo, userId);
    }

    public Long createOrUpdate(CreateOrUpdateNoticeVo vo) {
        //todo 若业务需求公告名不可重复需要校验
        Notice notice = Notice.builder()
                .userId(vo.getUserId())
                .title(vo.getTitle())
                .content(vo.getContent())
                .time(DateUtils.StringToDate(vo.getTime()))
                .build();
        if(Objects.isNull(vo.getId())){
            //创建公告
            if (!noticeService.save(notice)) {
                throw new BusinessException(StatusEnum.CREATE_ACTIVITY_FAIL);
            }
            return notice.getId();
        } else {
            //修改公告
            if (Objects.isNull(noticeService.getByIdAndUserId(vo.getId(), vo.getUserId()))) {
                throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
            }
            if (!noticeService.updateById(notice)) {
                throw new BusinessException(StatusEnum.UPDATE_ACTIVITY_FAIL);
            }
            return vo.getId();
        }
    }

    public Boolean delete(Long id, Long userId) {
        Notice existNotice = noticeService.getByIdAndUserId(id, null);
        if (Objects.isNull(existNotice)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        existNotice.setDeleted(true);
        return noticeService.updateById(existNotice);
    }
}
