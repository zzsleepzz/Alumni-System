package com.yuqi.alumnisystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqi.alumnisystem.entity.Donation;
import com.yuqi.alumnisystem.service.DonationService;
import com.yuqi.alumnisystem.mapper.DonationMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【donation】的数据库操作Service实现
* @createDate 2022-04-19 19:15:27
*/
@Service
public class DonationServiceImpl extends ServiceImpl<DonationMapper, Donation>
    implements DonationService{

}




