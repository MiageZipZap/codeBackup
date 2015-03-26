<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Patient Record" name="title" />
</jsp:include>


<div class="container" id="content">
	<div>
		<h1>Ajouter un dossier patient</h1>
	</div>

	<br />
	<form:form id="form_medicalRecord" method="post"
		action="/easyessoft/ihm/ref/medicalRecord/medicalRecordCreateAction"
		commandName="medicalRecord">
		<fieldset>
			<fieldset>

				<legend>Fiche santé</legend>
				<div class="form-group">
					<p>
						<label>Taille</label>
						<form:input type="text" id="height" class="form-control"
							path="height" placeholder="1.80" />
					</p>

					<p>
						<label>Poids</label>
						<form:input type="text" id="weight" class="form-control"
							path="weight" placeholder="75kg" />
					</p>

					<p>
						<label>Groupe sanguin</label>
						<form:input type="bloodGroup" id="birthdate" class="form-control"
							path="bloodGroup" placeholder="0+" />
					</p>
					<p>
						<label>Type du patient</label>
						<form:select id="listTypePatient" class="form-control"
							path="typePatient">
							<form:options items="${listTypePatient}"></form:options>
						</form:select>

						<label>Statut du patient</label>
						<form:select id="listStatusPatient" class="form-control"
							path="statusPatient">
							<form:options items="${listStatusPatient}"></form:options>
						</form:select>
					</p>
				</div>
			</fieldset>
		</fieldset>
		<input class="btn btn-primary btn-lg" type="submit" value="create"
			id="createStaffButton" />
		<br></br>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />