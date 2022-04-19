package com.yuqi.alumnisystem.dto;

import lombok.Data;

/**
 * @author yuexi.guo
 * @date 2022/4/19 19:33
 */
@Data
public class SimpleResponse<T> {

    private Boolean status = true;

    private Integer code;

    private String message;

    private T data;

    public SimpleResponse() {
        this.code = 0;
        this.message = "成功";
    }

    public SimpleResponse(T data) {
        this.setData(data);
        this.code = 0;
        this.message = "成功";
    }


    public SimpleResponse(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> SimpleResponse<T> error(Integer code, String msg) {
        SimpleResponse<T> response = new SimpleResponse();
        response.setCode(code);
        response.setMessage(msg);
        response.setStatus(Boolean.FALSE);
        return response;
    }
}
