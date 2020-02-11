package com.example.demo.exception;

import com.example.demo.enums.BusinessExceptionEnum;
import lombok.Getter;

public class BusinessException extends RuntimeException {

    @Getter
    private String code;

    public BusinessException(String message) {
        super(message);
        this.code = message;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.code = message;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getMessage());
        this.code = businessExceptionEnum.getCode();
    }
}
