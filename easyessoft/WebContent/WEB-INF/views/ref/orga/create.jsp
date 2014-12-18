<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Organisme" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation d'un organisme</h1>
	</div>
	<div class="box-content">
		<form:form id="orgaForm" class="form-horizontal" method="post"
			action="/easyessoft/ihm/ref/orga/create" commandName="organization"
			onsubmit="return false;">
			<fieldset>
				<legend>Type d'organisme</legend>
				<div class="form-group">
					<label class="col-sm-3 control-label">Choisir le type
						d'organisme</label>
					<div class="col-sm-5">
						<form:select path="orgaType.id" class="form-control"
							name="OrgaType" id="OrgaType">
							<c:forEach items="${list}" var="selectionType">
								<form:option value="${selectionType.id}">${selectionType.label}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Informations légales</legend>
				<div class="form-group">
					<label class="col-sm-3 control-label">Raison Sociale</label>
					<div class="col-sm-5">
						<form:input type="text" path="name" id="name" class="form-control"
							name="name" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Siret</label>
					<div class="col-sm-5">
						<form:input type="text" path="siret" id="siret"
							class="form-control" name="siret" />
					</div>
				</div>
				<legend>Adresse</legend>
				<div class="form-group">
					<label class="col-sm-3 control-label">Numéro de rue</label>
					<div class="col-sm-5">
						<form:input type="text" path="streetNumber" id="streetNumber"
							class="form-control" name="streetNumber" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Type de voie</label>
					<div class="col-sm-5">
						<form:input type="text" path="streetType" id="streetType"
							class="form-control" name="streetType" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Nom de rue</label>
					<div class="col-sm-5">
						<form:input type="text" path="streetName" id="streetName"
							class="form-control" name="streetName" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Ville</label>
					<div class="col-sm-5">
						<form:input type="text" path="city" id="city" class="form-control"
							name="city" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Zip code</label>
					<div class="col-sm-5">
						<form:input type="text" path="zipCode" id="zipCode"
							class="form-control" name="zipCode" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">départment</label>
					<div class="col-sm-5">
						<form:input type="text" path="department" id="department"
							class="form-control" name="department" />
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Contact</legend>
				<div class="form-group">
					<label class="col-sm-3 control-label">Fax</label>
					<div class="col-sm-5">
						<form:input type="text" path="fax" id="fax" class="form-control"
							name="fax" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">email</label>
					<div class="col-sm-5">
						<form:input type="text" path="email" id="email"
							class="form-control" name="email" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">téléphone</label>
					<div class="col-sm-5">
						<form:input type="text" path="phone" id="phone"
							class="form-control" name="phone" />
					</div>
				</div>
			</fieldset>
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" class="btn btn-primary" id="createButOrga">Créer</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />
