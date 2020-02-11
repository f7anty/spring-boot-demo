package com.example.demo.mapper.sys;

import com.example.demo.model.sys.SysUser;
import java.util.List;

public interface SysUserMapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<SysUser> {

    List<String> queryPermissionByUserId(Integer userId);
}
