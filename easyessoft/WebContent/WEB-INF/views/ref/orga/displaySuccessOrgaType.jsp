<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Type d'organisation" name="title"/>
</jsp:include>
	<div id="orgaTypeDisplay">
		<p>
			Le Type d'organisation ${orgaType.label}
			a bien été ajouté avec le numéro ${orgaType.id}
		</p>
	</div>
<jsp:include page="../../include/footer.jsp"/>