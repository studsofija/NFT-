/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.22-MariaDB : Database - nftmarketplace
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nftmarketplace` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `nftmarketplace`;

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `idKorisnik` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `korisnickoIme` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sifra` varchar(255) NOT NULL,
  `idPlacanja` bigint(20) NOT NULL,
  PRIMARY KEY (`idKorisnik`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `korisnik` */

/*Table structure for table `narudzbenica` */

DROP TABLE IF EXISTS `narudzbenica`;

CREATE TABLE `narudzbenica` (
  `idNarudzbenica` bigint(20) NOT NULL AUTO_INCREMENT,
  `cenaUkupno` double NOT NULL,
  `datum` date NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `idKorisnik` bigint(20) NOT NULL,
  PRIMARY KEY (`idNarudzbenica`),
  KEY `idKorisnik` (`idKorisnik`),
  CONSTRAINT `narudzbenica_ibfk_1` FOREIGN KEY (`idKorisnik`) REFERENCES `korisnik` (`idKorisnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `narudzbenica` */

/*Table structure for table `nft` */

DROP TABLE IF EXISTS `nft`;

CREATE TABLE `nft` (
  `idNFT` bigint(8) NOT NULL AUTO_INCREMENT,
  `nazivNFT` varchar(50) NOT NULL,
  `osnovica` double NOT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `idValuta` bigint(3) NOT NULL,
  PRIMARY KEY (`idNFT`),
  KEY `idValuta` (`idValuta`),
  CONSTRAINT `idValuta` FOREIGN KEY (`idValuta`) REFERENCES `valuta` (`idValuta`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `nft` */

insert  into `nft`(`idNFT`,`nazivNFT`,`osnovica`,`opis`,`idValuta`) values 
(10,'Purrgramming',13,'Zabavan način da upišeš svoj kod sa mačjim predenjem',1),
(11,'CatScript',50,'Kombinuje programiranje i mačji šarm',1),
(12,'PurrfectCode',10,'Savršen kod, savršen rezultat',1),
(13,'CatSharp',5,'Kombinacija mačjeg karaktera i lakog programiraanja',4);

/*Table structure for table `porez` */

DROP TABLE IF EXISTS `porez`;

CREATE TABLE `porez` (
  `idPorez` bigint(3) NOT NULL AUTO_INCREMENT,
  `stopa` double NOT NULL,
  `naziv` varchar(20) NOT NULL,
  PRIMARY KEY (`idPorez`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `porez` */

insert  into `porez`(`idPorez`,`stopa`,`naziv`) values 
(1,5,'PDV'),
(2,10,'digitalna imovina'),
(3,15,'kapitalna dobit'),
(4,2,'transakcije');

/*Table structure for table `stavkanarudzbenice` */

DROP TABLE IF EXISTS `stavkanarudzbenice`;

CREATE TABLE `stavkanarudzbenice` (
  `redniBroj` bigint(20) NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `kolicina` bigint(20) NOT NULL,
  `idNarudzbenice` bigint(20) NOT NULL,
  `idNFT` bigint(8) NOT NULL,
  `idPoreza` bigint(3) NOT NULL,
  PRIMARY KEY (`redniBroj`),
  KEY `idNarudzbenice` (`idNarudzbenice`),
  KEY `idNFT` (`idNFT`),
  KEY `idPoreza` (`idPoreza`),
  CONSTRAINT `stavkanarudzbenice_ibfk_1` FOREIGN KEY (`idNarudzbenice`) REFERENCES `narudzbenica` (`idNarudzbenica`) ON DELETE NO ACTION,
  CONSTRAINT `stavkanarudzbenice_ibfk_2` FOREIGN KEY (`idNFT`) REFERENCES `nft` (`idNFT`) ON DELETE NO ACTION,
  CONSTRAINT `stavkanarudzbenice_ibfk_3` FOREIGN KEY (`idPoreza`) REFERENCES `porez` (`idPorez`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkanarudzbenice` */

/*Table structure for table `valuta` */

DROP TABLE IF EXISTS `valuta`;

CREATE TABLE `valuta` (
  `idValuta` bigint(3) NOT NULL AUTO_INCREMENT,
  `nazivValute` varchar(20) NOT NULL,
  PRIMARY KEY (`idValuta`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `valuta` */

insert  into `valuta`(`idValuta`,`nazivValute`) values 
(1,'USD'),
(2,'RSD'),
(3,'GBP'),
(4,'EUR'),
(5,'BTC'),
(6,'ETH');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
