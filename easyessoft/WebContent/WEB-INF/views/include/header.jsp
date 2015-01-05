<%@ page contentType="text/html;charset=ISO-8859-15" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Software for Life">
			<meta name="author" content="EasyEs Soft development team">
				<title>EasyES Soft - ${param.title}</title> <script
					type="text/javascript" src="/easyessoft/js/jquery.js"></script>
<script type="text/javascript" src="/easyessoft/js/easyes.js"></script>
<script type="text/javascript" src="/easyessoft/js/geoloc.js"></script>
<script type="text/javascript" src="/easyessoft/js/doctor.js"></script>
<script type="text/javascript" src="/easyessoft/js/infra.js"></script>
<script type="text/javascript" src="/easyessoft/js/equip.js"></script>
<script type="text/javascript" src="/easyessoft/js/medic.js"></script>
<script type="text/javascript" src="/easyessoft/js/typerefinfra.js"></script>
<script type="text/javascript" src="/easyessoft/js/controlManager.js"></script>
<script type="text/javascript" src="/easyessoft/js/bannerMessage.js"></script>
<script type="text/javascript" src="/easyessoft/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/easyessoft/js/jquery.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/js/bootstrapValidator.js"></script>

<!-- Bootstrap Core CSS -->
<link href="/easyessoft/dist/css/bootstrap.css" rel="stylesheet">
	<link href="/easyessoft/dist/css/bootstrapValidator.css"
		rel="stylesheet">

		<!-- Custom CSS -->
		<link href="/easyessoft/dist/css/business-frontpage.css"
			rel="stylesheet">
			<link href="/easyessoft/dist/css/style.css" rel="stylesheet">

				<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
				<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

				<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/easyessoft/">Accueil</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">About</a></li>
				<!--li><a href="#">Services</a></li-->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Administrer
						un référentiel <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/easyessoft/ihm/ref/orgaAdmin/organizationHome">Organismes
								de santé</a></li>
						<li><a href="#">Personnel</a></li>
						<li><a href="/easyessoft/ihm/ref/emergencyDept/homePage">Infrastructures
								d'urgence</a></li>
						<li class="divider"></li>
						<li><a href="/easyessoft/ihm/doctor/form">Création d'un
								doctor</a></li>
						<li><a href="/easyessoft/ihm/geoloc/get">Test mock Geoloc</a></li>
					</ul></li>
				<!--li><a href="#">Contact</a></li-->
				<li style="float: right"><a
					href="/easyessoft/<c:url value='j_spring_security_logout' />">Déconnexion</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>