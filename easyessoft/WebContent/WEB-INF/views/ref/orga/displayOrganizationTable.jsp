<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>

<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/easyessoft/js/dataTableConfiguration.js"></script>
<div class="row">
	<div class="col-lg-14">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 class="boderline">Liste des organismes</h1>
			</div>
			<div class="panel-body">
				<div class="box-content">
					<table id="table_id" class="display">
						<thead>
							<tr>
								<td>Id</td>
								<td>Type</td>
								<td>Siret</td>
								<td>Raison Sociale</td>
								<td>N° Rue</td>
								<td>Nom rue</td>
								<td>Code Postal</td>
								<td>Ville</td>
								<td>Département</td>
								<td>Latitude</td>
								<td>Longitude</td>
								<td>E-mail</td>
								<td>Téléphone</td>
								<td>fax</td>
								<td>Détails</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="element" items="${tableValues}">
								<tr>
									<td>${element.id}</td>
									<td>${element.orgaType.label}</td>
									<td>${element.siret}</td>
									<td>${element.name}</td>
									<td>${element.streetNumber}</td>
									<td>${element.streetName}</td>
									<td>${element.zipCode}</td>
									<td>${element.city}</td>
									<td>${element.department}</td>
									<td>${element.longitude}</td>
									<td>${element.latitude}</td>
									<td>${element.email}</td>
									<td>${element.phone}</td>
									<td>${element.fax}</td>
									<td><a
										href="/easyessoft/ihm/ref/orga/getOrganizationDetails/${element.id}"><i
											class="glyphicon glyphicon-eye-open"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />