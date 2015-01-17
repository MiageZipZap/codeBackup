<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Medecin" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="tagline">Confirmation de création</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Code</th>
					<th>Libellé</th>
					<th>Capacité</th>
					<th>Type</th>
					<th>Accessibilité PMR</th>
					<th>Hôpital</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${infrastructure.code}</td>
					<td>${infrastructure.label}</td>
					<td>${infrastructure.capacity}</td>
					<td>${infrastructure.typeRefInfra.id}</td>
					<td><c:if test="${infrastructure.disabledFacilities}">oui
			</c:if> <c:if test="${!infrastructure.disabledFacilities}">non
			</c:if></td>
					<td>${infrastructure.hospital.id}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />