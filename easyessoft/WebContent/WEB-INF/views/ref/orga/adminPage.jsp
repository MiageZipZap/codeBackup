<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Référentiel des organismes de santé</h1>
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
											d'organisme
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-primary btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i> les organismes
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-success btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i>les Types de service
										</button>
									</a>
								</div>
							</div>
							<div class="col-sm-6">
								<h3 class="page-header">Créer</h3>
								<div class="well app-menu">
									<a href="/easyessoft/ihm/ref/orga/creationFormOrgaType">
										<button type="button" class="btn btn-default btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign"></i> un type
											d'organisme
										</button>
									</a> <a href="/easyessoft/ihm/ref/orga/creationForm">
										<button type="button" class="btn btn-primary btn-app">
											<i class="glyphicon glyphicon-plus-sign"></i> un organisme
										</button>
									</a> <a href="/easyessoft/ihm/ref/orga/creationFormServiceType">
										<button type="button" class="btn btn-success btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign app-icon-link"></i>un
											type de service
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
</div>
<jsp:include page="../../include/footer.jsp" />