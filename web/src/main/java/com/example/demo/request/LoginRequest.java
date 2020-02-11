package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginRequest {

    @NotEmpty(message = "登录名不能为空")
    private String loginId;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
