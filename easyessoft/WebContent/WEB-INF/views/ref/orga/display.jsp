<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title"/>
</jsp:include>
	<div id="orgaDisplay">
		<p>
			L'organisation ${organization.name}
			a bien été ajouté avec le numéro ${organization.id}
		</p>
	</div>
<jsp:include page="../../include/footer.jsp"/>