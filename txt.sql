/*
SQLyog Ultimate v8.32 
MySQL - 5.6.21-log : Database - db_student
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_student` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_student`;

/*Table structure for table `manage_table` */

DROP TABLE IF EXISTS `manage_table`;

CREATE TABLE `manage_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(1000) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `Email` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `manage_table` */

insert  into `manage_table`(`id`,`user`,`password`,`Email`) values (1,'rongjun','123456','438052598@qq.com');

/*Table structure for table `t_class` */

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(1000) DEFAULT NULL,
  `gradeID` int(11) DEFAULT NULL,
  `classRemark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_class` (`gradeID`),
  CONSTRAINT `FK_t_class` FOREIGN KEY (`gradeID`) REFERENCES `t_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `t_class` */

insert  into `t_class`(`id`,`className`,`gradeID`,`classRemark`) values (1,'1班',1,'不错'),(4,'2班',1,'ssss'),(7,'3班',1,'很好'),(10,'1班',5,''),(11,'2班',5,''),(13,'3班',2,'事实上'),(14,'4班',2,'事实上是'),(16,'6班',2,'sss'),(17,'7班',2,''),(18,'1班',3,''),(19,'2班',3,'sss'),(20,'3班',3,''),(21,'1班',2,'是是是是');

/*Table structure for table `t_grade` */

DROP TABLE IF EXISTS `t_grade`;

CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(100) DEFAULT NULL,
  `gradeRemark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_grade` */

insert  into `t_grade`(`id`,`gradeName`,`gradeRemark`) values (1,'大一','sssssxx'),(2,'大五','sssssxxssss'),(3,'七年级','aaasdf'),(5,'八年级','ddsfff'),(6,'大二',''),(7,'大三','');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentnumber` int(11) DEFAULT NULL,
  `name` varchar(1000) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `nativeplace` varchar(1000) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  `studentremark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_student` (`classid`),
  CONSTRAINT `FK_t_student` FOREIGN KEY (`classid`) REFERENCES `t_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`studentnumber`,`name`,`birthday`,`nativeplace`,`classid`,`studentremark`) values (1,2013944,'小明','2014-10-16','北京',1,'ssssss'),(2,20130444,'小花','2014-10-17','福州',4,'这个学生是校花'),(3,2013944,'张五','2014-10-16','北京',1,'ssssss试试'),(4,20130498,'小郭','2014-10-14','沧州',1,''),(9,20130499,'小','2010-06-15','沧州',17,''),(10,20130487,'事实上','2014-10-15','福建福州',16,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
