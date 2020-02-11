package com.example.demo.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {

    private boolean success = true;
    private String code;
    private T message;

    public BaseResponse(){}

    public BaseResponse(boolean success,String code, T message) {
        this.success=success;
        this.code = code;
        this.message = message;
    }

}
