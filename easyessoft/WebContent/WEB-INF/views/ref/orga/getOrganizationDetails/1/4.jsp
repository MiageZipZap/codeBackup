<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../../../include/header.jsp">
	<jsp:param value="Service Ambulatoire" name="title" />
</jsp:include>

			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">${service.name}</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h2>Nouveau rendez-vous</h2>
							
							
								
										<a
											href="/easyessoft/ihm/ref/orga/getServiceDetails/newAppointment/${organization.id}/${element.id}">Nouveau rendez-vous
												<i class="glyphicon glyphicon-th-list"></i>
										</a>
								
							
							<div class="col-sm-4">
							</div>
						</div>
					</div>
		
		
	</div>
</div>