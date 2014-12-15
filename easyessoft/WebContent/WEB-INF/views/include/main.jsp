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
				<a class="navbar-brand" href="">Accueil</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">About</a></li>
					<!--li><a href="#">Services</a></li-->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Administrer un référentiel
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Organismes de santé</a></li>
							<li><a href="#">Personnel</a></li>
							<li><a href="#">Infrastructures d'urgence</a></li>
							<li class="divider"></li>
							<li><a href="/easyessoft/ihm/doctor/form">Création d'un doctor</a></li>
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
		<!-- /.container -->
	</nav>

	<!-- Image Background Page Header -->
	<!-- Note: The background image is set within the business-casual.css file. -->
	<header class="business-header">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="tagline">EasyEs Soft. Ltd</h1>
				</div>
			</div>
		</div>
	</header>

	<!-- Page Content -->
	<div class="container">

		<hr>

		<div class="row">
			<div class="col-sm-8">
				<h2>What We Do</h2>
				<p>Introduce the visitor to the business using clear,
					informative text. Use well-targeted keywords within your sentences
					to make sure search engines can find the business.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et
					molestiae similique eligendi reiciendis sunt distinctio odit? Quia,
					neque, ipsa, adipisci quisquam ullam deserunt accusantium illo iste
					exercitationem nemo voluptates asperiores.</p>
				<p>
					<a class="btn btn-default btn-lg" href="#">Call to Action
						&raquo;</a>
				</p>
			</div>
			<div class="col-sm-4">
				<h2>Contact Us</h2>
				<address>
					<strong>Start Bootstrap</strong> <br>3481 Melrose Place <br>Beverly
					Hills, CA 90210 <br>
				</address>
				<address>
					<abbr title="Phone">P:</abbr>(123) 456-7890 <br> <abbr
						title="Email">E:</abbr> <a href="mailto:#">name@example.com</a>
				</address>
			</div>
		</div>
		<!-- /.row -->

		<hr>

		<div class="row">
			<div class="col-sm-4">
				<img class="img-circle img-responsive img-center"
					src="http://placehold.it/300x300" alt="">
				<h2>Marketing Box #1</h2>
				<p>These marketing boxes are a great place to put some
					information. These can contain summaries of what the company does,
					promotional information, or anything else that is relevant to the
					company. These will usually be below-the-fold.</p>
			</div>
			<div class="col-sm-4">
				<img class="img-circle img-responsive img-center"
					src="http://placehold.it/300x300" alt="">
				<h2>Marketing Box #2</h2>
				<p>The images are set to be circular and responsive. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
			</div>
			<div class="col-sm-4">
				<img class="img-circle img-responsive img-center"
					src="http://placehold.it/300x300" alt="">
				<h2>Marketing Box #3</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
			</div>
		</div>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="dist/js/bootstrap.min.js"></script>

	<!-- #entête -->
	<div class="container">
		<div id="page">
			<!-- entête -->
			<div style="float: left">Bienvenue sur le Prototype</div>
			<div id="menu">
				<a href="/easyessoft/ihm/doctor/form">Création d'un doctor</a> <a
					href="/easyessoft/ihm/geoloc/get">Test mock Geoloc</a>
			</div>
		</div>
	</div>