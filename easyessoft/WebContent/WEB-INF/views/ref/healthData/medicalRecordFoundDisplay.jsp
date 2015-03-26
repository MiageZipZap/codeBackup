<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title"/>
</jsp:include>

<div class="container" id="content">

	<br />
	
	<br />
			
	<div>
		<h1>Confirmation</h1>
	</div>
			
	<br />
	
	<div id="medicalRecordFoundDisplay">
	
		<p>Le dossier patient appartenant à ${patient.lastName} ${patient.firstName} a bien été relié au dossier patients à l'ID N°${medicalRecord.id} </p>
		<br />
		
		<a href="/easyessoft/ihm/ref/person/patientCreateForm" class="btn btn-primary btn-lg active" role="button">Ajouter un autre patient</a>
		
	</div>
</div>	
<jsp:include page="../../include/footer.jsp"/>