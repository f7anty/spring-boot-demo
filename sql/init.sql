/*
 Navicat Premium Data Transfer

 Source Server         : local_con
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/02/2020 16:18:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
    `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
    `menu_type` tinyint(1) DEFAULT '2' COMMENT '菜单类型(0:CURD;1:系统菜单;2:业务菜单;)',
    `parent_id` int DEFAULT NULL COMMENT '上级菜单编号',
    `request_url` varchar(100) DEFAULT NULL COMMENT '请求地址',
    `sort_no` int DEFAULT NULL COMMENT '排序号',
    `level` tinyint(1) NOT NULL DEFAULT '1' COMMENT '菜单级别(1:一级菜单;2:二级菜单;3:三级菜单;)',
    `permission` varchar(50) DEFAULT NULL COMMENT '权限标识',
    `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
    `del_flg` tinyint(1) DEFAULT '1',
    `create_by` int NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_by` int NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_menu_name` (`menu_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '系统管理', 1, NULL, NULL, NULL, 1, 'sys', NULL, 1, 0, '2020-02-11 11:44:42', 0, '2020-02-11 11:44:42');
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, 1, NULL, NULL, 1, 'sysUser', NULL, 1, 0, '2020-02-11 11:46:18', 0, '2020-02-11 11:46:18');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '角色编号',
    `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
    `role_type` int NOT NULL DEFAULT '1' COMMENT '角色类型(1:业务角色;2:管理角色 ;3:系统内置角色)',
    `del_flg` tinyint(1) NOT NULL DEFAULT '1',
    `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
    `create_by` int NOT NULL DEFAULT '0' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_by` int NOT NULL DEFAULT '0' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, 'admin', 1, 1, NULL, 0, '2020-02-11 11:39:47', 0, '2020-02-11 11:39:47');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
     `id` int NOT NULL AUTO_INCREMENT,
     `role_id` int NOT NULL,
     `menu_id` int NOT NULL,
     `permission` varchar(50) NOT NULL COMMENT '权限标识',
     `del_flg` tinyint(1) NOT NULL DEFAULT '1',
     `remark` varchar(1024) DEFAULT NULL,
     `create_by` int NOT NULL DEFAULT '0' COMMENT '创建者',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
     `update_by` int NOT NULL DEFAULT '0' COMMENT '更新者',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`),
     UNIQUE KEY `sys_role_menu_key1` (`role_id`,`menu_id`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色授权表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 1, 2, 'add', 1, NULL, 0, '2020-02-11 11:40:12', 0, '2020-02-11 11:40:12');
INSERT INTO `sys_role_menu` VALUES (2, 1, 2, 'view', 1, NULL, 0, '2020-02-11 15:45:16', 0, '2020-02-11 15:45:16');
INSERT INTO `sys_role_menu` VALUES (3, 1, 2, 'del', 1, NULL, 0, '2020-02-11 15:45:28', 0, '2020-02-11 15:45:28');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `login_id` varchar(20) DEFAULT NULL COMMENT '登陆帐户',
    `password` varchar(50) DEFAULT NULL COMMENT '密码',
    `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
    `phone` varchar(50) DEFAULT NULL COMMENT '电话',
    `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
    `address` varchar(256) DEFAULT NULL COMMENT '详细地址',
    `status` tinyint(1) DEFAULT '1' COMMENT '0:禁用， 1: 启用',
    `del_flg` tinyint(1) DEFAULT '1',
    `remark` varchar(1024) DEFAULT NULL,
    `create_time` datetime NOT NULL,
    `create_by` int NOT NULL DEFAULT '0' COMMENT '创建者',
    `update_time` datetime NOT NULL,
    `update_by` int NOT NULL DEFAULT '0' COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'lenka', NULL, NULL, NULL, 1, 1, NULL, '2020-02-07 12:56:44', 0, '2020-02-07 12:56:49', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
     `id` int NOT NULL AUTO_INCREMENT,
     `user_id` int NOT NULL,
     `role_id` int NOT NULL,
     `del_flg` tinyint(1) NOT NULL DEFAULT '1',
     `remark` varchar(1024) DEFAULT NULL,
     `create_by` int NOT NULL DEFAULT '0' COMMENT '创建者',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
     `update_by` int NOT NULL DEFAULT '0' COMMENT '更新者',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户授权表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1, 1, 1, NULL, 0, '2020-02-11 11:39:33', 0, '2020-02-11 11:39:33');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
