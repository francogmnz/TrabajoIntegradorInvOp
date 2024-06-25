-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bdproyectostock
-- ------------------------------------------------------
-- Server version	8.4.0

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
  `nombreArticulo` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `codArticulo` int NOT NULL,
  `costoUnidadArticulo` float DEFAULT NULL,
  `stockActualArticulo` int DEFAULT NULL,
  `costoPedidoArticulo` int DEFAULT NULL,
  `costoAlmacenimientoArticulo` float DEFAULT NULL,
  `codigoTipoArticulo` int NOT NULL,
  `modeloInventario` int DEFAULT NULL,
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
INSERT INTO `articulo` VALUES ('patito',1,1000,20,NULL,NULL,3,NULL);
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
  `nombreMes` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
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
/*!40000 ALTER TABLE `demanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleordencompra`
--

DROP TABLE IF EXISTS `detalleordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleordencompra` (
  `numDetalleOrdenCompra` int NOT NULL,
  `cantArticulosDOC` int DEFAULT NULL,
  `codArticulo` int NOT NULL,
  PRIMARY KEY (`numDetalleOrdenCompra`),
  KEY `fk_codArticulo_idx` (`codArticulo`),
  CONSTRAINT `fk_Articulo` FOREIGN KEY (`codArticulo`) REFERENCES `articulo` (`codArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleordencompra`
--

LOCK TABLES `detalleordencompra` WRITE;
/*!40000 ALTER TABLE `detalleordencompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleordencompra` ENABLE KEYS */;
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
  `nombreEstadoOC` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prediccioneshistoricas`
--

LOCK TABLES `prediccioneshistoricas` WRITE;
/*!40000 ALTER TABLE `prediccioneshistoricas` DISABLE KEYS */;
INSERT INTO `prediccioneshistoricas` VALUES (20,1,'Promedio móvil Ponderado',88,134),(21,1,'PM Suavizado Exponencialmente',10,460);
/*!40000 ALTER TABLE `prediccioneshistoricas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `nombreProveedor` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
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
INSERT INTO `proveedor` VALUES ('Mateo',1,292034,1,2);
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
  `nombreTipoArticulo` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
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
  `numVenta` int NOT NULL,
  `cantidad` int NOT NULL,
  `codArticulo` int NOT NULL,
  PRIMARY KEY (`numVenta`),
  KEY `codArticulo_idx` (`codArticulo`),
  CONSTRAINT `codArticulo` FOREIGN KEY (`codArticulo`) REFERENCES `articulo` (`codArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
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

-- Dump completed on 2024-06-25 17:14:20
