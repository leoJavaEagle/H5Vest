/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.110
Source Server Version : 50720
Source Host           : 192.168.1.110:3306
Source Database       : h5vest

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-18 12:10:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` varchar(25) NOT NULL COMMENT '主键id',
  `title` varchar(225) DEFAULT NULL COMMENT '文章标题',
  `content_one` text COMMENT '文章内容1段',
  `picture_one` varchar(225) DEFAULT NULL COMMENT '文章图片路径1段',
  `content_two` text COMMENT '文章内容2段',
  `read_count` varchar(25) DEFAULT NULL COMMENT '文章阅读量',
  `image` varchar(225) DEFAULT NULL COMMENT '标题图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0 显示  1 不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='咨询表';

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '银行贷款利率调整，房贷利息怎么还', '银行贷款利率调整，', null, '房贷利息怎么还啊', '5406', 'http://192.168.1.102:8088/imgupload/91d21f145bc9409aafa0b1730b573233.png', '2018-03-01 17:19:20', '0');
INSERT INTO `t_article` VALUES ('2', '酷爱房产的上海90后小伙房产抵押贷款300万开滑板店', '酷爱房产的上海90后小伙房产抵押贷款300万开滑板店，', null, '可太有才了', '5666', 'http://192.168.1.102:8088/imgupload/665e7167514d47678207bc1b8ac1e108.png', '2018-03-01 17:23:02', '0');
INSERT INTO `t_article` VALUES ('3', '扎心了，Coinbase开始提醒客户不要忘记加密所得税', '交易所和钱包服务提供商Coinbase似乎正在采取早期措施提醒客户履行即将到来的税收义务。随着美国税收年已经在12月31日结束，Coinbase用户现在面临着他们控制面板上呈现的一个问题，“\n', null, '请记得支付您的税款”，并且链接到网站的最新税务常见问题解答（FAQ）页面。FAQ指出Coinbase“无法提供法律或税务建议”，但提供了一个美国国税局（IRS）关于报告和支付与加密货币交易。', '5405', 'http://192.168.1.102:8088/imgupload/f5e0133078af41af8bcb15ffb9d2c697.png', '2018-03-01 16:23:49', '0');
INSERT INTO `t_article` VALUES ('4', '2018最新房产抵押利率', '2018最新房产抵押利率', null, '，好像是4%', '5405', 'http://192.168.1.102:8088/imgupload/1c8ce774de8c41eb9019476761147841.png', '2018-03-01 17:48:02', '0');
INSERT INTO `t_article` VALUES ('5', '无缘贷款的4大人群，你在其中吗？', '无缘贷款的4大人群，你在其中吗？', null, '反正我是在其中。', '5405', 'http://192.168.1.102:8088/imgupload/5d3dd41c49104011bffc785d68ec601e.png', '2018-03-01 17:48:32', '0');

-- ----------------------------
-- Table structure for t_model
-- ----------------------------
DROP TABLE IF EXISTS `t_model`;
CREATE TABLE `t_model` (
  `id` varchar(25) NOT NULL COMMENT '主键id',
  `source` varchar(25) DEFAULT NULL COMMENT '手机系统来源',
  `market_code` varchar(25) DEFAULT NULL COMMENT '渠道码',
  `market_name` varchar(50) DEFAULT NULL COMMENT '渠道商名称',
  `index` char(1) DEFAULT NULL COMMENT '首页：0 显示  1 不显示',
  `article` char(1) DEFAULT NULL COMMENT '资讯：0 显示  1 不显示',
  `counter` char(1) DEFAULT NULL COMMENT '计算器：0 显示  1 不显示',
  `mine` char(1) DEFAULT NULL COMMENT '我的：0 显示  1 不显示',
  `start_time` datetime DEFAULT NULL COMMENT '审核开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '审核结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0 审核中  1 审核结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块显示/隐藏表';

-- ----------------------------
-- Records of t_model
-- ----------------------------
INSERT INTO `t_model` VALUES ('1', 'IOS', 'ios', '苹果', '0', '0', '1', '1', '2018-05-12 18:56:18', '2018-05-12 18:56:22', '0');
INSERT INTO `t_model` VALUES ('2', 'android', 'QDVVVVHW20180131102552786', '华为', '0', '0', '0', '1', '2018-05-15 18:56:32', '2018-05-24 18:56:34', '1');
INSERT INTO `t_model` VALUES ('3', 'android', 'QDVTXYYB20180131102747084', '腾讯应用宝', '0', '0', '0', '1', '2018-05-15 18:56:37', '2018-05-30 18:56:40', '0');
INSERT INTO `t_model` VALUES ('4', 'android', 'QDBDSJZS20180131102804374', '百度手机助手', '0', '0', '0', '0', '2018-05-02 18:56:43', '2018-05-23 18:56:46', '0');
INSERT INTO `t_model` VALUES ('5', 'android', 'QDVVAZSC20180131102819536', '安卓市场', '0', '1', '1', '0', '2018-05-09 18:56:48', '2018-05-31 18:56:50', '0');
INSERT INTO `t_model` VALUES ('6', 'android', 'QDVVPPZS20180131102843058', 'PP助手', '0', '0', '1', '0', '2018-05-11 00:00:00', '2018-05-24 00:00:00', '0');
INSERT INTO `t_model` VALUES ('7', 'android', 'QDVV91ZS20180131102830414', '91助手', '0', '1', '1', '0', '2018-05-04 00:00:00', '2018-05-26 00:00:00', '0');
INSERT INTO `t_model` VALUES ('8', 'android', 'QDVVVWDJ20180131102903529', '豌豆荚', '0', '0', '1', '0', '2018-05-12 00:00:00', '2018-05-24 00:00:00', '0');
INSERT INTO `t_model` VALUES ('9', 'android', 'QDVVVYYH20180131102914506', '应用汇', '0', '0', '1', '0', '2018-05-11 00:00:00', '2018-05-19 00:00:00', '0');

-- ----------------------------
-- Table structure for t_problem
-- ----------------------------
DROP TABLE IF EXISTS `t_problem`;
CREATE TABLE `t_problem` (
  `id` varchar(25) NOT NULL COMMENT '主键id',
  `title` varchar(50) DEFAULT NULL COMMENT '问题标题',
  `content` text COMMENT '问题内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0 显示  1 不显示',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='常见问题表';

-- ----------------------------
-- Records of t_problem
-- ----------------------------
INSERT INTO `t_problem` VALUES ('1', '网上申请借款，审核一般要多久?', '根据申请信息完整性的不同，审核速度也不同，最快当天就可以通过审核。', '2018-05-09 16:41:57', '1', '2018-05-14 16:19:37');
INSERT INTO `t_problem` VALUES ('16215897', '789', '456789456', '2018-05-16 11:49:27', '1', null);
INSERT INTO `t_problem` VALUES ('2', '网上申请借款如何加快审核速度？', '1、保证填写信息的真实性2、信息的完整性，一般信息填写完整，信息审核越快', '2018-05-09 17:16:58', '0', '2018-05-14 16:18:29');
INSERT INTO `t_problem` VALUES ('24683484', '1', '2', '2018-05-16 12:06:27', '1', '2018-05-16 14:11:24');
INSERT INTO `t_problem` VALUES ('3', '从审核到下款一般需要多久？', '一般来说，市场上完成放款的时间为1-7天。每家机构放款速度是不一样，只需申请材料齐全，最快当天就能审核放款', '2018-05-09 14:19:53', '1', null);
INSERT INTO `t_problem` VALUES ('4', '如何保证个人贷款的审核通过率？', '申请个人贷款要重视自身的信用报告、还有未还贷款、如实填写资产证明、工作证明、居住状况等，则可以增加个人贷款通过率。', '2018-05-09 14:21:26', '0', null);
INSERT INTO `t_problem` VALUES ('5', '机构/银无抵押信用贷款考虑的因素有哪些？', '1、个人信用记录\r\n2、个人负责比率\r\n3、个人就业记录\r\n4、贷款额上限，一般的标准是，无抵押的个人贷款不应该超过申请人每月基本收入的10倍\r\n5、贷款期限，短期贷款期限一般在一年内\r\n', '2018-05-09 14:23:23', '1', null);
INSERT INTO `t_problem` VALUES ('57171312', '123', '456789', '2018-05-16 11:49:09', '1', null);
INSERT INTO `t_problem` VALUES ('6', '如何顺利通过电话审核？', '1、保证填写信息的真实性\r\n2、本人或者填写的联系人通讯保持通畅\r\n3、回答内容与申请表填写内容一致\r\n', '2018-05-09 14:24:43', '0', null);
INSERT INTO `t_problem` VALUES ('7', '电话审核一般核实哪些问题？', '1、核对姓名\r\n2、核对身份证号码\r\n3、借款用途\r\n4、提交申请填写过的信息\r\n5、资产信息\r\n6、工作信息\r\n7、个人征信情况等\r\n', '2018-05-09 14:26:44', '0', null);
INSERT INTO `t_problem` VALUES ('8', '申请贷款的基本要求是什么？', '1、年龄20-60周岁的具有合法收入和还款能力的中国公民2、具有稳定的工资收入，具有如期偿还贷款的能力3、没有不良信用记录', '2018-05-09 14:27:58', '1', '2018-05-16 11:49:44');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` varchar(25) NOT NULL COMMENT '产品主键ID',
  `product_type` char(1) DEFAULT '' COMMENT '0：现金贷、1：消费贷、2：抵押贷、3：租房分期、4：学生贷、5：业主贷',
  `product_name` varchar(30) NOT NULL COMMENT '借款产品名称',
  `product_picture_url` varchar(255) DEFAULT NULL COMMENT '产品图标URL',
  `day_rate` decimal(4,4) DEFAULT NULL COMMENT '日利率',
  `month_rate` decimal(4,4) unsigned DEFAULT NULL COMMENT '月利率',
  `year_rate` decimal(4,4) DEFAULT NULL COMMENT '年利率',
  `borrow_periods` varchar(100) DEFAULT NULL COMMENT '借款期限（1-30天；6个月；12个月；18个月）',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '0：启用、1：停用、2：待提交',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `out_url` varchar(255) DEFAULT NULL COMMENT '第三方产品链接',
  `amount_limit` varchar(255) DEFAULT NULL COMMENT '额度范围',
  `biz_time` varchar(255) DEFAULT NULL COMMENT '从提交资料到审核结束所需时间',
  `is_default` varchar(1) DEFAULT '0' COMMENT '1表示默认的产品',
  `logo_tip` varchar(100) DEFAULT NULL COMMENT '产品提示图标',
  `product_tip` varchar(200) DEFAULT NULL COMMENT '产品提示内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品主表';

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('00101517203811803101', '0', '大家贷', 'https://www.baidu.com/img/bd_logo1.png?where=super', '0.1230', '0.7800', '0.1310', '6-12月', '0', '2018-01-29 13:30:10', '2018-01-30 09:17:44', null, '10000~50W', '12小时', '0', '', '来贷款的');
INSERT INTO `t_product` VALUES ('00101517203811804566', '0', '悦借钱', 'https://www.baidu.com/img/bd_logo1.png?where=super', '0.0500', null, null, '6-12月', '0', '2017-12-04 13:53:57', '2018-01-31 17:32:39', '', '2000~5W', '24小时', '1', '', '');
INSERT INTO `t_product` VALUES ('00101517381152917106', '0', '融360', 'https://www.baidu.com/img/bd_logo1.png?where=super', null, '0.7300', null, '6-12月', '0', '2018-01-31 14:45:52', '2018-01-31 14:45:52', null, '3000~50W', '12小时', '1', '', '还死你');
INSERT INTO `t_product` VALUES ('00122222152222222222', '0', '新浪有还', 'https://www.baidu.com/img/bd_logo1.png?where=super', null, '0.4900', null, '6-12月', '0', '2018-05-11 17:55:21', null, 'http://www.baidu.com', '500~2W', '3分钟', '0', '', '');
INSERT INTO `t_product` VALUES ('15531033', '0', '贷贷贷', '123', '0.1230', '0.0000', '0.0000', '6-12月', '1', '2018-05-15 16:53:47', '2018-05-15 16:53:47', null, '5000~2W', '3分钟', '0', '', '');
INSERT INTO `t_product` VALUES ('49589586', '0', '001', '017', '0.1000', null, null, '6-12月', '1', '2018-05-15 18:03:00', '2018-05-15 18:03:00', null, '5000~2W', '12小时', '0', '', '');
INSERT INTO `t_product` VALUES ('95143338', '0', '什么贷', '12333', '0.1200', null, null, '6-12月', '1', '2018-05-15 17:58:39', '2018-05-15 17:58:39', null, '5000~2W', '3分钟', '1', '', '');
INSERT INTO `t_product` VALUES ('95726928', '1', '随便贷', 'https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=logo&step_word=&hs=0&pn=79&spn=0&di=5016269850&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1649015506%2C1847454705&os=2044238640%2C12817', '0.1100', '0.1200', '0.1300', '12', '1', '2018-05-14 14:34:02', '2018-05-14 14:34:02', '123', '123', '123', '0', '123', '123');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(25) NOT NULL COMMENT '主键id',
  `username` varchar(25) DEFAULT NULL COMMENT '渠道码',
  `password` varchar(50) DEFAULT NULL COMMENT '渠道商名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块显示/隐藏表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'lisi', '123');
INSERT INTO `t_user` VALUES ('2', 'lbh', '666');
INSERT INTO `t_user` VALUES ('3', 'lyf', '666');
INSERT INTO `t_user` VALUES ('4', 'mage', '123456');
INSERT INTO `t_user` VALUES ('5', 'admin', 'admin');
SET FOREIGN_KEY_CHECKS=1;
