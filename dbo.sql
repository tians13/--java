/*
 Navicat Premium Dump SQL

 Source Server         : SQL Server
 Source Server Type    : SQL Server
 Source Server Version : 16001000 (16.00.1000)
 Source Host           : localhost:1433
 Source Catalog        : stash
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 16001000 (16.00.1000)
 File Encoding         : 65001

 Date: 24/12/2024 00:34:38
*/


-- ----------------------------
-- Table structure for cargo
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[cargo]') AND type IN ('U'))
	DROP TABLE [dbo].[cargo]
GO

CREATE TABLE [dbo].[cargo] (
  [Sname] char(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Snum] int  NULL
)
GO

ALTER TABLE [dbo].[cargo] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'氨水                ', N'136')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'爆米花              ', N'416')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'苯                  ', N'146')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'苯胺                ', N'109')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'冰箱                ', N'664')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'丙酮                ', N'125')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'饼干                ', N'524')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'菠萝                ', N'554')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'草莓                ', N'189')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'草酸                ', N'107')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'橙子                ', N'378')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'传动轴              ', N'195')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'醋酸                ', N'112')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电池                ', N'137')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电吹风              ', N'719')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电磁炉              ', N'627')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电动剃须刀          ', N'599')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电动牙刷            ', N'648')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电动自行车          ', N'751')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电饭煲              ', N'632')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电视                ', N'714')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电熨斗              ', N'530')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电子秤              ', N'503')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'电子控制单元 (ECU)  ', N'126')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'二甲苯              ', N'103')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'发动机皮带          ', N'147')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'后悬挂臂            ', N'107')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'火花塞              ', N'124')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'加湿器              ', N'617')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'甲苯                ', N'108')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'甲醇                ', N'126')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'坚果                ', N'672')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'节气门体            ', N'155')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'咖啡机              ', N'776')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'烤箱                ', N'562')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'空调                ', N'549')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'空调压缩机          ', N'103')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'空气净化器          ', N'619')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'空气滤清器          ', N'139')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'蓝莓                ', N'399')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'梨子                ', N'481')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'磷酸                ', N'112')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'硫酸                ', N'120')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'榴莲                ', N'613')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'氯化钠              ', N'105')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'氯乙烯              ', N'114')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'轮胎                ', N'107')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'芒果                ', N'624')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'蜜瓜                ', N'215')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'柠檬                ', N'618')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'柠檬酸              ', N'137')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'排气管              ', N'139')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'苹果                ', N'222')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'葡萄                ', N'448')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'前大灯              ', N'110')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'前悬挂臂            ', N'118')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'巧克力              ', N'520')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'氢氧化钠            ', N'102')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'燃油喷射器          ', N'147')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'热水器              ', N'626')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'散热器              ', N'159')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'刹车盘              ', N'105')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'刹车片              ', N'104')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'薯片                ', N'710')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'水箱                ', N'181')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'碳酸氢钠            ', N'125')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'桃子                ', N'478')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'微波炉              ', N'721')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'西瓜                ', N'268')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'吸尘器              ', N'608')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'洗衣机              ', N'727')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'香蕉                ', N'817')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'硝基苯              ', N'146')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'硝酸                ', N'0')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'悬挂系统            ', N'118')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'乙醇                ', N'133')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'乙二醇              ', N'124')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'樱桃                ', N'269')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'油滤器              ', N'137')
GO

INSERT INTO [dbo].[cargo] ([Sname], [Snum]) VALUES (N'榨汁机              ', N'603')
GO


-- ----------------------------
-- Table structure for manager
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[manager]') AND type IN ('U'))
	DROP TABLE [dbo].[manager]
GO

CREATE TABLE [dbo].[manager] (
  [Mname] char(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Mpassword] char(100) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[manager] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO [dbo].[manager] ([Mname], [Mpassword]) VALUES (N'admin               ', N'admin                                                                                               ')
GO


-- ----------------------------
-- Table structure for shelf
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[shelf]') AND type IN ('U'))
	DROP TABLE [dbo].[shelf]
GO

CREATE TABLE [dbo].[shelf] (
  [Hid] char(5) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Cid] char(5) COLLATE Chinese_PRC_CI_AS  NULL,
  [Sname] char(20) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[shelf] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of shelf
-- ----------------------------
INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h1   ', N'C01  ', N'电视                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h10  ', N'C05  ', N'电吹风              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h11  ', N'C01  ', N'榨汁机              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h12  ', N'C02  ', N'咖啡机              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h13  ', N'C03  ', N'电磁炉              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h14  ', N'C04  ', N'空气净化器          ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h15  ', N'C05  ', N'加湿器              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h16  ', N'C01  ', N'电动牙刷            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h17  ', N'C02  ', N'电动剃须刀          ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h18  ', N'C03  ', N'电熨斗              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h19  ', N'C04  ', N'电子秤              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h2   ', N'C02  ', N'冰箱                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h20  ', N'C05  ', N'电动自行车          ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h3   ', N'C03  ', N'洗衣机              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h4   ', N'C04  ', N'空调                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h5   ', N'C05  ', N'微波炉              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h6   ', N'C01  ', N'热水器              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h7   ', N'C02  ', N'电饭煲              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h8   ', N'C03  ', N'烤箱                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'h9   ', N'C04  ', N'吸尘器              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k1   ', N'D01  ', N'甲醇                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k10  ', N'D05  ', N'苯胺                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k11  ', N'D01  ', N'硫酸                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k12  ', N'D02  ', N'氢氧化钠            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k13  ', N'D03  ', N'氯化钠              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k14  ', N'D04  ', N'硝酸                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k15  ', N'D05  ', N'磷酸                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k16  ', N'D01  ', N'碳酸氢钠            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k17  ', N'D02  ', N'氨水                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k18  ', N'D03  ', N'醋酸                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k19  ', N'D04  ', N'柠檬酸              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k2   ', N'D02  ', N'乙醇                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k20  ', N'D05  ', N'草酸                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k3   ', N'D03  ', N'丙酮                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k4   ', N'D04  ', N'乙二醇              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k5   ', N'D05  ', N'苯                  ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k6   ', N'D01  ', N'甲苯                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k7   ', N'D02  ', N'二甲苯              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k8   ', N'D03  ', N'氯乙烯              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'k9   ', N'D04  ', N'硝基苯              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm1   ', N'A01  ', N'苹果                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm10  ', N'A05  ', N'桃子                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm11  ', N'A01  ', N'梨子                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm12  ', N'A02  ', N'菠萝                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm13  ', N'A03  ', N'榴莲                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm14  ', N'A04  ', N'芒果                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm15  ', N'A05  ', N'蜜瓜                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm16  ', N'A01  ', N'坚果                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm17  ', N'A02  ', N'薯片                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm18  ', N'A03  ', N'巧克力              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm19  ', N'A04  ', N'饼干                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm2   ', N'A02  ', N'香蕉                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm20  ', N'A05  ', N'爆米花              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm3   ', N'A03  ', N'橙子                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm4   ', N'A04  ', N'葡萄                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm5   ', N'A05  ', N'西瓜                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm6   ', N'A01  ', N'柠檬                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm7   ', N'A02  ', N'草莓                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm8   ', N'A03  ', N'蓝莓                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'm9   ', N'A04  ', N'樱桃                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z1   ', N'B01  ', N'空气滤清器          ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z10  ', N'B05  ', N'燃油喷射器          ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z11  ', N'B01  ', N'排气管              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z12  ', N'B02  ', N'空调压缩机          ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z13  ', N'B03  ', N'水箱                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z14  ', N'B04  ', N'传动轴              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z15  ', N'B05  ', N'前悬挂臂            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z16  ', N'B01  ', N'后悬挂臂            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z17  ', N'B02  ', N'电子控制单元 (ECU)  ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z18  ', N'B03  ', N'节气门体            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z19  ', N'B04  ', N'散热器              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z2   ', N'B02  ', N'油滤器              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z20  ', N'B05  ', N'前大灯              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z3   ', N'B03  ', N'刹车片              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z4   ', N'B04  ', N'刹车盘              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z5   ', N'B05  ', N'火花塞              ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z6   ', N'B01  ', N'电池                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z7   ', N'B02  ', N'轮胎                ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z8   ', N'B03  ', N'悬挂系统            ')
GO

INSERT INTO [dbo].[shelf] ([Hid], [Cid], [Sname]) VALUES (N'z9   ', N'B04  ', N'发动机皮带          ')
GO


-- ----------------------------
-- Table structure for staff
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[staff]') AND type IN ('U'))
	DROP TABLE [dbo].[staff]
GO

CREATE TABLE [dbo].[staff] (
  [Pid] char(10) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Pname] char(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [Pphonenumber] char(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [Ppassword] char(100) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[staff] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'25896     ', N'李景杨    ', N'13696986958         ', N'123456                                                                                              ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'51442     ', N'宋琴      ', N'13473163880         ', N'123qwe1                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'51500     ', N'邓志强    ', N'13543536891         ', N'123qwe4                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'51613     ', N'武晓靖    ', N'13989484464         ', N'520520123                                                                                           ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'52272     ', N'王虎      ', N'13217433750         ', N'123qwe0                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'52954     ', N'张贺飞    ', N'13851571092         ', N'123qwe2                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'53793     ', N'李天意    ', N'13644284783         ', N'123qwe3                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'55839     ', N'吴伟      ', N'13345523897         ', N'123qwe9                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'56230     ', N'刘倩      ', N'13011101268         ', N'123123520                                                                                           ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'56624     ', N'黄江      ', N'13779884043         ', N'123qwe8                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'57179     ', N'刘宏军    ', N'13207629339         ', N'123qwe6                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'57817     ', N'王浩山    ', N'13761554402         ', N'123qwe5                                                                                             ')
GO

INSERT INTO [dbo].[staff] ([Pid], [Pname], [Pphonenumber], [Ppassword]) VALUES (N'58005     ', N'陈宇      ', N'13741370753         ', N'123qwe7                                                                                             ')
GO


-- ----------------------------
-- Table structure for stash
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[stash]') AND type IN ('U'))
	DROP TABLE [dbo].[stash]
GO

CREATE TABLE [dbo].[stash] (
  [Cid] char(5) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Cname] char(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [Cloc] char(20) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[stash] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of stash
-- ----------------------------
INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'A01  ', N'食品仓1   ', N'南环1路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'A02  ', N'食品仓2   ', N'南环1路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'A03  ', N'食品仓3   ', N'南环2路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'A04  ', N'食品仓4   ', N'南环2路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'A05  ', N'食品仓5   ', N'北环3路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'B01  ', N'汽修仓1   ', N'北环3路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'B02  ', N'汽修仓2   ', N'北环6路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'B03  ', N'汽修仓3   ', N'北环6路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'B04  ', N'汽修仓4   ', N'滨江道              ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'B05  ', N'汽修仓5   ', N'滨江道              ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'C01  ', N'电器仓1   ', N'怀仁路              ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'C02  ', N'电器仓2   ', N'怀仁路              ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'C03  ', N'电器仓3   ', N'魏都大道            ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'C04  ', N'电器仓4   ', N'魏都大道            ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'C05  ', N'电器仓5   ', N'北门桥              ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'D01  ', N'化工仓1   ', N'北门桥              ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'D02  ', N'化工仓2   ', N'化工1路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'D03  ', N'化工仓3   ', N'化工2路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'D04  ', N'化工仓4   ', N'化工3路             ')
GO

INSERT INTO [dbo].[stash] ([Cid], [Cname], [Cloc]) VALUES (N'D05  ', N'化工仓5   ', N'化工4路             ')
GO
-------------------------
--Table delivery for student
---------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[delivery]') AND type IN ('U'))
	DROP TABLE [dbo].[delivery]
GO

CREATE TABLE [dbo].[delivery] (
  [sqid] char(10) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [sender] char(10) COLLATE Chinese_PRC_CI_AS   NULL,
  [sphonenumber] char(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [receiver] char(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [rphonenumber] char(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [deli] char(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [note] char(20) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[delivery] SET (LOCK_ESCALATION = TABLE)
GO

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO [dbo].[delivery] ([sqid],[sender] ,[sphonenumber], [receiver], [rphonenumber],[deli],[note]) VALUES (N'11035269  ',N'CF老四  ', N'18822225555      ', N'四眼         ', N'15785963219        ',N'外星人电脑   ',N'爸爸的爱')
GO
INSERT INTO [dbo].[delivery] ([sqid], [sender], [sphonenumber], [receiver], [rphonenumber],[deli],[note]) VALUES (N'11035269  ',N'CF老四  ', N'18822225555      ', N'四眼         ', N'15785963219        ',N'眼镜   ',N'爸爸的爱')
GO
INSERT INTO [dbo].[delivery] ([sqid], [sender], [sphonenumber], [receiver], [rphonenumber],[deli],[note]) VALUES (N'11035269  ',N'CF老四  ', N'18822225555      ', N'四眼         ', N'15785963219        ',N'手机   ',N'爸爸的爱')
GO




-- ----------------------------
-- Table structure for student
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[student]') AND type IN ('U'))
	DROP TABLE [dbo].[student]
GO

CREATE TABLE [dbo].[student] (
  [Qid] char(10) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Qname] char(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [Qphonenumber] char(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [Qpassword] char(100) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[student] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'11035269  ', N'四眼      ', N'15785963219         ', N'yi                                                                                                  ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'16958485  ', N'coke老师  ', N'16984825489         ', N'wlgsg                                                                                               ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'19036001  ', N'光头强    ', N'13669693658         ', N'2656                                                                                                ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'19963331  ', N'熊二      ', N'14536547896         ', N'3621gt56                                                                                            ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'21332025  ', N'吴宇轩    ', N'15534313969         ', N'ldweasw                                                                                             ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'22312520  ', N'杜宇宇    ', N'15696545852         ', N'lsjddwe                                                                                             ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'22319043  ', N'郭晓珍    ', N'14332572659         ', N'asedefr                                                                                             ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'22350102  ', N'李正旭    ', N'15639658458         ', N'hfuejd                                                                                              ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'22453696  ', N'CF老四    ', N'18822225555         ', N'laosi                                                                                               ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'23302015  ', N'崔晓龙    ', N'15469845825         ', N'hurnvre                                                                                             ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'23313033  ', N'胡小涛    ', N'15735336965         ', N'lfjrew                                                                                              ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'23318026  ', N'李景杨    ', N'18435813969         ', N'ljyok                                                                                               ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'23332066  ', N'苗彩云    ', N'16958324566         ', N'bhrfdwe                                                                                             ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'23361025  ', N'张小宣    ', N'15896354589         ', N'khjilr                                                                                              ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'25345271  ', N'王志宇    ', N'15896945596         ', N'feiti                                                                                               ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'25959599  ', N'张君羊    ', N'14785693214         ', N'yaogeyaogekaimeirui                                                                                 ')
GO

INSERT INTO [dbo].[student] ([Qid], [Qname], [Qphonenumber], [Qpassword]) VALUES (N'69595488  ', N'熊大      ', N'18258963587         ', N'455666                                                                                              ')
GO


-- ----------------------------
-- Table structure for supervise
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[supervise]') AND type IN ('U'))
	DROP TABLE [dbo].[supervise]
GO

CREATE TABLE [dbo].[supervise] (
  [Pid] char(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [Qid] char(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [Cid] char(5) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[supervise] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of supervise
-- ----------------------------
INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'52272     ', N'23318026  ', N'A01  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'52272     ', N'21332025  ', N'A02  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'51442     ', N'21332025  ', N'A03  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'51442     ', N'22319043  ', N'A04  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'52954     ', N'22350102  ', N'A05  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'53793     ', N'23332066  ', N'B01  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'53793     ', N'23332066  ', N'B02  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'51500     ', N'23318026  ', N'B03  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'51500     ', N'23302015  ', N'B04  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'57817     ', N'23318026  ', N'B05  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'57179     ', N'25345271  ', N'C01  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'57179     ', N'16958485  ', N'C02  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'58005     ', N'16958485  ', N'C03  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'58005     ', N'23361025  ', N'C04  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'56624     ', N'25959599  ', N'C05  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'55839     ', N'22312520  ', N'D01  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'55839     ', N'11035269  ', N'D02  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'56230     ', N'22453696  ', N'D03  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'56230     ', N'23313033  ', N'D04  ')
GO

INSERT INTO [dbo].[supervise] ([Pid], [Qid], [Cid]) VALUES (N'51613     ', N'23313033  ', N'D05  ')
GO


-- ----------------------------
-- Primary Key structure for table cargo
-- ----------------------------
ALTER TABLE [dbo].[cargo] ADD CONSTRAINT [PK__cargo__52723D262B96E92C] PRIMARY KEY CLUSTERED ([Sname])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table manager
-- ----------------------------
ALTER TABLE [dbo].[manager] ADD CONSTRAINT [PK__manager__D3C738F0C2BDFDFC] PRIMARY KEY CLUSTERED ([Mname])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table shelf
-- ----------------------------
ALTER TABLE [dbo].[shelf] ADD CONSTRAINT [PK__shelf__B2773AEDDA8957B5] PRIMARY KEY CLUSTERED ([Hid], [Sname])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table staff
-- ----------------------------
ALTER TABLE [dbo].[staff] ADD CONSTRAINT [PK__staff__C57059385C60E8FF] PRIMARY KEY CLUSTERED ([Pid])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table stash
-- ----------------------------
ALTER TABLE [dbo].[stash] ADD CONSTRAINT [PK__stash__C1FFD861217CF9BC] PRIMARY KEY CLUSTERED ([Cid])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table student
-- ----------------------------
ALTER TABLE [dbo].[student] ADD CONSTRAINT [PK__student__CAB64A03B9CB180A] PRIMARY KEY CLUSTERED ([Qid])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table supervise
-- ----------------------------
ALTER TABLE [dbo].[supervise] ADD CONSTRAINT [PK__supervis__C1FFD861E1F4B181] PRIMARY KEY CLUSTERED ([Cid])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table shelf
-- ----------------------------
ALTER TABLE [dbo].[shelf] ADD CONSTRAINT [FK__shelf__Cid__10CB707D] FOREIGN KEY ([Cid]) REFERENCES [dbo].[stash] ([Cid]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[shelf] ADD CONSTRAINT [FK__shelf__Sname__11BF94B6] FOREIGN KEY ([Sname]) REFERENCES [dbo].[cargo] ([Sname]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table supervise
-- ----------------------------
ALTER TABLE [dbo].[supervise] ADD CONSTRAINT [FK__supervise__Pid__149C0161] FOREIGN KEY ([Pid]) REFERENCES [dbo].[staff] ([Pid]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[supervise] ADD CONSTRAINT [FK__supervise__Cid__1590259A] FOREIGN KEY ([Cid]) REFERENCES [dbo].[stash] ([Cid]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[supervise] ADD CONSTRAINT [FK__supervise__Qid__168449D3] FOREIGN KEY ([Qid]) REFERENCES [dbo].[student] ([Qid]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

