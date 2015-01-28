<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>
<link href="/easyessoft/dist/css/ref/staff/staff-style.css" rel="stylesheet">
<!-- Page Content -->
<script src="<c:url value="/resources/js/main.js" />"></script>

<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Référentiel du personnel soignant</h1>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-6">
								<h3 class="page-header">Afficher</h3>
								<div class="well app-menu">
									<a href="#">
										<button type="button" class="btn btn-default btn-app"
											role="button" disabled>
											<i class="glyphicon glyphicon-eye-open"></i> Membre du personnel
										</button>
									</a> 
								</div>
							</div>
							<div class="col-sm-6">
								<h3 class="page-header">Créer</h3>
								<div class="well app-menu">
									<a href="/easyessoft/ihm/ref/staffAdmin/member/createForm">
										<button type="button" class="btn btn-default btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign"></i> Membre du personnel
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-primary btn-app">
											<i class="glyphicon glyphicon-plus-sign"></i> Membre du personnel
										</button>
									</a> <a href="#">
										<button type="button" class="btn btn-success btn-app"
											role="button">
											<i class="glyphicon glyphicon-plus-sign app-icon-link"></i>
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