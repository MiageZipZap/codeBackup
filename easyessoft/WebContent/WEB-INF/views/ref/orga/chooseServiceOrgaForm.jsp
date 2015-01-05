<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Ajouter un Service" />
</jsp:include>
<script type="text/javascript" src="/easyessoft/js/service.js">
	
</script>
<style type="text/css">
/* Adjust feedback icon position */
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
						<h1 class="boderline">Ajout de services à L'organisation</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<form:form id="serviceForm" class="form-horizontal" method="post"
								action="/easyessoft/ihm/ref/orga/addNewService"
								commandName="service">
								<fieldset>
									<legend>Informations Type de service</legend>
									<p>
										L'organisation <b>"${name}"</b> avec le numéro <b>"${id}"</b>
									</p>
									<h4 class="page-header">Selection des services</h4>
									<div class="row form-group">
										<div class="col-sm-12">
											<form:hidden path="idOrganizaton" style="display:none" value="${id}"/>
											<form:select class="form-control" multiple="true"
												path="listIdTypeOfServices">
												<form:options items="${listServiceType}" itemValue="id"
													itemLabel="label" />
											</form:select>
										</div>
									</div>
								</fieldset>
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3" id="finish">
										<button type="submit" class="btn btn-primary btn-form"
											id="createButService">Créer</button>
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
<jsp:include page="../../include/footer.jsp" />
