-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 27 Janvier 2015 à 22:41
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `easyesdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `ID` int(11) NOT NULL,
  `UPDATEDATE` date DEFAULT NULL,
  `CREATEDATE` date NOT NULL,
  `UPDATEUSER` varchar(255) NOT NULL,
  `SURNAME` varchar(255) NOT NULL,
  `FIRSTNAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tr_call_center_organisation`
--

CREATE TABLE IF NOT EXISTS `tr_call_center_organisation` (
  `tr_organization_idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`tr_organization_idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tr_call_center_service`
--

CREATE TABLE IF NOT EXISTS `tr_call_center_service` (
  `tr_orga_serv_association_tr_organization_idtr_organization` int(11) NOT NULL,
  `tr_orga_serv_association_tr_service_type_tr_service_type_code` int(11) NOT NULL,
  PRIMARY KEY (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tr_hospital_service`
--

CREATE TABLE IF NOT EXISTS `tr_hospital_service` (
  `tr_hospital_capacity` int(11) DEFAULT NULL,
  `tr_orga_serv_association_tr_organization_idtr_organization` int(11) NOT NULL,
  `tr_orga_serv_association_tr_service_type_tr_service_type_code` int(11) NOT NULL,
  PRIMARY KEY (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`),
  KEY `fk_tr_hospital_service_tr_orga_serv_association1_idx` (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tr_infra_category`
--

CREATE TABLE IF NOT EXISTS `tr_infra_category` (
  `idtr_infra_category` int(11) NOT NULL,
  `tr_infra_label` varchar(255) DEFAULT NULL,
  `tr_infra_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idtr_infra_category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tr_infra_equipment`
--

CREATE TABLE IF NOT EXISTS `tr_infra_equipment` (
  `idtr_infra_equipment` int(11) NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_USER` varchar(255) NOT NULL,
  `tr_infra_label` varchar(255) NOT NULL,
  `tr_infra_serial_number` varchar(10) NOT NULL,
  `idtr_infra_type_ref_infra` int(11) DEFAULT NULL,
  `idtr_organization` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtr_infra_equipment`),
  KEY `FK_kmpodc4hncct8bwevw9f0mobx` (`idtr_infra_type_ref_infra`),
  KEY `FK_6qimy8ek8ae2463v8xj1tijdw` (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tr_infra_infrastructure`
--

CREATE TABLE IF NOT EXISTS `tr_infra_infrastructure` (
  `idtr_infra_infrastructure` int(11) NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_USER` varchar(255) NOT NULL,
  `tr_infra_label` varchar(255) NOT NULL,
  `tr_infra_code` varchar(10) NOT NULL,
  `tr_infra_capacity` int(11) NOT NULL,
  `idtr_infra_type_ref_infra` int(11) NOT NULL,
  `idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`idtr_infra_infrastructure`),
  KEY `FK_p3wldx0j3op0pg9noy3kx9jb8` (`idtr_infra_type_ref_infra`),
  KEY `FK_ir8sl6d5kae97le3qb95ht8a7` (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tr_infra_medicine`
--

CREATE TABLE IF NOT EXISTS `tr_infra_medicine` (
  `idtr_infra_medicine` int(11) NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_USER` varchar(255) NOT NULL,
  `tr_infra_label` varchar(255) NOT NULL,
  `tr_infra_ucdCode` varchar(10) NOT NULL,
  `tr_infra_quantity` int(11) NOT NULL,
  `idtr_infra_type_ref_infra` int(11) DEFAULT NULL,
  `idtr_organization` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtr_infra_medicine`),
  KEY `FK_8nirin0t3d31rvwyuj60w7et5` (`idtr_infra_type_ref_infra`),
  KEY `FK_dlc4tn7n5kha5jcbeahucyles` (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tr_infra_type_ref_infra`
--

CREATE TABLE IF NOT EXISTS `tr_infra_type_ref_infra` (
  `idtr_infra_type_ref_infra` int(11) NOT NULL,
  `tr_infra_label` varchar(255) DEFAULT NULL,
  `tr_infra_code` varchar(10) DEFAULT NULL,
  `idtr_infra_category` int(11) NOT NULL,
  PRIMARY KEY (`idtr_infra_type_ref_infra`),
  KEY `FK_cq87x56qwdguh6l6cscp0b5ba` (`idtr_infra_category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tr_mobile_unit_organization`
--

CREATE TABLE IF NOT EXISTS `tr_mobile_unit_organization` (
  `tr_organization_idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`tr_organization_idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tr_mobile_unit_service`
--

CREATE TABLE IF NOT EXISTS `tr_mobile_unit_service` (
  `tr_orga_serv_association_tr_organization_idtr_organization` int(11) NOT NULL,
  `tr_orga_serv_association_tr_service_type_tr_service_type_code` int(11) NOT NULL,
  PRIMARY KEY (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tr_organization`
--

CREATE TABLE IF NOT EXISTS `tr_organization` (
  `idtr_organization` int(11) NOT NULL AUTO_INCREMENT,
  `tr_orga_siret` varchar(45) DEFAULT NULL,
  `tr_orga_company_name` varchar(45) DEFAULT NULL,
  `tr_orga_street_number` int(6) DEFAULT NULL,
  `tr_orga_street_type` varchar(45) DEFAULT NULL,
  `tr_orga_street_name` varchar(45) DEFAULT NULL,
  `tr_orga_city` varchar(45) DEFAULT NULL,
  `tr_orga_zip_code` varchar(45) DEFAULT NULL,
  `tr_orga_department` varchar(45) DEFAULT NULL,
  `tr_orga_tel_number` varchar(45) DEFAULT NULL,
  `tr_orga_fax` varchar(45) DEFAULT NULL,
  `tr_orga_email` varchar(45) DEFAULT NULL,
  `tr_orga_latitude` float DEFAULT NULL,
  `tr_orga_longitude` float DEFAULT NULL,
  `UPDATEDATE` date DEFAULT NULL,
  `CREATEDATE` date DEFAULT NULL,
  `UPDATEUSER` varchar(45) DEFAULT NULL,
  `idtr_organization_type` int(11) NOT NULL,
  PRIMARY KEY (`idtr_organization`,`idtr_organization_type`),
  UNIQUE KEY `idtr_organization_UNIQUE` (`idtr_organization`),
  KEY `fk_tr_organization_tr_organization_type1_idx` (`idtr_organization_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=44 ;

--
-- Contenu de la table `tr_organization`
--

INSERT INTO `tr_organization` (`idtr_organization`, `tr_orga_siret`, `tr_orga_company_name`, `tr_orga_street_number`, `tr_orga_street_type`, `tr_orga_street_name`, `tr_orga_city`, `tr_orga_zip_code`, `tr_orga_department`, `tr_orga_tel_number`, `tr_orga_fax`, `tr_orga_email`, `tr_orga_latitude`, `tr_orga_longitude`, `UPDATEDATE`, `CREATEDATE`, `UPDATEUSER`, `idtr_organization_type`) VALUES
(1, '14521568564548', 'Mondor', 83, 'bis', 'rue petit', 'Paris', '75019', 'Ile de france', '0184852643', '0142625948', 'koulibali.samuel@gmail.com', -45.1548, 1.25, NULL, '2015-01-01', 'labraga', 1),
(2, '14521568564549', 'Ambulance Paris', 114, 'ter', 'rue de la victoire', 'Paris', '75008', 'Ile de france', '0184852643', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-05', 'labraga', 3),
(3, '14521568564564', 'Hopital Jules Vernes', 78, '', 'Rue de la Boétie', 'Paris', '75010', 'Ile de france', '0146582377', '0142586959', 'hjules-vernes@h-paris.fr', 78.4524, 14.125, NULL, '2015-01-05', 'labraga', 2),
(4, '14521568564570', 'Ambulance Créteil', 84, 'Avenue', 'Martial Roth', 'Créteil', '94000', 'Ile de france', '0251452623', '0142586959', 'samuel@koulibali.com', -75.26, 52, NULL, '2015-01-05', 'labraga', 3),
(5, '14521568564546', 'Ambulance Paris Bis', 85, 'rue', 'Prada', 'Paris', '75010', 'Ile de france', '0146582807', '0142586959', 'ambulance@h-parisbis.fr', -45.1548, 1.2, NULL, '2015-01-05', 'labraga', 3),
(6, '14521568561864', 'abc ambulance', 1, 'avenue', 'place du parc', 'Paris', '75005', 'Ile de france', '0123659856', '0142625856', 'ambulance.accueil@abc.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(7, '14521568564579', 'EPP', 40, 'Avenue', 'Martial Roth', 'Paris', '75008', 'Ile de france', '0146582301', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(8, '14521568564549', 'Ambulance Paris', 82, 'Avenue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0146582301', '0142586544', 'koulibali.samuel@gmail.com', -45.1548, 52.3, NULL, '2015-01-05', 'labraga', 3),
(9, '14521568564548', 'Samuel', 85, 'rue', 'rue petit', 'Créteil', '75010', 'Ile de france', '0146582301', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 2),
(10, '14521568564548', 'Esiag', 45, 'rue', 'Martial Roth', 'Paris', '75010', 'Ile de france', '0142515658', '0142625944', 'koulibali.samuel@gmail.com', -45.1548, 14.125, NULL, '2015-01-05', 'labraga', 4),
(11, '14521568564548', 'Esiag', 52, 'Rue', 'Martial Roth', 'petit', '75010', 'Ile de france', '0146582301', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(12, '14521568564548', 'Ambulance Paris', 52, 'Avenue', 'Martial Roth', 'Paris', '75008', 'Ile de france', '0146582301', '0142586959', 'koulibali.samuel@gmail.com', -45.1548, -1.25, NULL, '2015-01-05', 'labraga', 4),
(13, '14521568564548', 'Ambulance Paris', 52, 'Rue', 'Martial Roth', 'Paris', '75010', 'Ile de france', '0123659856', '0142586959', 'koulibali.samuel@yahoo.fr', 78.4524, -1.25, NULL, '2015-01-05', 'labraga', 4),
(14, '14521568564548', 'EPP', 89, 'rue', 'petit', 'Paris', '75008', 'Ile de france', '0146582300', '0142586959', 'modor@creteil.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(15, '14521568564548', 'Mondor', 88, 'rue', 'Martial Roth', 'Paris', '75010', 'Ile de france', '0146582301', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(16, '14521568564548', 'Ambulance Paris', 99, 'Avenue', 'Martial Roth', 'Créteil', '94000', 'Ile de france', '0142515658', '0142625948', 'koulibali.samuel@gmail.com', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(17, '14521568564548', 'Ambulance Paris', 14, 'Avenue', 'Martial Roth', 'Paris', '75010', 'Ile de france', '0123659856', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-05', 'labraga', 3),
(18, '14521568564548', 'Ambulance Paris', 45, 'rue', 'Martial Roth', 'Paris', '75010', 'Ile de france', '0142515658', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-05', 'labraga', 3),
(19, '14521568564548', 'Ambulance Paris', 11, 'Avenue', 'du chemin vert', 'Paris', '75008', 'Ile de france', '0142515658', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(20, '14521568564548', 'Ambulance Paris', 15, 'Avenue', 'rue petit', 'Créteil', '94000', 'Ile de france', '0123659856', '0142625944', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(21, '14521568564548', 'Ambulance Paris', 52, 'rue', 'Mondor', 'Paris', '75019', 'Ile de france', '0146582300', '0142625948', 'modor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-05', 'labraga', 3),
(22, '14521568564549', 'Ambulance Paris', 47, 'Avenue', 'Martial Roth', 'Paris', '75008', 'Ile de france', '0146582301', '0142625948', 'modor@creteil.fr', -75.26, -1.265, NULL, '2015-01-05', 'labraga', 3),
(23, '14521568564548', 'Ambulance Paris', 45, 'Avenue', 'Martial Roth', 'Créteil', '94000', 'Ile de france', '0142515658', '0142625948', 'koulibali.samuel@gmail.com', -45.1548, -1.265, NULL, '2015-01-05', 'labraga', 3),
(24, '14521568564548', 'Ambulance Paris', 45, 'rue', 'Petit', 'Paris', '75019', 'Ile de france', '0142515658', '0142586959', 'samuel@koulibali.com', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 3),
(25, '14521568564548', 'Ambulance Paris', 42, 'rue', 'Petit', 'Paris', '75010', 'Ile de france', '0123659856', '0142586959', 'modor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 3),
(26, '14521568564548', 'Ambulance Paris', 96, 'rue', 'rue petit', 'Créteil', '75019', 'Ile de france', '0123659856', '0142586959', 'hjules-vernes@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(27, '14521568564548', 'Ambulance Paris', 85, 'rue', 'Mondor', 'Paris', '75019', 'Ile de france', '0123659856', '0142586959', 'koulibali.samuel@gmail.com', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(28, '14521568564548', 'Ambulance Paris', 70, 'ter', 'rue petit', 'Paris', '75006', 'Ile de france', '0184852643', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(29, '14521568564548', 'Ambulance Paris', 47, 'Avenue', 'Martial Roth', 'Créteil', '94000', 'Ile de france', '0142515658', '0142586959', 'koulibali.samuel@gmail.com', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(30, '14521568564548', 'Ambulance Paris', 85, 'rue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0184852643', '0142625948', 'modor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 3),
(31, '14521568564548', 'Ambulance Paris', 85, 'rue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0184852643', '0142625948', 'modor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 3),
(32, '14521568564548', 'Mondor', 69, 'Avenue', 'Martial Roth', 'Créteil', '94000', 'Ile de france', '0123659856', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 3),
(33, '14521568564548', 'Mondor', 69, 'Avenue', 'Martial Roth', 'Créteil', '94000', 'Ile de france', '0123659856', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 3),
(34, '14521568564548', 'Ambulance Paris', 85, 'Avenue', 'rue petit', 'Créteil', '75008', 'Ile de france', '0123659856', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(35, '14521568564548', 'Ambulance Paris', 85, 'Avenue', 'rue petit', 'Créteil', '75008', 'Ile de france', '0123659856', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(36, '14521568564548', 'Ambulance Paris', 85, 'Avenue', 'rue petit', 'Créteil', '75008', 'Ile de france', '0123659856', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.265, NULL, '2015-01-06', 'labraga', 3),
(37, '14521568544546', 'Mondor', 14, 'ter', 'rue de la victoire', 'Créteil', '94000', 'Ile de france', '0146582301', '0142625944', 'mondor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 1),
(38, '14521568544546', 'Mondor', 14, 'ter', 'rue de la victoire', 'Créteil', '94000', 'Ile de france', '0146582301', '0142625944', 'mondor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 1),
(39, '14521568544546', 'Mondor', 14, 'ter', 'rue de la victoire', 'Créteil', '94000', 'Ile de france', '0146582301', '0142625944', 'mondor@creteil.fr', -45.1548, -1.25, NULL, '2015-01-06', 'labraga', 1),
(40, '14521568564548', 'Ambulance Paris', 5, 'rue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0142515658', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-07', 'labraga', 3),
(41, '14521568564548', 'Ambulance Paris', 5, 'rue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0142515658', '0142625948', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-07', 'labraga', 3),
(42, '14521568564548', 'Ambulance Paris', 14, 'rue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0184852643', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-17', 'labraga', 1),
(43, '14521568564548', 'Ambulance Paris', 14, 'rue', 'Martial Roth', 'Paris', '75019', 'Ile de france', '0184852643', '0142586959', 'ambulance@h-paris.fr', -45.1548, -1.25, NULL, '2015-01-17', 'labraga', 1);

-- --------------------------------------------------------

--
-- Structure de la table `tr_organization_type`
--

CREATE TABLE IF NOT EXISTS `tr_organization_type` (
  `idtr_organization_type` int(11) NOT NULL AUTO_INCREMENT,
  `tr_orga_type_code` varchar(45) DEFAULT NULL,
  `tr_orga_type_description` varchar(45) DEFAULT NULL,
  `tr_orga_type_legal_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtr_organization_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `tr_organization_type`
--

INSERT INTO `tr_organization_type` (`idtr_organization_type`, `tr_orga_type_code`, `tr_orga_type_description`, `tr_orga_type_legal_status`) VALUES
(1, 'OT01', 'HOPITAL', 'PUBLIC'),
(2, 'OT02', 'HOPITAL', 'PRIVE'),
(3, 'OT03', 'AMBULANCE', 'PRIVE'),
(4, 'OT04', 'LABORATOIRE D''ANALYSE', 'PRIVE');

-- --------------------------------------------------------

--
-- Structure de la table `tr_orga_hospital`
--

CREATE TABLE IF NOT EXISTS `tr_orga_hospital` (
  `idtr_organization` int(11) NOT NULL,
  `tr_hospital_finess` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `tr_orga_hospital`
--

INSERT INTO `tr_orga_hospital` (`idtr_organization`, `tr_hospital_finess`) VALUES
(1, '444532253'),
(3, '4521452586'),
(9, '4521452586'),
(37, '4521455833'),
(38, '4521455833'),
(39, '4521455833'),
(42, '4521452586'),
(43, '4521452586');

-- --------------------------------------------------------

--
-- Structure de la table `tr_orga_serv_association`
--

CREATE TABLE IF NOT EXISTS `tr_orga_serv_association` (
  `idtr_organization` int(11) NOT NULL,
  `idtr_service_type` int(11) NOT NULL,
  PRIMARY KEY (`idtr_organization`,`idtr_service_type`),
  KEY `fk_tr_orga_serv_association_tr_service_type1_idx` (`idtr_service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `tr_orga_serv_association`
--

INSERT INTO `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) VALUES
(33, 1),
(35, 1),
(36, 1),
(39, 1),
(41, 1),
(33, 2),
(35, 2),
(36, 2),
(39, 2),
(41, 2),
(43, 2);

-- --------------------------------------------------------

--
-- Structure de la table `tr_service_type`
--

CREATE TABLE IF NOT EXISTS `tr_service_type` (
  `idtr_service_type` int(11) NOT NULL AUTO_INCREMENT,
  `tr_service_type_code` varchar(45) DEFAULT NULL,
  `tr_service_type_description` varchar(45) DEFAULT NULL,
  `tr_service_type_category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtr_service_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `tr_service_type`
--

INSERT INTO `tr_service_type` (`idtr_service_type`, `tr_service_type_code`, `tr_service_type_description`, `tr_service_type_category`) VALUES
(1, 'ST01', 'URGENCE', 'HOPITAL'),
(2, 'ST02', 'REANIMATION', 'HOPITAL');

-- --------------------------------------------------------

--
-- Structure de la table `tr_staff_member`
--

CREATE TABLE IF NOT EXISTS `tr_staff_member` (
  `idtr_staff_member` int(11) NOT NULL AUTO_INCREMENT,
  `tr_staff_member_first_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `tr_staff_member_last_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `tr_staff_member_number` varchar(45) CHARACTER SET utf16 DEFAULT NULL,
  `tr_staff_member_street_type` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `tr_staff_member_street_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`idtr_staff_member`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `tr_staff_member`
--

INSERT INTO `tr_staff_member` (`idtr_staff_member`, `tr_staff_member_first_name`, `tr_staff_member_last_name`, `tr_staff_member_number`, `tr_staff_member_street_type`, `tr_staff_member_street_name`) VALUES
(1, 'jawad', 'assaraj', NULL, '', ''),
(2, 'jawad', 'assaraj', NULL, '', ''),
(3, 'AAA', 'AAA', NULL, NULL, NULL),
(4, 'AAA', 'AAA', NULL, NULL, NULL),
(5, 'arsrt', 'ydyy', NULL, NULL, NULL),
(6, 'vg', 'HIHU', NULL, NULL, NULL),
(7, 'vg', 'HIHU', NULL, NULL, NULL),
(8, 'vg', 'HIHU', NULL, NULL, NULL),
(9, 'oihioh', 'iohoih', NULL, NULL, NULL),
(10, '', '', '', NULL, NULL),
(11, 'fze', 'fze', 'fezf', NULL, NULL),
(12, 'fezf', 'fzef', 'fzefe', NULL, NULL),
(13, 'fezf', 'fzef', 'fzefe', NULL, NULL),
(14, 'fezf', 'fzef', 'fzefe', NULL, NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `tr_call_center_organisation`
--
ALTER TABLE `tr_call_center_organisation`
  ADD CONSTRAINT `fk_tr_call_center_orga_tr_organization1` FOREIGN KEY (`tr_organization_idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_call_center_service`
--
ALTER TABLE `tr_call_center_service`
  ADD CONSTRAINT `fk_tr_call_center_tr_orga_serv_association1` FOREIGN KEY (`tr_orga_serv_association_tr_organization_idtr_organization`, `tr_orga_serv_association_tr_service_type_tr_service_type_code`) REFERENCES `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_hospital_service`
--
ALTER TABLE `tr_hospital_service`
  ADD CONSTRAINT `fk_tr_hospital_service_tr_orga_serv_association1` FOREIGN KEY (`tr_orga_serv_association_tr_organization_idtr_organization`, `tr_orga_serv_association_tr_service_type_tr_service_type_code`) REFERENCES `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_infra_equipment`
--
ALTER TABLE `tr_infra_equipment`
  ADD CONSTRAINT `FK_6qimy8ek8ae2463v8xj1tijdw` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_orga_hospital` (`idtr_organization`),
  ADD CONSTRAINT `FK_kmpodc4hncct8bwevw9f0mobx` FOREIGN KEY (`idtr_infra_type_ref_infra`) REFERENCES `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`);

--
-- Contraintes pour la table `tr_infra_infrastructure`
--
ALTER TABLE `tr_infra_infrastructure`
  ADD CONSTRAINT `FK_ir8sl6d5kae97le3qb95ht8a7` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_orga_hospital` (`idtr_organization`),
  ADD CONSTRAINT `FK_p3wldx0j3op0pg9noy3kx9jb8` FOREIGN KEY (`idtr_infra_type_ref_infra`) REFERENCES `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`);

--
-- Contraintes pour la table `tr_infra_medicine`
--
ALTER TABLE `tr_infra_medicine`
  ADD CONSTRAINT `FK_dlc4tn7n5kha5jcbeahucyles` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_orga_hospital` (`idtr_organization`),
  ADD CONSTRAINT `FK_8nirin0t3d31rvwyuj60w7et5` FOREIGN KEY (`idtr_infra_type_ref_infra`) REFERENCES `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`);

--
-- Contraintes pour la table `tr_infra_type_ref_infra`
--
ALTER TABLE `tr_infra_type_ref_infra`
  ADD CONSTRAINT `FK_cq87x56qwdguh6l6cscp0b5ba` FOREIGN KEY (`idtr_infra_category`) REFERENCES `tr_infra_category` (`idtr_infra_category`);

--
-- Contraintes pour la table `tr_mobile_unit_organization`
--
ALTER TABLE `tr_mobile_unit_organization`
  ADD CONSTRAINT `fk_tr_mobile_organization_tr_organization1` FOREIGN KEY (`tr_organization_idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_mobile_unit_service`
--
ALTER TABLE `tr_mobile_unit_service`
  ADD CONSTRAINT `fk_tr_mobile_unit_tr_orga_serv_association1` FOREIGN KEY (`tr_orga_serv_association_tr_organization_idtr_organization`, `tr_orga_serv_association_tr_service_type_tr_service_type_code`) REFERENCES `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_organization`
--
ALTER TABLE `tr_organization`
  ADD CONSTRAINT `fk_tr_organization_tr_organization_type1` FOREIGN KEY (`idtr_organization_type`) REFERENCES `tr_organization_type` (`idtr_organization_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_orga_hospital`
--
ALTER TABLE `tr_orga_hospital`
  ADD CONSTRAINT `fk_tr_hospital_organisation_tr_organization1` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tr_orga_serv_association`
--
ALTER TABLE `tr_orga_serv_association`
  ADD CONSTRAINT `fk_tr_orga_serv_association_tr_organization1` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tr_orga_serv_association_tr_service_type1` FOREIGN KEY (`idtr_service_type`) REFERENCES `tr_service_type` (`idtr_service_type`) ON DELETE NO ACTION ON UPDATE NO ACTION;


--
-- Structure of `tr_infra_category` table
--

CREATE TABLE IF NOT EXISTS `tr_infra_category` (
  `idtr_infra_category` int(11) NOT NULL,
  `tr_infra_label` varchar(255) DEFAULT NULL,
  `tr_infra_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idtr_infra_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure of `tr_infra_type_ref_infra` table
--

CREATE TABLE IF NOT EXISTS `tr_infra_type_ref_infra` (
  `idtr_infra_type_ref_infra` int(11) NOT NULL,
  `tr_infra_label` varchar(255) DEFAULT NULL,
  `tr_infra_code` varchar(10) DEFAULT NULL,
  `idtr_infra_category` int(11) NOT NULL,
  PRIMARY KEY (`idtr_infra_type_ref_infra`),
  KEY `FK_cq87x56qwdguh6l6cscp0b5ba` (`idtr_infra_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure of `tr_infra_equipment` table
--

CREATE TABLE IF NOT EXISTS `tr_infra_equipment` (
  `idtr_infra_equipment` int(11) NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_USER` varchar(255) NOT NULL,
  `tr_infra_label` varchar(255) NOT NULL,
  `tr_infra_serial_number` varchar(10) NOT NULL,
  `idtr_infra_type_ref_infra` int(11) NOT NULL,
  `idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`idtr_infra_equipment`),
  KEY `FK_kmpodc4hncct8bwevw9f0mobx` (`idtr_infra_type_ref_infra`),
  KEY `FK_6qimy8ek8ae2463v8xj1tijdw` (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure of `tr_infra_infrastructure` table
--

CREATE TABLE IF NOT EXISTS `tr_infra_infrastructure` (
  `idtr_infra_infrastructure` int(11) NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_USER` varchar(255) NOT NULL,
  `tr_infra_label` varchar(255) NOT NULL,
  `tr_infra_code` varchar(10) NOT NULL,
  `tr_infra_capacity` int(11) NOT NULL,
  `idtr_infra_type_ref_infra` int(11) NOT NULL,
  `idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`idtr_infra_infrastructure`),
  KEY `FK_p3wldx0j3op0pg9noy3kx9jb8` (`idtr_infra_type_ref_infra`),
  KEY `FK_ir8sl6d5kae97le3qb95ht8a7` (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure of `tr_infra_medicine` table
--

CREATE TABLE IF NOT EXISTS `tr_infra_medicine` (
  `idtr_infra_medicine` int(11) NOT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_USER` varchar(255) NOT NULL,
  `tr_infra_label` varchar(255) NOT NULL,
  `tr_infra_ucdCode` varchar(10) NOT NULL,
  `tr_infra_quantity` int(11) NOT NULL,
  `idtr_infra_type_ref_infra` int(11) NOT NULL,
  `idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`idtr_infra_medicine`),
  KEY `FK_8nirin0t3d31rvwyuj60w7et5` (`idtr_infra_type_ref_infra`),
  KEY `FK_dlc4tn7n5kha5jcbeahucyles` (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Content of `tr_infra_category` table
--

INSERT INTO `tr_infra_category` (`idtr_infra_category`, `tr_infra_label`, `tr_infra_code`) VALUES
(1, 'Infrastructure', 'infraCode1'),
(2, 'Equipement', 'equipCode2'),
(3, 'Médicament', 'medicCode3');

--
-- Content of `tr_infra_type_ref_infra` table
--

INSERT INTO `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`, `tr_infra_label`, `tr_infra_code`, `idtr_infra_category`) VALUES
(1, 'Salle', 'infra00001', 1),
(2, 'Lit normal', 'lit0000001', 2),
(3, 'Paracétamol', 'UCD0000001', 3);

--
-- Content of `tr_infra_equipment` table
--

INSERT INTO `tr_infra_equipment` (`idtr_infra_equipment`, `UPDATE_DATE`, `CREATE_DATE`, `UPDATE_USER`, `tr_infra_label`, `tr_infra_serial_number`, `idtr_infra_type_ref_infra`, `idtr_organization`) VALUES
(1, NULL, '2015-01-24', 'frulio', 'lit Chambre 12', '1234567890', 2, 39);

--
-- Content of `tr_infra_infrastructure` table
--

INSERT INTO `tr_infra_infrastructure` (`idtr_infra_infrastructure`, `UPDATE_DATE`, `CREATE_DATE`, `UPDATE_USER`, `tr_infra_label`, `tr_infra_code`, `tr_infra_capacity`, `idtr_infra_type_ref_infra`, `idtr_organization`) VALUES
(1, NULL, '2015-01-24', 'frulio', 'test d''une infrastructure', '1234567890', 10, 1, 39);

--
-- Content of `tr_infra_medicine` table
--

INSERT INTO `tr_infra_medicine` (`idtr_infra_medicine`, `UPDATE_DATE`, `CREATE_DATE`, `UPDATE_USER`, `tr_infra_label`, `tr_infra_ucdCode`, `tr_infra_quantity`, `idtr_infra_type_ref_infra`, `idtr_organization`) VALUES
(1, NULL, '2015-01-24', 'frulio', 'Para Mai', 'UCD1234566', 120, 3, 39);


--
-- Constraint of `tr_infra_type_ref_infra` table
--

ALTER TABLE `tr_infra_type_ref_infra`
  ADD CONSTRAINT `FK_Infra_Type_Category` FOREIGN KEY (`idtr_infra_category`) REFERENCES `tr_infra_category` (`idtr_infra_category`);

--
-- Constraint of `tr_infra_equipment` table
--

ALTER TABLE `tr_infra_equipment`
  ADD CONSTRAINT `FK_Infra_Equip_Hospital` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_orga_hospital` (`idtr_organization`),
  ADD CONSTRAINT `FK_Infra_Equip_Type` FOREIGN KEY (`idtr_infra_type_ref_infra`) REFERENCES `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`);

--
-- Constraint of `tr_infra_infrastructure` table
--
ALTER TABLE `tr_infra_infrastructure`
  ADD CONSTRAINT `FK_Infra_Infra_Hospital` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_orga_hospital` (`idtr_organization`),
  ADD CONSTRAINT `FK_Infra_Infra_Type` FOREIGN KEY (`idtr_infra_type_ref_infra`) REFERENCES `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`);

--
-- Constraint of `tr_infra_medicine` table
--
ALTER TABLE `tr_infra_medicine`
  ADD CONSTRAINT `FK_Infra_Medic_Hospital` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_orga_hospital` (`idtr_organization`),
  ADD CONSTRAINT `FK_Infra_Medic_Type` FOREIGN KEY (`idtr_infra_type_ref_infra`) REFERENCES `tr_infra_type_ref_infra` (`idtr_infra_type_ref_infra`);



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
