-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.23-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema idroc
--

CREATE DATABASE IF NOT EXISTS idroc;
USE idroc;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `user_uid` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`user_uid`),
  CONSTRAINT `admn_uid_fk ` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment` (
  `user_uid` varchar(99) NOT NULL,
  `inventory_inv_id` varchar(32) NOT NULL,
  KEY `asgn_uid_fk_idx` (`user_uid`),
  KEY `asgn_invid_fk_idx` (`inventory_inv_id`),
  CONSTRAINT `asgn_invid_fk` FOREIGN KEY (`inventory_inv_id`) REFERENCES `inventory` (`inv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `asgn_uid_fk` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assignment`
--

/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;


--
-- Definition of table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `cmt_id` varchar(32) NOT NULL,
  `comment` varchar(500) NOT NULL,
  PRIMARY KEY (`cmt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comments`
--

/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;


--
-- Definition of table `crt_tag`
--

DROP TABLE IF EXISTS `crt_tag`;
CREATE TABLE `crt_tag` (
  `user_uid` varchar(32) NOT NULL,
  `tags_tag_id` varchar(32) NOT NULL,
  KEY `crtg_uid_fk_idx` (`user_uid`),
  KEY `crtg_tid_fk_idx` (`tags_tag_id`),
  CONSTRAINT `crtg_tid_fk` FOREIGN KEY (`tags_tag_id`) REFERENCES `tags` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `crtg_uid_fk` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `crt_tag`
--

/*!40000 ALTER TABLE `crt_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `crt_tag` ENABLE KEYS */;


--
-- Definition of table `inv_comment`
--

DROP TABLE IF EXISTS `inv_comment`;
CREATE TABLE `inv_comment` (
  `inventory_inv_id` varchar(32) NOT NULL,
  `comments_cmt_id` varchar(32) NOT NULL,
  KEY `invc_invid_fk_idx` (`inventory_inv_id`),
  KEY `invc_cmtid_fk_idx` (`comments_cmt_id`),
  CONSTRAINT `invc_cmtid_fk` FOREIGN KEY (`comments_cmt_id`) REFERENCES `comments` (`cmt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `invc_invid_fk` FOREIGN KEY (`inventory_inv_id`) REFERENCES `inventory` (`inv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inv_comment`
--

/*!40000 ALTER TABLE `inv_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv_comment` ENABLE KEYS */;


--
-- Definition of table `inv_tag`
--

DROP TABLE IF EXISTS `inv_tag`;
CREATE TABLE `inv_tag` (
  `inventory_inv_id` varchar(32) NOT NULL,
  `tags_tag_id` varchar(32) NOT NULL,
  KEY `invtg_invid_fk_idx` (`inventory_inv_id`),
  KEY `invtg_tid_fk_idx` (`tags_tag_id`),
  CONSTRAINT `invtg_invid_fk` FOREIGN KEY (`inventory_inv_id`) REFERENCES `inventory` (`inv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `invtg_tid_fk` FOREIGN KEY (`tags_tag_id`) REFERENCES `tags` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inv_tag`
--

/*!40000 ALTER TABLE `inv_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv_tag` ENABLE KEYS */;


--
-- Definition of table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `inv_id` varchar(32) NOT NULL,
  `name` varchar(150) NOT NULL,
  `detail` varchar(255) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventory`
--

/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;


--
-- Definition of table `ownership`
--

DROP TABLE IF EXISTS `ownership`;
CREATE TABLE `ownership` (
  `user_uid` varchar(99) NOT NULL,
  `inventory_inv_id` varchar(32) NOT NULL,
  PRIMARY KEY (`inventory_inv_id`),
  KEY `own_uid_fk_idx` (`user_uid`),
  CONSTRAINT `own_invid_fk` FOREIGN KEY (`inventory_inv_id`) REFERENCES `inventory` (`inv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `own_uid_fk` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ownership`
--

/*!40000 ALTER TABLE `ownership` DISABLE KEYS */;
/*!40000 ALTER TABLE `ownership` ENABLE KEYS */;


--
-- Definition of table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `inventory_inv_id` varchar(32) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`inventory_inv_id`),
  CONSTRAINT `stts_invid_fk` FOREIGN KEY (`inventory_inv_id`) REFERENCES `inventory` (`inv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `status`
--

/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;


--
-- Definition of table `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `tag_id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tags`
--

/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;


--
-- Definition of table `timestamp`
--

DROP TABLE IF EXISTS `timestamp`;
CREATE TABLE `timestamp` (
  `tmpid` varchar(99) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `timestamp`
--

/*!40000 ALTER TABLE `timestamp` DISABLE KEYS */;
/*!40000 ALTER TABLE `timestamp` ENABLE KEYS */;


--
-- Definition of table `transition`
--

DROP TABLE IF EXISTS `transition`;
CREATE TABLE `transition` (
  `trid` varchar(32) NOT NULL,
  `dpid` varchar(99) NOT NULL,
  `prev` varchar(500) DEFAULT NULL,
  `next` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`trid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transition`
--

/*!40000 ALTER TABLE `transition` DISABLE KEYS */;
/*!40000 ALTER TABLE `transition` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(99) NOT NULL,
  `email` varchar(99) NOT NULL,
  `password` varchar(32) NOT NULL,
  `f_name` varchar(45) NOT NULL,
  `m_name` varchar(45) DEFAULT NULL,
  `l_name` varchar(45) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `usr_comment`
--

DROP TABLE IF EXISTS `usr_comment`;
CREATE TABLE `usr_comment` (
  `user_uid` varchar(99) NOT NULL,
  `comments_cmt_id` varchar(32) NOT NULL,
  KEY `usrc_uid_fk_idx` (`user_uid`),
  KEY `usrc_cmtid_fk_idx` (`comments_cmt_id`),
  CONSTRAINT `usrc_cmtid_fk` FOREIGN KEY (`comments_cmt_id`) REFERENCES `comments` (`cmt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usrc_uid_fk` FOREIGN KEY (`user_uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usr_comment`
--

/*!40000 ALTER TABLE `usr_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `usr_comment` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
