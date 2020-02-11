package com.example.demo.model.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.model.BaseModel;
import lombok.Data;

@Data
public class SysRoleMenu extends BaseModel {

	@TableField(value="role_id")
	private Integer roleId;

	@TableField(value="menu_id")
	private Integer menuId;
	/**
	 * 权限标识
	 */
	@TableField(value="permission")
	private String permission;
}
