
<%@ page contentType="text/html;charset=ISO-8859-15" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>EasyES Soft - ${param.title}</title>
<script type="text/javascript" src="/IhmSpringMVC/js/jquery.js"></script>
<script type="text/javascript" src="/IhmSpringMVC/js/easyes.js"></script>
<script type="text/javascript" src="/IhmSpringMVC/js/geoloc.js"></script>
<script type="text/javascript" src="/IhmSpringMVC/js/doctor.js"></script>
<script type="text/javascript" src="/IhmSpringMVC/js/controlManager.js"></script>
<script type="text/javascript" src="/IhmSpringMVC/js/bannerMessage.js"></script>


</head>

<body>
	<!-- entête -->
	<div style="float: right">
		<a href="/IhmSpringMVC/<c:url value='j_spring_security_logout' />">Déconnexion</a>
	</div>
	<!-- #entête -->

	<div id="page">
		<div id="menu">
			<a href="/IhmSpringMVC/ihm/doctor/form">Création d'un doctor</a> <a
				href="/IhmSpringMVC/ihm/geoloc/get">Test mock Geoloc</a>
		</div>
