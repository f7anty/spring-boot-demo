package com.example.demo.model.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.model.BaseModel;
import lombok.Data;

@Data
public class SysUser extends BaseModel {

    @TableField(value="login_id")
    private String loginId;

    @TableField(value="user_name")
    private String userName;

    @TableField(value="password")
    private String password;

    @TableField(value="phone")
    private String phone;

    @TableField(value="email")
    private String email;

    @TableField(value="address")
    private String address;

    /**
     * 用户状态,0 禁用 1 启用
     */
    @TableField(value="status")
    private Integer status;
}