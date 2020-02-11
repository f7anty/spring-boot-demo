package com.example.demo.model.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.model.BaseModel;
import lombok.Data;

@Data
public class SysMenu extends BaseModel {

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;
    /**
     * 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)
     */
    @TableField(value = "menu_type")
    private Integer menuType;
    /**
     * 上级菜单编号
     */
    @TableField(value = "parent_id")
    private Integer parentId;
    /**
     * 请求地址
     */
    @TableField(value = "request_url")
    private String requestUrl;
    /**
     * 排序号
     */
    @TableField(value = "sort_no")
    private Integer sortNo;
    /**
     * 菜单级别(1:一级菜单;2:二级菜单;3:三级菜单;)
     */
    private Integer level;
    /**
     * 权限标识
     */
    private String permission;
}
