<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title"/>
</jsp:include>
	<div id="staffDisplay">
		<p>
			Le médecin ${staff.surname} ${staff.firstname}
			a bien été ajouté avec le numéro ${staff.id}
		</p>
	</div>
<jsp:include page="../../include/footer.jsp"/>