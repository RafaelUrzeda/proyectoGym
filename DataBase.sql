-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.3.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para proyectojava1
CREATE DATABASE IF NOT EXISTS `proyectojava1` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `proyectojava1`;

-- Volcando estructura para tabla proyectojava1.clases
CREATE TABLE IF NOT EXISTS `clases` (
  `tipo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `aforo` varchar(255) DEFAULT NULL,
  `duracion` varchar(255) DEFAULT NULL,
  `numeroEmpleado` varchar(255) DEFAULT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  `intensidad` varchar(255) DEFAULT NULL,
  `tipoCiclismo` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla proyectojava1.clases: ~6 rows (aproximadamente)
REPLACE INTO `clases` (`tipo`, `nombre`, `horario`, `aforo`, `duracion`, `numeroEmpleado`, `nivel`, `intensidad`, `tipoCiclismo`, `material`) VALUES
	('Bodypump', 'Bodypump Clase A', 'PimeraHora', '20', '1 hora', 'E1234', 'Intermedio', 'Alta', NULL, 'Pesas'),
	('Ciclismo', 'Ciclismo Indoor', 'SegundaHora', '15', '1 hora', 'E5678', NULL, NULL, 'Indoor', 'Bicicletas estáticas'),
	('Yoga', 'Yoga Relax', 'PimeraHora', '10', '1 hora', 'E1121', 'Principiante', 'Baja', NULL, 'Esterillas'),
	('Bodypump', 'Bodypump Clase B', 'TerceraHora', '20', '1 hora', 'E1234', 'Avanzado', 'Alta', NULL, 'Pesas'),
	('Pilates', 'Pilates Mat', 'CuartaHora', '15', '1 hora', 'E3141', 'Intermedio', 'Media', NULL, 'Colchonetas'),
	('Yoga', 'Relax', 'PimeraHora', '45', '14', 'E009', 'Principiante', NULL, NULL, 'Nada');

-- Volcando estructura para tabla proyectojava1.entrenadores
CREATE TABLE IF NOT EXISTS `entrenadores` (
  `nombre` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `dni` varchar(255) NOT NULL,
  `numeroEmpleado` varchar(255) DEFAULT NULL,
  `antiguedad` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla proyectojava1.entrenadores: ~6 rows (aproximadamente)
REPLACE INTO `entrenadores` (`nombre`, `edad`, `dni`, `numeroEmpleado`, `antiguedad`, `horario`, `especialidad`) VALUES
	('David B', 29, '123456a', 'ENT001', '5', 'Tarde', 'Entrenador Personal'),
	('Laura', 23, '129564f', 'E009', '8', 'Tarde', 'Yoga'),
	('Sara', 30, '13131313B', 'ENT002', '5 años', 'Tarde', 'Crossfit'),
	('Javier', 35, '14141414C', 'ENT003', '6 años', 'Noche', 'Yoga'),
	('Eva', 32, '15151515D', 'ENT004', '3 años', 'Tarde', 'Pilates'),
	('Antonio', 40, '16161616E', 'ENT005', '8 años', 'Mañana', 'Bodypump');

-- Volcando estructura para tabla proyectojava1.gerentes
CREATE TABLE IF NOT EXISTS `gerentes` (
  `nombre` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `dni` varchar(255) NOT NULL,
  `numeroEmpleado` varchar(255) DEFAULT NULL,
  `antiguedad` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla proyectojava1.gerentes: ~5 rows (aproximadamente)
REPLACE INTO `gerentes` (`nombre`, `edad`, `dni`, `numeroEmpleado`, `antiguedad`, `horario`, `departamento`) VALUES
	('Elena', 42, '10101010E', 'GER005', '9 años', 'Mañana', 'Finanzas'),
	('Laura', 35, '66666666A', 'GER001', '7 años', 'Tarde', 'Administración'),
	('Carlos', 40, '77777777B', 'GER002', '10 años', 'Mañana', 'Recursos Humanos'),
	('Marta', 45, '88888888C', 'GER003', '12 años', 'Tarde', 'Ventas'),
	('Pablo', 38, '99999999D', 'GER004', '8 años', 'Noche', 'Marketing');

-- Volcando estructura para tabla proyectojava1.recepcionistas
CREATE TABLE IF NOT EXISTS `recepcionistas` (
  `nombre` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `dni` varchar(255) NOT NULL,
  `numeroEmpleado` varchar(255) DEFAULT NULL,
  `antiguedad` varchar(255) DEFAULT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `idiomas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla proyectojava1.recepcionistas: ~5 rows (aproximadamente)
REPLACE INTO `recepcionistas` (`nombre`, `edad`, `dni`, `numeroEmpleado`, `antiguedad`, `horario`, `idiomas`) VALUES
	('María', 25, '11111111A', 'REC001', '2 años', 'Mañana', 'Inglés, Francés'),
	('Juan', 28, '22222222B', 'REC002', '3 años', 'Tarde', 'Inglés, Alemán'),
	('Luisa', 30, '33333333C', 'REC003', '1 año', 'Tarde', 'Inglés, Italiano'),
	('Ana', 32, '44444444D', 'REC004', '5 años', 'Mañana', 'Inglés, Portugués'),
	('Pedro', 27, '55555555E', 'REC005', '4 años', 'Noche', 'Inglés, Chino');

-- Volcando estructura para tabla proyectojava1.usuarioclase
CREATE TABLE IF NOT EXISTS `usuarioclase` (
  `usuario_dni` varchar(255) DEFAULT NULL,
  `clase_nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla proyectojava1.usuarioclase: ~6 rows (aproximadamente)
REPLACE INTO `usuarioclase` (`usuario_dni`, `clase_nombre`) VALUES
	('44444444F', 'Bodypump Clase A'),
	('55555555G', 'Ciclismo Indoor'),
	('66666666H', 'Yoga Relax'),
	('77777777I', 'Bodypump Clase B'),
	('88888888J', 'Pilates Mat'),
	('44444444F', 'Bodypump Clase A');

-- Volcando estructura para tabla proyectojava1.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `nombre` varchar(255) DEFAULT NULL,
  `edad` varchar(255) DEFAULT NULL,
  `dni` varchar(255) NOT NULL,
  `peso` int(11) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL,
  `planEntrenamiento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla proyectojava1.usuarios: ~5 rows (aproximadamente)
REPLACE INTO `usuarios` (`nombre`, `edad`, `dni`, `peso`, `altura`, `planEntrenamiento`) VALUES
	('Ana', '25', '44444444F', 55, 165, 'Tonificación'),
	('David', '30', '55555555G', 80, 180, 'Cardio'),
	('Elena', '40', '66666666H', 60, 170, 'Flexibilidad'),
	('Miguel', '35', '77777777I', 75, 175, 'Fuerza'),
	('Sara', '28', '88888888J', 65, 160, 'Tonificación');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
