/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : chentest

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2015-01-15 16:21:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `userid` int(11) NOT NULL,
  `NAME` varchar(255) default NULL,
  `PASS` varchar(255) default NULL,
  `GRADE` int(11) default NULL,
  `STATE` int(11) default NULL,
  `POINT` int(11) default NULL,
  `SEX` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `role_id` int(11) default NULL,
  `nickname` varchar(255) default NULL,
  `regdate` datetime default NULL,
  `logindate` datetime default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('32768', '我是管理员', '管理员密码', '0', '0', '0', null, null, '4', null, null, null);

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `ID` int(11) NOT NULL auto_increment,
  `userid` int(11) default NULL,
  `BOARD_id` int(11) default NULL,
  `TOPIC_id` int(11) default NULL,
  `USER_BOARDSTATE` int(11) default NULL,
  `USER_TOPICSTATE` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_ny7yt6vhj7fntmp3au2sbbyh8` (`BOARD_id`),
  KEY `FK_heshyuf6ce143kyit4e48olol` (`TOPIC_id`),
  CONSTRAINT `FK_heshyuf6ce143kyit4e48olol` FOREIGN KEY (`TOPIC_id`) REFERENCES `topic` (`ID`),
  CONSTRAINT `FK_ny7yt6vhj7fntmp3au2sbbyh8` FOREIGN KEY (`BOARD_id`) REFERENCES `board` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '32769', '9', '2', '1', '1');
INSERT INTO `authority` VALUES ('2', '32768', '9', '1', '1', '1');

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `ID` int(11) NOT NULL auto_increment,
  `NAME` varchar(255) default NULL,
  `boardMaster_ID` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_aq3h8abf5mhj62ajyc699lcnn` (`boardMaster_ID`),
  CONSTRAINT `FK_aq3h8abf5mhj62ajyc699lcnn` FOREIGN KEY (`boardMaster_ID`) REFERENCES `boardmaster` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', 'PE讨论区', null);
INSERT INTO `board` VALUES ('2', '综合讨论区', null);
INSERT INTO `board` VALUES ('3', 'USB启动区', null);
INSERT INTO `board` VALUES ('4', '杀毒软件', null);
INSERT INTO `board` VALUES ('5', '数据恢复', null);
INSERT INTO `board` VALUES ('6', '虚拟机', null);
INSERT INTO `board` VALUES ('7', '灌水区', null);
INSERT INTO `board` VALUES ('8', '版务公开区', null);
INSERT INTO `board` VALUES ('9', '版区二', '32770');
INSERT INTO `board` VALUES ('10', '版区名字', '32770');

-- ----------------------------
-- Table structure for boardmaster
-- ----------------------------
DROP TABLE IF EXISTS `boardmaster`;
CREATE TABLE `boardmaster` (
  `userid` int(11) NOT NULL,
  `NAME` varchar(255) default NULL,
  `PASS` varchar(255) default NULL,
  `GRADE` int(11) default NULL,
  `STATE` int(11) default NULL,
  `POINT` int(11) default NULL,
  `SEX` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `role_id` int(11) default NULL,
  `nickname` varchar(255) default NULL,
  `regdate` datetime default NULL,
  `logindate` datetime default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boardmaster
-- ----------------------------
INSERT INTO `boardmaster` VALUES ('32770', '版主名字', '版主密码', '0', '0', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` int(11) NOT NULL auto_increment,
  `userid` int(11) default NULL,
  `CONTENT` varchar(255) default NULL,
  `topic_id` int(11) default NULL,
  `DATE` datetime default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_5o2pkwb576mg4061dp8eq6vfs` (`topic_id`),
  CONSTRAINT `FK_5o2pkwb576mg4061dp8eq6vfs` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '32769', '评论类容', '2', '2015-01-14 18:11:06');

-- ----------------------------
-- Table structure for hibernate_unique_key
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_unique_key`;
CREATE TABLE `hibernate_unique_key` (
  `next_hi` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_unique_key
-- ----------------------------
INSERT INTO `hibernate_unique_key` VALUES ('3');

-- ----------------------------
-- Table structure for mangertype
-- ----------------------------
DROP TABLE IF EXISTS `mangertype`;
CREATE TABLE `mangertype` (
  `roleID` int(11) NOT NULL,
  `NAME` varchar(255) default NULL,
  PRIMARY KEY  (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mangertype
-- ----------------------------
INSERT INTO `mangertype` VALUES ('1', '前台管理员');
INSERT INTO `mangertype` VALUES ('2', '后台管理员');
INSERT INTO `mangertype` VALUES ('4', '超级管理员');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleID` int(11) NOT NULL,
  `NAME` varchar(255) default NULL,
  PRIMARY KEY  (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `ID` int(11) NOT NULL auto_increment,
  `TITLE` varchar(255) default NULL,
  `CONTENT` varchar(255) default NULL,
  `topicState_id` int(11) default NULL,
  `userid` int(11) default NULL,
  `board_id` int(11) default NULL,
  `DATE` datetime default NULL,
  `VIEW` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_279yym632h279xhmorkksr7ay` (`topicState_id`),
  KEY `FK_k9ffx28qeaj42d10olljlefvy` (`board_id`),
  CONSTRAINT `FK_279yym632h279xhmorkksr7ay` FOREIGN KEY (`topicState_id`) REFERENCES `topicstate` (`ID`),
  CONSTRAINT `FK_k9ffx28qeaj42d10olljlefvy` FOREIGN KEY (`board_id`) REFERENCES `board` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '帖子2标题', '帖子2内容', null, '32769', '10', '2015-01-14 18:11:06', '23');
INSERT INTO `topic` VALUES ('2', '帖子标题', '帖子内容', '1', '32769', '10', '2015-01-14 18:11:06', '10');

-- ----------------------------
-- Table structure for topicstate
-- ----------------------------
DROP TABLE IF EXISTS `topicstate`;
CREATE TABLE `topicstate` (
  `ID` int(11) NOT NULL auto_increment,
  `NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topicstate
-- ----------------------------
INSERT INTO `topicstate` VALUES ('1', '精华');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `NAME` varchar(255) default NULL,
  `PASS` varchar(255) default NULL,
  `GRADE` int(11) default NULL,
  `STATE` int(11) default NULL,
  `POINT` int(11) default NULL,
  `SEX` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `role_id` int(11) default NULL,
  `nickname` varchar(255) default NULL,
  `regdate` datetime default NULL,
  `logindate` datetime default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('32769', '用户1', '用户密码', '0', '0', '0', null, null, null, '用户昵称', '2015-01-14 18:11:06', '2015-01-14 18:11:06');
INSERT INTO `user` VALUES ('65536', '123', '123123', '0', '0', '0', '男', '1@1.com', null, null, '2015-01-15 00:07:51', '2015-01-15 00:07:51');
