package com.example.demo.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.sys.SysUserMapper;
import com.example.demo.model.sys.SysUser;
import com.example.demo.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findByLoginId(String loginId) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("login_id",loginId));
    }

    @Override
    public List<String> queryPermissionByUserId(Integer userId) {
        return sysUserMapper.queryPermissionByUserId(userId);
    }
}
