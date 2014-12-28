<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Type Ref Infra" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="tagline">Création d'une nouvelle entrée : TypeRefInfra</h1>
			</div>
		</div>
	</div>
	<div class="box-content">
		<form:form id="InfraForm" class="form-horizontal" method="post"
			action="/easyessoft/ihm/ref/infra/create" commandName="type ref infra"
			onsubmit="return false;">
			<fieldset>
				<legend>Informations type ref infra</legend>
				<p class="form-group">
					<label class="col-sm-3 control-label">code</label> :
					<form:input path="code" type="text" id="code" />
				</p>
				<p class="form-group">
					<label class="col-sm-3 control-label">Libellé</label> :
					<form:input path="label" type="text" id="label" />
				</p>
				<div class="form-group">
					<label class="col-sm-3 control-label"> Category :</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="categoryRefInfra.id">
							<c:forEach items="${lstOfCategory}" var="item">
								<form:option value="${item.id}">${item.label}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</fieldset>

			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<input type="submit" value="création type référentiel infrastructure"
						class="btn btn-primary" id="createButTypeRefInfra">
				</div>
			</div>
		</form:form>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />

