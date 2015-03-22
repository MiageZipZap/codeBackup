<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../../include/header.jsp">
	<jsp:param value="Create Patient" name="title" />
</jsp:include>


<div class="container" id="content">
	<div>
		<h1>Ajouter un patient</h1>
	</div>

	<br />
	<form:form id="form_patient" method="post"
		action="/easyessoft/ihm/ref/person/patient" commandName="patient">
		<fieldset>
			<fieldset>

				<legend>Informations g�n�rales</legend>
				<div class="form-group">
					<p>
						<label>Nom de famille</label>
						<form:input type="text" id="name" class="form-control"
							path="name" placeholder="Nom de famille" />
					</p>

					<p>
						<label>Pr�nom</label>
						<form:input type="text" id="surname" class="form-control"
							path="surname" placeholder="Pr�nom" />
					</p>
					<p>
						<label>Age</label>
						<form:input type="text" id="age" class="form-control"
							path="age" placeholder="age" />
					</p>

					<p>
						<label>Sexe</label> <br /> <label class="radio-inline"> <form:radiobutton
								name="sex" id="genderM" path="sex" value="M" />Homme
						</label> <label class="radio-inline"> <form:radiobutton
								name="sex" id="genderF" path="sex" value="F" />Femme
						</label>
					</p>
				</div>

				<br />
<%-- 
				<legend>Adresse</legend>

				<div class="form-group">

					<p>
						<label>Numero de la voie</label>
						<form:input type="text" id="streetNumber" class="form-control"
							path="streetNumber" placeholder="Numero" />
					</p>

					<p>
						<label>Type de voie</label>
						<form:input type="text" id="streetType" class="form-control"
							path="streetType" placeholder="S�l�ctionnez" />
					</p>

					<p>
						<label>Nom de la voie</label>
						<form:input type="text" id="streetName" class="form-control"
							path="streetName" placeholder="Nom de la voie" />
					</p>

					<p>
						<label>R�gion</label>
						<form:input type="text" id="region" class="form-control"
							path="region" placeholder="R�gion" />
					</p>

					<p>
						<label>Code postal</label>
						<form:input type="text" id="zipCode" class="form-control"
							path="zipCode" placeholder="Code postal" />
					</p>

					<p>
						<label>Ville</label>
						<form:input type="text" id="city" class="form-control" path="city"
							placeholder="Ville" />
					</p>

				</div>


				<br />

				<legend>Contact</legend>

				<div class="form-group">

					<p>
						<label>Num�ro de t�l�phone bureau</label>
						<form:input type="text" id="phoneNumberWork" class="form-control"
							path="phoneNumberWork" placeholder="Num�ro fixe" />
					</p>

					<p>
						<label>Num�ro de t�l�phone mobile</label>
						<form:input type="text" id="phoneNumberMobile"
							class="form-control" path="phoneNumberMobile"
							placeholder="Num�ro mobile" />
					</p>

					<p>
						<label>Adresse e-mail</label>
						<form:input type="text" id="mailAdress" class="form-control"
							path="mailAdress" placeholder="votre@adresse.email" />
					</p>
				</div>

				<br />
--%>
				<legend>Informations suppl�mentaires</legend>
				<div class="form-group">
					<label>Num�ro de s�curit� sociale</label>
					<form:input type="text" id="nir" class="form-control" path="nir"
						placeholder="Num�ro de s�curit� sociale" />
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
				</div>
			</fieldset>
			<input class="btn btn-primary btn-lg" type="submit" value="create"
				id="createStaffButton" />
</div>
</fieldset>
<br></br>
</form:form>
</div>
<jsp:include page="../../../include/footer.jsp" />