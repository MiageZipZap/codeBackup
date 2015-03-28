<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Recherche patient" name="title" />
</jsp:include>

<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/easyessoft/js/dataTableConfiguration.js"></script>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 class="boderline">Liste des patients </h1>
			</div>
			<div class="panel-body">
				<div class="box-content">
					<table id="table_id" class="display">
						<thead>
							<tr>
								<td>Id</td>
								<td>Prénom</td>
								<td>Nom</td>
								<td>Date de naissance</td>
								<td>Numéro de SS</td>
								<td>N° Rue</td>
								<td>Nom rue</td>
								<td>Code Postal</td>
								<td>Ville</td>
								<td>E-mail</td>
								<td>Téléphone</td>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="element" items="${tablePatient}">
								<tr>
									<td>${element.id}</td>
									<td>${element.firstName}</td>
									<td>${element.lastName}</td>
									<td>${element.birthdate}</td>
									<td>${element.nir}</td>
									<td>${element.address.streetNumber}</td>
									<td>${element.address.streetName}</td>
									<td>${element.address.zipCode}</td>
									<td>${element.address.city}</td>
									<td>${element.mailAdress}</td>
									<td>${element.phoneNumberHome}</td>

									<td><a
										href="/easyessoft/ihm/admin/appointment/createFormAppoint/${element.id}">OK</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<p class="form-group">
	<div class="col-sm-9 col-sm-offset-3">
		<input type="submit" value="Nouveau patient" class="btn btn-primary"
			id="newPatient">
	</div>

</div>
<jsp:include page="../include/footer.jsp" />