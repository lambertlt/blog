/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : lambert_blog

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 09/01/2022 12:43:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment_msg` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `like_it` bigint DEFAULT NULL,
  `state` int DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `t_media_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_comment_reply`;
CREATE TABLE `t_comment_reply` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment_msg` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `like_it` bigint DEFAULT NULL,
  `comment_id` bigint DEFAULT NULL,
  `reply_user_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reply_comment_id` (`comment_id`),
  CONSTRAINT `reply_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `t_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment_reply
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_diary
-- ----------------------------
DROP TABLE IF EXISTS `t_diary`;
CREATE TABLE `t_diary` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '上次编辑时间',
  `content` text COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_diary
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `file_size` double DEFAULT NULL COMMENT '文件大小',
  `path` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_img
-- ----------------------------
DROP TABLE IF EXISTS `t_img`;
CREATE TABLE `t_img` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `img_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `file_id` int DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`id`),
  KEY `img_file_id` (`file_id`),
  CONSTRAINT `img_file_id` FOREIGN KEY (`file_id`) REFERENCES `t_file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_img
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_index_post
-- ----------------------------
DROP TABLE IF EXISTS `t_index_post`;
CREATE TABLE `t_index_post` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` varchar(255) DEFAULT NULL COMMENT '主页文章内容',
  `order` int DEFAULT NULL COMMENT '排列顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_index_post
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_media
-- ----------------------------
DROP TABLE IF EXISTS `t_media`;
CREATE TABLE `t_media` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `media_name` varchar(255) DEFAULT NULL COMMENT '媒体名',
  `file_id` int DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`id`),
  KEY `media_file_id` (`file_id`),
  CONSTRAINT `media_file_id` FOREIGN KEY (`file_id`) REFERENCES `t_file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_media
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `tag_id` int DEFAULT NULL COMMENT '分类id',
  `favour` int DEFAULT NULL COMMENT '点赞',
  `view_number` int DEFAULT NULL COMMENT '浏览量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `top` int DEFAULT NULL COMMENT '是否置顶',
  `order` int DEFAULT NULL COMMENT '排列顺序',
  PRIMARY KEY (`id`),
  KEY `post_tag_id` (`tag_id`),
  CONSTRAINT `post_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_post
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `resource_url` varchar(255) DEFAULT NULL COMMENT '资源地址',
  `resource_img_id` varchar(255) DEFAULT NULL COMMENT '资源图片id',
  `resource_introduce` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `resource_title` varchar(255) DEFAULT NULL COMMENT '资源标题',
  `top` int DEFAULT NULL COMMENT '是否置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_resource_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_classify`;
CREATE TABLE `t_resource_classify` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `classify_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource_classify
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tag_name` varchar(255) DEFAULT NULL COMMENT '分类名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
