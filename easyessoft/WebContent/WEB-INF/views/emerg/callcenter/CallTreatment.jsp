<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Call center">
<meta name="author" content="Samuel">
<!-- Custom CSS -->
<link href="/easyessoft/dist/css/simple-sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/easyessoft/js/dataTableConfiguration.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h1 class="boderline">Traitement des appels 112</h1>
		</div>
		<div class="row menu-tools " id="msg-one">
			<a href="#menu-toggle">
				<button id="menu-toggle" type="button"
					class="btn btn-default btn-app" role="button">
					<i class="glyphicon glyphicon-collapse-down"></i>Menu
				</button>
			</a> <a href="/easyessoft/ihm/emerg/callcenter/createIncidentLocation">
				<button type="button" class="btn btn-default btn-app" role="button">
					<i class="glyphicon glyphicon-earphone"></i> Nouveau cas
				</button>
			</a>
		</div>
		<div id="wrapper">
			<!-- Sidebar -->
			<div id="sidebar-wrapper">
				<ul class="sidebar-nav">
					<li class="sidebar-brand"><a id="msg-inbox" href="#">Gestion d'incidents</a></li>
					<li><a href="#" class="" id="display-dashbord"> <i
							class="glyphicon glyphicon-dashboard"></i> <span
							class="hidden-xs">Dashboard</span>
					</a></li>
					<li><a href="#" class="" id="display-map"> <i
							class="glyphicon glyphicon-map-marker"></i> <span
							class="hidden-xs">Carte des Interventions</span>
					</a></li>
					<li><a href="#" class="" id="msg-waiting"> <i
							class="glyphicon glyphicon-exclamation-sign"></i> <span
							class="hidden-xs">Interventions > En Attente <span id="nb-interv-en-attente"
								class="badge"></span></span>
					</a></li>
					<li><a href="#" class="" id="msg-starred"> <i
							class="glyphicon glyphicon-repeat"></i> <span class="hidden-xs">Interventions
								> En Cours <span id="nb-interv-en-cours" class="badge"></span>
						</span>
					</a></li>
					<li><a href="#" class="" id="msg-important"> <i
							class="glyphicon glyphicon-envelope"></i> <span class="hidden-xs">Alertes
								& Messages</span>
					</a></li>
					<li><a href="#" class="" id="msg-sent"> <i
							class="fafa-reply"></i> <span class="hidden-xs">Interventions
								closes</span></a></li>
					<li class="divider"></li>
					<li><a href="#" class="" id="msg-draft"><i
							class="fa fa-pencil"></i> <span class="hidden-xs">Nouveau
								dossier</span> </a></li>
					<li><a href="#" class="" id="msg-pending"><i
							class="fa fa-pencil"></i> <span class="hidden-xs">Dossiers
								en cours (5)</span> </a></li>
					<li><a href="#" class="" id="msg-trash"><i
							class="fa fa-trash-o"></i> <span class="hidden-xs">Dossiers
								clos</span> </a></li>
				</ul>
			</div>
			<!-- /#sidebar-wrapper -->

			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<td>id intervention</td>
										<td>Etat</td>
										<td>Localisation</td>
										<td>id Véhicule</td>
										<td>Catégorie Véhicule</td>
										<td>Priotité</td>
										<td>Agent PARM</td>
										<td>id Hopital</td>
										<td>Hopital</td>
										<td>Ouvert le</td>
										<td>Fermé le</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="element" items="${ticketList}">
										<tr>
											<td>${element.id}</td>
											<td>${element.state.label}</td>
											<td>${element.location.incidentAddress}</td>
											<td>${element.vehicule.id}</td>
											<td>${element.vehicule.category}</td>
											<td>${element.priority.label}</td>
											<td>15</td>
											<td><a
												href="/easyessoft/ihm/ref/orga/getOrganizationDetails/1"><i
													class="glyphicon glyphicon-eye-open"></i></a></td>
											<td>Mondor</td>
											<td>${element.openedDate}</td>
											<td>${element.closedDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
		$(function() {
			$('#sidebar-wrapper').css({
				height : $(window).innerHeight()
			});
			$(window).resize(function() {
				$('#sidebar-wrapper').css({
					height : $(window).innerHeight()
				});
			});
		});

		var statusValue = "";
		 $.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
			var status = data[1]; // use data for the age column
			if (statusValue === status) {
				return true;
			} else if (statusValue===""){
				return true;
			}
			return false;
		});
		
		$('#msg-inbox').click(function() {
			var table;
			table = $("#table_id").DataTable();
			statusValue="";
			table.draw();
		});
		
		$('#msg-starred').click(function() {
			var table;
			table = $("#table_id").DataTable();	
			statusValue="En Cours";
			table.draw();
			getNumber("#nb-interv-en-cours", 2);
		});
		$('#msg-waiting').click(function() {
			var table;
			table = $("#table_id").DataTable();	
			statusValue="En Attente";
			table.draw();
			getNumber("#nb-interv-en-attente", 1);
		});
		
		function getNumber(element, type) {
			var result;
			var nb;
			if(type==0) 
				return false;
			var url = "getNbPending/"+type
			$.getJSON(url, function(nb) {
				var value = $(element)[0];
				value.innerHTML=nb;
			})
		};
		$( "#sidebar-wrapper" ).load(function() {
			getNumber("#nb-interv-en-cours", 2);
			getNumber("#nb-interv-en-attente", 1);
			});
	</script>
</body>

<jsp:include page="../../include/footer.jsp" />