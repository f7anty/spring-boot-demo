package com.example.demo.service.user;

import com.example.demo.model.sys.SysUser;

public interface LoginService {

    SysUser login(String loginId, String pwd);
}
