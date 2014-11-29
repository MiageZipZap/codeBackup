<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation Medecin" name="title"/>
</jsp:include>
	<div id="doctorDisplay">
		<p>
			Le médecin ${doctor.surname} ${doctor.firstname}
			a bien été ajouté avec le numéro ${doctor.id}
		</p>
	</div>
<jsp:include page="../include/footer.jsp"/>