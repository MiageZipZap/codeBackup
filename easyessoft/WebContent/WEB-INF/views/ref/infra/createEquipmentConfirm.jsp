<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Medecin" name="title" />
</jsp:include>
<div id="content">
	<p>L'infrastructure ${equipment.label} a bien �t� ajout� !</p>

	<p>
	<table>
		<tr>
			<th>Num�ro de s�rie</th>
			<th>Libell�</th>
			<th>Type</th>
		</tr>
		<tr>
			<td>${equipment.serialNumber}</td>
			<td>${equipment.label}</td>
			<td>${equipment.typeRefInfra.id}</td>
		</tr>
	</table>
	</p>
</div>
<jsp:include page="../../include/footer.jsp" />