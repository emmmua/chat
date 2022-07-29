/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : mychat

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 29/07/2022 18:34:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments`  (
  `number` bigint NOT NULL AUTO_INCREMENT,
  `text` varchar(10240) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dep_id` int NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`number`) USING BTREE,
  INDEX `emp_dept_id`(`dep_id` ASC) USING BTREE,
  CONSTRAINT `emp_dept_id` FOREIGN KEY (`dep_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of moments
-- ----------------------------
INSERT INTO `moments` VALUES (1, 'Hello World', 1, '2022-06-22 16:20:43');
INSERT INTO `moments` VALUES (2, '测试数据', 2, '2022-06-23 17:50:43');
INSERT INTO `moments` VALUES (5, '今天天气真好', 1, '2022-06-23 20:50:31');
INSERT INTO `moments` VALUES (11, '测试一下', 4, '2022-06-23 21:39:42');
INSERT INTO `moments` VALUES (16, '测试一下', 1, '2022-06-27 18:02:18');
INSERT INTO `moments` VALUES (17, '发布测试', 2, '2022-06-27 18:05:12');
INSERT INTO `moments` VALUES (19, '124', 1, '2022-07-02 18:08:00');
INSERT INTO `moments` VALUES (21, '关注', 1, '2022-07-26 21:41:13');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'http://q1.qlogo.cn/g?b=qq&nk=11470226&s=640', 'admin', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (2, 'https://data.fivk.cn/view.php/9c20358416fdbd060d622eb4c34da198.png', 'fivk', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (4, 'http://q1.qlogo.cn/g?b=qq&nk=2380321570&s=640', 'kkndtng', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (5, 'https://data.fivk.cn/view.php/4fdb80b75194e648c6d0a4727a700d03.png', '马化腾', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (6, 'https://data.fivk.cn/view.php/442b11aab37a66e5bfd7af4a3a59b769.png', '马云', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (7, 'http://q1.qlogo.cn/g?b=qq&nk=2173822023&s=640', '文旭松', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (8, 'http://q1.qlogo.cn/g?b=qq&nk=1392956552&s=640', '邹远念', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (9, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (19, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛1', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (20, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛2', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (21, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛3', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (22, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛4', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (23, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛5', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (24, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛6', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (25, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛7', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (26, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛8', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (27, 'http://q1.qlogo.cn/g?b=qq&nk=1471554961&s=640', '徐涛9', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (28, 'https://data.fivk.cn/view.php/9c20358416fdbd060d622eb4c34da198.png', 'testuser', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (30, 'https://data.fivk.cn/view.php/9c20358416fdbd060d622eb4c34da198.png', 'usertest', 'e10adc3949ba59abbe56e057f20f883e');

SET FOREIGN_KEY_CHECKS = 1;
