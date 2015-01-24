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
						<h1 class="boderline">Service d'urgence de l'h�pital
							${hospital.name}</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h2>Listes des �quipements</h2>
							<div class="box-content">
								<table id="equipmentTable" class="display">
									<thead>
										<tr>
											<th>Num�ro de s�rie</th>
											<th>Libell�</th>
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
									<button class="btn btn-primary">cr�ation d'un
										�quipement</button>
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
											<th>Libell�</th>
											<th>Accessibilit�</th>
											<th>Capacit�</th>
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
									<button class="btn btn-primary">cr�ation d'une infrastructure</button>
								</a>
							</div>
						</div>

						<div class="panel-body">
							<h2>Listes des m�dicaments</h2>
							<div class="box-content">
								<table id="medicineTable" class="display">
									<thead>
										<tr>
											<th>Code UCD</th>
											<th>Libell�</th>
											<th>Quantit�</th>
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
									<button class="btn btn-primary">cr�ation d'un m�dicament</button>
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