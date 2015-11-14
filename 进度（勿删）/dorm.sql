-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.0.17-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 dorm 的数据库结构
CREATE DATABASE IF NOT EXISTS `dorm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dorm`;


-- 导出  表 dorm.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `dormapt` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.admin 的数据：~2 rows (大约)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`username`, `password`, `dormapt`) VALUES
	('admin1', '123456', '竹一'),
	('admin', '123', '竹二');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


-- 导出  表 dorm.create2 结构
CREATE TABLE IF NOT EXISTS `create2` (
  `name` varchar(50) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `message` varchar(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.create2 的数据：~2 rows (大约)
DELETE FROM `create2`;
/*!40000 ALTER TABLE `create2` DISABLE KEYS */;
INSERT INTO `create2` (`name`, `subject`, `message`) VALUES
	('1', '2', '3'),
	('1', '1', '1');
/*!40000 ALTER TABLE `create2` ENABLE KEYS */;


-- 导出  表 dorm.destination 结构
CREATE TABLE IF NOT EXISTS `destination` (
  `stunum` varchar(50) DEFAULT NULL,
  `stuname` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `dormapt` varchar(50) DEFAULT NULL,
  `dormnum` varchar(50) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `leavetime` varchar(50) DEFAULT NULL,
  `backtime` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.destination 的数据：~5 rows (大约)
DELETE FROM `destination`;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` (`stunum`, `stuname`, `phone`, `dormapt`, `dormnum`, `destination`, `leavetime`, `backtime`) VALUES
	('09133849', '汪鹤祥', '15162157838', '竹一', 'B4081', '去哪儿', '2015-07-29', '2015-07-31'),
	('09133849', '汪鹤祥', '15162157838', '竹一', 'B4081', '济南', '2015-07-20', '2015-07-29'),
	('09133850', '段誉', '15162156838', '竹一', 'A5022', '北京大兴', '2015-07-05', '2015-07-30'),
	('09133860', '赵敏', '15162153838', '竹二', 'B2022', '广西壮族自治区找同学玩', '2015-07-27', '2015-07-31'),
	('09133849', '汪鹤祥', '15162157838', '竹一', 'B4081', '南京', '2015-07-21', '2015-07-31');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;


-- 导出  表 dorm.fix 结构
CREATE TABLE IF NOT EXISTS `fix` (
  `fixorder` varchar(50) DEFAULT NULL,
  `stunum` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `dormapt` varchar(50) DEFAULT NULL,
  `dormnum` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `problem` varchar(400) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.fix 的数据：~5 rows (大约)
DELETE FROM `fix`;
/*!40000 ALTER TABLE `fix` DISABLE KEYS */;
INSERT INTO `fix` (`fixorder`, `stunum`, `name`, `dormapt`, `dormnum`, `phone`, `time`, `img`, `problem`, `type`) VALUES
	('20150729104349', '09133849', '汪鹤祥', '竹一', 'B4081', '15162157838', '2015-07-29', '20150708034102油菜花.jpg', ' 下水管坏了', '未完成'),
	('20150729151341', '09133849', '汪鹤祥', '竹一', 'B4081', '15162157838', '2015-07-19', '5429562615.jpg', ' 花洒坏了，请尽快维修，谢谢！', '已完成'),
	('20150729153933', '09133850', '段誉', '竹一', 'A5022', '15162156838', '2015-07-06', '20150708034102油菜花.jpg', '门坏了。。。', '已完成'),
	('20150729155348', '09133860', '赵敏', '竹二', 'B2022', '15162153838', '2015-07-20', '20150708033712花.jpg', ' 灯泡烧了', '未完成'),
	('20150730183405', '09133849', '汪', '竹一', 'B4081', '1516215', '2015-07-07', '20150708034102油菜花.jpg', ' 下水道', '已完成');
/*!40000 ALTER TABLE `fix` ENABLE KEYS */;


-- 导出  表 dorm.information 结构
CREATE TABLE IF NOT EXISTS `information` (
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `dormapt` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.information 的数据：~3 rows (大约)
DELETE FROM `information`;
/*!40000 ALTER TABLE `information` DISABLE KEYS */;
INSERT INTO `information` (`title`, `content`, `date`, `dormapt`) VALUES
	('B4081水电费', '竹一B4081的水电费该交了！！！', '2015-07-29', '竹二'),
	('电费', '竹一 B4091、B5021、A3022 请注意交电费，电量过低！', '2015-07-29', '竹二'),
	('B4082', '水电费没了', '2015-07-30', '竹一');
/*!40000 ALTER TABLE `information` ENABLE KEYS */;


-- 导出  表 dorm.suggestion 结构
CREATE TABLE IF NOT EXISTS `suggestion` (
  `stunum` varchar(50) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.suggestion 的数据：~5 rows (大约)
DELETE FROM `suggestion`;
/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
INSERT INTO `suggestion` (`stunum`, `title`, `name`, `content`, `date`) VALUES
	('09133849', '欢迎来到宿舍管家！', '汪鹤祥', '宿舍管家，就是好！', '2015-07-29 10:43:03'),
	('09133849', '对改进宿舍关系的若干建议', '汪果果', '宿舍关系的融洽，来自于大家的相互包容。多参加聚会活动，会改进我们的关系', '2015-07-29 15:12:24'),
	('09133850', '楼上说的对', '段誉羽', '怒赞楼上！！', '2015-07-29 15:38:38'),
	('09133860', 'yes', '敏敏', '众位哥哥说的不错，要有融洽的环境，一起参加活动是必要的.......', '2015-07-29 15:52:42'),
	('09133849', '哈哈', '我', '沟沟壑壑', '2015-07-30 18:33:07');
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;


-- 导出  表 dorm.users 结构
CREATE TABLE IF NOT EXISTS `users` (
  `stunum` varchar(50) DEFAULT NULL,
  `stuname` varchar(50) DEFAULT '',
  `dormnum` varchar(50) DEFAULT '',
  `dormapt` varchar(50) DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT '',
  `phone` varchar(50) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.users 的数据：~4 rows (大约)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`stunum`, `stuname`, `dormnum`, `dormapt`, `password`, `email`, `phone`) VALUES
	('09133861', '', '', '', '123456', '', ''),
	('09133850', '段誉', 'A5022', '竹一', '12345', '2418057698@qq.com', '15162156838'),
	('09133860', '赵敏', 'B2022', '竹二', '1234', '2418057698@qq.com', '15162153838'),
	('09133849', '汪鹤祥', 'B4081', '竹一', '123456', '2418057698@qq.com', '15162157838');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- 导出  表 dorm.water 结构
CREATE TABLE IF NOT EXISTS `water` (
  `stunum` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `dormapt` varchar(50) DEFAULT NULL,
  `dormnum` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `waterorder` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dorm.water 的数据：~5 rows (大约)
DELETE FROM `water`;
/*!40000 ALTER TABLE `water` DISABLE KEYS */;
INSERT INTO `water` (`stunum`, `name`, `dormapt`, `dormnum`, `phone`, `time`, `waterorder`, `type`) VALUES
	('09133849', '汪鹤祥', '竹一', 'B4081', '15162157838', '2015-07-29', '201562910421', '已支付'),
	('09133849', '张三丰', '竹一', 'B4081', '15162157839', '2015-07-30', '2015629151031', '未支付'),
	('09133850', '段誉', '竹一', 'A5022', '15162156838', '2015-07-13', '2015629153723', '未支付'),
	('09133860', '赵敏', '竹二', 'B2022', '15162153838', '2015-07-29', '2015629155013', '已支付'),
	('09133849', '汪鹤祥', '竹一', 'B4081', '15162157838', '2015-07-15', '2015630183228', '已支付');
/*!40000 ALTER TABLE `water` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
dorm