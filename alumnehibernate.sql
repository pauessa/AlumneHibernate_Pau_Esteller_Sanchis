-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-01-2019 a las 14:08:08
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alumnehibernate`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnes`
--

CREATE TABLE `alumnes` (
  `nexp` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `telefon` int(11) DEFAULT NULL,
  `sexe` tinyint(4) NOT NULL,
  `datanaix` date NOT NULL,
  `susp` int(11) NOT NULL,
  `grup` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnes`
--

INSERT INTO `alumnes` (`nexp`, `nom`, `telefon`, `sexe`, `datanaix`, `susp`, `grup`) VALUES
(1, 'Faus Gisbert, Esteve', 965530205, 1, '1984-06-30', 0, 'B1A'),
(2, 'Roig Mas, Begonya', 962382456, 0, '1987-02-18', 0, 'B2A'),
(3, 'Roma Prim, Empar', 965531122, 0, '1980-11-11', 2, 'F1V'),
(4, 'Amat Grau, Maria', 966502211, 0, '1984-08-22', 0, 'G1V'),
(5, 'Bas Ferrer, Josep', 965591145, 1, '1981-03-16', 1, 'I1M'),
(6, 'Mataix Folch, Joan', 965331212, 1, '1980-12-12', 2, 'I1M'),
(7, 'Molto Rodes, Jordi', 0, 1, '1981-02-28', 0, 'I1M'),
(8, 'Faus Pla, Joaquim', 965510066, 1, '1981-01-22', 0, 'R1V');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grups`
--

CREATE TABLE `grups` (
  `codi` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nivell` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `delegat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `grups`
--

INSERT INTO `grups` (`codi`, `nivell`, `delegat`) VALUES
('B1A', 'Batxiller', 1),
('B2A', 'Batxiller', 2),
('F1V', 'CF', 3),
('G1V', 'CF', 4),
('I1M', 'CF', 5),
('R1V', 'CF', 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`nexp`),
  ADD KEY `grup` (`grup`);

--
-- Indices de la tabla `grups`
--
ALTER TABLE `grups`
  ADD PRIMARY KEY (`codi`),
  ADD UNIQUE KEY `delegat` (`delegat`),
  ADD UNIQUE KEY `delegat_2` (`delegat`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnes`
--
ALTER TABLE `alumnes`
  MODIFY `nexp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`grup`) REFERENCES `grups` (`codi`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `grups`
--
ALTER TABLE `grups`
  ADD CONSTRAINT `grups_ibfk_1` FOREIGN KEY (`delegat`) REFERENCES `alumnes` (`nexp`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
