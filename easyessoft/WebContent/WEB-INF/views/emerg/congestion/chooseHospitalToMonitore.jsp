<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Engorgement - Choose Hospital" />
</jsp:include>

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
						<h1 class="boderline">Monitorer les services d'urgences</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<form:form id="hospitalChoose" class="form-horizontal"
								method="post" action="/easyessoft/ihm/emerg/congestion/simulator/DisplaySingleService"
								commandName="hospital">
								<fieldset>
									<legend>Hôpitaux</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label selectContainer">Choisir
											l'hôpital</label>
										<div class="col-sm-5">
											<form:select path="id" class="form-control" name="id" id="id">
												<form:option value='0' label='<Selectionnez>' />
												<c:forEach items="${listHospital}" var="item">
													<form:option value="${item.id}">${item.name}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</fieldset>
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3" id="finish">
										<button type="submit" class="btn btn-primary btn-form"
											id="createButOrgaType">OK</button>
									</div>
								</div>
							</form:form>
							<div class="col-md-4">
								<button class="btn btn-success btn-jg" id="createButOrgaType">Monitorer
									l'ensemble des hôpitaux</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />