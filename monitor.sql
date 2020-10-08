/*
 Navicat Premium Data Transfer

 Source Server         : LocalMySQL
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : monitor

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 08/10/2020 21:44:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dht22
-- ----------------------------
DROP TABLE IF EXISTS `dht22`;
CREATE TABLE `dht22`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `in_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `temperature` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度',
  `humidity` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '湿度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of dht22
-- ----------------------------
BEGIN;
INSERT INTO `dht22` VALUES (2, '2020-09-06 16:26:34', '27.100000381469727', '51.599998474121094'), (3, '2020-09-06 16:26:38', '26.700000762939453', '52.70000076293945'), (4, '2020-09-06 16:26:43', '26.700000762939453', '52.599998474121094'), (5, '2020-09-06 16:26:48', '26.600000381469727', '52.20000076293945'), (6, '2020-09-06 16:26:53', '26.600000381469727', '52.5'), (7, '2020-09-06 16:26:58', '26.600000381469727', '52.70000076293945'), (8, '2020-09-06 16:27:03', '26.600000381469727', '53.20000076293945'), (9, '2020-09-06 16:27:08', '26.700000762939453', '53.5');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
