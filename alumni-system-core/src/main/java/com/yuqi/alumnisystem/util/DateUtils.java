package com.yuqi.alumnisystem.util;

import com.yuqi.alumnisystem.enums.StatusEnum;
import com.yuqi.alumnisystem.exception.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author yuexi.guo
 * @date 2022 20:17
 */
public class DateUtils {


    public static Date StringToDate(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = simpleDateFormat.parse(time);
            return date;
        } catch (ParseException e) {
            throw new BusinessException(StatusEnum.DATA_MAPPER_FAILED);
        }
    }

}
