/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : girlsy

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2017-07-11 16:27:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) NOT NULL,
  `admin_pwd` varchar(50) NOT NULL,
  `admin_tel` varchar(50) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'lg', 'a608b9c44912c72db6855ad555397470', '123456789');
INSERT INTO `admin` VALUES ('2', 'azy', '89467933b281d01a30965155574b82e2', '12312345678');
INSERT INTO `admin` VALUES ('3', 'lxy', 'e574f89de1fb4d977c3bddcfce3ab640', '123456789');
INSERT INTO `admin` VALUES ('4', 'zw', 'a1555463c361e7036a274a8b44e29192', '123456789');
INSERT INTO `admin` VALUES ('5', 'ln', 'f8e19f449f17c9d37dcc93dd244ec3bb', '123456789');
INSERT INTO `admin` VALUES ('6', 'dsq', 'fe37defe4f8d4c738bbdda259ef79b19', '123456789');
INSERT INTO `admin` VALUES ('11', '张三', '202cb962ac59075b964b07152d234b70', '123123456789');
INSERT INTO `admin` VALUES ('19', '张三', '202cb962ac59075b964b07152d234b70', '123123456789');

-- ----------------------------
-- Table structure for custom
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(50) NOT NULL,
  `cus_pwd` varchar(50) NOT NULL,
  `cus_sex` varchar(10) DEFAULT NULL,
  `cus_tel` varchar(50) NOT NULL,
  `cus_addr` varchar(255) NOT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES ('1', '大力男', '1234', '男', '13900001111', '第一大街');
INSERT INTO `custom` VALUES ('2', '遁地鼠', '1234', '男', '13900001111', '第五大街');
INSERT INTO `custom` VALUES ('3', '冲天刺', '1234', '男', '13900001111', '第六大街');
INSERT INTO `custom` VALUES ('4', '金刚芭比', '1234', '女', '13900001111', '第二大街');
INSERT INTO `custom` VALUES ('5', '火焰狼', '1234', '女', '13900001111', '第三大街');
INSERT INTO `custom` VALUES ('6', '不死鸟', '1234', '男', '13900001111', '第四大街');
INSERT INTO `custom` VALUES ('7', '巨人锤', '1234', '男', '13900001111', '第五大街');
INSERT INTO `custom` VALUES ('8', 'A', '1234', '男', '13900001111', '第六大街');
INSERT INTO `custom` VALUES ('9', 'B', '1234', '男', '13900001111', '第七大街');
INSERT INTO `custom` VALUES ('10', '原谅草', '1234', '女', '13900001111', '选择省份   11');
INSERT INTO `custom` VALUES ('11', '嘿嘿嘿', '12', '男', '13900001111', '1');
INSERT INTO `custom` VALUES ('12', '小蘑菇', '1234', '女', '13900001111', '选择省份   gggg');
INSERT INTO `custom` VALUES ('13', '任意门', '1234', '女', '13900001111', '选择省份   11');
INSERT INTO `custom` VALUES ('14', 'freestyle', '111', '女', '13900001111', '选择省份   111');
INSERT INTO `custom` VALUES ('15', '撒拉嘿哟', '11', '女', '13900001111', '选择省份   11');
INSERT INTO `custom` VALUES ('16', '咖喱gaygay', '11', '女', '13900001111', '选择省份   11');
INSERT INTO `custom` VALUES ('17', 'sb', '11', '男', '13900001111', '选择省份   111');
INSERT INTO `custom` VALUES ('18', '我编不出来了', '1', '男', '13900001111', '山东 滨州 博兴县 1');
INSERT INTO `custom` VALUES ('19', '最后一个', '123', '男', '13900001111', '河南 漯河 召陵区 123');
INSERT INTO `custom` VALUES ('20', '小蜜桃', '123456', '男', '13345678999', '江西 南昌 青山湖区 江西理工大学');
INSERT INTO `custom` VALUES ('21', '小傻瓜', '123456', '男', '13111111111', '内蒙古 赤峰 林西县 hhhhh');
INSERT INTO `custom` VALUES ('22', '小傻瓜', '123456', '男', '13111111111', '台湾 屏东县 null 1111');
INSERT INTO `custom` VALUES ('23', '小傻瓜', '123456', '男', '13111111111', '台湾 屏东县 null 1111');
INSERT INTO `custom` VALUES ('24', '小傻瓜', '123456', '男', '13111111111', '黑龙江 大兴安岭地区 大兴安岭辖区 hhhh');
INSERT INTO `custom` VALUES ('25', '小傻瓜', '123456', '男', '13123456333', '吉林 延边朝鲜族自治州 汪清县 1234');
INSERT INTO `custom` VALUES ('26', '小菠萝', '123456', '男', '13900000000', '内蒙古 通辽 开鲁县 江西理工大学');

-- ----------------------------
-- Table structure for favourite
-- ----------------------------
DROP TABLE IF EXISTS `favourite`;
CREATE TABLE `favourite` (
  `favourite_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  PRIMARY KEY (`favourite_id`),
  KEY `cus_id` (`cus_id`),
  KEY `pk_list_goods` (`goods_id`),
  CONSTRAINT `favourite_ibfk_1` FOREIGN KEY (`cus_id`) REFERENCES `custom` (`cus_id`),
  CONSTRAINT `favourite_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of favourite
-- ----------------------------
INSERT INTO `favourite` VALUES ('39', '6', '79');
INSERT INTO `favourite` VALUES ('40', '6', '105');
INSERT INTO `favourite` VALUES ('41', '6', '107');
INSERT INTO `favourite` VALUES ('42', '6', '87');
INSERT INTO `favourite` VALUES ('43', '6', '82');
INSERT INTO `favourite` VALUES ('44', '6', '73');
INSERT INTO `favourite` VALUES ('45', '6', '71');
INSERT INTO `favourite` VALUES ('46', '2', '77');
INSERT INTO `favourite` VALUES ('47', '6', '74');
INSERT INTO `favourite` VALUES ('48', '6', '72');
INSERT INTO `favourite` VALUES ('49', '6', '84');
INSERT INTO `favourite` VALUES ('50', '25', '82');
INSERT INTO `favourite` VALUES ('51', '2', '79');
INSERT INTO `favourite` VALUES ('52', '6', '117');
INSERT INTO `favourite` VALUES ('53', '6', '110');
INSERT INTO `favourite` VALUES ('54', '1', '71');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL,
  `goods_storage` int(11) NOT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `goods_discount` float DEFAULT NULL,
  `goods_sellCount` int(11) NOT NULL,
  `goods_type` varchar(100) DEFAULT '',
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_imgs` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('71', 'Zero意大利零度男士正装皮鞋', '1000', '100.00', '10', '0', '生活用品', '真皮专柜同款商务男鞋头层牛皮尖头结婚鞋子 93057 黑色 41 ', 'images//product_add//9__1__.jpg images//product_add//9__2__.jpg images//product_add//9__3__.jpg images//product_add//9__4__.jpg images//product_add//9__5__.jpg images//product_add//9__6__.jpg images//product_add//9__7__.jpg images//product_add//9__8__.jpg images//product_add//9__9__.jpg images//product_add//9__10__.jpg images//product_add//9__11__.jpg images//product_add//9__12__.jpg images//product_add//9__13__.jpg images//product_add//9__14__.jpg images//product_add//9__15__.jpg ');
INSERT INTO `goods` VALUES ('72', '富贵鸟男鞋', '1000', '123.00', '10', '0', '生活用品', '休闲鞋男士夏季轻便透气休闲皮鞋男柔软舒适冲孔真皮驾车休闲鞋 黑色 41 ', 'images//product_add//72__1__.jpg images//product_add//72__2__.jpg images//product_add//72__3__.jpg images//product_add//72__4__.jpg images//product_add//72__5__.jpg images//product_add//72__6__.jpg images//product_add//72__7__.jpg images//product_add//72__8__.jpg images//product_add//72__9__.jpg images//product_add//72__10__.jpg images//product_add//72__11__.jpg images//product_add//72__12__.jpg images//product_add//72__13__.jpg images//product_add//72__14__.jpg images//product_add//72__15__.jpg ');
INSERT INTO `goods` VALUES ('73', '帕兰保 男鞋板鞋', '1000', '123.00', '10', '0', '生活用品', '男士休闲鞋 透气网布鞋潮流系带 英伦驾车鞋 鞋子男 男款 蓝色 43', 'images//product_add//73__1__.jpg images//product_add//73__2__.jpg images//product_add//73__3__.jpg images//product_add//73__4__.jpg images//product_add//73__5__.jpg images//product_add//73__6__.jpg images//product_add//73__7__.jpg images//product_add//73__8__.jpg images//product_add//73__9__.jpg images//product_add//73__10__.jpg images//product_add//73__11__.jpg images//product_add//73__12__.jpg images//product_add//73__13__.jpg images//product_add//73__14__.jpg images//product_add//73__15__.jpg ');
INSERT INTO `goods` VALUES ('74', 'Beats X 蓝牙无线', '1000', '123.00', '10', '0', '电器', '入耳式耳机 运动耳机 手机耳机 带麦可通话 灰色', 'images//product_add//74__1__.jpg images//product_add//74__2__.jpg images//product_add//74__3__.jpg images//product_add//74__4__.jpg images//product_add//74__5__.jpg images//product_add//74__6__.jpg images//product_add//74__7__.jpg images//product_add//74__8__.jpg images//product_add//74__9__.jpg images//product_add//74__10__.jpg images//product_add//74__11__.jpg images//product_add//74__12__.jpg images//product_add//74__13__.jpg images//product_add//74__14__.jpg images//product_add//74__15__.jpg ');
INSERT INTO `goods` VALUES ('75', '烟花烫2017春装新款', '1000', '123.00', '10', '0', '生活用品', '女装气质外套+背心裙两件套连衣裙 山如笑 粉色 M', 'images//product_add//75__1__.jpg images//product_add//75__2__.jpg images//product_add//75__3__.jpg images//product_add//75__4__.jpg images//product_add//75__5__.jpg images//product_add//75__6__.jpg images//product_add//75__7__.jpg images//product_add//75__8__.jpg images//product_add//75__9__.jpg images//product_add//75__10__.jpg images//product_add//75__11__.jpg images//product_add//75__12__.jpg images//product_add//75__13__.jpg images//product_add//75__14__.jpg images//product_add//75__15__.jpg ');
INSERT INTO `goods` VALUES ('76', 'Belle/百丽', '1000', '123.00', '10', '0', '生活用品', '春复古玛丽珍鞋牛皮粗跟女单鞋17202AQ7 棕色 37', 'images//product_add//76__1__.jpg images//product_add//76__2__.jpg images//product_add//76__3__.jpg images//product_add//76__4__.jpg images//product_add//76__5__.jpg images//product_add//76__6__.jpg images//product_add//76__7__.jpg images//product_add//76__8__.jpg images//product_add//76__9__.jpg images//product_add//76__10__.jpg images//product_add//76__11__.jpg images//product_add//76__12__.jpg images//product_add//76__13__.jpg images//product_add//76__14__.jpg images//product_add//76__15__.jpg ');
INSERT INTO `goods` VALUES ('77', '锤子 坚果Pro', '700', '1000.00', '1', '0', '电器', '64GB 碳黑色 全网通 移动联通电信4G手机 双卡双待', 'images//product_add//77__1__.jpg images//product_add//77__2__.jpg images//product_add//77__3__.jpg images//product_add//77__4__.jpg images//product_add//77__5__.jpg images//product_add//77__6__.jpg images//product_add//77__7__.jpg images//product_add//77__8__.jpg images//product_add//77__9__.jpg images//product_add//77__10__.jpg images//product_add//77__11__.jpg images//product_add//77__12__.jpg images//product_add//77__13__.jpg images//product_add//77__14__.jpg images//product_add//77__15__.jpg ');
INSERT INTO `goods` VALUES ('78', '索尼（SONY）', '100', '999.00', '2', '0', '电器', 'MDR-1000X Hi-Res无线降噪立体声耳机（黑色）', 'images//product_add//78__1__.jpg images//product_add//78__2__.jpg images//product_add//78__3__.jpg images//product_add//78__4__.jpg images//product_add//78__5__.jpg images//product_add//78__6__.jpg images//product_add//78__7__.jpg images//product_add//78__8__.jpg images//product_add//78__9__.jpg images//product_add//78__10__.jpg images//product_add//78__11__.jpg images//product_add//78__12__.jpg images//product_add//78__13__.jpg images//product_add//78__14__.jpg images//product_add//78__15__.jpg ');
INSERT INTO `goods` VALUES ('79', '阿帕琦IK 手表', '100', '123.00', '3', '0', '电器', '镂空全自动夜光机械表 男表防水商务韩版时尚休闲腕表学生运动男士手表新款 金边白面金机心 ', 'images//product_add//79__1__.jpg images//product_add//79__2__.jpg images//product_add//79__3__.jpg images//product_add//79__4__.jpg images//product_add//79__5__.jpg images//product_add//79__6__.jpg images//product_add//79__7__.jpg images//product_add//79__8__.jpg images//product_add//79__9__.jpg images//product_add//79__10__.jpg images//product_add//79__11__.jpg images//product_add//79__12__.jpg images//product_add//79__13__.jpg images//product_add//79__14__.jpg images//product_add//79__15__.jpg ');
INSERT INTO `goods` VALUES ('80', '漫步者（EDIFIER）', '111', '2222.00', '4', '0', '电器', ' H230P 入耳式手机耳机 酷雅黑 ', 'images//product_add//80__1__.jpg images//product_add//80__2__.jpg images//product_add//80__3__.jpg images//product_add//80__4__.jpg images//product_add//80__5__.jpg images//product_add//80__6__.jpg images//product_add//80__7__.jpg images//product_add//80__8__.jpg images//product_add//80__9__.jpg images//product_add//80__10__.jpg images//product_add//80__11__.jpg images//product_add//80__12__.jpg images//product_add//80__13__.jpg images//product_add//80__14__.jpg images//product_add//80__15__.jpg ');
INSERT INTO `goods` VALUES ('81', '哥弟女装2017', '123', '1234.00', '5', '0', '生活用品', '夏季新款短袖连衣裙系腰扣带气质淑女高腰裙8500012 藏蓝 3/M  ', 'images//product_add//81__1__.jpg images//product_add//81__2__.jpg images//product_add//81__3__.jpg images//product_add//81__4__.jpg images//product_add//81__5__.jpg images//product_add//81__6__.jpg images//product_add//81__7__.jpg images//product_add//81__8__.jpg images//product_add//81__9__.jpg images//product_add//81__10__.jpg images//product_add//81__11__.jpg images//product_add//81__12__.jpg images//product_add//81__13__.jpg images//product_add//81__14__.jpg images//product_add//81__15__.jpg ');
INSERT INTO `goods` VALUES ('82', '艾朵乐2017新款韩', '123', '1324.00', '6', '0', '生活用品', '韩版春夏季增高女鞋休闲运动鞋系带飞织女单鞋 黑色-镂空款 37', 'images//product_add//82__1__.jpg images//product_add//82__2__.jpg images//product_add//82__3__.jpg images//product_add//82__4__.jpg images//product_add//82__5__.jpg images//product_add//82__6__.jpg images//product_add//82__7__.jpg images//product_add//82__8__.jpg images//product_add//82__9__.jpg images//product_add//82__10__.jpg images//product_add//82__11__.jpg images//product_add//82__12__.jpg images//product_add//82__13__.jpg images//product_add//82__14__.jpg images//product_add//82__15__.jpg ');
INSERT INTO `goods` VALUES ('83', '小米（MI）小米手环', '233', '123.00', '10', '16', '电器', '小米手环2＋Smorss 硅胶腕带 小米手环2替换腕带 咖啡色 ', 'images//product_add//83__1__.jpg images//product_add//83__2__.jpg images//product_add//83__3__.jpg images//product_add//83__4__.jpg images//product_add//83__5__.jpg images//product_add//83__6__.jpg images//product_add//83__7__.jpg images//product_add//83__8__.jpg images//product_add//83__9__.jpg images//product_add//83__10__.jpg images//product_add//83__11__.jpg images//product_add//83__12__.jpg images//product_add//83__13__.jpg images//product_add//83__14__.jpg images//product_add//83__15__.jpg ');
INSERT INTO `goods` VALUES ('84', '荣耀畅玩手环', '321', '445.00', '10', '17', '电器', 'A2 持续心率 单次运动监测 多点触摸大屏 微信内容显示来电提醒 运动睡眠自动监测 适配ios&安卓 魔法黑 ', 'images//product_add//84__1__.jpg images//product_add//84__2__.jpg images//product_add//84__3__.jpg images//product_add//84__4__.jpg images//product_add//84__5__.jpg images//product_add//84__6__.jpg images//product_add//84__7__.jpg images//product_add//84__8__.jpg images//product_add//84__9__.jpg images//product_add//84__10__.jpg images//product_add//84__11__.jpg images//product_add//84__12__.jpg images//product_add//84__13__.jpg images//product_add//84__14__.jpg images//product_add//84__15__.jpg ');
INSERT INTO `goods` VALUES ('85', '华为（HUAWEI）荣耀手表', '123', '321.00', '10', '18', '电器', 'zero 经典黑长 (智能运动健康手环手表 触控屏幕8级防水 信息查看) ', 'images//product_add//85__1__.jpg images//product_add//85__2__.jpg images//product_add//85__3__.jpg images//product_add//85__4__.jpg images//product_add//85__5__.jpg images//product_add//85__6__.jpg images//product_add//85__7__.jpg images//product_add//85__8__.jpg images//product_add//85__9__.jpg images//product_add//85__10__.jpg images//product_add//85__11__.jpg images//product_add//85__12__.jpg images//product_add//85__13__.jpg images//product_add//85__14__.jpg images//product_add//85__15__.jpg ');
INSERT INTO `goods` VALUES ('86', '拉卡拉 跨界手环', '333', '123.00', '10', '19', '电器', ' 跨界歌王明星同款 智能手环 运动手环 NFC 支付 闪付 心率 运动监测 公交地铁一卡通', 'images//product_add//86__1__.jpg images//product_add//86__2__.jpg images//product_add//86__3__.jpg images//product_add//86__4__.jpg images//product_add//86__5__.jpg images//product_add//86__6__.jpg images//product_add//86__7__.jpg images//product_add//86__8__.jpg images//product_add//86__9__.jpg images//product_add//86__10__.jpg images//product_add//86__11__.jpg images//product_add//86__12__.jpg images//product_add//86__13__.jpg images//product_add//86__14__.jpg images//product_add//86__15__.jpg ');
INSERT INTO `goods` VALUES ('87', '智能运动手环', '333', '321.00', '10', '21', '电器', '男女计步器防水手表心率血压监测健康睡眠苹果安卓通用来电QQ微信提醒 钢琴黑 ', 'images//product_add//87__1__.jpg images//product_add//87__2__.jpg images//product_add//87__3__.jpg images//product_add//87__4__.jpg images//product_add//87__5__.jpg images//product_add//87__6__.jpg images//product_add//87__7__.jpg images//product_add//87__8__.jpg images//product_add//87__9__.jpg images//product_add//87__10__.jpg images//product_add//87__11__.jpg images//product_add//87__12__.jpg images//product_add//87__13__.jpg images//product_add//87__14__.jpg images//product_add//87__15__.jpg ');
INSERT INTO `goods` VALUES ('88', '魅族（MEIZU）魅族手环', '234', '432.00', '10', '22', '电器', 'H1 智能手环 运动心率手环 一体化设计 触控屏幕 电话微信QQ信息提醒 IP67防水 ', 'images//product_add//88__1__.jpg images//product_add//88__2__.jpg images//product_add//88__3__.jpg images//product_add//88__4__.jpg images//product_add//88__5__.jpg images//product_add//88__6__.jpg images//product_add//88__7__.jpg images//product_add//88__8__.jpg images//product_add//88__9__.jpg images//product_add//88__10__.jpg images//product_add//88__11__.jpg images//product_add//88__12__.jpg images//product_add//88__13__.jpg images//product_add//88__14__.jpg images//product_add//88__15__.jpg ');
INSERT INTO `goods` VALUES ('105', '麦德好燕麦巧克力', '100000', '10.00', '9', '0', '食品', '营养麦片力 休闲零食大礼包 婚庆喜糖果饼干 紫薯味468g', 'images//product_add//105__1__.jpg images//product_add//105__2__.jpg images//product_add//105__3__.jpg images//product_add//105__4__.jpg images//product_add//105__5__.jpg images//product_add//105__6__.jpg images//product_add//105__7__.jpg images//product_add//105__8__.jpg images//product_add//105__9__.jpg images//product_add//105__10__.jpg images//product_add//105__11__.jpg images//product_add//105__12__.jpg images//product_add//105__13__.jpg images//product_add//105__14__.jpg images//product_add//105__15__.jpg ');
INSERT INTO `goods` VALUES ('106', '盼盼涂层蛋糕', '30000', '30.00', '9', '0', '食品', '奶香味 饼干糕点 休闲零食 780g', 'images//product_add//106__1__.jpg images//product_add//106__2__.jpg images//product_add//106__3__.jpg images//product_add//106__4__.jpg images//product_add//106__5__.jpg images//product_add//106__6__.jpg images//product_add//106__7__.jpg images//product_add//106__8__.jpg images//product_add//106__9__.jpg images//product_add//106__10__.jpg images//product_add//106__11__.jpg images//product_add//106__12__.jpg images//product_add//106__13__.jpg images//product_add//106__14__.jpg images//product_add//106__15__.jpg ');
INSERT INTO `goods` VALUES ('107', '稻香村北京特产', '100000', '20.00', '9', '0', '食品', '小麻花芝麻味103g 休闲零食糕点 ', 'images//product_add//107__1__.jpg images//product_add//107__2__.jpg images//product_add//107__3__.jpg images//product_add//107__4__.jpg images//product_add//107__5__.jpg images//product_add//107__6__.jpg images//product_add//107__7__.jpg images//product_add//107__8__.jpg images//product_add//107__9__.jpg images//product_add//107__10__.jpg images//product_add//107__11__.jpg images//product_add//107__12__.jpg images//product_add//107__13__.jpg images//product_add//107__14__.jpg images//product_add//107__15__.jpg ');
INSERT INTO `goods` VALUES ('108', '兜兜小果蜜饯果干', '20000', '30.00', '9', '0', '食品', '新疆和田大红枣夹核桃仁 零食特产 250g/袋', 'images//product_add//108__1__.jpg images//product_add//108__2__.jpg images//product_add//108__3__.jpg images//product_add//108__4__.jpg images//product_add//108__5__.jpg images//product_add//108__6__.jpg images//product_add//108__7__.jpg images//product_add//108__8__.jpg images//product_add//108__9__.jpg images//product_add//108__10__.jpg images//product_add//108__11__.jpg images//product_add//108__12__.jpg images//product_add//108__13__.jpg images//product_add//108__14__.jpg images//product_add//108__15__.jpg ');
INSERT INTO `goods` VALUES ('109', '士力架花生夹心巧克力', '10100', '30.00', '9', '0', '食品', '（量贩装）糖果巧克力休闲零食1000g ', 'images//product_add//109__1__.jpg images//product_add//109__2__.jpg images//product_add//109__3__.jpg images//product_add//109__4__.jpg images//product_add//109__5__.jpg images//product_add//109__6__.jpg images//product_add//109__7__.jpg images//product_add//109__8__.jpg images//product_add//109__9__.jpg images//product_add//109__10__.jpg images//product_add//109__11__.jpg images//product_add//109__12__.jpg images//product_add//109__13__.jpg images//product_add//109__14__.jpg images//product_add//109__15__.jpg ');
INSERT INTO `goods` VALUES ('110', '小米(MI)小米电视4A', '10000', '3999.00', '9', '0', '电器', '标准版 55英寸 HDR 2GB+8GB 四核64位高性能处理器 4K超高清智能语音网络液晶平板电视（L55M5-AZ）', 'images//product_add//110__1__.jpg images//product_add//110__2__.jpg images//product_add//110__3__.jpg images//product_add//110__4__.jpg images//product_add//110__5__.jpg images//product_add//110__6__.jpg images//product_add//110__7__.jpg images//product_add//110__8__.jpg images//product_add//110__9__.jpg images//product_add//110__10__.jpg images//product_add//110__11__.jpg images//product_add//110__12__.jpg images//product_add//110__13__.jpg images//product_add//110__14__.jpg images//product_add//110__15__.jpg ');
INSERT INTO `goods` VALUES ('111', '三只松鼠_约辣辣条', '900', '12.00', '8', '16', '食品', '200g休闲麻辣零食特产面制素食辣片魅惑辣 ', 'images//product_add//111__1__.jpg images//product_add//111__2__.jpg images//product_add//111__3__.jpg images//product_add//111__4__.jpg images//product_add//111__5__.jpg images//product_add//111__6__.jpg images//product_add//111__7__.jpg images//product_add//111__8__.jpg images//product_add//111__9__.jpg images//product_add//111__10__.jpg images//product_add//111__11__.jpg images//product_add//111__12__.jpg images//product_add//111__13__.jpg images//product_add//111__14__.jpg images//product_add//111__15__.jpg');
INSERT INTO `goods` VALUES ('112', '韩国春雨面膜papa', '900', '50.00', '9', '0', '生活用品', 'recipe 蜂胶蜂蜜保湿面膜舒缓补水修护 孕妇敏感肌可用 红参精油面膜10片', 'images//product_add//112__1__.jpg images//product_add//112__2__.jpg images//product_add//112__3__.jpg images//product_add//112__4__.jpg images//product_add//112__5__.jpg images//product_add//112__6__.jpg images//product_add//112__7__.jpg images//product_add//112__8__.jpg images//product_add//112__9__.jpg images//product_add//112__10__.jpg images//product_add//112__11__.jpg images//product_add//112__12__.jpg images//product_add//112__13__.jpg images//product_add//112__14__.jpg images//product_add//112__15__.jpg');
INSERT INTO `goods` VALUES ('113', '自然乐园芦荟凝胶', '800', '20.00', '10', '0', '生活用品', '祛痘淡印 补水保湿去痘印面膜晒后修复面膜 芦荟胶300ML', 'images//product_add//113__1__.jpg images//product_add//113__2__.jpg images//product_add//113__3__.jpg images//product_add//113__4__.jpg images//product_add//113__5__.jpg images//product_add//113__6__.jpg images//product_add//113__7__.jpg images//product_add//113__8__.jpg images//product_add//113__9__.jpg images//product_add//113__10__.jpg images//product_add//113__11__.jpg images//product_add//113__12__.jpg images//product_add//113__13__.jpg images//product_add//113__14__.jpg images//product_add//113__15__.jpg');
INSERT INTO `goods` VALUES ('114', '【Girlsy超市】瑞士莲Lindt', '700', '50.00', '10', '0', '食品', '京东海外直采 软心牛奶巧克力制品礼盒装 瑞士进口 187g/盒', 'images//product_add//114__1__.jpg images//product_add//114__2__.jpg images//product_add//114__3__.jpg images//product_add//114__4__.jpg images//product_add//114__5__.jpg images//product_add//114__6__.jpg images//product_add//114__7__.jpg images//product_add//114__8__.jpg images//product_add//114__9__.jpg images//product_add//114__10__.jpg images//product_add//114__11__.jpg images//product_add//114__12__.jpg images//product_add//114__13__.jpg images//product_add//114__14__.jpg images//product_add//114__15__.jpg');
INSERT INTO `goods` VALUES ('115', '【Girlsy超市】十月稻田', '700', '20.00', '10', '0', '食品', '长粒香大米 东北大米 大米5kg', 'images//product_add//115__1__.jpg images//product_add//115__2__.jpg images//product_add//115__3__.jpg images//product_add//115__4__.jpg images//product_add//115__5__.jpg images//product_add//115__6__.jpg images//product_add//115__7__.jpg images//product_add//115__8__.jpg images//product_add//115__9__.jpg images//product_add//115__10__.jpg images//product_add//115__11__.jpg images//product_add//115__12__.jpg images//product_add//115__13__.jpg images//product_add//115__14__.jpg images//product_add//115__15__.jpg');
INSERT INTO `goods` VALUES ('116', '【Girlsy超市】陶华碧老干妈', '700', '50.00', '7', '0', '食品', '风味豆豉油制辣椒 280g', 'images//product_add//116__1__.jpg images//product_add//116__2__.jpg images//product_add//116__3__.jpg images//product_add//116__4__.jpg images//product_add//116__5__.jpg images//product_add//116__6__.jpg images//product_add//116__7__.jpg images//product_add//116__8__.jpg images//product_add//116__9__.jpg images//product_add//116__10__.jpg images//product_add//116__11__.jpg images//product_add//116__12__.jpg images//product_add//116__13__.jpg images//product_add//116__14__.jpg images//product_add//116__15__.jpg');
INSERT INTO `goods` VALUES ('117', '奥马冰箱（Homa）', '700', '199.00', '8', '0', '电器', 'BCD-153CR 153升 一级节能 双门电冰箱（白色', 'images//product_add//117__1__.jpg images//product_add//117__2__.jpg images//product_add//117__3__.jpg images//product_add//117__4__.jpg images//product_add//117__5__.jpg images//product_add//117__6__.jpg images//product_add//117__7__.jpg images//product_add//117__8__.jpg images//product_add//117__9__.jpg images//product_add//117__10__.jpg images//product_add//117__11__.jpg images//product_add//117__12__.jpg images//product_add//117__13__.jpg images//product_add//117__14__.jpg images//product_add//117__15__.jpg');
INSERT INTO `goods` VALUES ('118', '这是一个测试', '700', '20.00', '9', '0', '生活用品', '嘿嘿', 'images//product_add//118__1__.jpg images//product_add//118__2__.jpg images//product_add//118__3__.jpg images//product_add//118__4__.jpg images//product_add//118__5__.jpg images//product_add//118__6__.jpg images//product_add//118__7__.jpg images//product_add//118__8__.jpg images//product_add//118__9__.jpg images//product_add//118__10__.jpg images//product_add//118__11__.jpg images//product_add//118__12__.jpg images//product_add//118__13__.jpg images//product_add//118__14__.jpg images//product_add//118__15__.jpg ');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_buyNum` int(11) NOT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `pk_orderDetail_order` (`order_id`),
  CONSTRAINT `pk_orderDetail_order` FOREIGN KEY (`order_id`) REFERENCES `order_list` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('17', '26', '105', '40');
INSERT INTO `order_detail` VALUES ('18', '26', '77', '10');
INSERT INTO `order_detail` VALUES ('19', '27', '88', '79');
INSERT INTO `order_detail` VALUES ('20', '27', '78', '1');
INSERT INTO `order_detail` VALUES ('21', '27', '77', '1');
INSERT INTO `order_detail` VALUES ('22', '27', '79', '1');
INSERT INTO `order_detail` VALUES ('23', '27', '110', '100');
INSERT INTO `order_detail` VALUES ('24', '27', '87', '6');
INSERT INTO `order_detail` VALUES ('25', '27', '86', '3');
INSERT INTO `order_detail` VALUES ('26', '27', '107', '1');
INSERT INTO `order_detail` VALUES ('28', '1', '105', '1');
INSERT INTO `order_detail` VALUES ('29', '2', '105', '11');
INSERT INTO `order_detail` VALUES ('30', '3', '105', '12');
INSERT INTO `order_detail` VALUES ('32', '5', '107', '15');
INSERT INTO `order_detail` VALUES ('33', '6', '108', '17');
INSERT INTO `order_detail` VALUES ('34', '7', '109', '1');
INSERT INTO `order_detail` VALUES ('35', '8', '108', '14');
INSERT INTO `order_detail` VALUES ('36', '9', '110', '15');
INSERT INTO `order_detail` VALUES ('37', '11', '110', '1');
INSERT INTO `order_detail` VALUES ('38', '10', '107', '5');
INSERT INTO `order_detail` VALUES ('39', '12', '111', '6');
INSERT INTO `order_detail` VALUES ('40', '13', '112', '7');
INSERT INTO `order_detail` VALUES ('41', '14', '113', '20');
INSERT INTO `order_detail` VALUES ('42', '15', '111', '2');
INSERT INTO `order_detail` VALUES ('43', '16', '80', '8');
INSERT INTO `order_detail` VALUES ('44', '17', '81', '7');
INSERT INTO `order_detail` VALUES ('45', '18', '82', '7');
INSERT INTO `order_detail` VALUES ('46', '19', '83', '7');
INSERT INTO `order_detail` VALUES ('47', '20', '84', '1');
INSERT INTO `order_detail` VALUES ('48', '21', '85', '8');
INSERT INTO `order_detail` VALUES ('49', '22', '105', '9');
INSERT INTO `order_detail` VALUES ('50', '23', '106', '10');
INSERT INTO `order_detail` VALUES ('51', '24', '107', '5');
INSERT INTO `order_detail` VALUES ('52', '26', '108', '4');
INSERT INTO `order_detail` VALUES ('53', '27', '109', '5');
INSERT INTO `order_detail` VALUES ('54', '28', '107', '5');
INSERT INTO `order_detail` VALUES ('55', '29', '105', '4');
INSERT INTO `order_detail` VALUES ('56', '30', '110', '4');
INSERT INTO `order_detail` VALUES ('63', '36', '79', '2');
INSERT INTO `order_detail` VALUES ('64', '36', '88', '1');
INSERT INTO `order_detail` VALUES ('65', '36', '110', '1');
INSERT INTO `order_detail` VALUES ('66', '37', '88', '1');
INSERT INTO `order_detail` VALUES ('67', '38', '84', '1');
INSERT INTO `order_detail` VALUES ('68', '38', '117', '1');
INSERT INTO `order_detail` VALUES ('69', '38', '86', '1');
INSERT INTO `order_detail` VALUES ('70', '39', '108', '1');
INSERT INTO `order_detail` VALUES ('71', '39', '87', '11');
INSERT INTO `order_detail` VALUES ('73', '41', '79', '1');
INSERT INTO `order_detail` VALUES ('74', '42', '77', '6');
INSERT INTO `order_detail` VALUES ('75', '42', '73', '1');
INSERT INTO `order_detail` VALUES ('76', '42', '105', '4');
INSERT INTO `order_detail` VALUES ('77', '43', '105', '1');
INSERT INTO `order_detail` VALUES ('78', '44', '79', '1');
INSERT INTO `order_detail` VALUES ('79', '44', '77', '2');

-- ----------------------------
-- Table structure for order_list
-- ----------------------------
DROP TABLE IF EXISTS `order_list`;
CREATE TABLE `order_list` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `order_state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `cus_id` (`cus_id`),
  CONSTRAINT `pk_order_custom` FOREIGN KEY (`cus_id`) REFERENCES `custom` (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of order_list
-- ----------------------------
INSERT INTO `order_list` VALUES ('1', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('2', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('3', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('5', '7', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('6', '8', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('7', '7', '2017-07-28 10:16:44', '已发货');
INSERT INTO `order_list` VALUES ('8', '4', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('9', '4', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('10', '4', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('11', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('12', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('13', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('14', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('15', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('16', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('17', '6', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('18', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('19', '6', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('20', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('21', '1', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('22', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('23', '1', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('24', '2', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('26', '18', '2017-07-08 09:00:47', '已付款');
INSERT INTO `order_list` VALUES ('27', '6', '2017-07-09 10:27:16', '已付款');
INSERT INTO `order_list` VALUES ('28', '15', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('29', '15', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('30', '5', '2017-07-28 10:16:44', '交易完成');
INSERT INTO `order_list` VALUES ('36', '5', '2017-07-11 08:41:29', '已付款');
INSERT INTO `order_list` VALUES ('37', '5', '2017-07-11 08:42:13', '已付款');
INSERT INTO `order_list` VALUES ('38', '5', '2017-07-11 08:46:24', '已付款');
INSERT INTO `order_list` VALUES ('39', '6', '2017-07-11 11:03:21', '交易完成');
INSERT INTO `order_list` VALUES ('41', '25', '2017-07-11 13:19:18', '已付款');
INSERT INTO `order_list` VALUES ('42', '6', '2017-07-11 15:46:06', '已付款');
INSERT INTO `order_list` VALUES ('43', '6', '2017-07-11 15:47:04', '已付款');
INSERT INTO `order_list` VALUES ('44', '6', '2017-07-11 15:57:28', '已付款');

-- ----------------------------
-- Table structure for shopping_list
-- ----------------------------
DROP TABLE IF EXISTS `shopping_list`;
CREATE TABLE `shopping_list` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_buyNum` int(11) NOT NULL,
  PRIMARY KEY (`g_id`),
  KEY `cus_id` (`cus_id`),
  KEY `pk_list_goods` (`goods_id`),
  CONSTRAINT `pk_list_custom` FOREIGN KEY (`cus_id`) REFERENCES `custom` (`cus_id`),
  CONSTRAINT `pk_list_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of shopping_list
-- ----------------------------
INSERT INTO `shopping_list` VALUES ('70', '18', '106', '100');
INSERT INTO `shopping_list` VALUES ('114', '25', '107', '7');
INSERT INTO `shopping_list` VALUES ('118', '5', '80', '1');
INSERT INTO `shopping_list` VALUES ('125', '6', '87', '3');
INSERT INTO `shopping_list` VALUES ('127', '1', '77', '1');
SET FOREIGN_KEY_CHECKS=1;
