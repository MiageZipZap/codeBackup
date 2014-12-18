<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Page d'accueil du référentiel des infrastructures de service d'urgence</h1>
	</div>
	<a href="/easyessoft/ihm/ref/equip/createForm">Création d'un équipement</a>
	<a href="/easyessoft/ihm/ref/infra/createForm">Création d'une infrastructure</a>
</div>
<jsp:include page="../../include/footer.jsp" />



