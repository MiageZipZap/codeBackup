<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation MedicalRecord" name="title" />
</jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container" id="content">

	<br /> <br />

	<div>
		<h1>Confirmation</h1>
	</div>

	<br />

	<div id="medicalRecordDisplay">
		<div class="form-group">
			<legend>Infos g�n�rales</legend>
			<p>Pr�nom : ${patient.firstName}
			<p />
			<p>Nom : ${patient.lastName} <p/>
			<p>Date de naissance: ${patient.birthdate}<p/>
			<br />
		</div>
		<div class="form-group">
			<legend>Fiche sant�</legend>
			<p>Taille du patient ${medicalRecord.height}m</p>
			<p>Poids du patient: ${medicalRecord.weight}kg</p>
			<p>Groupe sanguin du patient : ${medicalRecord.bloodGroup}</p>
			<p>Type de patient : ${medicalRecord.typePatient}</p>
			<p>Statut du patient: ${medicalRecord.statusPatient}</p>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />