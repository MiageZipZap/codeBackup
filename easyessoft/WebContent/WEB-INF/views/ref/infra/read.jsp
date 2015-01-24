<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="read emergency dept" name="title" />
</jsp:include>

<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
	src="/easyessoft/js/readInfra.js"></script>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Service d'urgence de l'hôpital
							${hospital.name}</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h2>Listes des équipements</h2>
							<div class="box-content">
								<table id="equipmentTable" class="display">
									<thead>
										<tr>
											<th>Numéro de série</th>
											<th>Libellé</th>
											<th>Type</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${equipments}">
											<tr>
												<td>${item.serialNumber}</td>
												<td>${item.label}</td>
												<td>${item.typeRefInfra.label}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<a href="/easyessoft/ihm/ref/equip/createForm/${hospital.id}">
									<button class="btn btn-primary">création d'un
										équipement</button>
								</a>
							</div>
						</div>

						<div class="panel-body">
							<h2>Listes des infrastructures</h2>
							<div class="box-content">
								<table id="infrastructureTable" class="display">
									<thead>
										<tr>
											<th>Code</th>
											<th>Libellé</th>
											<th>Accessibilité</th>
											<th>Capacité</th>
											<th>Type</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${infrastructures}">
											<tr>
												<td>${item.code}</td>
												<td>${item.label}</td>
												<td>${item.disabledFacilities}</td>
												<td>${item.capacity}</td>
												<td>${item.typeRefInfra.label}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<a href="/easyessoft/ihm/ref/infra/createForm/${hospital.id}">
									<button class="btn btn-primary">création d'une infrastructure</button>
								</a>
							</div>
						</div>

						<div class="panel-body">
							<h2>Listes des médicaments</h2>
							<div class="box-content">
								<table id="medicineTable" class="display">
									<thead>
										<tr>
											<th>Code UCD</th>
											<th>Libellé</th>
											<th>Quantité</th>
											<th>Type</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${medicines}">
											<tr>
												<td>${item.ucdCode}</td>
												<td>${item.label}</td>
												<td>${item.quantity}</td>
												<td>${item.typeRefInfra.label}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<a href="/easyessoft/ihm/ref/medicine/createForm/${hospital.id}">
									<button class="btn btn-primary">création d'un médicament</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../../include/footer.jsp" />