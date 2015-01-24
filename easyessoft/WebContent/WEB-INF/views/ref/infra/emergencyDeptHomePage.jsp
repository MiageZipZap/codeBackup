<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>

<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Référentiel des infrastructures des
							services d'urgence</h1>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-6">
								<h3 class="page-header">Afficher</h3>
								<div class="well app-menu">
									<a href="#">
										<button type="button" class="btn btn-default btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i> les types
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-primary btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i> les
											infrastructures
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-success btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i>les équipements
										</button>
									</a><a href="#">
										<button type="button" class="btn btn-default btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i>les médicaments
										</button>
									</a>
								</div>
							</div>

							<div class="col-sm-6">
								<h3 class="page-header">Créer</h3>
								<div class="well app-menu">
									<a href="/easyessoft/ihm/ref/typeRefInfra/createForm">
										<button type="button" class="btn btn-default btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign"></i> un type
										</button>
									</a> <a href="/easyessoft/ihm/ref/infra/createForm">
										<button type="button" class="btn btn-primary btn-app">
											<i class="glyphicon glyphicon-plus-sign"></i> une
											infrastructure
										</button>
									</a> <a href="/easyessoft/ihm/ref/equip/createForm">
										<button type="button" class="btn btn-success btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign app-icon-link"></i>un
											équipement
										</button>
									</a> <a href="/easyessoft/ihm/ref/medicine/createForm">
										<button type="button" class="btn btn-default btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign app-icon-link"></i>un
											médicament
										</button>
									</a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<jsp:include page="../../include/footer.jsp" />