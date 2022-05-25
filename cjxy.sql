/*
 Navicat Premium Data Transfer

 Source Server         : KJ
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : cjxy

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 18/05/2022 12:24:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS cjxy;
USE cjxy;

-- ----------------------------
-- Table structure for qinjia
-- ----------------------------
DROP TABLE IF EXISTS `qinjia`;
CREATE TABLE `qinjia`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `teachername` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `backDays` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `severalDays` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `days` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phoneNum` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `parentsPhoneNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `userNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `qinjia_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `isconsent` tinyint(1) NOT NULL,
  `isconsent2` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qinjia
-- ----------------------------
INSERT INTO `qinjia` VALUES (82, '数据信息学院', '软件技术', '软件2003', '老李', '生病', '2022-05-20', '2022-05-18', '2天', '44444444444', '55555555555', '蒯杰', '20204738', NULL, 0, 0);
INSERT INTO `qinjia` VALUES (83, 'zrm', 'zrm', 'zrm', 'zrm', 'zrm', '2022-05-22', '2022-05-18', '4天', '44444444444', '55555555555', '蒯杰', '20204738', NULL, 0, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(8) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `stu_userNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `stu_userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `stu_back01` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `stu_back02` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `stu_back03` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (53, '蒯杰', '20204738', '15935728qaz', NULL, NULL, NULL);
INSERT INTO `student` VALUES (54, '张润民', '20204738', '789456', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tea_id` int(8) NOT NULL AUTO_INCREMENT,
  `tea_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tea_userNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tea_userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tea_back01` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `tea_back02` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `tea_back03` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (2, '杨老师', '55555555', '123456', NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (4, '张三', '88888888', '456123', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
