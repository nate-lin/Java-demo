/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : db_infosystem

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-08-29 13:31:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_grade`
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(20) DEFAULT NULL,
  `gradeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '19计本', '19计算机本科');
INSERT INTO `t_grade` VALUES ('2', '09计本', '09计算机本科');
INSERT INTO `t_grade` VALUES ('29', '17软件技术1班', '放假啦');

-- ----------------------------
-- Table structure for `t_interior`
-- ----------------------------
DROP TABLE IF EXISTS `t_interior`;
CREATE TABLE `t_interior` (
  `interiorId` int(11) NOT NULL AUTO_INCREMENT,
  `interiorNo` varchar(20) DEFAULT NULL,
  `interiorName` varchar(10) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `tentry` date DEFAULT NULL,
  `localId` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `interiorCheck` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`interiorId`),
  KEY `FK_t_student` (`localId`),
  CONSTRAINT `t_interior_ibfk_1` FOREIGN KEY (`localId`) REFERENCES `t_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_interior
-- ----------------------------
INSERT INTO `t_interior` VALUES ('2', '080606110', '张555', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('4', '080606110', '张四', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('5', '080606110', '张四', '女', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('9', '08060611011', '张四', '男', '1989-11-03', '1', '31321@qq.com', 'Good111');
INSERT INTO `t_interior` VALUES ('10', '080606110', '张四', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('11', '080606110', '张四', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('12', '080606110', '张四', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('13', '080606110', '张四', '男', '1988-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('14', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('15', '080606110', '张四', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('16', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('17', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_interior` VALUES ('18', '090606119', '王小美', '女', '1990-11-03', '1', '3112121@qq.com', 'Good Girls11');
INSERT INTO `t_interior` VALUES ('19', '090606119', '王小美', '女', '1990-11-03', '2', '3112121@qq.com', 'Good Girls');
INSERT INTO `t_interior` VALUES ('20', '090606119', '王小美', '女', '1990-11-03', '1', '3112121@qq.com', 'Good Girls');
INSERT INTO `t_interior` VALUES ('21', '090606119', '王小美', '女', '1990-11-03', '2', '3112121@qq.com', '张红');
INSERT INTO `t_interior` VALUES ('28', '111111', '曹小小', '女', '2013-05-30', '1', '111321@11.com', '312111\r\n112232');

-- ----------------------------
-- Table structure for `t_local`
-- ----------------------------
DROP TABLE IF EXISTS `t_local`;
CREATE TABLE `t_local` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `localName` varchar(20) DEFAULT NULL,
  `localCheck` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_local
-- ----------------------------
INSERT INTO `t_local` VALUES ('1', '17j计应1班', '全勤115');
INSERT INTO `t_local` VALUES ('2', '17软件技术3班', '张三缺课4节\r\n');
INSERT INTO `t_local` VALUES ('29', '17软件技术4班', '实习');
INSERT INTO `t_local` VALUES ('32', '18工程技术1班', '全勤');
INSERT INTO `t_local` VALUES ('33', '18软件技术2班', '在家上网课');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(20) DEFAULT NULL,
  `stuName` varchar(10) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `stuDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  KEY `FK_t_student` (`gradeId`),
  CONSTRAINT `FK_t_student` FOREIGN KEY (`gradeId`) REFERENCES `t_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('5', '080606110', '张三', '女', '1989-11-16', '1', '31321@qq.com', '女生17人，男34人');
INSERT INTO `t_student` VALUES ('9', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('10', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('11', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('13', '080606110', '张三', '男', '1988-11-03', '1', '1724342055@qq.com', '222');
INSERT INTO `t_student` VALUES ('14', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('15', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('16', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('17', '080606110', '张三', '男', '1989-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('18', '090606119', '王小美', '女', '1990-11-03', '1', '3112121@qq.com', 'Good Girls11');
INSERT INTO `t_student` VALUES ('20', '090606119', '王小美', '女', '1990-11-03', '1', '3112121@qq.com', 'Good Girls');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1');
INSERT INTO `t_user` VALUES ('2', '2', '2');
INSERT INTO `t_user` VALUES ('3', '11', '11');
INSERT INTO `t_user` VALUES ('4', '22', '22');
INSERT INTO `t_user` VALUES ('5', '111', '111');
INSERT INTO `t_user` VALUES ('6', '111', '11');
INSERT INTO `t_user` VALUES ('7', '11', '11');
INSERT INTO `t_user` VALUES ('8', '1111', '1');
INSERT INTO `t_user` VALUES ('9', '33', '3');
INSERT INTO `t_user` VALUES ('10', '1112', '22');
INSERT INTO `t_user` VALUES ('11', '123', '1');
INSERT INTO `t_user` VALUES ('12', '11123', '1');
INSERT INTO `t_user` VALUES ('13', '23', '3');
INSERT INTO `t_user` VALUES ('14', '336', '3');
INSERT INTO `t_user` VALUES ('15', '55', '55');
INSERT INTO `t_user` VALUES ('16', '14', '14');
INSERT INTO `t_user` VALUES ('17', '12345', '1');
INSERT INTO `t_user` VALUES ('18', '15', '1');
INSERT INTO `t_user` VALUES ('19', '19', '1');
INSERT INTO `t_user` VALUES ('20', '16', '1');
