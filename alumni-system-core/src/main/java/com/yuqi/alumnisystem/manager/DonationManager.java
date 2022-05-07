package com.yuqi.alumnisystem.manager;

import com.yuqi.alumnisystem.dto.DonationDto;
import com.yuqi.alumnisystem.entity.Donation;
import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;
import com.yuqi.alumnisystem.service.DonationService;
import com.yuqi.alumnisystem.util.DateUtils;
import com.yuqi.alumnisystem.vo.CreateOrUpdateDonationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:50
 */
@Service
public class DonationManager {

    @Autowired
    private DonationService donationService;

    public DonationDto detail(Long id) {
        Donation donation = donationService.getByIdAndUserId(id, null);
        if (Objects.isNull(donation)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        DonationDto dto = DonationDto.builder()
                .id(donation.getId())
                .name(donation.getName())
                .value(donation.getValue())
                .time(donation.getTime())
                .build();
        return dto;
    }

    public List<DonationDto> list(Long userId) {
        return donationService.listByUserId(userId);
    }

    public Long createOrUpdate(CreateOrUpdateDonationVo vo) {
        Donation donation = Donation.builder()
                .userId(vo.getUserId())
                .name(vo.getName())
                .value(vo.getValue())
                .time(DateUtils.StringToDate(vo.getTime()))
                .build();
        if(Objects.isNull(vo.getId())){
            //创建捐款记录
            if (!donationService.save(donation)) {
                throw new BusinessException(StatusEnum.CREATE_ACTIVITY_FAIL);
            }
            return donation.getId();
        } else {
            //修改捐款记录
            if (Objects.isNull(donationService.getByIdAndUserId(vo.getId(), vo.getUserId()))) {
                throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
            }
            if (!donationService.updateById(donation)) {
                throw new BusinessException(StatusEnum.UPDATE_ACTIVITY_FAIL);
            }
            return vo.getId();
        }
    }

    public Boolean delete(Long id, Long userId) {
        Donation existDonation = donationService.getByIdAndUserId(id, userId);
        if (Objects.isNull(existDonation)) {
            throw new BusinessException(StatusEnum.DATA_NOT_EXIST);
        }
        existDonation.setDeleted(true);
        return donationService.updateById(existDonation);
    }
}
