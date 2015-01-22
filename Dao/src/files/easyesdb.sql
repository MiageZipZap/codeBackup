-- --------------------------------------------------------

--
-- Table structure for table `tr_call_center_organisation`
--

CREATE TABLE IF NOT EXISTS `tr_call_center_organisation` (
  `tr_organization_idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`tr_organization_idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- --------------------------------------------------------

--
-- Table structure for table `tr_call_center_service`
--

CREATE TABLE IF NOT EXISTS `tr_call_center_service` (
  `tr_orga_serv_association_tr_organization_idtr_organization` int(11) NOT NULL,
  `tr_orga_serv_association_tr_service_type_tr_service_type_code` int(11) NOT NULL,
  PRIMARY KEY (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- --------------------------------------------------------

--
-- Table structure for table `tr_hospital_service`
--

CREATE TABLE IF NOT EXISTS `tr_hospital_service` (
  `tr_hospital_capacity` int(11) DEFAULT NULL,
  `tr_orga_serv_association_tr_organization_idtr_organization` int(11) NOT NULL,
  `tr_orga_serv_association_tr_service_type_tr_service_type_code` int(11) NOT NULL,
  PRIMARY KEY (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`),
  KEY `fk_tr_hospital_service_tr_orga_serv_association1_idx` (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- --------------------------------------------------------

--
-- Table structure for table `tr_mobile_unit_organization`
--

CREATE TABLE IF NOT EXISTS `tr_mobile_unit_organization` (
  `tr_organization_idtr_organization` int(11) NOT NULL,
  PRIMARY KEY (`tr_organization_idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- --------------------------------------------------------

--
-- Table structure for table `tr_mobile_unit_service`
--

CREATE TABLE IF NOT EXISTS `tr_mobile_unit_service` (
  `tr_orga_serv_association_tr_organization_idtr_organization` int(11) NOT NULL,
  `tr_orga_serv_association_tr_service_type_tr_service_type_code` int(11) NOT NULL,
  PRIMARY KEY (`tr_orga_serv_association_tr_organization_idtr_organization`,`tr_orga_serv_association_tr_service_type_tr_service_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- --------------------------------------------------------

--
-- Table structure for table `tr_organization`
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
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `tr_organization`
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
-- Table structure for table `tr_organization_type`
--

CREATE TABLE IF NOT EXISTS `tr_organization_type` (
  `idtr_organization_type` int(11) NOT NULL AUTO_INCREMENT,
  `tr_orga_type_code` varchar(45) DEFAULT NULL,
  `tr_orga_type_description` varchar(45) DEFAULT NULL,
  `tr_orga_type_legal_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtr_organization_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tr_organization_type`
--

INSERT INTO `tr_organization_type` (`idtr_organization_type`, `tr_orga_type_code`, `tr_orga_type_description`, `tr_orga_type_legal_status`) VALUES
(1, 'OT01', 'HOPITAL', 'PUBLIC'),
(2, 'OT02', 'HOPITAL', 'PRIVE'),
(3, 'OT03', 'AMBULANCE', 'PRIVE'),
(4, 'OT04', 'LABORATOIRE D''ANALYSE', 'PRIVE');

-- --------------------------------------------------------

--
-- Table structure for table `tr_orga_hospital`
--

CREATE TABLE IF NOT EXISTS `tr_orga_hospital` (
  `idtr_organization` int(11) NOT NULL,
  `tr_hospital_finess` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtr_organization`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--
-- Dumping data for table `tr_orga_hospital`
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
-- Table structure for table `tr_orga_serv_association`
--

CREATE TABLE IF NOT EXISTS `tr_orga_serv_association` (
  `idtr_organization` int(11) NOT NULL,
  `idtr_service_type` int(11) NOT NULL,
  PRIMARY KEY (`idtr_organization`,`idtr_service_type`),
  KEY `fk_tr_orga_serv_association_tr_service_type1_idx` (`idtr_service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--
-- Dumping data for table `tr_orga_serv_association`
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
-- Table structure for table `tr_service_type`
--

CREATE TABLE IF NOT EXISTS `tr_service_type` (
  `idtr_service_type` int(11) NOT NULL AUTO_INCREMENT,
  `tr_service_type_code` varchar(45) DEFAULT NULL,
  `tr_service_type_description` varchar(45) DEFAULT NULL,
  `tr_service_type_category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtr_service_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tr_service_type`
--

INSERT INTO `tr_service_type` (`idtr_service_type`, `tr_service_type_code`, `tr_service_type_description`, `tr_service_type_category`) VALUES
(1, 'ST01', 'URGENCE', 'HOPITAL'),
(2, 'ST02', 'REANIMATION', 'HOPITAL');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tr_call_center_organisation`
--
ALTER TABLE `tr_call_center_organisation`
  ADD CONSTRAINT `fk_tr_call_center_orga_tr_organization1` FOREIGN KEY (`tr_organization_idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_call_center_service`
--
ALTER TABLE `tr_call_center_service`
  ADD CONSTRAINT `fk_tr_call_center_tr_orga_serv_association1` FOREIGN KEY (`tr_orga_serv_association_tr_organization_idtr_organization`, `tr_orga_serv_association_tr_service_type_tr_service_type_code`) REFERENCES `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_hospital_service`
--
ALTER TABLE `tr_hospital_service`
  ADD CONSTRAINT `fk_tr_hospital_service_tr_orga_serv_association1` FOREIGN KEY (`tr_orga_serv_association_tr_organization_idtr_organization`, `tr_orga_serv_association_tr_service_type_tr_service_type_code`) REFERENCES `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_mobile_unit_organization`
--
ALTER TABLE `tr_mobile_unit_organization`
  ADD CONSTRAINT `fk_tr_mobile_organization_tr_organization1` FOREIGN KEY (`tr_organization_idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_mobile_unit_service`
--
ALTER TABLE `tr_mobile_unit_service`
  ADD CONSTRAINT `fk_tr_mobile_unit_tr_orga_serv_association1` FOREIGN KEY (`tr_orga_serv_association_tr_organization_idtr_organization`, `tr_orga_serv_association_tr_service_type_tr_service_type_code`) REFERENCES `tr_orga_serv_association` (`idtr_organization`, `idtr_service_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_organization`
--
ALTER TABLE `tr_organization`
  ADD CONSTRAINT `fk_tr_organization_tr_organization_type1` FOREIGN KEY (`idtr_organization_type`) REFERENCES `tr_organization_type` (`idtr_organization_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_orga_hospital`
--
ALTER TABLE `tr_orga_hospital`
  ADD CONSTRAINT `fk_tr_hospital_organisation_tr_organization1` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tr_orga_serv_association`
--
ALTER TABLE `tr_orga_serv_association`
  ADD CONSTRAINT `fk_tr_orga_serv_association_tr_organization1` FOREIGN KEY (`idtr_organization`) REFERENCES `tr_organization` (`idtr_organization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tr_orga_serv_association_tr_service_type1` FOREIGN KEY (`idtr_service_type`) REFERENCES `tr_service_type` (`idtr_service_type`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
