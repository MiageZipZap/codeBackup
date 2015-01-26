<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>

<div class="row">
	<div class="col-lg-14">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 class="boderline">${organization.name}</h1>
			</div>
			<div class="panel-body">
				<div class="box-content">
					<h2>Informations légales</h2>
					<label>Type d'organisation :${organization.orgaType.label}</label><br>
					<label>Siret :${organization.siret}</label><br> 
					<c:if test="${organization.orgaType.label=='HOPITAL'}">
						<label>Finess :${organization.finess}</label><br>
					</c:if>
					<div class="col-sm-4">
						<h2>Contacts</h2>
						<address>
							${organization.streetNumber} ${organization.streetType}
							${organization.streetName}<br> ${organization.zipCode}
							${organization.city}<br> <abbr title="Phone">${organization.phone}</abbr><br>
							<abbr title="Fax">${organization.fax}</abbr><br> <abbr
								title="Email"><a href="mailto:${organization.email}">"${organization.email}"</a></abbr>
						</address>
					</div>
					<div class="col-sm-4">
						<h2>Liste des services</h2>
						<ul>
							<c:forEach var="element" items="${services}">
								<li><a
									href="/easyessoft/ihm/ref/orga/getServiceDetails/${organization.id}/${element.id}">${element.label} <i
										class="glyphicon glyphicon-th-list"></i></a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>