package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.manager.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:37
 */
@RestController
public class MessageController {

    @Autowired
    private MessageManager messageManager;

}
