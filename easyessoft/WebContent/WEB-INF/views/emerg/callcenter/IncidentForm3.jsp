<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Ouvrir une intervention" />
</jsp:include>
<head>
<script type="text/javascript"
	src="/easyessoft/js/CallCenterAjaxGetListPatients.js"></script>
<!-- JQuery dependency already loaded by header-->
<script type="text/javascript"
	src="/easyessoft/dist/tinymce/tinymce.min.js"></script>
<script type="text/javascript">
	tinymce.init({
		selector : "textarea"
	});
</script>
<style type="text/css">
/* Adjust feedback icon position */
.form-horizontal .has-feedback .form-control-feedback {
	right: 30px;
}
</style>
</head>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Traiter un appel</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h1 class="page-header">Ouverture du ticket</h1>
							<form:form id="IncidentForm" role="form" class="form-horizontal"
								method="POST"
								action="/easyessoft/ihm/emerg/callcenter/createIncidentTicket"
								commandName="interventionTicket">
								<div class="form-group">
									<fieldset>
										<legend>Description des victimes</legend>
										<div class="form-group has-error has-feedback">
											<label class="col-sm-3 control-label">Nombre de
												victime</label>
											<div class="col-sm-2">
												<input type="text" id="injPatientNumber"
													path="injPatientNumber" class="form-control"
													name="injPatientNumber" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-styles">Remarques</label>
											<div class="col-sm-10">
												<textarea class="form-control" rows="5" name="remarks"
													id="wysiwig_simple"></textarea>
												<input id="testRemarks" type="hidden" path="remarks" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="form-styles">Diagnostic</label>
											<div class="col-sm-10">
												<textarea class="form-control" rows="5" name="diagnostics"
													id="wysiwig_full"></textarea>
												<input type="hidden" path="diagnostics" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Contraintes</label>
											<div class="col-sm-2">
												<div class="input-group">
													<input type="text" path="nbStretcher" class="form-control"
														placeholder="nb Allongement" name="nbStretcher"
														id="nbStretcher"><span class="input-group-addon"><i
														class="fa fa-github-square"></i></span>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="input-group">
													<input type="text" class="form-control"
														placeholder="transport"> <span
														class="input-group-addon"><i class="fa fa-group"></i></span>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-money"></i></span>
													<form:select path="priority" class="form-control"
														name="priority" id="priority">
														<c:forEach items="${priorities}" var="selectionType">
															<form:option value="${selectionType.id}">${selectionType.code}-${selectionType.label}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>
										</div>
									</fieldset>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-2">
											<button type="cancel" class="btn btn-default btn-label-left">
												<span><i class="fa fa-clock-o txt-danger"></i></span> Cancel
											</button>
										</div>
										<div class="col-sm-2">
											<button type="submit" class="btn btn-primary btn-label-left">
												<span><i class="fa fa-clock-o"></i></span> Next
											</button>
										</div>
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