<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Médicament" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="tagline">Création d'une nouvelle entrée : Médicament</h1>
			</div>
		</div>
	</div>
	<div class="box-content">
		<form:form id="medicForm" class="form-horizontal" method="post"
			action="/easyessoft/ihm/ref/medicine/create"
			commandName="medicine" onsubmit="return false;">
			<fieldset>
				<legend>Informations médicament</legend>
				
				<p class="form-group">
					<label class="col-sm-3 control-label">Libellé :</label>
					<form:input path="label" type="text" id="label" />
				</p>
				
				<p class="form-group">
					<label class="col-sm-3 control-label">Code UCD :</label>
					<form:input path="ucdCode" type="text" id="ucdCode" />
				</p>

				<div class="form-group">
					<label class="col-sm-3 control-label">Type :</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="typeRefInfra.id">
							<c:forEach items="${lstOfType}" var="item">
								<form:option value="${item.id}">${item.label}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<p class="form-group">
					<label class="col-sm-3 control-label">Quantité :</label>
						<form:input size="4" type="text" id="quantity" path="quantity" />
				</p>
				
			</fieldset>

			<p class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<input type="submit" value="création du médicament"
						class="btn btn-primary" id="createButMedicine">
				</div>
			</p>
		</form:form>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />