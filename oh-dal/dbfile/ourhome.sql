/*
 Navicat Premium Data Transfer

 Source Server         : ourhome
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : ourhome

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/05/2019 22:23:48
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oh_login_info
-- ----------------------------
DROP TABLE IF EXISTS `oh_login_info`;
CREATE TABLE `oh_login_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `creator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `updater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新人',
  `update_date` datetime(0) NOT NULL COMMENT '更新时间',
  `is_deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否删除',
  `login_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `login_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_login_num`(`login_num`) USING BTREE COMMENT '登录账号索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oh_user_info
-- ----------------------------
DROP TABLE IF EXISTS `oh_user_info`;
CREATE TABLE `oh_user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `creator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `updater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新人',
  `update_date` datetime(0) NOT NULL COMMENT '更新时间',
  `is_deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否删除',
  `login_id` bigint(20) NOT NULL COMMENT '登录信息ID',
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '姓名',
  `birthday` date NOT NULL COMMENT '生日',
  `identity_id` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '身份证号码',
  `phone_num` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '邮箱',
  `country_id` bigint(20) NOT NULL COMMENT '国家ID',
  `province_id` bigint(20) NOT NULL COMMENT '省份ID',
  `city_id` bigint(20) NOT NULL COMMENT '城市ID',
  `address` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '详细地址',
  `portrait_url` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_phone_num`(`phone_num`) USING BTREE,
  INDEX `idx_user_login_id`(`login_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
