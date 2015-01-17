<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Infrastructure" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="tagline">Création d'une nouvelle entrée :
					Infrastructure</h1>
			</div>
		</div>
	</div>
	<div class="box-content">
		<form:form id="infraForm" class="form-horizontal" method="post"
			action="/easyessoft/ihm/ref/infra/create"
			commandName="infrastructure" onsubmit="return false;">
			<fieldset>
				<legend>Informations infrastructure</legend>
				<p class="form-group">
					<label class="col-sm-3 control-label">Code :</label>
					<form:input path="code" type="text" id="code" />
				</p>
				<p class="form-group">
					<label class="col-sm-3 control-label">Libellé :</label>
					<form:input path="label" type="text" id="label" />
				</p>

				<div class="form-group">
					<label class="col-sm-3 control-label">Type :</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="typeRefInfra.id">
							<c:forEach items="${lstOfType}" var="item">
								<form:option value="${item.id}">${item.label}</form:option>
							</c:forEach>
						</form:select>
						<form:hidden path="typeRefInfra.category.code"
							value="${lstOfType[0].category.code}" />
					</div>
				</div>
				<p class="form-group">
					<label class="col-sm-3 control-label">Capacité d'accueil :</label>
					<form:input size="4" type="text" id="capacity" path="capacity" />
				</p>
				<p class="form-group">
					<label class="col-sm-3 control-label">Accessibilité PMR :</label>
					<form:checkbox path="disabledFacilities" />
				</p>
				<div class="form-group">
					<label class="col-sm-3 control-label">Hôpital :</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="hospital.id">
							<c:forEach items="${lstHospital}" var="item">
								<form:option value="${item.id}">${item.name}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</fieldset>

			<p class="form-group">
			<div class="col-sm-9 col-sm-offset-3">
				<input type="submit" value="création de l'infrastructure"
					class="btn btn-primary" id="createButInfra">
			</div>
			</p>
		</form:form>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />