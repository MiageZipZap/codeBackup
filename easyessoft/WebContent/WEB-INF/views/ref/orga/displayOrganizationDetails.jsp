<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Display Organization List" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">${organization.name}</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h2>Informations légales</h2>
							<dl class="dl-horizontal">
								<dt>Type d'organisation</dt>
								<dd>: ${organization.orgaType.label}</dd>
								<dt>Siret</dt>
								<dd>: ${organization.siret}</dd>
								<c:if test="${organization.orgaType.label=='HOPITAL'}">
									<dt>Finess</dt>
									<dd>: ${organization.finess}</dd>
								</c:if>
								<dt></dt>
							</dl>
							<h2>Contacts</h2>
							<dl class="dl-horizontal">
								<dt>Rue</dt>
								<dd>: ${organization.streetNumber} ${organization.streetType} ${organization.streetName}</dd>
								<dt>Code Postal</dt>
								<dd>: ${organization.zipCode}</dd>
								<dt>Ville</dt>
								<dd>: ${organization.city}</dd>
								<dt>Téléphone</dt>
								<dd>: ${organization.phone}</dd>
								<dt>Fax</dt>
								<dd>: ${organization.fax}</dd>
								<dt>Email</dt>
								<dd>: <a href="mailto:${organization.email}">"${organization.email}"</a></dd>
							</dl>
							<h2>Liste des services</h2>
							<dl class="dl-horizontal">
								<ul>
									<c:forEach var="element" items="${services}">
										<li><a
											href="/easyessoft/ihm/ref/orga/getServiceDetails/${organization.id}/${element.id}">${element.label}
												<i class="glyphicon glyphicon-th-list"></i>
										</a></li>
									</c:forEach>
								</ul>
							</dl>
							<div class="col-sm-4">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>