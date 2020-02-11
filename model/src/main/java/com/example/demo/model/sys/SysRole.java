package com.example.demo.model.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.model.BaseModel;
import lombok.Data;

@Data
public class SysRole extends BaseModel {

	/**
	 * 角色名称
	 */
	@TableField(value="role_name")
	private String roleName;
	/**
	 * 角色类型
	 */
	private Integer roleType;
}
