/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : rj1

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-08-29 14:19:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department` varchar(50) DEFAULT NULL,
  `num` int(20) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `crtm` datetime DEFAULT NULL,
  `mdtm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事部', '5', '招聘员工', null, null);
INSERT INTO `department` VALUES ('2', '经理部', '3', '管理员工', null, null);
INSERT INTO `department` VALUES ('3', '销售部', '10', '销售业务', null, null);
INSERT INTO `department` VALUES ('4', '运营部', '15', '运营项目', null, null);
INSERT INTO `department` VALUES ('5', '财经部', '15', '管理财务', null, '2019-10-14 18:57:24');

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ogid` int(11) DEFAULT NULL COMMENT '组织机构id',
  `dtid` int(11) DEFAULT NULL COMMENT '设备类型id',
  `code` varchar(11) DEFAULT NULL COMMENT '设备流水号',
  `residual` decimal(16,2) DEFAULT NULL COMMENT '净残值',
  `original` decimal(16,2) DEFAULT NULL COMMENT '原值',
  `status` decimal(2,0) DEFAULT NULL COMMENT '状态 1-入库、2-出库中、3-出库、4-领用、5-报修',
  `proddate` date DEFAULT NULL COMMENT '生产日期',
  `creator` int(11) DEFAULT NULL COMMENT '登记人',
  `createtime` datetime DEFAULT NULL COMMENT '登记时间',
  `buyer` int(11) DEFAULT NULL COMMENT '购买人',
  `bugdate` date DEFAULT NULL COMMENT '购买日期',
  `sno` varchar(32) DEFAULT NULL COMMENT '序列号',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='设备明细';

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('5', '1', '1', 'S20190002', '200.00', '300.00', '1', '2019-10-05', '2', '2019-10-31 00:00:00', '1', '2019-10-24', 'SL20190005', null, null);
INSERT INTO `device` VALUES ('11', '1', '1', 'S20190008', '23.00', '23.00', '1', '2019-10-25', '2', '2019-10-12 00:00:00', '2', '2019-10-29', 'SL20190004', null, null);
INSERT INTO `device` VALUES ('12', '0', '0', 'S20190009', '1.00', '1.00', '1', '2017-10-10', '2', '2017-11-11 00:00:00', '1', '2017-11-12', 'DJS20190005', '2019-12-10 15:56:16', '2019-12-10 15:56:16');
INSERT INTO `device` VALUES ('13', '1', '10', 'S20190010', '1.00', '1.00', '1', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190006', '2019-12-10 15:56:59', '2019-12-10 15:56:59');
INSERT INTO `device` VALUES ('14', '1', '3', 'S20190011', '1.00', '1.00', '1', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190007', '2019-12-10 15:57:22', '2019-12-10 15:57:22');
INSERT INTO `device` VALUES ('15', '1', '2', 'S20190012', '1.00', '1.00', '2', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190008', '2019-12-10 16:00:09', '2019-12-10 16:00:09');
INSERT INTO `device` VALUES ('16', '1', '2', 'S20190013', '1.00', '11.00', '1', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190009', '2019-12-10 16:05:38', '2019-12-10 16:05:38');
INSERT INTO `device` VALUES ('17', '1', '2', 'S20190014', '1.00', '11.00', '3', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190010', '2019-12-10 16:05:59', '2019-12-10 16:05:59');
INSERT INTO `device` VALUES ('18', '1', '2', 'S20190015', '1.00', '1.00', '4', '2017-10-10', '1', '2017-11-11 00:00:00', '2', '2017-12-11', 'DJS20190011', '2019-12-10 16:06:24', '2019-12-10 16:06:24');
INSERT INTO `device` VALUES ('19', '1', '7', 'S20190016', '1.00', '1.00', '5', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190012', '2019-12-10 16:06:42', '2019-12-10 16:06:42');
INSERT INTO `device` VALUES ('20', '1', '2', 'S20190017', '1.00', '1.00', '4', '2017-10-10', '1', '2017-11-11 00:00:00', '1', '2017-12-11', 'DJS20190013', '2019-12-10 16:07:00', '2019-12-10 16:07:00');
INSERT INTO `device` VALUES ('21', '1', '3', 'S20190018', '11.00', '1.00', '2', '2017-10-10', '1', '2017-11-11 00:00:00', '3', '2017-12-11', 'DJS20190014', '2019-12-10 16:17:38', '2019-12-10 16:17:38');
INSERT INTO `device` VALUES ('22', '2', '2', 'S20190019', '22.00', '22.00', '1', '2017-10-10', '0', '2017-11-11 00:00:00', '0', '2017-12-11', 'DJS20190015', '2019-12-10 16:19:13', '2019-12-10 16:19:13');

-- ----------------------------
-- Table structure for `devicereceive`
-- ----------------------------
DROP TABLE IF EXISTS `devicereceive`;
CREATE TABLE `devicereceive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '设备id',
  `code` varchar(15) DEFAULT NULL COMMENT '单据号',
  `recipients` int(5) DEFAULT NULL COMMENT '领用人',
  `receivedate` datetime DEFAULT NULL COMMENT '领取时间',
  `returndate` datetime DEFAULT NULL COMMENT '归还日期',
  `status` decimal(2,0) DEFAULT NULL COMMENT '状态 1-领用、2-归还',
  `rcremarks` varchar(200) DEFAULT NULL COMMENT '领用备注',
  `rtremarks` varchar(200) DEFAULT NULL COMMENT '归还备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='设备领用表';

-- ----------------------------
-- Records of devicereceive
-- ----------------------------
INSERT INTO `devicereceive` VALUES ('18', '5', 'DJS20190009', '1', '2016-11-11 00:00:00', '2107-06-03 00:00:00', '2', '145', '999', '2019-12-06 15:44:01', '2019-12-10 16:01:43');
INSERT INTO `devicereceive` VALUES ('19', '5', 'DJS20190010', '1', '2012-11-05 00:00:00', null, '1', '1s', null, '2019-12-06 15:52:52', '2019-12-06 15:52:52');
INSERT INTO `devicereceive` VALUES ('20', '11', 'DJS20190011', '1', '2016-11-18 00:00:00', '2017-12-03 00:00:00', '2', '3333', '--', '2019-12-06 15:54:20', '2019-12-10 15:58:57');
INSERT INTO `devicereceive` VALUES ('26', '11', 'DJS20190017', '2', '2016-11-05 00:00:00', '2017-05-06 00:00:00', '2', '366', '999', '2019-12-10 15:45:25', '2019-12-10 16:16:51');
INSERT INTO `devicereceive` VALUES ('27', '5', 'DJS20190018', '2', '2016-11-05 00:00:00', null, '1', '33', null, '2019-12-10 15:59:43', '2019-12-10 15:59:43');
INSERT INTO `devicereceive` VALUES ('28', '11', 'DJS20190019', '1', '2016-11-05 00:00:00', null, '1', '888', null, '2019-12-10 16:01:00', '2019-12-10 16:01:00');
INSERT INTO `devicereceive` VALUES ('29', '11', 'DJS20190020', '1', '2016-11-05 00:00:00', null, '1', '66', null, '2019-12-10 16:02:04', '2019-12-10 16:02:04');
INSERT INTO `devicereceive` VALUES ('30', '15', 'DJS20190021', '1', '2016-11-05 00:00:00', null, '1', '366', null, '2019-12-10 16:02:14', '2019-12-10 16:02:14');
INSERT INTO `devicereceive` VALUES ('31', '14', 'DJS20190022', '1', '2016-11-05 00:00:00', null, '1', '366', null, '2019-12-10 16:02:22', '2019-12-10 16:02:22');
INSERT INTO `devicereceive` VALUES ('32', '5', 'DJS20190023', '2', '2016-11-05 00:00:00', null, '1', '6666', null, '2019-12-10 16:02:33', '2019-12-10 16:02:33');
INSERT INTO `devicereceive` VALUES ('33', '15', 'DJS20190024', '1', '2016-12-05 00:00:00', null, '1', '99999999999', null, '2019-12-10 16:02:41', '2019-12-10 16:02:41');

-- ----------------------------
-- Table structure for `devicerepair`
-- ----------------------------
DROP TABLE IF EXISTS `devicerepair`;
CREATE TABLE `devicerepair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '设备id',
  `damager` int(11) DEFAULT NULL COMMENT '报修人',
  `damagedate` datetime DEFAULT NULL COMMENT '报修时间',
  `damageremarks` varchar(200) DEFAULT NULL COMMENT '报修备注',
  `repairdate` datetime DEFAULT NULL COMMENT '维修时间',
  `repairer` int(11) DEFAULT NULL COMMENT '维修人',
  `repairremarks` varchar(200) DEFAULT NULL COMMENT '维修备注',
  `status` decimal(1,0) DEFAULT NULL COMMENT '状态 1-报修、2-维修',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='设备维修表';

-- ----------------------------
-- Records of devicerepair
-- ----------------------------
INSERT INTO `devicerepair` VALUES ('1', '5', '1', '1885-11-25 23:54:17', '1232', '2019-12-14 00:00:00', '1', '66', '2', '2019-11-26 17:25:33', '2019-12-08 22:20:08');
INSERT INTO `devicerepair` VALUES ('2', '5', '1', '1888-02-18 23:54:17', '坏了', '1888-01-19 23:54:17', '1', '维修好', '2', '2019-11-25 19:38:47', '2019-12-08 22:36:27');
INSERT INTO `devicerepair` VALUES ('3', '0', '1', '1899-02-14 23:54:17', '看', '1888-01-15 23:54:17', '1', '123465', '2', '2019-11-25 19:42:06', '2019-12-10 16:12:49');
INSERT INTO `devicerepair` VALUES ('4', '0', '2', '2019-11-05 00:00:00', '322', '2019-11-09 00:00:00', '2', '258', '2', null, '2019-12-10 16:11:31');
INSERT INTO `devicerepair` VALUES ('5', '13', '1', '2019-11-05 00:00:00', '11', null, null, null, '1', '2019-12-07 00:26:13', '2019-12-10 16:11:48');
INSERT INTO `devicerepair` VALUES ('6', '15', '1', '1885-11-28 23:54:17', '322', null, null, null, '1', '2019-12-07 00:28:10', '2019-12-10 16:12:00');
INSERT INTO `devicerepair` VALUES ('7', '13', '2', '2019-11-05 00:00:00', '11', null, null, null, '1', '2019-12-07 10:34:22', '2019-12-10 16:12:11');
INSERT INTO `devicerepair` VALUES ('8', '9', null, null, null, null, null, null, '1', '2019-12-07 12:03:55', '2019-12-07 12:03:55');
INSERT INTO `devicerepair` VALUES ('9', '5', null, null, null, null, null, null, '1', '2019-12-07 15:46:07', '2019-12-07 15:46:07');
INSERT INTO `devicerepair` VALUES ('10', '5', null, null, null, null, null, null, '1', '2019-12-07 16:13:14', '2019-12-07 16:13:14');
INSERT INTO `devicerepair` VALUES ('12', '5', '2', '2100-08-05 00:00:00', '322', '2019-11-09 00:00:00', '2', '663', '2', '2019-12-07 16:20:35', '2019-12-10 16:10:57');
INSERT INTO `devicerepair` VALUES ('14', '5', '1', '0021-05-05 23:54:17', '555', '2019-11-09 00:00:00', '1', '663', '2', '2019-12-07 16:22:23', '2019-12-08 17:45:21');
INSERT INTO `devicerepair` VALUES ('15', '5', '1', '2222-05-06 00:00:00', '11', '2019-11-09 00:00:00', '1', '663', '2', '2019-12-07 16:33:16', '2019-12-08 17:44:42');
INSERT INTO `devicerepair` VALUES ('17', '8', '1', '2019-11-05 00:00:00', '322', '2019-11-09 00:00:00', '1', '258', '2', '2019-12-07 17:23:25', '2019-12-08 22:00:12');
INSERT INTO `devicerepair` VALUES ('20', '11', '1', '2019-11-05 00:00:00', '322', '2019-11-09 00:00:00', '1', '258', '2', '2019-12-10 15:48:04', '2019-12-10 16:10:47');
INSERT INTO `devicerepair` VALUES ('21', '11', '2', '2019-11-05 00:00:00', '11', null, null, null, '1', '2019-12-10 15:48:14', '2019-12-10 15:48:14');

-- ----------------------------
-- Table structure for `devicesout`
-- ----------------------------
DROP TABLE IF EXISTS `devicesout`;
CREATE TABLE `devicesout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL COMMENT '设备id',
  `outter` int(11) DEFAULT NULL COMMENT '报废人',
  `outdate` datetime DEFAULT NULL COMMENT '报废日期',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` decimal(1,0) DEFAULT NULL COMMENT '状态 1-申请、2-准许、3-拒绝',
  `approver` int(11) DEFAULT NULL COMMENT '审批人',
  `approvalremarks` varchar(200) DEFAULT NULL COMMENT '审批意见',
  `approvaldate` datetime DEFAULT NULL COMMENT '申请日期',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='设备出库';

-- ----------------------------
-- Records of devicesout
-- ----------------------------
INSERT INTO `devicesout` VALUES ('5', '5', '2', '1999-08-12 00:00:00', '55555', '3', '1', '888881', '1998-10-11 00:00:00', '2019-12-02 20:02:25', '2019-12-09 19:41:07');
INSERT INTO `devicesout` VALUES ('15', '5', '1', '1223-10-10 23:54:17', '11', '2', '1', '888881', '1222-05-29 23:54:17', '2019-12-09 01:00:53', '2019-12-10 16:13:19');
INSERT INTO `devicesout` VALUES ('16', '11', '2', '1222-04-19 23:54:17', '55555', '3', '1', '888881', '1222-06-06 23:54:17', '2019-12-10 14:41:55', '2019-12-10 15:46:13');
INSERT INTO `devicesout` VALUES ('18', '11', '2', '1222-04-19 23:54:17', '朱', '2', '1', '11', '1222-06-06 23:54:17', '2019-12-10 15:46:58', '2019-12-10 15:47:13');
INSERT INTO `devicesout` VALUES ('19', '5', '1', '1222-04-27 23:54:17', '55555', '1', null, null, null, '2019-12-10 15:50:41', '2019-12-10 15:50:41');
INSERT INTO `devicesout` VALUES ('20', '11', '2', '1999-08-12 00:00:00', '--', '1', null, null, null, '2019-12-10 15:50:51', '2019-12-10 15:50:51');
INSERT INTO `devicesout` VALUES ('21', '11', '1', '1222-04-19 23:54:17', '9999', '2', '2', '888881888', '1222-06-06 23:54:17', '2019-12-10 15:51:33', '2019-12-10 15:52:21');
INSERT INTO `devicesout` VALUES ('22', '11', '2', '1223-10-26 23:54:17', '33', '1', null, null, null, '2019-12-10 15:51:46', '2019-12-10 15:51:46');
INSERT INTO `devicesout` VALUES ('23', '11', '2', '1999-08-12 00:00:00', '55555', '1', null, null, null, '2019-12-10 15:51:53', '2019-12-10 15:51:53');
INSERT INTO `devicesout` VALUES ('24', '5', '1', '1222-04-27 23:54:17', '--', '1', null, null, null, '2019-12-10 15:52:02', '2019-12-10 15:52:02');

-- ----------------------------
-- Table structure for `devicetype`
-- ----------------------------
DROP TABLE IF EXISTS `devicetype`;
CREATE TABLE `devicetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌',
  `intlcode` varchar(100) DEFAULT NULL COMMENT '国际编号',
  `model` varchar(100) DEFAULT NULL COMMENT '型号',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `asl` decimal(3,0) DEFAULT NULL COMMENT '使用年限',
  `anrv` decimal(8,3) DEFAULT NULL COMMENT '预计净残值',
  `crtm` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `mdtm` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='设备类型';

-- ----------------------------
-- Records of devicetype
-- ----------------------------
INSERT INTO `devicetype` VALUES ('2', 'heihei', 'qq', '11', '11', '111', '2', '111.000', '2019-12-09 20:04:16.838', '2019-12-09 20:04:16.838');
INSERT INTO `devicetype` VALUES ('3', 'admin', '去1', '11', '11', '111111', '11', '11.000', '2019-12-10 15:48:55.207', '2019-12-10 15:48:55.207');
INSERT INTO `devicetype` VALUES ('5', 'admin', '·1', '11', '·1', '55555', '2', '11.000', '2019-12-10 15:57:37.423', '2019-12-10 15:57:37.423');
INSERT INTO `devicetype` VALUES ('6', 'admin', '·1', '11', '·1', '55555', '2', '11.000', '2019-12-10 16:03:17.384', '2019-12-10 16:03:17.384');
INSERT INTO `devicetype` VALUES ('7', 'admin', '·1', '11', '·1', '55555', '2', '11.000', '2019-12-10 16:03:30.478', '2019-12-10 16:03:30.478');
INSERT INTO `devicetype` VALUES ('8', 'heihei', '去1', '11', '11', '55555', '2', '11.000', '2019-12-10 16:03:41.342', '2019-12-10 16:03:41.342');
INSERT INTO `devicetype` VALUES ('9', 'admin', '林', '11', '·1', '--', '2', '11.000', '2019-12-10 16:04:01.091', '2019-12-10 16:04:01.091');
INSERT INTO `devicetype` VALUES ('10', '林春燕', '林', '林', '·1', '5111', '2', '11.000', '2019-12-10 16:04:26.43', '2019-12-10 16:04:26.43');
INSERT INTO `devicetype` VALUES ('11', '林春燕', '去1', '11', '·1', '林', '11', '11.000', '2019-12-10 16:04:50.204', '2019-12-10 16:04:50.204');
INSERT INTO `devicetype` VALUES ('12', 'heihei', '·1', '林', '11', '111', '11', '11.000', '2019-12-10 16:05:05.015', '2019-12-10 16:05:05.015');
INSERT INTO `devicetype` VALUES ('13', 'heihei', '去1', '林', '11', '22222222222', '11', '11.000', '2019-12-10 16:05:19.889', '2019-12-10 16:05:19.889');
INSERT INTO `devicetype` VALUES ('14', '林春燕', '去1', '11', '·1', '33', '11', '11.000', '2019-12-10 16:15:46.819', '2019-12-10 16:15:46.819');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='组织机构';

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '开发一部', '中山分公司开发部', null, '2019-09-30 16:25:17');
INSERT INTO `organization` VALUES ('2', '开发二部', '广州分公司', null, null);
INSERT INTO `organization` VALUES ('3', '林春燕', '55555', '2019-12-10 16:14:40', '2019-12-10 16:14:40');
INSERT INTO `organization` VALUES ('4', 'admin', '111', '2019-12-10 16:14:59', '2019-12-10 16:14:59');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '炒鸡管理员2', '炒鸡管理员1', null, null);
INSERT INTO `role` VALUES ('4', '一级客服', '一级客服', null, null);
INSERT INTO `role` VALUES ('5', '开发二部', '广州开发二部', '2019-09-30 16:23:26', '2019-09-30 16:23:26');
INSERT INTO `role` VALUES ('6', 'heihei', '55555', '2019-12-10 16:14:49', '2019-12-10 16:14:49');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `ogid` int(11) DEFAULT NULL COMMENT '组织机构id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` decimal(1,0) DEFAULT NULL COMMENT '性别 1-男、2-女',
  `birth` varchar(20) DEFAULT NULL COMMENT '生日',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(500) DEFAULT NULL COMMENT '邮件',
  `logintime` varchar(20) DEFAULT NULL COMMENT '登录时间',
  `loginip` varchar(500) DEFAULT NULL COMMENT '登录ip',
  `crtm` datetime DEFAULT NULL COMMENT '创建时间',
  `mdtm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '2', 'admin', '123456', '2', '2018-09-17', '15813342257', '332039038@qq.com', '2019-10-14 14:34:51', '127.0.0.1', '2018-09-17 00:30:12', '2018-09-17 00:36:53');
INSERT INTO `user` VALUES ('2', '4', '1', 'heihei', '123456', '1', '2012-12-20', '13833335555', '123@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('3', '1', '1', '林春燕', '123456', '2', '2009-03-03', '15362910682', '1724342055@qq.com', null, null, null, null);
