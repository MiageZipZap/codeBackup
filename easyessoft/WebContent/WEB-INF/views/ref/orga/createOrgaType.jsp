<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Organisme" />
</jsp:include>
<script type="text/javascript" src="/easyessoft/js/jquery.js">
<script type="text/javascript" src="/easyessoft/js/orgaType.js" />
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
						<h1 class="boderline">Creation d'un type d'organisme</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<form:form id="orgaTypeForm" class="form-horizontal"
								method="post" action="/easyessoft/ihm/ref/orga/creationOrgaType"
								commandName="orgaType">
								<fieldset>
									<legend>Informations Type d'organisme</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label">Code du type
											d'organisme</label>
										<div class="col-sm-5">
											<form:input type="text" path="code" id="code"
												class="form-control" name="code"  value="OTXX"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Libellé</label>
										<div class="col-sm-5">
											<form:input type="text" path="label" id="label"
												class="form-control" name="label" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Type d'établissement</label>
										<div class="col-sm-5">
											<form:select path="legalStatus" class="form-control" name="legalStatus" id="legalStatus">
												<form:option value='NONE' label='<Selectionnez>' />
												<form:option value='PUBLIC' label='PUBLIC' />
												<form:option value='PRIVE' label='PRIVE' />
											</form:select>
										</div>
									</div>
								</fieldset>
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3" id="finish">
										<button type="submit" class="btn btn-primary btn-form"
											id="createButTypeOrga">Créer</button>
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