-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: nhnpre
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `text` varchar(3000) NOT NULL,
  `add_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'lovegjgjgj@naver.com','1234','This is first Article','2016-12-19 01:18:43',NULL),(2,'lovegjgjgj@gmail.com','12345','test article2','2016-12-19 06:36:33',NULL),(3,'lovegjgjgj@hanmail.net','1515','Insert Test','2016-12-20 19:37:28',NULL),(4,'lovegjgjgj@hanmail.net','1515','Insert Test 2','2016-12-20 19:38:31',NULL),(5,'lovegjgjgj@hanmail.net','1515','Insert Test 3','2016-12-22 22:48:39',NULL),(6,'lovegjgjgj@hanmail.net','1515','Insert Test 4','2016-12-22 23:08:22',NULL),(7,'lovegjgjgj@hanmail.net','1515','Insert Test 5','2016-12-22 23:32:30',NULL),(8,'lovegjgjgj@hanmail.net','1515','Modify 1','2016-12-22 23:34:06','2016-12-26 23:27:52'),(9,'lovegjgjgj@hanmail.net','1234','test 9','2017-01-14 21:48:04',NULL),(10,'lovegjgjgj@hanmail.net','1234','modify 2','2017-01-15 01:12:51',NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-15  1:55:41
