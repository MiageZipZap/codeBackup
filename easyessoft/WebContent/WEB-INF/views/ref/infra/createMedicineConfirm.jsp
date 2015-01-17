<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation M�dicament" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="tagline">Confirmation de cr�ation</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Libell�</th>
					<th>Code UCD</th>
					<th>Type</th>
					<th>Quantit�</th>
					<th>H�pital</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${medicine.label}</td>
					<td>${medicine.ucdCode}</td>
					<td>${medicine.typeRefInfra.id}</td>
					<td>${medicine.quantity}</td>
					<td>${medicine.hospital.id}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />