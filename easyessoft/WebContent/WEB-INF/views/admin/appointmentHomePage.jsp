<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Appointment home page" name="title" />
</jsp:include>

<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Gestion des rendez-vous</h1>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-6">
								<h3 class="page-header">Afficher</h3>
								<div class="well app-menu">
									<a href="#">
										<button type="button" class="btn btn-default btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i> Tout les rendez-vous
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-primary btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i>Les rendez-vous d'un médecin
										</button>
									</a> <a href="#">
										
								</div>
							</div>

							<div class="col-sm-6">
								<h3 class="page-header">Créer</h3>
								<div class="well app-menu">
									<!-- <a href="/easyessoft/ihm/admin/appointment/createForm"> -->
									<a href="/easyessoft/ihm/admin/appointment/createForm">
										<button type="button" class="btn btn-default btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign"></i> un rendez-vous
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
<jsp:include page="../include/footer.jsp" />