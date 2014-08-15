CREATE DATABASE  IF NOT EXISTS `webshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `webshop`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: webshop
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `price` decimal(50,0) NOT NULL,
  `expirationDate` datetime NOT NULL,
  `sellerUsername` varchar(45) NOT NULL,
  `sold` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `SellerUsername_idx` (`sellerUsername`),
  CONSTRAINT `sellerUsername` FOREIGN KEY (`sellerUsername`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (29,'product1','My new product1 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(30,'product2','My new product2 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(31,'product3','My new product3 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(32,'product4','My new product4 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(33,'product5','My new product5 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(34,'product6','My new product6 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(35,'product7','My new product7 is awsome!',12000,'2014-09-01 00:00:00','balazs',''),(36,'product8','My new product8 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(37,'product9','My new product9 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(38,'product10','My new product10 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(39,'product11','My new product11 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(40,'product12','My new product12 is awsome!',12000,'2014-09-01 00:00:00','balazs','\0'),(41,'product13','My new product13 is awsome!',12000,'2014-09-01 00:00:00','balazs',''),(42,'product14','My new product14 is awsome!',12000,'2014-09-01 00:00:00','balazs',''),(43,'Trabant','It\'s a trabant',12500,'2014-08-25 00:00:00','user1','');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-15 16:18:20
