-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bdproyectostock
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `nombreArticulo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codArticulo` int NOT NULL,
  `costoUnidadArticulo` float DEFAULT NULL,
  `stockActualArticulo` int DEFAULT NULL,
  `costoPedidoArticulo` int DEFAULT NULL,
  `costoAlmacenimientoArticulo` float DEFAULT NULL,
  `codigoTipoArticulo` int NOT NULL,
  `modeloInventario` int DEFAULT NULL,
  `loteOptimo` float DEFAULT NULL,
  `puntoPedido` float DEFAULT NULL,
  `stockSeguridad` float DEFAULT NULL,
  PRIMARY KEY (`codArticulo`),
  KEY `fk_tipoArticulo_idx` (`codigoTipoArticulo`),
  KEY `fk_modeloInventario_idx` (`modeloInventario`),
  CONSTRAINT `fk_codTipoArticulo` FOREIGN KEY (`codigoTipoArticulo`) REFERENCES `tipoarticulo` (`codigoTipoArticulo`),
  CONSTRAINT `fk_modeloInventario` FOREIGN KEY (`modeloInventario`) REFERENCES `articulomodelo` (`codarticulomodelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES ('Juan',1,44,75,44,33,1,1,1827.93,8771000,4.35226),('Pedro',2,44,40,44,33,1,2,0,4.35226,4.35226),('Jorge',3,44,55,44,33,1,1,0,0,60),('Leo',4,34,43,22,11,2,2,NULL,50,NULL);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulomodelo`
--

DROP TABLE IF EXISTS `articulomodelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulomodelo` (
  `codarticulomodelo` int NOT NULL,
  `nombrearticulomodelo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codarticulomodelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulomodelo`
--

LOCK TABLES `articulomodelo` WRITE;
/*!40000 ALTER TABLE `articulomodelo` DISABLE KEYS */;
INSERT INTO `articulomodelo` VALUES (1,'Lote Fijo'),(2,'Intervalo Fijo');
/*!40000 ALTER TABLE `articulomodelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demanda`
--

DROP TABLE IF EXISTS `demanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demanda` (
  `numeroDemanda` int NOT NULL,
  `anio` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `mes` int NOT NULL,
  `nombreMes` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codArticulo` int DEFAULT NULL,
  PRIMARY KEY (`numeroDemanda`),
  KEY `fk_codArticulo_idx` (`codArticulo`),
  CONSTRAINT `fk_codArticulo` FOREIGN KEY (`codArticulo`) REFERENCES `articulo` (`codArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demanda`
--

LOCK TABLES `demanda` WRITE;
/*!40000 ALTER TABLE `demanda` DISABLE KEYS */;
INSERT INTO `demanda` VALUES (1,2024,12000,1,'Enero',1),(2,2024,18000,2,'Febrero',1),(3,2024,90000,3,'Marzo',1),(4,2024,130000,4,'Abril',1),(5,2024,190000,5,'Mayo',1),(6,2024,300000,6,'Junio',1),(7,2024,143000,7,'Julio',1),(8,2024,90000,8,'Agosto',1),(9,2024,70000,9,'Septiembre',1),(10,2024,40000,10,'Octubre',1),(11,2024,80000,11,'Noviembre',1),(12,2024,90000,12,'Diciembre',1),(13,2024,70000,1,'Enero',2),(14,2024,70000,2,'Febrero',2),(15,2024,70000,3,'Marzo',2),(16,2024,70000,4,'Abril',2),(17,2024,70000,5,'Mayo',2),(18,2024,70000,6,'Junio',2),(19,2024,70000,7,'Julio',2),(20,2024,70000,8,'Agosto',2),(21,2024,70000,9,'Septiembre',2),(22,2024,70000,10,'Octubre',2),(23,2024,70000,11,'Noviembre',2),(24,2024,70000,12,'Diciembre',2);
/*!40000 ALTER TABLE `demanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoordencompra`
--

DROP TABLE IF EXISTS `estadoordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoordencompra` (
  `codEstadoOC` int NOT NULL,
  `fechaCambio` date DEFAULT NULL,
  `nombreEstadoOC` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codEstadoOC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoordencompra`
--

LOCK TABLES `estadoordencompra` WRITE;
/*!40000 ALTER TABLE `estadoordencompra` DISABLE KEYS */;
INSERT INTO `estadoordencompra` VALUES (1,'2024-06-23','Realizada');
/*!40000 ALTER TABLE `estadoordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompra`
--

DROP TABLE IF EXISTS `ordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordencompra` (
  `numOrdenCompra` int NOT NULL,
  `fechaCreacionOC` date DEFAULT NULL,
  `codEstadoOC` int NOT NULL,
  `codProveedor` int NOT NULL,
  `codArticulo` int DEFAULT NULL,
  `cantArticulosOC` int DEFAULT NULL,
  PRIMARY KEY (`numOrdenCompra`),
  KEY `fk_estado_idx` (`codEstadoOC`),
  KEY `fk_proveedor_idx` (`codProveedor`),
  KEY `fk_articulo_idx` (`codArticulo`),
  CONSTRAINT `fk_codigoArticulo` FOREIGN KEY (`codArticulo`) REFERENCES `articulo` (`codArticulo`),
  CONSTRAINT `fk_estado` FOREIGN KEY (`codEstadoOC`) REFERENCES `estadoordencompra` (`codEstadoOC`),
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`codProveedor`) REFERENCES `proveedor` (`codProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompra`
--

LOCK TABLES `ordencompra` WRITE;
/*!40000 ALTER TABLE `ordencompra` DISABLE KEYS */;
INSERT INTO `ordencompra` VALUES (1,'2024-03-01',1,1,1,30),(2,'2024-06-26',1,1,1,44),(3,'2024-06-26',1,1,1,3),(4,'2024-06-26',1,1,1,5);
/*!40000 ALTER TABLE `ordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prediccioneshistoricas`
--

DROP TABLE IF EXISTS `prediccioneshistoricas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prediccioneshistoricas` (
  `numPrediccionHistorica` int NOT NULL AUTO_INCREMENT,
  `Articulo` int DEFAULT NULL,
  `ModeloPrediccion` varchar(255) DEFAULT NULL,
  `Error` decimal(10,0) DEFAULT NULL,
  `resultadoDemanda` int DEFAULT NULL,
  PRIMARY KEY (`numPrediccionHistorica`),
  KEY `fk_codigodelarticuloo_idx` (`Articulo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prediccioneshistoricas`
--

LOCK TABLES `prediccioneshistoricas` WRITE;
/*!40000 ALTER TABLE `prediccioneshistoricas` DISABLE KEYS */;
INSERT INTO `prediccioneshistoricas` VALUES (20,1,'Promedio móvil Ponderado',88,134),(21,1,'PM Suavizado Exponencialmente',10,460),(22,1,'Promedio móvil Ponderado',75,43000),(23,1,'PM Suavizado Exponencialmente',2,91500),(24,1,'Promedio móvil Ponderado',100,0),(25,1,'Promedio móvil Ponderado',100,0),(26,1,'Promedio móvil Ponderado',75,43000);
/*!40000 ALTER TABLE `prediccioneshistoricas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `nombreProveedor` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codProveedor` int NOT NULL,
  `celular` int DEFAULT NULL,
  `tipoArticuloId` int DEFAULT NULL,
  `diasDemora` int DEFAULT NULL,
  PRIMARY KEY (`codProveedor`),
  KEY `fk_idTipoArticulo_idx` (`tipoArticuloId`),
  CONSTRAINT `fk_idTipoArticulo` FOREIGN KEY (`tipoArticuloId`) REFERENCES `tipoarticulo` (`codigoTipoArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('Jorge',1,2944324,1,7);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoarticulo`
--

DROP TABLE IF EXISTS `tipoarticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoarticulo` (
  `codigoTipoArticulo` int NOT NULL,
  `nombreTipoArticulo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigoTipoArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoarticulo`
--

LOCK TABLES `tipoarticulo` WRITE;
/*!40000 ALTER TABLE `tipoarticulo` DISABLE KEYS */;
INSERT INTO `tipoarticulo` VALUES (1,'Campera'),(2,'Buzos'),(3,'Accesorios'),(4,'Remeras');
/*!40000 ALTER TABLE `tipoarticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `fechaVenta` date NOT NULL,
  `numVenta` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `codArticulo` int NOT NULL,
  PRIMARY KEY (`numVenta`),
  KEY `codArticulo_idx` (`codArticulo`),
  CONSTRAINT `codArticulo` FOREIGN KEY (`codArticulo`) REFERENCES `articulo` (`codArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES ('2024-06-26',1,10,4),('2024-06-26',3,2,2),('2024-06-26',4,1,2),('2024-06-26',5,1,2),('2024-06-26',6,3,2),('2024-06-26',7,1,1),('2024-06-26',8,10,1),('2024-06-26',9,12,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-26 21:59:01
