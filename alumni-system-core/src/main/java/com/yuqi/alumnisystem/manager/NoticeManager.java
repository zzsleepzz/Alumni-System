package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:52
 */
@Service
public class NoticeManager {

    @Autowired
    private NoticeService noticeService;

}
