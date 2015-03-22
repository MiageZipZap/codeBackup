<jsp:include page="../../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title"/>
</jsp:include>

<div class="container" id="content">

	<br />
	
	<br />
			
	<div>
		<h1>Confirmation</h1>
	</div>
			
	<br />
	
	<div id="staffDisplay">
	
		<p>Le patient ${patient.name} ${patient.surname} a bien été ajouté au référentiel des patients à l'ID N°${patient.id} </p>
		
		<br />
		
		<a href="/easyessoft/ihm/ref/person/patientCreateForm" class="btn btn-primary btn-lg active" role="button">Ajouter un autre patient</a>
		
	</div>
</div>	
<jsp:include page="../../../include/footer.jsp"/>