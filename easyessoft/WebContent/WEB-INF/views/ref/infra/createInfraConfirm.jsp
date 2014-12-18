<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Medecin" name="title" />
</jsp:include>
<div id="content">
	<p>L'infrastructure ${infrastructure.label} a bien été ajouté !</p>

	<p>
	<table>
		<tr>
			<th>Code</th>
			<th>Libellé</th>
			<th>Capacité</th>
			<th>Type</th>
			<th>Accessibilité PMR</th>
		</tr>
		<tr>
			<td>${infrastructure.code}</td>
			<td>${infrastructure.label}</td>
			<td>${infrastructure.capacity}</td>
			<td>${infrastructure.typeRefInfra.id}</td>
			<td><c:if test="${infrastructure.disabledFacilities}">oui
			</c:if> <c:if test="${!infrastructure.disabledFacilities}">non
			</c:if></td>
		</tr>
	</table>
	</p>
</div>
<jsp:include page="../../include/footer.jsp" />