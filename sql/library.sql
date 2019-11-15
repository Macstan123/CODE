/*
 Navicat Premium Data Transfer

 Source Server         : xampp_mysql
 Source Server Type    : MySQL
 Source Server Version : 100138
 Source Host           : 127.0.0.1:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 100138
 File Encoding         : 65001

 Date: 06/06/2019 00:13:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_borrow
-- ----------------------------
DROP TABLE IF EXISTS `book_borrow`;
CREATE TABLE `book_borrow`  (
  `borrow_id` int(30) NOT NULL,
  `book_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `borrow_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`borrow_id`) USING BTREE,
  INDEX `book_isbn`(`book_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_borrow
-- ----------------------------
INSERT INTO `book_borrow` VALUES (1, '34567', '201603', '2019-02-01 23:34:30');
INSERT INTO `book_borrow` VALUES (2, '23456', '201745', '2018-12-14 23:35:29');
INSERT INTO `book_borrow` VALUES (3, '1234567890', '201714', '2019-06-04 21:13:36');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_saving` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Book name`(`book_name`) USING BTREE,
  INDEX `Book author`(`book_author`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES (1, 'adventure of wangxin', '1234567890', 'wangxin', 7);
INSERT INTO `book_info` VALUES (2, '356 day of wangxin', '23456', 'yanghui', 3);
INSERT INTO `book_info` VALUES (3, 'programming', '34567', 'Mark', 1);

-- ----------------------------
-- Table structure for lib_student
-- ----------------------------
DROP TABLE IF EXISTS `lib_student`;
CREATE TABLE `lib_student`  (
  `id` int(15) NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_dept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_break` int(1) NOT NULL DEFAULT 0,
  `user_pwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pwd`(`user_pwd`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lib_student
-- ----------------------------
INSERT INTO `lib_student` VALUES (1, '201711', '小美', '电子信息', 0, '234567');
INSERT INTO `lib_student` VALUES (2, '201712', '付铄雯', '计算机', 0, '123456');
INSERT INTO `lib_student` VALUES (3, '201713', '郭帆', '公共管理', 0, '345678');
INSERT INTO `lib_student` VALUES (4, '201714', '王辛', '计算机', 0, '123456');

SET FOREIGN_KEY_CHECKS = 1;
