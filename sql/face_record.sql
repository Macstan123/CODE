/*
 Navicat Premium Data Transfer

 Source Server         : xampp_mysql
 Source Server Type    : MySQL
 Source Server Version : 100138
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100138
 File Encoding         : 65001

 Date: 06/06/2019 00:13:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for face_infor
-- ----------------------------
DROP TABLE IF EXISTS `face_infor`;
CREATE TABLE `face_infor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `face_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of face_infor
-- ----------------------------
INSERT INTO `face_infor` VALUES (1, '7a39809cd461d39d58cc9b96fc899e43', 'guofan', 'C:\\\\Users\\\\王辛\\\\Desktop\\\\研究开发实践\\\\代码\\\\view1\\\\registerpic\\\\2.png', '201713');
INSERT INTO `face_infor` VALUES (2, '1794c20658afa5e1affe04a706604b4f', 'wangxin', 'C:\\\\Users\\\\王辛\\\\Desktop\\\\研究开发实践\\\\代码\\\\view1\\\\registerpic\\\\1.jpg', '201714');
INSERT INTO `face_infor` VALUES (3, '28ffdcc8b1736aa7018149167844eafb', 'fushuowen', 'C:\\\\Users\\\\王辛\\\\Desktop\\\\研究开发实践\\\\代码\\\\view1\\\\registerpic\\\\1.jpg', '201715');

SET FOREIGN_KEY_CHECKS = 1;
