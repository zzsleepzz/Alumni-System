package com.yuqi.alumnisystem.config;

import com.yuqi.alumnisystem.dto.SimpleResponse;
import com.yuqi.alumnisystem.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yuexi.guo
 * @date 2022/4/19 18:17
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public SimpleResponse handlerBusinessException(HttpServletResponse response , BusinessException ex){
        log.error("自定义业务异常:{}", ex);
        return SimpleResponse.error(ex.getCode(), ex.getMessage());
    }

}
