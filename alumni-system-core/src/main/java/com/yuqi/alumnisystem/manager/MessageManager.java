package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:51
 */
@Service
public class MessageManager {

    @Autowired
    private MessageService messageService;

}
