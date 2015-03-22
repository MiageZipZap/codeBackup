<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../../include/header.jsp">
	<jsp:param value="Create Staff Member" name="title" />
</jsp:include>

<script type="text/javascript" src="/easyessoft/js/staff.js"></script>


<div class="container" id="content">
	<div>
		<h1>Ajouter un membre du personnel</h1>
	</div>

	<br />
	<form:form id="form_staffMember" method="post"
		action="/easyessoft/ihm/ref/person/staffMember"
		commandName="staffMember">
		<fieldset>
			<fieldset>

				<legend>Informations g�n�rales</legend>
				<div class="form-group">
					<p>
						<label>Nom de famille</label>
						<form:input type="text" id="name" class="form-control" path="name"
							placeholder="Nom de famille" />
					</p>

					<p>
						<label>Pr�nom</label>
						<form:input type="text" id="surname" class="form-control"
							path="surname" placeholder="Pr�nom" />
					</p>

					<p>
						<label>Date de naissance</label>
						<form:input type="text" id="age" class="form-control" path="age"
							placeholder="01/01/1970" />
					</p>

					<p>
						<label>Sexe</label> <br /> <label class="radio-inline"> <form:radiobutton
								name="sex" id="sexM" path="sex" value="M" />Homme
						</label> <label class="radio-inline"> <form:radiobutton name="sex"
								id="sexF" path="sex" value="F" />Femme
						</label>
					</p>
				</div>

				<br />

				<legend>Adresse</legend>
				<%--
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
 --%>
			</fieldset>

			<br />
			<fieldset>
				<legend>Organisme et Service d'affectation</legend>

				<div class="form-group">
					<%--
				<p>
					<label>Type d'organisme</label>
					<form:select id="listOrganizationType" class="form-control"
						path="idTest">
						<form:option value='0' label='<Selectionnez>' />
						<c:forEach items="${listOrganizationType}" var="organizationType">
							<form:option class="organizationType${organizationType.id}"
								value="${organizationType.id}">${organizationType.label} (${organizationType.legalStatus})</form:option>
						</c:forEach>
					</form:select>
				</p>
--%>
					<!--  
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

				<p>
					<label>Service</label>
					<form:select disabled="true" id="listService" class="form-control"
						path="idService">
						<form:option value='0' label='<Selectionnez>' />
						<c:forEach items="${listService}" var="service">
							<form:option class="organizationType${service.id}"
								value="${service.id}">${service.label}</form:option>
						</c:forEach>
					</form:select>
				</p>
				!-->
				</div>
			</fieldset>
			<fieldset>
				<legend>Information suppl�mentaire</legend>
				<div class="form-group">
					<form:input type="text" path="codeRPPS" id="codeRPPS"
						class="form-control" name="codeRPPS" />
				</div>
			</fieldset>
		</fieldset>
		<input class="btn btn-primary btn-lg" type="submit" value="create"
			id="createStaffButton" />
		<br></br>
	</form:form>
</div>
<jsp:include page="../../../include/footer.jsp" />