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
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${typeRefInfra.code}</td>
					<td>${typeRefInfra.label}</td>
					<td>${typeRefInfra.category.id}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />