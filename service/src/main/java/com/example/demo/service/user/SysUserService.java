package com.example.demo.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.sys.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {

    SysUser findByLoginId(String loginId);

    List<String> queryPermissionByUserId(Integer userId);
}
