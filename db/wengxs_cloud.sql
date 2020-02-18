/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : localhost:3306
 Source Schema         : wengxs_cloud

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 19/02/2020 00:20:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('wengxs', '', '$2a$10$u0bZmE3ncLZmbQnCshq1kOEp7nuu3fRQNkTHoSpfD1FnJIpOWHwz.', 'server', 'password,refresh_token', NULL, '', NULL, NULL, '{}', '');
INSERT INTO `oauth_client_details` VALUES ('wengxs1', '', '$2a$10$u0bZmE3ncLZmbQnCshq1kOEp7nuu3fRQNkTHoSpfD1FnJIpOWHwz.', 'server', 'password,refresh_token', NULL, '', NULL, NULL, '{}', '');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级ID',
  `name` varchar(32) NOT NULL COMMENT '菜单权限名称',
  `icon` varchar(128) DEFAULT NULL COMMENT '图标',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型（0菜单 1按钮）',
  `permission` varchar(128) DEFAULT NULL COMMENT '权限标识',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `path` varchar(255) DEFAULT NULL COMMENT '路径URL',
  `component` varchar(255) DEFAULT NULL COMMENT 'VUE页面组件',
  `keep_alive` varchar(255) DEFAULT NULL COMMENT '路由缓冲',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_type` (`type`) USING BTREE,
  CONSTRAINT `fk_sys_menu_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, NULL, '首页', NULL, 0, NULL, 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (5, 1, '用户管理', NULL, 0, 'admin:user:query', 0, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', '拥有最高级权限');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(11) NOT NULL,
  `menu_id` bigint(11) NOT NULL,
  KEY `idx_role_id` (`role_id`) USING BTREE,
  KEY `idx_menu_id` (`menu_id`) USING BTREE,
  CONSTRAINT `fk_sys_role_menu_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `fk_sys_role_menu_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 5);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `mobile` varchar(11) NOT NULL COMMENT '手机号',
  `is_enabled` int(11) NOT NULL DEFAULT '1' COMMENT '是否启用',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING BTREE,
  UNIQUE KEY `uk_mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$KjqyRR.64g9lqgCHIa5efebnyA.S8y4XqD1KYbJR3PHnXkyIJiAhC', '13800138000', 1, '2020-02-09 23:11:17', '');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `idx_user_id` (`role_id`) USING BTREE,
  KEY `idx_role_id` (`user_id`) USING BTREE,
  CONSTRAINT `fk_sys_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `fk_sys_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
