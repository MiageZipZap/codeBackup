<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="tagline">Référentiel des infrastructures d'un service d'urgences</h1>
				</div>
			</div>
		</div>
	<ul class="nav nav-pills nav-stacked">
		<li><a href="/easyessoft/ihm/ref/equip/createForm">Création
				d'un équipement</a></li>
		<li><a href="/easyessoft/ihm/ref/infra/createForm">Création
				d'une infrastructure</a></li>
		<li><a href="/easyessoft/ihm/ref/infra/createForm">Création
				d'un médicament</a></li>
	</ul>
</div>
<jsp:include page="../../include/footer.jsp" />



