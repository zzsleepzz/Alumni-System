package com.yuqi.alumnisystem.controller;

import com.yuqi.alumnisystem.manager.DonationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuexi.guo
 * @date 2022/4/19 17:36
 */
@RestController
public class DonationController {

    @Autowired
    private DonationManager donationManager;

}
