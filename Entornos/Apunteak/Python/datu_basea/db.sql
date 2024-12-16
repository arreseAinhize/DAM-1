-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ordenagailuak
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB-1:10.5.8+maria~focal

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP DATABASE IF EXISTS `ordenagailuak`;
CREATE DATABASE `ordenagailuak`;

USE `ordenagailuak`;


--
-- Table structure for table `SOLAIRUA`
--

DROP TABLE IF EXISTS `SOLAIRUA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SOLAIRUA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `KODEA` varchar(100) NOT NULL,
  `IZENA` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `GELA`
--

DROP TABLE IF EXISTS `GELA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GELA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SOLAIRUA` int(11) NOT NULL,
  `KODEA` varchar(100) DEFAULT NULL,
  `IZENA` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `SOLAIRUA` FOREIGN KEY (`SOLAIRUA`) REFERENCES `SOLAIRUA` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ORDENAGAILUA`
--

DROP TABLE IF EXISTS `ORDENAGAILUA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDENAGAILUA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GELA` int(11) NOT NULL,
  `KODEA` varchar(100) NOT NULL,
  `IP_HELBIDEA` varchar(100) NOT NULL,
  `SISTEMA_ERAGILEA` varchar(100) DEFAULT NULL ,
  `EROSKETA_EGUNA` date DEFAULT NULL,
  `AZKEN_ERREBISIOA` date DEFAULT NULL,
  `OHARRAK` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `GELA_FK` FOREIGN KEY (`GELA`) REFERENCES `GELA` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-07  9:41:29
