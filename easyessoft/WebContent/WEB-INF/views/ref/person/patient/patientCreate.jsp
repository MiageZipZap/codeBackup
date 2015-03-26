<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../../include/header.jsp">
	<jsp:param value="Create Patient" name="title" />
</jsp:include>

<script type="text/javascript" src="/easyessoft/js/patient.js"></script>

<div class="container" id="content">
	<div>
		<h1>Ajouter un patient</h1>
	</div>

	<br />
	<form:form id="form_patient" method="post"
		action="/easyessoft/ihm/ref/person/patient" commandName="patient">
		<fieldset>
			<fieldset>

				<legend>Informations générales</legend>
				<div class="form-group">
					<p>
						<label>Nom de famille</label>
						<form:input type="text" id="firstName" class="form-control"
							path="firstName" placeholder="Nom de famille" />
					</p>

					<p>
						<label>Prénom</label>
						<form:input type="text" id="lastName" class="form-control"
							path="lastName" placeholder="Prénom" />
					</p>
					<p>
						<label>Age</label>
						<form:input type="date" id="birthdate" class="form-control"
							path="birthdate" placeholder="04/10/1991" />
					</p>

					<p>
						<label>Sexe</label> <br /> <label class="radio-inline"> <form:radiobutton
								name="gender" id="genderM" path="gender" value="M" />Homme
						</label> <label class="radio-inline"> <form:radiobutton
								name="gender" id="genderF" path="gender" value="F" />Femme
						</label>
					</p>
				</div>

				<br /> <br />

				<legend>Contact</legend>

				<div class="form-group">

					<p>
						<label>Numéro de téléphone bureau</label>
						<form:input type="text" id="phoneNumberHome" class="form-control"
							path="phoneNumberHome" placeholder="Numéro fixe" />
					</p>

					<p>
						<label>Numéro de téléphone mobile</label>
						<form:input type="text" id="phoneNumberMobile"
							class="form-control" path="phoneNumberMobile"
							placeholder="Numéro mobile" />
					</p>

					<p>
						<label>Adresse e-mail</label>
						<form:input type="text" id="mailAdress" class="form-control"
							path="mailAdress" placeholder="votre@adresse.email" />
					</p>
				</div>

				<br />

				<legend>Données patient :</legend>

				<div class="form-group">

					<p>
						<label>Numéro de sécurité sociale</label>
						<form:input type="text" id="nir" class="form-control" path="nir"
							placeholder="Numéro fixe" />
					</p>

					<p>
						<label>Organisme</label>
						<form:select disabled="true" id="listOrganization"
							class="form-control" path="idOrganization">
							<form:option value='0' label='<Selectionnez>' />
							<c:forEach items="${listOrganization}" var="organization">
								<form:option class="organizationType${organization.orgaType.id}"
									value="${organization.id}">${organization.name}</form:option>
							</c:forEach>
						</form:select>
					</p>
				</div>
			</fieldset>
			<input class="btn btn-primary btn-lg" type="submit" value="create"
				id="createStaffButton" />
</div>
<br></br>
</form:form>
</div>
<jsp:include page="../../../include/footer.jsp" />