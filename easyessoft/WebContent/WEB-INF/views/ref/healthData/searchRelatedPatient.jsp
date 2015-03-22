<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Patient Record" name="title" />
</jsp:include>


<div class="container" id="content">
	<div>
		<h1>Associer un patient à son dossier</h1>
	</div>

	<br />
	<form:form id="form_staffMember" method="post"
		action="/easyessoft/ihm/ref/medicalRecord/searchPatient"
		commandName="medicalRecord">
		<fieldset>
			<fieldset>

				<legend>Identification du patient à associer</legend>
				<div class="form-group">
					<p>
						<label>Type de profession</label>
						<form:select id="listPatient" class="form-control"
							path="idPatient">
							<form:option value='0' label='<Selectionnez>' />
							<c:forEach items="${listPatient}" var="patient">
								<form:option class="relatedPatient${patient.id}"
									value="${patient.id}">${patient.firstName}  ${patient.lastName}</form:option>
							</c:forEach>
						</form:select>
					</p>
					<p>
						<label>Nom du patient</label>
						<form:input type="text" id="lastName" class="form-control"
							path="lastName" placeholder="Nom de famille" />
					</p>
					<p>
						<label>Prénom du patient</label>
						<form:input type="text" id="lastName" class="form-control"
							path="firstName" placeholder="Nom de famille" />
					</p>
					<p>
						<label>Date de naissance du patient</label>
						<form:input type="text" id="lastName" class="form-control"
							path="birthdate" type="date" placeholder="01/01/1970" />
					</p>
				</div>
			</fieldset>
		</fieldset>
		<input class="btn btn-primary btn-lg" type="submit"
			value="createRelation" id="createRelationToPatient" />
		<br></br>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />