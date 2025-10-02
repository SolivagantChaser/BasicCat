--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) NOT NULL,
                           `role_key` varchar(255) NOT NULL,
                           `description` varchar(255) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
INSERT INTO `tb_role` VALUES (1,'admin','admin','admin','2021-09-08 17:09:15','2021-09-08 17:09:15');
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `user_name` varchar(45) NOT NULL,
                           `password` varchar(45) NOT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           `phone_number` int(11) DEFAULT NULL,
                           `description` varchar(255) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
INSERT INTO `tb_user` VALUES (1,'pdai','dfasdf','suzhou.daipeng@gmail.com',1212121213,'afsdfsaf','2021-09-08 17:09:15','2021-09-08 17:09:15');
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role`
--

DROP TABLE IF EXISTS `tb_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_role` (
                                `user_id` int(11) NOT NULL,
                                `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
-- Dumping data for table `tb_user_role`
--

LOCK TABLES `tb_user_role` WRITE;
INSERT INTO `tb_user_role` VALUES (1,1);
UNLOCK TABLES;