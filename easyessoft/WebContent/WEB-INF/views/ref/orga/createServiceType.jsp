<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Service" />
</jsp:include>
<script type="text/javascript" src="/easyessoft/js/jquery.js">
<script type="text/javascript" src="/easyessoft/js/ServiceType.js" />
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
								method="post" action="/easyessoft/ihm/ref/orga/creationServiceType"
								commandName="servicetype">
								<fieldset>
									<legend>Informations Type de service</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label">Code du type
											de service</label>
										<div class="col-sm-5">
											<form:input type="text" path="code" id="code"
												class="form-control" name="code"  value="STXX"/>
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
										<label class="col-sm-3 control-label selectContainer">Choisir
											le type d'organisme</label>
										<div class="col-sm-5">
											<form:select path="categoryService" class="form-control"
												name="categoryService" id="categoryService">
												<form:option value='NONE' label='<Selectionnez>' />
												<c:forEach items="${listCategory}" var="selectionType">
													<form:option value="${selectionType}">${selectionType}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</fieldset>
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3" id="finish">
										<button type="submit" class="btn btn-primary btn-form"
											id="createButTypeService">Créer</button>
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