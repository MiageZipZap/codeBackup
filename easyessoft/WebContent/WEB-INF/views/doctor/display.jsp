<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation Medecin" name="title"/>
</jsp:include>
	<div id="doctorDisplay">
		<p>
			Le m�decin ${doctor.surname} ${doctor.firstname}
			a bien �t� ajout� avec le num�ro ${doctor.id}
		</p>
	</div>
<jsp:include page="../include/footer.jsp"/>