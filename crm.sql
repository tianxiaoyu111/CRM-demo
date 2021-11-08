/*
Navicat MySQL Data Transfer

Source Server         : mysql_250
Source Server Version : 50555
Source Host           : 192.168.10.250:3306
Source Database       : CRMtxy

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2021-11-08 10:15:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `crm_customer`
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer` (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
  `cust_create_id` bigint(32) DEFAULT NULL COMMENT '创建人id',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
  `cust_linkman` varchar(64) DEFAULT NULL COMMENT '联系人',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
  `cust_zipcode` varchar(10) DEFAULT NULL,
  `cust_address` varchar(100) DEFAULT NULL,
  `cust_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`cust_id`),
  KEY `FK_cst_customer_source` (`cust_source`),
  KEY `FK_cst_customer_industry` (`cust_industry`),
  KEY `FK_cst_customer_level` (`cust_level`),
  KEY `FK_cst_customer_user_id` (`cust_user_id`),
  KEY `FK_cst_customer_create_id` (`cust_create_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_customer
-- ----------------------------
INSERT INTO `crm_customer` VALUES ('13', '北京普光天泓科贸有限公司', null, null, '6', '4', '23', '包海松111', '108888887', '13888888888', '123456', '北京', null);
INSERT INTO `crm_customer` VALUES ('16', '中山市小榄镇家源水族用品厂', null, null, '6', '5', '22', '陈爱巧', '108888887', '13888888888', '123456', '中山', null);
INSERT INTO `crm_customer` VALUES ('17', '东莞市雄焱环保节能科技有限公司', null, null, '6', '2', '23', '陈淮', '108888887', '13888888888', '123456', '东莞', null);
INSERT INTO `crm_customer` VALUES ('28', '长沙国玲电子设备贸易有限公司', null, null, '7', '2', '23', '崔忠仁', '108888887', '13888888888', '123456', '长沙', null);
INSERT INTO `crm_customer` VALUES ('29', '南京安琪尔冷柜', null, null, '7', '1', '23', '陈前金', '108888886', '13888888886', '6123456', '南京', null);
INSERT INTO `crm_customer` VALUES ('30', '上海龙晨磁业有限公司', null, null, '6', '2', '22', '丁元竹', '108888887', '13888888888', '123456', '上海', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('31', '深圳市中泰视讯科技有限公司', null, null, '6', '3', '23', '党国英', '108888887', '13888888888', '123456', '深圳', null);
INSERT INTO `crm_customer` VALUES ('35', '上海均宏磁业有限公司销售部', null, null, '6', '2', '22', '范恒山', '108888887', '13888888888', '123456', '上海', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('39', '天津市圣宁生物科技有限公司', null, null, '7', '2', '22', '胡鞍钢', '108888887', '13888888888', '123456', '天津', null);
INSERT INTO `crm_customer` VALUES ('40', '东莞市美厚塑磁有限公司', null, null, '6', '2', '22', '韩俊', '108888887', '13888888888', '123456', '东莞', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('41', '佛山市顺德区福禄康电器科技有限公司', null, null, '6', '4', '22', '靳东升', '108888887', '13888888888', '123456', '佛山', null);
INSERT INTO `crm_customer` VALUES ('42', '广东省佛山顺德美磁电器有限公司', null, null, '7', '2', '23', '贾康', '108888887', '13888888888', '123456', '广东', null);
INSERT INTO `crm_customer` VALUES ('43', '中山市东凤镇英家凯五金厂', null, null, '6', '2', '22', '匡贤明', '108888887', '13888888888', '123456', '中山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('44', '北京汉特尔商贸有限公司', null, null, '6', '2', '22', '李尚勇', '108888887', '13888888888', '123456', '北京', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('45', '东莞市多吉尼电器有限公司', null, null, '6', '2', '22', '李实', '108888887', '13888888888', '123456', '东莞', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('46', '潮安县东凤镇兴发五金厂', null, null, '6', '2', '22', '卢中原', '108888887', '13888888888', '123456', '潮安', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('47', '昭和（厦门）自动化洗净设备有限公司', null, null, '7', '4', '23', '刘世锦', '108888887', '13888888888', '123456', '昭和', null);
INSERT INTO `crm_customer` VALUES ('48', '中意·名田工艺品有限公司', null, null, '6', '2', '22', '刘尚希', '108888887', '13888888888', '123456', '中意', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('49', '中山市东凤镇赛锦电器', null, null, '6', '2', '22', '李雪松', '108888887', '13888888888', '123456', '中山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('50', '南京乐鹰商用厨房设备有限公司', null, null, '6', '4', '22', '刘以雷', '108888887', '13888888888', '123456', '南京', null);
INSERT INTO `crm_customer` VALUES ('51', '世菱武贸易（深圳）有限公司', null, null, '6', '2', '23', '罗红光', '108888887', '13888888888', '123456', '世菱', null);
INSERT INTO `crm_customer` VALUES ('52', '枣庄高科商贸有限公司', null, null, '7', '2', '23', '陆德', '108888887', '13888888888', '123456', '枣庄', null);
INSERT INTO `crm_customer` VALUES ('53', '宁波雄海磁材器械实业有限公司', null, null, '7', '5', '22', '厉以宁', '108888887', '13888888888', '123456', '宁波', null);
INSERT INTO `crm_customer` VALUES ('54', '厦门鼎荣电器制造有限公司', null, null, '7', '2', '22', '龙永图', '108888887', '13888888888', '123456', '厦门', null);
INSERT INTO `crm_customer` VALUES ('55', '东莞鸿泰微晶玻璃有限公司', null, null, '7', '5', '23', '倪红日', '108888887', '13888888888', '123456', '东莞', null);
INSERT INTO `crm_customer` VALUES ('56', '佛山市亿厨丰电器有限公司', null, null, '6', '2', '22', '任凌云', '108888887', '13888888888', '123456', '佛山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('57', '北京阿联阿商贸有限公司', null, null, '6', '2', '22', '宋洪远', '108888887', '13888888888', '123456', '北京', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('58', '中山市玖喜电气有限公司', null, null, '6', '2', '22', '宋圭武', '108888887', '13888888888', '123456', '中山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('59', '潮州市潮安区佳尔丽不锈钢实业有限公司', null, null, '6', '2', '22', '苏海南', '108888887', '13888888888', '123456', '潮州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('60', '南宁市桂雪制冷设备有限公司', null, null, '6', '2', '22', '单大圣', '108888887', '13888888888', '123456', '南宁', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('61', '广州安菲环保科技有限公司上海分公司', null, null, '6', '2', '22', '宋增伟', '108888887', '13888888888', '123456', '广州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('62', '淄博淄美电器厂', null, null, '6', '2', '22', '孙立平', '108888887', '13888888888', '123456', '淄博', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('63', '青岛聚力达复合材料有限公司', null, null, '6', '2', '22', '宋晓梧', '108888887', '13888888888', '123456', '青岛', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('64', '佛山市雅绅宝制冷设备制造有限公司', null, null, '6', '2', '22', '唐海滨', '108888887', '13888888888', '123456', '佛山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('65', '江阴市青阳鑫忠塑料五金厂', null, null, '6', '2', '22', '田国强', '108888887', '13888888888', '123456', '江阴', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('66', '西安国大环保科技有限公司', null, null, '6', '2', '22', '唐志军', '108888887', '13888888888', '123456', '西安', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('67', '合肥德尔曼电器有限公司', null, null, '6', '2', '22', '唐钧', '108888887', '13888888888', '123456', '合肥', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('68', '张军家电维修公司', null, null, '6', '2', '22', '王永钦', '108888887', '13888888888', '123456', '张军', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('69', '广州静电贴印刷厂', null, null, '6', '2', '22', '王小鲁', '108888887', '13888888888', '123456', '广州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('70', '北京冰之乐冰淇淋销售中心', null, null, '6', '2', '22', '汪玉凯', '108888887', '13888888888', '123456', '北京', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('71', '合肥市特而博机电设备有限公司', null, null, '6', '2', '22', '王梦奎', '108888887', '13888888888', '123456', '合肥', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('72', '佛山市顺德万祥电器有限公司', null, null, '6', '2', '22', '魏加宁', '108888887', '13888888888', '123456', '佛山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('73', '深圳市欧雪制冷设备有限公司', null, null, '6', '2', '22', '温铁军', '108888887', '13888888888', '123456', '深圳', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('74', '佛山市顺德区民威电器科技有限公司', null, null, '6', '2', '22', '吴敬琏', '108888887', '13888888888', '123456', '佛山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('75', '上海永乐电器销售有限公司', null, null, '6', '2', '22', '吴晓灵', '108888887', '13888888888', '123456', '上海', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('76', '深圳普能达实业有限公司', null, null, '6', '2', '22', '徐登伟', '108888887', '13888888888', '123456', '深圳', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('77', '兰州快一点家电维修', null, null, '6', '2', '22', '肖迎', '108888887', '13888888888', '123456', '兰州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('78', '深圳锐星物流有限公司', null, null, '6', '2', '22', '夏锋', '108888887', '13888888888', '123456', '深圳', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('79', '滨州元达冷冻设备有限公司', null, null, '6', '2', '22', '于建嵘', '108888887', '13888888888', '123456', '滨州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('80', '佛山市斯科曼商用制冷设备有限公司', null, null, '6', '2', '22', '竹立家', '108888887', '13888888888', '123456', '佛山', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('81', '珠海博威电气有限公司', null, null, '6', '2', '22', '周克全', '108888887', '13888888888', '123456', '珠海', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('82', '广东全自动商用豆浆机厂', null, null, '6', '2', '22', '张占斌', '108888887', '13888888888', '123456', '广东', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('83', '家海尔世纪永波锁业有限公司', null, null, '6', '2', '22', '郑梦熊', '108888887', '13888888888', '123456', '家海', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('84', '厦门市永是磁电有限公司', null, null, '6', '2', '22', '郑永年', '108888887', '13888888888', '123456', '厦门', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('85', '深圳东洋冷柜有限公司', null, null, '6', '2', '22', '赵俊臣', '108888887', '13888888888', '123456', '深圳', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('86', '东莞市杰美电器有限公司', null, null, '6', '2', '22', '张卓元', '108888887', '13888888888', '123456', '东莞', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('87', '深圳市新潮酒窖文化传播有限公司', null, null, '6', '2', '22', '赵晓', '108888887', '13888888888', '123456', '深圳', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('88', '玉环县冰箱压缩机厂', null, null, '6', '2', '22', '周天勇', '108888887', '13888888888', '123456', '玉环', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('89', '杭州致诚机械厂家指定维修服务站点', null, null, '6', '2', '22', '张曙光', '108888887', '13888888888', '123456', '杭州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('90', '杭州舒逸电器有限公司', null, null, '6', '2', '22', '魏礼群', '108888887', '13888888888', '123456', '杭州', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('91', '伸缩型洗衣机托架冰箱脚架有限公司', null, null, '6', '2', '22', '张玉台', '108888887', '13888888888', '123456', '伸缩', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('92', '浙江润尚厨卫科技有限公司', null, null, '6', '2', '22', '郑秉文', '108888887', '13888888888', '123456', '浙江', '2019-04-08 16:32:00');
INSERT INTO `crm_customer` VALUES ('93', '上海铭汇佛山市顺德区智首电器有限公司', null, null, '6', '2', '22', '蔡昉', '108888887', '13888888888', '123456', '上海', '2019-04-08 16:32:00');

-- ----------------------------
-- Table structure for `crm_dict`
-- ----------------------------
DROP TABLE IF EXISTS `crm_dict`;
CREATE TABLE `crm_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目代码(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_dict
-- ----------------------------
INSERT INTO `crm_dict` VALUES ('1', '001', '客户行业', '教育培训 ', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('10', '003', '公司性质', '民企', null, '3', '1', null);
INSERT INTO `crm_dict` VALUES ('12', '004', '年营业额', '1-10万', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('13', '004', '年营业额', '10-20万', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('14', '004', '年营业额', '20-50万', null, '3', '1', null);
INSERT INTO `crm_dict` VALUES ('15', '004', '年营业额', '50-100万', null, '4', '1', null);
INSERT INTO `crm_dict` VALUES ('16', '004', '年营业额', '100-500万', null, '5', '1', null);
INSERT INTO `crm_dict` VALUES ('17', '004', '年营业额', '500-1000万', null, '6', '1', null);
INSERT INTO `crm_dict` VALUES ('18', '005', '客户状态', '基础客户', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('19', '005', '客户状态', '潜在客户', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('2', '001', '客户行业', '电子商务', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('20', '005', '客户状态', '成功客户', null, '3', '1', null);
INSERT INTO `crm_dict` VALUES ('21', '005', '客户状态', '无效客户', null, '4', '1', null);
INSERT INTO `crm_dict` VALUES ('22', '006', '客户级别', '普通客户', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('23', '006', '客户级别', 'VIP客户', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('24', '007', '商机状态', '意向客户', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('25', '007', '商机状态', '初步沟通', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('26', '007', '商机状态', '深度沟通', null, '3', '1', null);
INSERT INTO `crm_dict` VALUES ('27', '007', '商机状态', '签订合同', null, '4', '1', null);
INSERT INTO `crm_dict` VALUES ('3', '001', '客户行业', '对外贸易', null, '3', '1', null);
INSERT INTO `crm_dict` VALUES ('30', '008', '商机类型', '新业务', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('31', '008', '商机类型', '现有业务', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('32', '009', '商机来源', '电话营销', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('33', '009', '商机来源', '网络营销', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('34', '009', '商机来源', '推广活动', null, '3', '1', null);
INSERT INTO `crm_dict` VALUES ('4', '001', '客户行业', '酒店旅游', null, '4', '1', null);
INSERT INTO `crm_dict` VALUES ('5', '001', '客户行业', '房地产', null, '5', '1', null);
INSERT INTO `crm_dict` VALUES ('6', '002', '客户来源', '电话营销', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('7', '002', '客户来源', '网络营销', null, '2', '1', null);
INSERT INTO `crm_dict` VALUES ('8', '003', '公司性质', '合资', null, '1', '1', null);
INSERT INTO `crm_dict` VALUES ('9', '003', '公司性质', '国企', null, '2', '1', null);

-- ----------------------------
-- Table structure for `crm_user`
-- ----------------------------
DROP TABLE IF EXISTS `crm_user`;
CREATE TABLE `crm_user` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(32) NOT NULL COMMENT '用户账号',
  `user_name` varchar(64) NOT NULL COMMENT '用户名称',
  `user_password` varchar(32) NOT NULL COMMENT '用户密码',
  `user_state` char(1) NOT NULL COMMENT '1:正常,0:暂停',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_user
-- ----------------------------
INSERT INTO `crm_user` VALUES ('5', 'admin', 'admin', '202cb962ac59075b964b07152d234b70', '1');
INSERT INTO `crm_user` VALUES ('6', 'xiaohong', '小红', '202cb962ac59075b964b07152d234b70', '1');
INSERT INTO `crm_user` VALUES ('7', 'xiaoming', '小明', '202cb962ac59075b964b07152d234b70', '1');
INSERT INTO `crm_user` VALUES ('8', 'xiaohong2', '小红2', '202cb962ac59075b964b07152d234b70', '1');
