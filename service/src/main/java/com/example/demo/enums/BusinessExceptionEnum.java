package com.example.demo.enums;

public enum BusinessExceptionEnum {

    USER_NOT_LOGIN("10009","用户名未登录"),
    USER_NOT_EXIST("10010","用户名不存在"),
    USER_IS_DISABLED("10011","用户名已禁用"),
    USER_NAME_OR_PASSWORD_ERROR("10012","用户名或密码错误"),
    USER_RETRY_OVER_LIMIT("10013","超过重试次数"),
    LOGIN_FAILED("10014","登录失败")
    ;

    private String code;
    private String message;

    BusinessExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
    @Override
    public String toString() {
        return this.message;
    }
}
