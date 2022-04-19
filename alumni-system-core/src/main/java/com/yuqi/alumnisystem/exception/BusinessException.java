package com.yuqi.alumnisystem.exception;

import com.yuqi.alumnisystem.enums.StatusEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:21
 */
@Data
public class BusinessException extends RuntimeException{

    public static final Integer DEFAULT_FAULT_CODE = -1;

    private Integer code;

    private String message;


    public BusinessException(String message) {
        this(DEFAULT_FAULT_CODE, message);
    }

    public BusinessException(Integer code, String message) {
        this(code, message, new Throwable());
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BusinessException(StatusEnum statusEnum) {
        super(new Throwable());
        this.code = statusEnum.getIndex();
        this.message = statusEnum.getDesc();
    }

    public BusinessException(StatusEnum statusEnum, Throwable cause) {
        super(statusEnum.getDesc(), cause);
        this.code = statusEnum.getIndex();
        this.message = statusEnum.getDesc();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
