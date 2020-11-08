/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.25 : Database - mybatis_plus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=''NO_AUTO_VALUE_ON_ZERO'' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis_plus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis_plus`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''主键ID'',
  `name` varchar(30) DEFAULT NULL COMMENT ''姓名'',
  `age` int(11) DEFAULT NULL COMMENT ''年龄'',
  `email` varchar(50) DEFAULT NULL COMMENT ''邮箱'',
  `version` int(10) DEFAULT ''1'' COMMENT ''乐观锁'',
  `create_time` datetime DEFAULT NULL COMMENT ''创建时间'',
  `update_time` datetime DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`age`,`email`,`version`,`create_time`,`update_time`) values (1,''kuangshen'',18,''24736743@qq.com'',3,''2020-11-08 22:28:25'',''2020-11-08 23:13:54''),(2,''Jack'',20,''test2@baomidou.com'',1,''2020-11-08 22:28:25'',''2020-11-08 22:28:25''),(3,''Tom'',28,''test3@baomidou.com'',1,''2020-11-08 22:28:25'',''2020-11-08 22:28:25''),(4,''Sandy'',21,''test4@baomidou.com'',1,''2020-11-08 22:28:25'',''2020-11-08 22:28:25''),(5,''Billie'',24,''test5@baomidou.com'',1,''2020-11-08 22:28:25'',''2020-11-08 22:28:25'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
