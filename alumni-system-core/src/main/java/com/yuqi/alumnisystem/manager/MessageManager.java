package com.yuqi.alumnisystem.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuqi.alumnisystem.dto.MessageDto;
import com.yuqi.alumnisystem.entity.Message;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.MessageService;
import com.yuqi.alumnisystem.util.DateUtils;
import com.yuqi.alumnisystem.vo.CreateOrUpdateMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:51
 */
@Service
public class MessageManager {

    @Autowired
    private MessageService messageService;

    public MessageDto detail(Long id) {
        Message message = messageService.getByIdAndUserId(id, null);
        if (Objects.isNull(message)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        MessageDto dto = MessageDto.builder()
                .id(message.getId())
                .content(message.getContent())
                .time(message.getTime())
                .build();
        return dto;
    }

    public Page<MessageDto> list(Integer pageNo, Long userId) {
        return messageService.listByUserId(pageNo, userId);
    }

    public Long createOrUpdate(CreateOrUpdateMessageVo vo) {
        Message message = Message.builder()
                .userId(vo.getUserId())
                .content(vo.getContent())
                .time(DateUtils.StringToDate(vo.getTime()))
                .build();
        if(Objects.isNull(vo.getId())){
            //创建留言
            if (!messageService.save(message)) {
                throw new BusinessException(StatusEnum.CREATE_ACTIVITY_FAIL);
            }
            return message.getId();
        } else {
            //修改留言
            if (Objects.isNull(messageService.getByIdAndUserId(vo.getId(), vo.getUserId()))) {
                throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
            }
            if (!messageService.updateById(message)) {
                throw new BusinessException(StatusEnum.UPDATE_ACTIVITY_FAIL);
            }
            return vo.getId();
        }
    }

    public Boolean delete(Long id, Long userId) {
        Message existMessage = messageService.getByIdAndUserId(id, userId);
        if (Objects.isNull(existMessage)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        existMessage.setDeleted(true);
        return messageService.updateById(existMessage);
    }
}
