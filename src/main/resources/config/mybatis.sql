/*
Navicat MySQL Data Transfer

Source Server         : GX
Source Server Version : 50636
Source Host           : 127.0.0.1:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2020-04-06 21:10:51
*/

DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE IF NOT EXISTS mybatis;

SHOW DATABASES;

USE mybatis;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(256) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'andrew', 'andrew', '1234567');
INSERT INTO `t_user` VALUES ('2', 'ylq', 'ylq', '1234567');
INSERT INTO `t_user` VALUES ('3', 'lxd', 'lxd', '1234567');