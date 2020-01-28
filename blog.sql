/*
Navicat MySQL Data Transfer

Source Server         : LocalDB
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-01-28 11:27:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_blog
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog`;
CREATE TABLE `tb_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` longtext NOT NULL,
  `first_picture` varchar(255) NOT NULL,
  `flag` varchar(24) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `appreciation` tinyint(1) DEFAULT NULL,
  `share_statement` tinyint(1) DEFAULT NULL,
  `commnetable` tinyint(1) DEFAULT NULL,
  `published` tinyint(1) DEFAULT NULL,
  `recommend` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_blog` (`type_id`),
  KEY `user_blog` (`user_id`),
  CONSTRAINT `type_blog` FOREIGN KEY (`type_id`) REFERENCES `tb_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_blog` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_blog
-- ----------------------------
INSERT INTO `tb_blog` VALUES ('1', '    StringUtils 是 org.apache.commons.lang3.StringUtils包中的一个字符串的工具类，', 'StringUtils 中isEmpty 和 isBlank区别', '> ##### commons.lang3 学习No.1\r\n\r\n#### &ensp;&ensp;&ensp;&ensp;StringUtils 是 org.apache.commons.lang3.StringUtils包中的一个字符串的工具类，其中isEmpty 和 isBlank 功能是比较类似的，容易混淆，学习一下：\r\n\r\n- **isEmpty ：** 判断某字符串是否为空，为空的标准是 str==null或 str.length()==0\r\n\r\n	StringUtils.isEmpty(null) = true\r\n	\r\n	StringUtils.isEmpty(“”) = true;#空字符串\r\n	\r\n	StringUtils.isEmpty(” “) = false;#空格\r\n	\r\n	StringUtils.isEmpty(” “) = false; #TAB\r\n	\r\n	StringUtils.isEmpty(“bob”) = false;\r\n	\r\n	StringUtils.isEmpty(” bob “) = false;\r\n	\r\n\r\n\r\n\r\n- **isBlank ：** 判断某字符串是否为空或长度为0或由空白符(whitespace) 构成\r\n\r\n	StringUtils.isBlank(null) = true ;\r\n	\r\n	StringUtils.isBlank(“”) = true ; // 空字符串\r\n	\r\n	StringUtils.isBlank(” “) = true; // 空格\r\n	\r\n	StringUtils.isBlank(” “) = true; // TAB\r\n	\r\n	StringUtils.isBlank(“\\t \\n \\f \\r”) = true; // 对于制表符、换行符、换页符和回车符\r\n	\r\n	StringUtils.isBlank(“\\b”) = false; // “\\b”为单词边界符\r\n	\r\n	StringUtils.isBlank(“bob”) = false;\r\n	\r\n	StringUtils.isBlank(” bob “) = false;\r\n	\r\n', 'https://picsum.photos/id/253/800/450', '原创', '13', '1', '1', '0', '1', '0', '2018-07-27 18:25:56', '2020-01-26 07:01:22', '1', '1');
INSERT INTO `tb_blog` VALUES ('3', 'IT界知名的程序员曾说：对于那些月薪三万以下，自称IT工程师的码农们，其实我们从来没有把他们归为我们IT工程师的队伍。\r\n', '程序员：我终于知道post和get的区别', 'IT界知名的程序员曾说：对于那些月薪三万以下，自称IT工程师的码农们，其实我们从来没有把他们归为我们IT工程师的队伍。他们虽然总是以IT工程师自居，但只是他们一厢情愿罢了。\r\n\r\n此话一出，不知激起了多少(码农)程序员的愤怒，却又无可奈何，于是码农问程序员。\r\n\r\n码农：你知道get和post请求到底有什么区别？\r\n程序员：你看这篇就知道了。\r\n码农：你月薪三万了？\r\n程序员：嗯。\r\n码农：你是怎么做到的?\r\n程序员：我做梦做到的\r\n————————————————\r\n版权声明：本文为CSDN博主「dotnet全栈开发」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/kebi007/article/details/103059900', 'https://picsum.photos/id/251/800/450', '转载', '6', '1', null, '1', '1', '0', '2019-06-27 18:26:06', '2020-01-25 10:13:02', '4', '1');
INSERT INTO `tb_blog` VALUES ('5', '双十一大概会产生多大的数据量呢，可能大家没概念，举个例子央视拍了这么多年电视新闻节目，', '阿里靠什么武功秘籍渡过“双十一“的天量冲击', '双十一大概会产生多大的数据量呢，可能大家没概念，举个例子央视拍了这么多年电视新闻节目，几十年下来他存了大概80P的数据。而今年双11一天，阿里要处理970P的数据，做为一个IT人，笔者认为今年”双十一“阿里最大的技术看点有有以下两个：\r\n\r\n阿里的数据库，也就是刚刚拿下TPC冠军的OcceanBase，处理峰值也达到了骇人听闻的6100万次/秒，\r\n阿里核心系统百分百上云了。\r\n如果把信息系统比做一个武林高手，那么如此之大的交易量代表了他的刚猛威武，而全面触云又代表他灵动飘逸。而能把刚猛和灵活完美结合是简直是神才能达到的境界。\r\n\r\n上云虽好，但不适合大规模计算，由于底层与用户之间多了一个虚拟化层，所以云计算平台一般都会产生10%左右的调度损耗，而这10%的损耗也让很多密集计算型的应用场景不太合适使用云平台。所以站在IT视角，云计算也不太合适双十一的场景。那么阿里刚猛兼顾灵活的武功是如何练成的呢？\r\n\r\n乾坤大挪移-Tair\r\n\r\n通过阿里的官宣来看在Tair之前还有一个LVS的负载均衡层，不过那些都不是国产的自研技术，也不细表了。\r\n\r\nTair是阿里自研的开源缓存服务中间件（Github地址：。https://github.com/alibaba/tair）提供快速访问的内存（MDB引擎）/持久化（LDB引擎）存储服务，基于高性能、高可用的分布式集群架构，满足读写性能要求高及容量可弹性伸缩的业务需求，在双十一秒杀的体系内完成乾坤大挪移般的加速工作。\r\n\r\n通常情况下，一个 Tair 集群中包含2台 Configserver 及多台 DataServer。其中两台 Configserver 互为主备。通过和 Dataserver 之间的心跳检测获取集群中存活可用的 Dataserver，构建数据在集群中的分布信息。Dataserver 负责数据的存储，并按照 Configserver 的指示完成数据的复制和迁移工作。Client 在启动的时候，从 Configserver 获取数据分布信息，根据数据分布信息，和相应的 Dataserver 进行交互，完成用户的请求。\r\n————————————————\r\n版权声明：本文为CSDN博主「beyondma」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/BEYONDMA/article/details/103213493', 'https://picsum.photos/id/251/800/450', '原创', '1', '1', '1', '1', '1', '0', '2018-06-20 18:26:17', '2020-01-25 10:22:41', '6', '1');
INSERT INTO `tb_blog` VALUES ('7', '后来自己花了一个星期看完了 Python 的基础知识，就想着找点项目看一看，学一学，练一练，这个时候我才真正的去了解 GitHub', 'GitHub 标星 1.6w+，我发现了一个宝藏项目，作为编程新手有福了！', '后来自己花了一个星期看完了 Python 的基础知识，就想着找点项目看一看，学一学，练一练，这个时候我才真正的去了解 GitHub，开始了在 GitHub 的瞎逛之旅，在开始之初，随之而来的问题是我不知道哪些项目当时还是新手的我，哪些项目是好项目，哪些项目好玩有价值。\r\n\r\n\r\n虽然现在我已经在 GitHub 上逛的相当流畅，但我还是想如果有一个东西可以收集这些对新手友好的东西，那么我当时可以少走更多的弯路，节省更多的时间吧。\r\n\r\n\r\n那么有这么一个东西么？\r\n\r\n\r\n有的，而且已经做了三年多，这就是 HelloGitHub，一个分享 GitHub 上有趣，入门级的开源项目。\r\n————————————————\r\n版权声明：本文为CSDN博主「Rocky0429」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/u013486414/article/details/103274892', 'https://picsum.photos/id/248/800/450', '转载', '1', '1', '1', '1', '1', '0', '2019-07-25 18:26:29', '2020-01-25 06:31:01', '8', '1');
INSERT INTO `tb_blog` VALUES ('8', '其实这个问题是我一直有一些好奇的地方，对于目前的监督学习来说，标记的好坏决定了学习的最佳结果的程度，也就是最终网络输出结果的好坏。', '深度学习100问之提高深度学习模型训练效果（调参经验）', '其实这个问题是我一直有一些好奇的地方，对于目前的监督学习来说，标记的好坏决定了学习的最佳结果的程度，也就是最终网络输出结果的好坏。\r\n\r\n根据 没有免费的午餐 这个学界公认的道理，任何算法都不能脱离数据或者应用场景来谈效果的好坏。算法的最终目的是 拟合这种趋势或者分布，不同的数据集的特征分布是不同的，甚至同一个数据集划分方式和比例的不同都也会使得特征的分布存在差异。\r\n\r\n所以还记得之前看过一个大佬说，现在工业界训练效果提升，数据占了很大一部分，其实可以理解为，如果你能更好地处理数据，那么最后的训练效果就会更好！！！\r\n\r\n常说的几种方法，比如：\r\n\r\n人工标注，大家比较熟知的就是花钱进行众包了，特别出名的应该是IMAGENET；再就是让实验室的小师弟小师妹帮忙。。。咳咳；\r\n适当预处理，大家比较熟知的就是数据清洗，降噪；再就是去除冗余数据，减少过拟合；\r\n等等。\r\n之前写过一个\r\n————————————————\r\n版权声明：本文为CSDN博主「我是管小亮 :)」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/TeFuirnever/article/details/104050694', 'https://picsum.photos/id/241/800/450', '原创', '0', '1', '1', '1', '1', '0', '2017-03-01 18:26:41', '2020-01-25 06:31:09', '4', '1');
INSERT INTO `tb_blog` VALUES ('9', '如何将int 类型转换为 Long类型.\r\n错误的姿势： 很多同学可能会用下面的方法将int类型转换为Long类型，但事实上这样是不可行的。', 'Java基础1：int 类型转换为 Long类型', '> ##### 如何将int 类型转换为 Long类型.\r\n\r\n-  **错误的姿势：** 很多同学可能会用下面的方法将int类型转换为Long类型，但事实上这样是不可行的。因为Long是包装类，而int是值类型数据，两者是不能这样强转的。\r\n	```java\r\n	Long l = (Long)3;\r\n	```\r\n\r\n- **正确的姿势：** int和long都是基本类型的数据，是可以强转的，那么我就可以以此作为桥梁，强转成long后，再生成Long类型的数据。这样就可以将int类型顺利转换为Long类型。\r\n\r\n	```java\r\n	Long l = new Long((long)3);\r\n	```\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n', 'https://picsum.photos/id/165/800/450', '原创', '4', '1', '1', '1', '1', '1', '2019-02-21 18:26:51', '2020-01-25 10:22:55', '1', '1');
INSERT INTO `tb_blog` VALUES ('10', 'SpringBoot集成thymeleaf做开发遇到的错误\r\n报错：EL1007E: Property or field ‘name’ cannot be found on null\r\n详细信息：(片段)', '报错：EL1007E: Property or field \'name\' cannot be found on null', '>##### SpringBoot集成thymeleaf做开发遇到的错误\r\n\r\n\r\n报错：EL1007E: Property or field \'name\' cannot be found on null\r\n- **详细信息：(片段)**\r\n\r\n	```java\r\n	org.thymeleaf.exceptions.TemplateInputException: An error happened during template parsing (template: \"class path resource [templates//admin/types-input.html]\")\r\n\r\n	Caused by: org.attoparser.ParseException: Exception evaluating SpringEL expression: \"name\" (template: \"/admin/types-input\" - line 59, col 72)\r\n		at org.attoparser.MarkupParser.parseDocument(MarkupParser.java:393) ~[attoparser-2.0.5.RELEASE.jar:2.0.5.RELEASE]\r\n		at org.attoparser.MarkupParser.parse(MarkupParser.java:257) ~[attoparser-2.0.5.RELEASE.jar:2.0.5.RELEASE]\r\n		at org.thymeleaf.templateparser.markup.AbstractMarkupTemplateParser.parse(AbstractMarkupTemplateParser.java:230) ~[thymeleaf-3.0.11.RELEASE.jar:3.0.11.RELEASE]\r\n		... 53 common frames omitted\r\n	Caused by: org.thymeleaf.exceptions.TemplateProcessingException: Exception evaluating SpringEL expression: \"name\" (template: \"/admin/types-input\" - line 59, col 72)\r\n		at \r\n	org.springframework.expression.spel.SpelEvaluationException: EL1007E: Property or field \'name\' cannot be found on null\r\n		at\r\n\r\n	```\r\n\r\n- **原因：**\r\n 静态页面使用了thymeleaf的表达式接收后台controller传输的对象（数据），但是后台却没有把这个对象传过来，或者传过来一个空对象，所有报错，意思是找不见这个字段（当然对象都没有哪来的字段）。\r\n\r\n- **解决方案：**\r\n1. 在yml配置文件添加：\r\n\r\n	```java\r\n	mybatis:\r\n	  configuration:\r\n	    call-setters-on-nulls: true #设置返回字段不为空，前端不报错\r\n	```\r\n\r\n2. 后台controller层，再跳转页面时带一个空对象过去就行。例如：\r\n\r\n	```java\r\n	 /**\r\n		 * 静态页面跳转\r\n		 * @return\r\n		 */\r\n		@GetMapping(\"types/input\")\r\n		public String typesInput(Model model) {\r\n			model.addAttribute(\"type\", new Type());\r\n			return \"/admin/types-input\";\r\n		}\r\n	```\r\n***\r\n- **前端代码展示：**\r\n\r\n	```javascirpt\r\n	<!--表单提交-->\r\n			<form action=\"#\" method=\"post\" th:action=\"@{/admin/types}\" th:object=\"${type}\" class=\"ui form\">\r\n				<!--分类名称-->\r\n				<div class=\"field\">\r\n					<div class=\"ui left labeled input\">\r\n						<label  class=\"ui teal basic label\">分类名称</label>\r\n						<input type=\"text\" name=\"name\" placeholder=\"请输入分类\" th:value=\"*{name}\">\r\n					</div>\r\n				</div>\r\n	```\r\n\r\n\r\n\r\n\r\n\r\n\r\n', 'https://picsum.photos/id/312/800/450', '原创', '9', '1', '1', '1', '1', '1', '2019-12-28 18:26:59', '2020-01-26 13:03:15', '20', '1');
INSERT INTO `tb_blog` VALUES ('11', '管理系统缩写\r\n通用的4大管理系统\r\n1、OMS：Order Management System，订单管理系统\r\n    订单管理模块是信息系统集中管理的核心模块，是实现宏观调', '各种管理系统术语，OMS、WMS、CRM...', '> ##### 管理系统缩写\r\n###### 通用的4大管理系统\r\n\r\n\r\n- 1、OMS：Order Management System，**订单管理系统**\r\n&ensp;&ensp;&ensp;&ensp;订单管理模块是信息系统集中管理的核心模块，是实现宏观调控、统一管理和决策分析的核心。\r\n&ensp;&ensp;&ensp;&ensp;订单管理模块主要以订单管理为核心，辅助以工作流控制技术 ，使得在供应链上的各个部门，各个工作中心能够统一的去协调物流资源，提高协作效率订单管理模块是整个信息化系统的数据中心，拥有各地的所有交易数据。\r\n&ensp;&ensp;&ensp;&ensp;所有物流业务活动的全过程将在订单管理模块得到恰当的体现，为企业的各项分析、决策和其他活动提供基础数据支持。OMS不仅仅是订单执行的分配，而是监控异常，管理订单全程生命周期的系统\r\n\r\n- 2、WMS：Warehouse Management System，**仓库管理系统**\r\n&ensp;&ensp;&ensp;&ensp;仓库管理系统是通过入库业务、出库业务、仓库调拨、库存调拨和虚仓管理等功能，综合批次管理、物料对应、库存盘点、质检管理、虚仓管理和即时库存管理等功能综合运用的管理系统，有效控制并跟踪仓库业务的物流和成本管理全过程，实现完善的企业仓储信息管理。\r\n&ensp;&ensp;&ensp;&ensp;该系统可以独立执行库存操作，与其他系统的单据和凭证等结合使用，可提供更为完整全面的企业业务流程和财务管理信息。\r\n\r\n- 3、CRM：Customer Relationship Management，**客户关系管理**\r\n&ensp;&ensp;&ensp;&ensp;CRM是选择和管理有价值客户及其关系的一种商业策略，CRM要求以客户为中心的商业哲学和企业文化来支持有效的市场营销、销售与服务流程。\r\n&ensp;&ensp;&ensp;&ensp;CRM是一个获取、保持和增加可获利客户的方法和过程。CRM既是一种崭新的、国际领先的、以客户为中心的企业管理理论、商业理念和商业运作模式，也是一种以信息技术为手段、有效提高企业收益、客户满意度、雇员生产力的具体软件和实现方法。\r\n\r\n- 4、ERP：Enterprise Resource Planning，**企业资源计划**\r\n&ensp;&ensp;&ensp;&ensp;ERP系统是指建立在信息技术基础上，以系统化的管理思想，为企业决策层及员工提供决策运行手段的管理平台。\r\n&ensp;&ensp;&ensp;&ensp;它是从MRP（物料需求计划）发展而来的新一代集成化管理信息系统，它扩展了MRP的功能，其核心思想是供应链管理。它跳出了传统企业边界，从供应链范围去优化企业的资源。\r\n&ensp;&ensp;&ensp;&ensp;电商ERP系统集中信息技术与先进的管理思想於一身，成为现代企业的运行模式，反映时代对企业合理调配资源，最大化地创造社会财富的要求，成为企业在信息时代生存、发展的基石。它对于改善企业业务流程、提高企业核心竞争力的作用是显而易见的。\r\n', 'https://picsum.photos/id/301/800/450', '', '3', '1', '1', '1', '1', '1', '2020-01-25 06:25:22', '2020-01-25 06:25:22', '21', '1');
INSERT INTO `tb_blog` VALUES ('22', '120245324532', '测试002', '测试002', 'dgd', '', '1', '1', '1', '1', '1', '1', '2020-01-26 18:27:04', '2020-01-27 06:58:11', '22', '1');

-- ----------------------------
-- Table structure for tb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag`;
CREATE TABLE `tb_blog_tag` (
  `blog_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  KEY `tag_id` (`tag_id`),
  KEY `blog_id` (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_blog_tag
-- ----------------------------
INSERT INTO `tb_blog_tag` VALUES ('3', '2');
INSERT INTO `tb_blog_tag` VALUES ('3', '3');
INSERT INTO `tb_blog_tag` VALUES ('3', '68');
INSERT INTO `tb_blog_tag` VALUES ('3', '9');
INSERT INTO `tb_blog_tag` VALUES ('5', '2');
INSERT INTO `tb_blog_tag` VALUES ('5', '11');
INSERT INTO `tb_blog_tag` VALUES ('5', '12');
INSERT INTO `tb_blog_tag` VALUES ('9', '4');
INSERT INTO `tb_blog_tag` VALUES ('9', '10');
INSERT INTO `tb_blog_tag` VALUES ('9', '11');
INSERT INTO `tb_blog_tag` VALUES ('1', '2');
INSERT INTO `tb_blog_tag` VALUES ('1', '3');
INSERT INTO `tb_blog_tag` VALUES ('1', '4');
INSERT INTO `tb_blog_tag` VALUES ('1', '90');
INSERT INTO `tb_blog_tag` VALUES ('10', '2');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `admin` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blog_commnet` (`blog_id`),
  CONSTRAINT `blog_commnet` FOREIGN KEY (`blog_id`) REFERENCES `tb_blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag` VALUES ('2', 'Java');
INSERT INTO `tb_tag` VALUES ('3', 'Mysql');
INSERT INTO `tb_tag` VALUES ('4', 'Intellij IDEA');
INSERT INTO `tb_tag` VALUES ('5', 'WebStorm');
INSERT INTO `tb_tag` VALUES ('7', 'Spring');
INSERT INTO `tb_tag` VALUES ('8', 'JavaScript');
INSERT INTO `tb_tag` VALUES ('9', 'Python');
INSERT INTO `tb_tag` VALUES ('10', 'HTML');
INSERT INTO `tb_tag` VALUES ('11', 'SpringBoot');
INSERT INTO `tb_tag` VALUES ('12', 'SpringMVC');

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', 'Java基础');
INSERT INTO `tb_type` VALUES ('4', '杂志');
INSERT INTO `tb_type` VALUES ('6', 'Java工具');
INSERT INTO `tb_type` VALUES ('8', '专业术语');
INSERT INTO `tb_type` VALUES ('20', '问题解决');
INSERT INTO `tb_type` VALUES ('21', '相关术语');
INSERT INTO `tb_type` VALUES ('22', '相关软件');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'Smilevers', 'aaa', '202cb962ac59075b964b07152d234b70', 'smilevers@163.com', null, '/images/headpicture.jpg', null, null);
