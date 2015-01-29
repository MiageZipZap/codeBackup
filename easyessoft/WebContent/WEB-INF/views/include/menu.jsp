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
				<li><a href="#">About</a></li>
				<!--li><a href="#">Services</a></li-->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Administrer
						un référentiel <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/easyessoft/ihm/ref/orgaAdmin/organizationHome">Organismes
								de santé</a></li>
						<li><a href="/easyessoft/ihm/ref/staffAdmin/member/createForm">Personnel</a></li>
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
</nav>