<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Engorgement" name="title" />
</jsp:include>
<style type="text/css">
/* Adjust feedback icon position */
.panel-body {
	padding: 0px;
}

.col-xs-offset-2 {
	margin-left: 10% !important;
}
</style>

<script src="/easyessoft/dist/js/highcharts.js"></script>
<script src="/easyessoft/dist/js/highcharts-more.js"></script>
<script src="/easyessoft/dist/js/solid-gauge.js"></script>
<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>

<div>
	<h3 class="page-header">Simuler l'activité du service</h3>
	<button id="startSimulationButn" type="button"
		class="btn btn-success btn-lg" role="button">
		<i class="glyphicon glyphicon-play"></i> START SIMULATION
	</button>
	<button id="stopSimulationButn" type="button"
		class="btn btn-danger btn-lg" role="button">
		<i class="glyphicon glyphicon-stop"></i> STOP SIMULATION
	</button>
	<form>
		<div class="form-group">
			<label>Temps moyen entre chaque arrivée </label> <input type="text"
				id="muArr" placeholder="secondes" size="10">
		</div>
		<div class="form-group">
			<label>Temps moyen de traitement </label> <input type="text"
				id="muTrait" placeholder="secondes" size="10">
		</div>
	</form>
	<div class="row">

		<div class="col-md-6">
			<h3 class="page-header">Engorgement du service</h3>

			<div style="width: 600px; height: 400px; margin: 0 auto">
				<div id="container-congest"
					style="width: 400px; height: 300px; float: left"></div>
			</div>
		</div>
		<div class="col-md-6">
			<h3 class="page-header">Etat de la file d'attente</h3>
			<div class="col-md-6">
				<h4 class="page-header">En attente</h4>
				<table id="table_attente" class="table table-striped">
					<thead>
						<tr>
							<td>N°</td>
							<td>Nom</td>
							<td>Prénom</td>
							<td>Heure d'arrivée</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${waitingPatients}">
							<tr>
								<td>${item.idPatient}</td>
								<td>Doe</td>
								<td>John</td>
								<td><fmt:formatDate value="${item.timeQueueState}"
										type="both" pattern="dd/MM/yyyy hh:mm:ss" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h4 class="page-header">Sortis</h4>
				<table id="table_sortis" class="table table-striped">
					<thead>
						<tr>
							<td>N°</td>
							<td>Prenom</td>
							<td>Nom</td>
							<td>Heure de sortie</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${treatedPatients}">
							<tr>
								<td>${item.idPatient}</td>
								<td>Doe</td>
								<td>John</td>
								<td><fmt:formatDate value="${item.timeQueueState}"
										type="both" pattern="dd/MM/yyyy hh:mm:ss" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>




</div>

<script type="text/javascript">
	$(function() {
		drawChart();
	});
	function drawChart() {

		var gaugeOptions = {

			chart : {
				type : 'solidgauge'
			},

			title : null,

			pane : {
				center : [ '50%', '85%' ],
				size : '140%',
				startAngle : -90,
				endAngle : 90,
				background : {
					backgroundColor : (Highcharts.theme && Highcharts.theme.background2)
							|| '#EEE',
					innerRadius : '60%',
					outerRadius : '100%',
					shape : 'arc'
				}
			},

			tooltip : {
				enabled : false
			},

			// the value axis
			yAxis : {
				stops : [ [ 0.6, '#55BF3B' ], // green
				[ 0.7, '#DDDF0D' ], // yellow
				[ 0.8, '#DF5353' ] // red
				],
				lineWidth : 0,
				minorTickInterval : null,
				tickPixelInterval : 400,
				tickWidth : 0,
				title : {
					y : -70
				},
				labels : {
					y : 16
				}
			},

			plotOptions : {
				solidgauge : {
					dataLabels : {
						y : 5,
						borderWidth : 0,
						useHTML : true
					}
				}
			}
		};

		// The speed gauge
		$('#container-congest')
				.highcharts(
						Highcharts
								.merge(
										gaugeOptions,
										{
											yAxis : {
												min : 0,
												max : 200,
											},

											credits : {
												enabled : false
											},

											series : [ {
												name : 'Speed',
												data : [ Math
														.round("${waitingRoomCongestion}") ],
												dataLabels : {
													format : '<div style="text-align:center"><span style="font-size:25px;color:'
															+ ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black')
															+ '">{y}</span><br/>'
															+ '<span style="font-size:12px;color:silver">%</span></div>'
												},
												tooltip : {
													valueSuffix : '%'
												}
											} ]

										}));

		// Bring life to the dials
		setInterval(function() {
			var idHospital = "${hospital.id}";
			$.getJSON("RefreshChartSingle", {
				idHospital : idHospital
			}, function(data) {
				var chart = $('#container-congest').highcharts(), points;
				if (chart) {
					point = chart.series[0].points[0];
					point.update(data);
				}
			})

			$.getJSON("RefreshTableWaiting", {
				idHospital : idHospital
			}, function(data) {
				tableAttente = $('#table_attente').dataTable();
				tableAttente.fnClearTable(this);
				var cmptAttente = 1;
				$.each(data, function() {
					var date = new Date(this.timeQueueState);
					tableAttente.fnAddData([
							this.idPatient,
							"John",
							"Doe",
							date.toLocaleDateString() + " "
									+ date.toLocaleTimeString() ]);
					cmptAttente++;
				});

			})

			$.getJSON("RefreshTableTreated", {
				idHospital : idHospital
			}, function(data) {
				tableSortis = $('#table_sortis').dataTable();
				tableSortis.fnClearTable(this);
				var cmptSortis = 1;
				$.each(data, function() {
					var date = new Date(this.timeQueueState);
					tableSortis.fnAddData([
							this.idPatient,
							"John",
							"Doe",
							date.toLocaleDateString() + " "
									+ date.toLocaleTimeString() ]);
					cmptSortis++;
				});

			})
			/* $.ajax({
				url : "RefreshData",
				success : function(data) {
					var chart = $('#container-congest').highcharts(),
			        point,
			        newVal,
			        inc;
					if (chart) {
			            point = chart.series[0].points[0];

			            point.update(data);
			        }
			    } 
			}) */

		}, 5000);

	};
</script>

<script type="text/javascript">
	/****Configuration Datatable****/
	$(document)
			.ready(
					function() {
						$('#table_attente')
								.DataTable(
										{
											"language" : {
												"lengthMenu" : "Affichage _MENU_ lignes par page",
												"search" : "Rechercher:",
												"zeroRecords" : "Aucun enregistrement - d&eacute;sol&eacute;",
												"info" : "Affiche page _PAGE_ of _PAGES_",
												"infoEmpty" : "Aucune donn&eacute;e disponible",
												"infoFiltered" : "(trier &agrave; partir de _MAX_ enregistrements au total)",
												"emptyTable" : "Aucune donn&eacute;e dans la table",
												"infoPostFix" : "",
												"thousands" : ",",
												"lengthMenu" : "Affiche _MENU_ entr&eacute;es",
												"loadingRecords" : "Chargement...",
												"processing" : "Traitement...",
												"paginate" : {
													"first" : "Premier",
													"last" : "Dernier",
													"next" : "Suivant",
													"previous" : "Pr&eacute;c&eacute;dant"
												},
												"aria" : {
													"sortAscending" : ": Tri croissant de la colonne",
													"sortDescending" : ": Tri d&eacute;croissant de la colonne"
												}

											},
											searching : false,
											pageLength : 20
										});
						$('#table_sortis')
								.Datatable(
										{
											"language" : {
												"lengthMenu" : "Affichage _MENU_ lignes par page",
												"search" : "Rechercher:",
												"zeroRecords" : "Aucun enregistrement - d&eacute;sol&eacute;",
												"info" : "Affiche page _PAGE_ of _PAGES_",
												"infoEmpty" : "Aucune donn&eacute;e disponible",
												"infoFiltered" : "(trier &agrave; partir de _MAX_ enregistrements au total)",
												"emptyTable" : "Aucune donn&eacute;e dans la table",
												"infoPostFix" : "",
												"thousands" : ",",
												"lengthMenu" : "Affiche _MENU_ entr&eacute;es",
												"loadingRecords" : "Chargement...",
												"processing" : "Traitement...",
												"paginate" : {
													"first" : "Premier",
													"last" : "Dernier",
													"next" : "Suivant",
													"previous" : "Pr&eacute;c&eacute;dant"
												},
												"aria" : {
													"sortAscending" : ": Tri croissant de la colonne",
													"sortDescending" : ": Tri d&eacute;croissant de la colonne"
												}

											},
											searching : false,
											pageLength : 20
										});
					});
</script>

<script type="text/javascript">
	$('#startSimulationButn').on('click', function() {
		var muArr = parseFloat($('#muArr').val());
		var muSorties = parseFloat($('#muTrait').val());
		$.getJSON("StartSimulation", {
			muArr : muArr,
			muSorties : muSorties
		}, function(data) {
		})
		alert("Simulation démarrée")
	});

	$('#stopSimulationButn').on('click', function() {
		$.getJSON("StopSimulation", function(data) {
		})
		alert("Simulation stoppée")
	});
</script>

<jsp:include page="../../include/footer.jsp" />


