package com.example.demo.util;

import com.example.demo.model.sys.SysUser;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    public static Integer getCurrentUser(){
        SysUser sysUser= (SysUser) SecurityUtils.getSubject().getPrincipal();
        return sysUser.getId();
    }
}
