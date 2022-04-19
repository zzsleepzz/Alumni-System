package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:50
 */
@Service
public class DonationManager {

    @Autowired
    private DonationService donationService;

}
