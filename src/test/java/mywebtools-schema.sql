-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-05-2015 a las 11:23:47
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
`id_category` int(8) NOT NULL  AUTO_INCREMENT,
  `category` varchar(256) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `timestamp` datetime NOT NULL,
  `ip` varchar(32) NOT NULL,
  `agent` varchar(512) NOT NULL,
  `logger` varchar(512) NOT NULL,
  `level` varchar(64) NOT NULL,
  `message` varchar(1024) NOT NULL,
  `file` varchar(256) DEFAULT NULL,
  `line` int(32) DEFAULT NULL,
  `year` int(4) NOT NULL,
  `month` int(2) NOT NULL,
  `day` int(2) NOT NULL,
  `hour` int(2) NOT NULL,
  `minute` int(2) NOT NULL,
  `second` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE IF NOT EXISTS `subcategory` (
  `id_subcategory` int(8) NOT NULL  AUTO_INCREMENT,
  `subcategory` varchar(256) NOT NULL,
  --`id_category` int(8) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tool`
--

DROP TABLE IF EXISTS `tool`;
CREATE TABLE IF NOT EXISTS `tool` (
`id_tool` int(255) NOT NULL  AUTO_INCREMENT,
  `id_category` int(8) DEFAULT NULL,
  `id_subcategory` int(8) DEFAULT NULL,
  `name` varchar(256) NOT NULL,
  `url` varchar(256) NOT NULL,
  `description` text,
  `rating` int(1) NOT NULL DEFAULT '0',
  `icon` text,
  `image` text,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  `isvalid` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
 ADD PRIMARY KEY (`id_category`);

--
-- Indices de la tabla `log`
--
ALTER TABLE `log`
 ADD PRIMARY KEY (`timestamp`,`ip`);

--
-- Indices de la tabla `subcategory`
--
ALTER TABLE `subcategory`
 ADD PRIMARY KEY (`id_subcategory`);

--
-- Indices de la tabla `tool`
--
ALTER TABLE `tool`
 ADD PRIMARY KEY (`id_tool`);



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
