<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title" />
</jsp:include>


<div class="container" id="content">

	<br /> <br />

	<div>
		<h1>Confirmation</h1>
	</div>

	<br />

	<div id="patientDisplay">

		<p>Patient correspondant: ${patient.lastName} ${patient.firstName}
			à l'ID N°${patient.id}</p>

		<br /> <a href="/easyessoft/ihm/ref/medicalRecord/${patient.id}"
			class="btn btn-primary btn-lg active" role="button">Rechercher le
			dossier patient associé</a>

	</div>
</div>
<jsp:include page="../../../include/footer.jsp" />