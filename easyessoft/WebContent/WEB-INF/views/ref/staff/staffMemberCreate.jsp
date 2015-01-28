<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Create Staff Member" name="title" />
</jsp:include>

<script type="text/javascript" src="/easyessoft/js/staff.js"></script>

<div class="container" id="content">
				
	<br />
			
	<div>
		<h1>Ajouter un membre du personnel</h1>
	</div>
			
	<br />
			
	<form:form id="form" method="post" action="/easyessoft/ihm/ref/staffAdmin/member/createAction" commandName="staffMember" >	
		
		<fieldset>
		
			<legend>Informations générales</legend>
			
			<div class="form-group">
			
				<p>
					<label>N° de Matricule</label>
					<form:input type="text" id="staffNumber" class="form-control" path="staffNumber" placeholder="N° de Matricule" />
				</p>
			
				<p>
					<label>Nom de famille</label>
					<form:input type="text" id="lastName" class="form-control" path="lastName" placeholder="Nom de famille" />
				</p>	
				
				<p>
					<label>Prénom</label>
					<form:input type="text" id="firstName" class="form-control" path="firstName" placeholder="Prénom" />
				</p>
			 
				<p>
					<label>Date de naissance</label>
					<form:input type="date" id="birthdate" class="form-control" path="birthdate" placeholder="01/01/1970" />
				</p>

				<p>
					<label>Sexe</label>
					<br />
					<label class="radio-inline">
						<form:radiobutton name="gender" id="genderM" path="gender" value="M" />Homme 
					</label>
					<label class="radio-inline">
						<form:radiobutton name="gender" id="genderF" path="gender" value="F" />Femme
					</label>
				</p>
				
			</div>
			
			<br />
			
			<legend>Adresse</legend>
			
				<div class="form-group">
			
					<p>
						<label>Numero de la voie</label>
						<form:input type="text" id="addressStreetNumber" class="form-control" path="adress.streetNumber" placeholder="Numero" />
					</p>
					
					<p>
						<label>Type de voie</label>
						<form:input type="text" id="addressStreetType" class="form-control" path="adress.streetType" placeholder="Séléctionnez"/>
					</p>
	
					<p>
						<label>Nom de la voie</label>
						<form:input type="text" id="adressStreetName" class="form-control" path="adress.streetName" placeholder="Nom de la voie"/>
					</p>
					
					<p>
						<label>Région</label>
						<form:input type="text" id="addressRegion" class="form-control" path="adress.region" placeholder="Région"/>
					</p>
			
					<p>
						<label>Code postal</label>
						<form:input type="text" id="addressZipCode" class="form-control" path="adress.zipCode" placeholder="Code postal" />
					</p>
					
					<p>
						<label>Ville</label>
						<form:input type="text" id="addressCity" class="form-control" path="adress.city" placeholder="Ville" />
					</p>
			
				</div>
			
			
			<br />
				
			<legend>Contact</legend>
				
				<div class="form-group">
				
					<p>
						<label>Numéro de téléphone bureau</label>
						<form:input type="text" id="phoneNumberWork" class="form-control" path="phoneNumberWork" placeholder="Numéro fixe" />
					</p>
			
					<p>
						<label>Numéro de téléphone mobile</label>
						<form:input type="text" id="phoneNumberMobile" class="form-control" path="phoneNumberMobile" placeholder="Numéro mobile" />
					</p>

					<p>
						<label>Adresse e-mail</label>
						<form:input type="text" id="mailAdress" class="form-control" path="mailAdress" placeholder="votre@adresse.email"  />
					</p>
					
				</div>
			
			<br />
			
			<legend>Profession</legend>
				
				<div class="form-group">		

					<p>
						<label>Type de profession</label>
						<form:select id="id" class="form-control" path="id" name="id" >
							<form:option value='0' label='<Selectionnez>' />
								<c:forEach items="${listTypeOrga}" var="selectionType">
									<form:option value="${selectionType.id}">${selectionType.code}-${selectionType.label} (${selectionType.legalStatus})</form:option>
								</c:forEach>
						</form:select>
					</p>
					
					<p>
						<label>Profession</label>
						<form:select id="id" class="form-control" path="id" name="id" >
							<form:option value='0' label='<Selectionnez>' />
								<c:forEach items="${listTypeOrga}" var="selectionType">
									<form:option value="${selectionType.id}">${selectionType.code}-${selectionType.label} (${selectionType.legalStatus})</form:option>
								</c:forEach>
						</form:select>
					</p>
					
					<p>
						<label>Spécialité</label> :
						<form:input type="text" id="professionLabel" class="form-control" path="profession.label" value="${orga.label} sisi ${listTypeOrga}" placeholder="Profession"/>
					</p>			
			
				</div>
			
			<br />
			
			<legend>Organisme et Service d'affectation</legend>
			
				<div class="form-group">
			
					<p>
						<label>Type d'organisme</label>
						<form:select id="listOrganizationType" class="form-control" path="id" name="listOrganizationType">
							<form:option value='0' label='<Selectionnez>' />
								<c:forEach items="${listOrganizationType}" var="organizationType">
									<form:option class="organizationType${organizationType.id}" value="${organizationType.id}">${organizationType.label} (${organizationType.legalStatus})</form:option>
								</c:forEach>
						</form:select>
					</p>

					<p>
					<label>Organisme</label>
					<form:select disabled="true" id="listOrganization" class="form-control" path="id" name="listOrganization">
						<form:option value='0' label='<Selectionnez>' />
							<c:forEach items="${listOrganization}" var="organization">
								<form:option class="organizationType${organization.orgaType.id}" value="${organization.id}">${organization.name}</form:option>
							</c:forEach>
						</form:select>
					</p>
					
					<p>
					<label>Service</label>
					<form:select disabled="true" id="listService" class="form-control" path="id" name="listService">
						<form:option value='0' label='<Selectionnez>' />
							<c:forEach items="${listService}" var="service">
								<form:option value="${service.id}">okok</form:option>
							</c:forEach>
						</form:select>
					</p>
			
				</div>
			
			<br />
			
			<br />
			
			<input class="btn btn-primary btn-lg" type="submit" value="create" id="createButton" />
				
		</fieldset>
	
	</form:form>
															
</div>

<jsp:include page="../../include/footer.jsp" />