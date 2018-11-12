-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: call_application_db
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnmmt6f2kg0oaxr11uhy7qqf3w` (`department_id`),
  KEY `FK8ahhk8vqegfrt6pd1p9i03aej` (`user_id`),
  CONSTRAINT `FK8ahhk8vqegfrt6pd1p9i03aej` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKnmmt6f2kg0oaxr11uhy7qqf3w` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'SYSTEM','2017-05-15 12:30:25','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,1,5);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `keyy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h5tdku9skqaaxxljo3vqxvju0` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'SYSTEM','2017-05-15 09:06:01','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'cus_ticket_create','Customer can create ticket','api.ticket.create'),(2,'SYSTEM','2017-05-15 09:07:35','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'cus_ticket_comment','Customer can comment ticket','api.ticket.comment'),(3,'SYSTEM','2017-05-15 09:29:30','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'cus_ticket_list','Customer can list tickets','api.ticket.list'),(4,'SYSTEM','2017-05-15 11:01:03','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'sup_ticket_comment','SupTeam can comment ticket','api.ticket.comment'),(5,'SYSTEM','2017-05-15 11:02:36','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'sup_ticket_list','SupTeam can create ticket','api.ticket.list'),(6,'SYSTEM','2017-05-15 11:02:36','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'sup_ticket_closed','SupTeam can closed ticket','api.ticket.closed'),(7,'SYSTEM','2017-05-15 11:12:01','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'bum_ticket_closed_	consent','Bum can close consent ticket','api.ticket.consent'),(8,'SYSTEM','2017-05-15 11:12:01','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'bum_ticket_supteam','Bum can list supteam','api.ticket.list.supteam');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `category_name` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpfk8djhv5natgshmxiav6xkpu` (`user_id`),
  CONSTRAINT `FKpfk8djhv5natgshmxiav6xkpu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'SYSTEM','2017-05-19 09:17:55','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,'MOBİL',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `request_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr7sn827lv8orfsni6pu70lm3s` (`request_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKr7sn827lv8orfsni6pu70lm3s` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,'muhammed.iscan','2017-05-19 09:18:19','\0',NULL,'muhammed.iscan','2017-05-19 12:18:19',NULL,NULL,0,1,1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'SYSTEM','2017-05-15 09:13:48','\0',NULL,'SYSTEM',NULL,'iottech',NULL,1),(2,'muhammed.iscan','2017-05-15 09:45:13','\0',NULL,'muhammed.iscan','2017-05-15 12:45:13','Finpro',NULL,0);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5b3xqcpp6nvpm64shn5yjks1q` (`department_id`),
  KEY `FKj8dlm21j202cadsbfkoem0s58` (`user_id`),
  CONSTRAINT `FK5b3xqcpp6nvpm64shn5yjks1q` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKj8dlm21j202cadsbfkoem0s58` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'SYSTEM','2017-05-15 09:14:36','\0',NULL,'SYSTEM',NULL,NULL,NULL,1,1,1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh1m88q0f7sc0mk76kju4kcn6f` (`company_id`),
  CONSTRAINT `FKh1m88q0f7sc0mk76kju4kcn6f` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'SYSTEM','2017-05-15 09:14:25','\0',NULL,'SYSTEM',NULL,'IK',NULL,1,1),(2,'muhammed.iscan','2017-05-15 09:55:04','\0',NULL,'muhammed.iscan','2017-05-15 12:55:04','Yazılım',NULL,0,2);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `employee` tinyblob,
  `is_manager` bit(1) NOT NULL,
  `user` tinyblob,
  `employee_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd4dvhrigl3oiod8nxp7hcdn3e` (`employee_id`),
  KEY `FK6lk0xml9r7okjdq0onka4ytju` (`user_id`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
  CONSTRAINT `FK6lk0xml9r7okjdq0onka4ytju` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKd4dvhrigl3oiod8nxp7hcdn3e` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'muhammed.iscan','2017-05-15 10:54:57','\0',NULL,'muhammed.iscan','2017-05-15 13:54:57',NULL,NULL,0,NULL,'',NULL,NULL,2,NULL),(2,'muhammed.iscan','2017-05-15 11:14:49','\0',NULL,'muhammed.iscan','2017-05-15 14:14:49',NULL,NULL,0,NULL,'\0',NULL,1,3,NULL),(3,'muhammed.iscan','2017-05-15 11:14:57','\0',NULL,'muhammed.iscan','2017-05-15 14:14:57',NULL,NULL,0,NULL,'\0',NULL,1,4,NULL),(4,'muhammed.iscan','2017-05-15 12:31:38','\0',NULL,'muhammed.iscan',NULL,NULL,NULL,0,NULL,'',NULL,NULL,5,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `file_url` varchar(50) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  `process` varchar(255) DEFAULT NULL,
  `request_content` varchar(200) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq6tndvbdfit87agqwakox1a5m` (`category_id`),
  KEY `FKqws2fdeknk90txm7qnm9bxd07` (`user_id`),
  CONSTRAINT `FKq6tndvbdfit87agqwakox1a5m` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKqws2fdeknk90txm7qnm9bxd07` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,'SYSTEM','2017-05-19 09:18:11','\0',NULL,'SYSTEM',NULL,NULL,NULL,0,NULL,NULL,NULL,'DDF',0,1,NULL),(2,'muhammed.iscan','2017-05-19 11:29:17','\0',NULL,'muhammed.iscan',NULL,NULL,NULL,0,NULL,NULL,NULL,'FEW',0,1,2),(3,'muhammed.iscan','2017-05-19 13:25:33','\0',NULL,'muhammed.iscan',NULL,NULL,NULL,0,NULL,NULL,NULL,'SDFASD',0,1,4);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c36say97xydpmgigg38qv5l2p` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'SYSTEM','2017-05-13 15:58:29','\0',NULL,'SYSTEM',NULL,NULL,NULL,1,'ANONYMOUS','ANONYMOUS'),(2,'SYSTEM','2017-05-13 15:58:29','\0',NULL,'SYSTEM',NULL,NULL,NULL,1,'CUSTOMER','CUSTOMER'),(3,'SYSTEM','2017-05-13 15:58:29','\0',NULL,'SYSTEM',NULL,NULL,NULL,1,'BUSUNIMAN','BUSUNIMAN'),(4,'SYSTEM','2017-05-13 15:58:29','\0',NULL,'SYSTEM',NULL,NULL,NULL,1,'SUPTEAM','SUPTEAM'),(5,'SYSTEM','2017-05-13 15:58:29','\0',NULL,'SYSTEM',NULL,NULL,NULL,1,'ADMIN','ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_authority`
--

DROP TABLE IF EXISTS `role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authority` (
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`authority_id`),
  KEY `FKqbri833f7xop13bvdje3xxtnw` (`authority_id`),
  CONSTRAINT `FK2052966dco7y9f97s1a824bj1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKqbri833f7xop13bvdje3xxtnw` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_authority`
--

LOCK TABLES `role_authority` WRITE;
/*!40000 ALTER TABLE `role_authority` DISABLE KEYS */;
INSERT INTO `role_authority` VALUES (2,1),(2,2),(2,3),(4,4),(4,5),(4,6),(3,7),(3,8);
/*!40000 ALTER TABLE `role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL,
  `activated` bit(1) NOT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `reset_date` datetime DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'anonymousUser','2017-05-15 09:10:41','\0',NULL,'anonymousUser','2017-05-15 12:10:41',NULL,NULL,0,'','22573985927888631438','muhammed@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$DsQRyG4n3g.JpCrV3jBGIeqREWtw.qicW1hJe.2QxOoX30DpUh3tu',NULL,NULL,'CUS','muhammed.iscan'),(2,'anonymousUser','2017-05-15 10:31:20','\0',NULL,'anonymousUser','2017-05-15 13:31:20',NULL,NULL,0,'','35799759852311198954','osman@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$aChcrJIcEXnWD5qeTsGnOOcspKzGiAboDNkTxQgs1UvJez98IU42.',NULL,NULL,'BUM','osman.kara'),(3,'anonymousUser','2017-05-15 10:31:40','\0',NULL,'anonymousUser','2017-05-15 13:31:40',NULL,NULL,0,'','95491281040756078370','veli@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$sY/aYyinYs5nmAXGUgvPBOfVNqi4Q5qgwYWC6HBaoW7rKOkK4vxtm',NULL,NULL,'EMPTY','veli.idris'),(4,'anonymousUser','2017-05-15 10:31:54','\0',NULL,'anonymousUser','2017-05-15 13:31:54',NULL,NULL,0,'','10176397156623040455','halil@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$HfzDTwbf80SiaGi.Hwk/jeXqlBnJqU/1Ew8Z0dxhcY9GjrW9uvBAK',NULL,NULL,'EMPTY','halil.idris'),(5,'anonymousUser','2017-05-15 12:27:56','\0',NULL,'anonymousUser','2017-05-15 15:27:56',NULL,NULL,0,'','17734244400350809156','admin@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$LP5aqzbcyr3XB0vqihLTM.N17xM/uz44x0zQ8KdhTF1Af91mNiF0i',NULL,NULL,'EMPTY','admin.admin'),(6,'anonymousUser','2017-05-15 13:57:01','\0',NULL,'anonymousUser','2017-05-15 16:57:01',NULL,NULL,0,'\0','23512425187487685697','muhammediscannn@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$rUFeZf/kdNjzdSqBd.O.J.9ktKrI67qgrtf.nVQP5kL6ZDAvmBcfi',NULL,NULL,'EMPTY','mehment.gunduz'),(7,'anonymousUser','2017-05-15 14:00:35','\0',NULL,'anonymousUser','2017-05-15 17:00:35',NULL,NULL,0,'\0','91014952173512804588','muhammedischann@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$aeW//lig5znVdH9QK0tyi.wmSERGQ0ERpYQIiIhzaBylihDfuNmo2',NULL,NULL,'EMPTY','h'),(8,'anonymousUser','2017-05-15 14:01:39','\0',NULL,'anonymousUser','2017-05-15 17:01:39',NULL,NULL,0,'\0','53340024042594664467','h',NULL,NULL,NULL,NULL,'$2a$10$WkC/N38W6fJNlmPbnatTjOBkOoWVd1hL/AS/EUeoX7Ik/044dLzE.',NULL,NULL,'EMPTY','j'),(9,'anonymousUser','2017-05-15 14:04:24','\0',NULL,'anonymousUser','2017-05-15 17:04:24',NULL,NULL,0,'\0','67456631693952643052','muhammediscandfdn@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$3mkF2LszGzvemDDJfsrUTuB9/w/4pER/QY/H90p31rd.27F8QkX4W',NULL,NULL,'EMPTY','sdfs'),(10,'anonymousUser','2017-05-15 22:01:53','\0',NULL,'anonymousUser','2017-05-16 01:01:53',NULL,NULL,0,'','09959391980113897264','omer@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$F.NhM.7lpdeZdWJ1kr9wTekG3.bNxQQqswWlQZR175gNMsjprjUcC',NULL,NULL,'EMPTY','ömer.gunduz'),(11,'anonymousUser','2017-05-18 08:42:55','\0',NULL,'anonymousUser','2017-05-18 11:42:55',NULL,NULL,0,'\0','38954570775210983518','alifaruk@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$z73vDiVcT8SNGhQkPJg9/e9Rnw9LyMMVB51ABCU4ysapZMOy/t0mW',NULL,NULL,'EMPTY','alifaruk'),(12,'anonymousUser','2017-05-18 08:44:58','\0',NULL,'anonymousUser','2017-05-18 11:44:58',NULL,NULL,0,'\0','84233773249500230352','alifarukg@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$Q96nn8DuHXCPpH6Eqjd.keQ5rBOvOKsgfeFLXfbeGOWWTQm1/AcD2',NULL,NULL,'EMPTY','alifarukg'),(13,'anonymousUser','2017-05-18 08:49:08','\0',NULL,'anonymousUser','2017-05-18 11:49:08',NULL,NULL,0,'\0','04899205612744055951','alifarukdg@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$tS/Py5uo0wRxXM1GZeuwE.X52Lk4P44G/M1tqMctkOsqE3ZI5Rwae',NULL,NULL,'EMPTY','alidfarukg'),(14,'anonymousUser','2017-05-18 08:52:15','\0',NULL,'anonymousUser','2017-05-18 11:52:15',NULL,NULL,0,'\0','88985849857931671263','faruk@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$VT1azg7E3jcd8GH8SpkigeBe8fBQNgNr509wJAvJm9wFCBAtCK3iG',NULL,NULL,'EMPTY','faruk'),(15,'anonymousUser','2017-05-18 08:54:30','\0',NULL,'anonymousUser','2017-05-18 11:54:30',NULL,NULL,0,'\0','46642181922050317282','gurkan@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$OWTmb7sy1B1BmdHhRBDyCeHv1tJhxTRGrUzOrWbxW2r24Si/hy3Ym',NULL,NULL,'EMPTY','gürkan.enver'),(16,'anonymousUser','2017-05-18 08:59:25','\0',NULL,'anonymousUser','2017-05-18 11:59:25',NULL,NULL,0,'\0','39143992881482406962','gurkanf@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$w4oLSRdttRCEZZzhm1cN8.VQEUqCj5KkPXvXqXz/gsjzt3aPg2BtC',NULL,NULL,'EMPTY','gürkafn.enver'),(17,'anonymousUser','2017-05-18 09:51:18','\0',NULL,'anonymousUser','2017-05-18 12:51:18',NULL,NULL,0,'\0','80431936182408500817','murat@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$gea6UQXro8ZwPzW.WL2cvOzf5ZsYFVca3vKgqg6a8LxVkeGAb8pPm',NULL,NULL,'EMPTY','murat.boz'),(18,'anonymousUser','2017-05-18 12:39:31','\0',NULL,'anonymousUser','2017-05-18 15:39:31',NULL,NULL,0,'\0','76314925021771446628','deniz@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$Gx5hvcgab2bHHhh.OkMZweiHckmDcSAh8UWhe1MXoDbOM5s5W2A8.',NULL,NULL,'EMPTY','deniz.seki'),(19,'anonymousUser','2017-05-18 12:42:05','\0',NULL,'anonymousUser','2017-05-18 15:42:05',NULL,NULL,0,'\0','54836721097028388473','yildiz@gmail.com',NULL,NULL,NULL,NULL,'$2a$10$iLgsRKlsAwz96QfJRBMkTe8efYyUXwmOsLlJFOHVZFMS33YoYS.Fy',NULL,NULL,'EMPTY','yildiz.tilbe'),(20,'anonymousUser','2017-05-19 08:19:26','\0',NULL,'anonymousUser','2017-05-19 11:19:26',NULL,NULL,0,'\0','91436365435324439599','osmanbeyaz@gmail.com','Osman',NULL,NULL,'Beyaz','$2a$10$EqcOtQ148eYK4Ik1QGjm8egRPWenrV70roB95aV1Bf7WpCI3dZdJa',NULL,NULL,'EMPTY','osman.beyaz');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(1,2),(5,2),(2,3),(5,3),(3,4),(4,4),(5,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-19 16:30:17
