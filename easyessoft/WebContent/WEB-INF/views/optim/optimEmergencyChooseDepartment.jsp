<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp">
	<jsp:param name="title" value="Choix hospital optimisation" />
</jsp:include>
<style type="text/css">
.form-horizontal .has-feedback .form-control-feedback {
	right: 30px;
}
</style>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Choix de l'hospital pour un service d'urgence</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
						<form:form id="chooseHospitalForOptimService" class="form-horizontal"
								method="post" action="/easyessoft/ihm/optim/analyzeEmergencyService"
								commandName="organization">
								<fieldset>
									<legend>Hospitaux</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label selectContainer">Choisir l'hospital pour l'analyse du service d'urgence</label>
										<div class="col-sm-5">
											<form:select path="id" class="form-control" name="id" id="id">
												<form:option value='0' label='<Selectionnez>' />
												<c:forEach items="${orgaOfHistory}" var="selectionOrga">
													<form:option value="${selectionOrga.id}">${selectionOrga.name}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</fieldset>
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3" id="finish">
										<button type="submit" class="btn btn-primary btn-form"
											id="createButOrgaType">Analyser</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />