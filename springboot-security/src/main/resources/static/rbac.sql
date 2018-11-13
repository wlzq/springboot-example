CREATE DATABASE `test`;

USE `test`;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `permId` int(11) NOT NULL AUTO_INCREMENT,
  `permName` varchar(20) NOT NULL,
  `permUrl` varchar(50) NOT NULL,
  `permType` char(1) NOT NULL,
  `permPid` int(11) DEFAULT NULL,
  `permDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`permId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限信息';

/*Data for the table `t_permission` */

insert  into `t_permission`(`permId`,`permName`,`permUrl`,`permType`,`permPid`,`permDesc`) values (1,'添加用户','/user/add','1',1,NULL),(2,'删除用户','/user/delete','1',1,NULL),(3,'编辑用户','/user/edit','1',1,NULL),(4,'查询用户','/user/list','1',1,NULL),(5,'添加角色','/role/add','1',2,NULL),(6,'删除角色','/role/delete','1',2,NULL),(7,'编辑角色','/role/edit','1',2,NULL),(8,'查询角色','/role/list','1',2,NULL);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) NOT NULL,
  `roleCode` varchar(20) NOT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息';

/*Data for the table `t_role` */

insert  into `t_role`(`roleId`,`roleName`,`roleCode`,`roleDesc`) values (1,'superadmin','ROLE_SUPER','超级管理员'),(2,'admin','ROLE_ADMIN','普通管理员');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `rolePermId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `permId` int(11) NOT NULL,
  PRIMARY KEY (`rolePermId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色权限关系信息';

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`rolePermId`,`roleId`,`permId`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,2,5),(10,2,6);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`username`,`password`,`email`,`telephone`) values (5,'武松','$2a$05$DReUhDnwKVedgSX5n4jlBuhcoWV0zzXYeM5H2hqejGplmRnZJZ2pm','ws@qq.com','13000000000'),(6,'鲁智深','$2a$05$DReUhDnwKVedgSX5n4jlBuhcoWV0zzXYeM5H2hqejGplmRnZJZ2pm','lzs@qq.com','13000000001');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `userRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userRoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色关系信息';

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`userRoleId`,`userId`,`roleId`) values (1,5,1),(2,6,2);