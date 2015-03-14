<%@ page contentType="text/html;charset=ISO-8859-15" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li><a href="#">A propos</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Administrer
						un référentiel <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/easyessoft/ihm/ref/orgaAdmin/organizationHome">Organismes
								de santé</a></li>
						<li><a
							href="/easyessoft/ihm/ref/staffAdmin/member/createForm">Personnel</a></li>
						<li><a href="/easyessoft/ihm/ref/emergencyDept/homePage">Infrastructures
								d'urgence</a></li>
						<li class="divider"></li>
						<li><a href="/easyessoft/ihm/emerg/congestion/simulator/DisplayMain">Création d'un
								doctor</a></li>
						<li><a href="/easyessoft/ihm/geoloc/get">Test mock Geoloc</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Centre
						d'Appel<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/easyessoft/ihm/emerg/callcenter/CallHome">Traiter
								les appels</a></li>
						<li class="divider"></li>
						<li><a href="/easyessoft/ihm/vehicle/optimalvehicle/vehiclealgorithm">Déterminer le véhicule optimal</a></li>
						<li class="divider"></li>
						<li><a href="/easyessoft/ihm/doctor/form">Carte</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Gestion
						des patients<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="/easyessoft/ihm/admin/appointment/appointmentHome">Rendez-vous</a></li>
						<li class="divider"></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Outils d'analyses
					<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/easyessoft/ihm/optim/emergencyOptim">Optimisation des services d'urgence</a></li>
						<li><a href="/easyessoft/ihm/emerg/congestion/simulator/DisplayMain">Monitorer l'engorgement des services d'urgences</a></li>
					</ul></li>
				<!--li><a href="#">Contact</a></li-->
				<li style="float: right"><a
					href="/easyessoft/<c:url value='j_spring_security_logout' />">Déconnexion</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
</nav>