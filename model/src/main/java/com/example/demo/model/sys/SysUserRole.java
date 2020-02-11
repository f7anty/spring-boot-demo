package com.example.demo.model.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.model.BaseModel;
import lombok.Data;

@Data
public class SysUserRole extends BaseModel {

	@TableField(value="user_id")
	private Integer userId;

	@TableField(value="role_id")
	private Integer roleId;
}
