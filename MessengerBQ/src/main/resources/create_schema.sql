/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;

grant all privileges on *.* to  'messenger'@'localhost' identified by 'messenger1234#';
grant all privileges on *.* to  'messenger'@'%' identified by 'messenger1234#';

DROP DATABASE IF EXISTS `messenger`;
CREATE DATABASE `messenger` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `messenger`;

#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `internalId` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) DEFAULT NULL UNIQUE,  
  `name` varchar(255),
  `email` varchar(255),
  PRIMARY KEY (`internalId`)
) ;

#
# Source for table "message"
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `internalId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(255) NOT NULL,  
  `body` varchar(4096),
  PRIMARY KEY (`internalId`)
) ;

CREATE INDEX i_userId USING BTREE on message(userId);

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
