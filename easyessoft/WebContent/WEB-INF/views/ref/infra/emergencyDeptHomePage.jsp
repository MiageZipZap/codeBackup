<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Page d'accueil du r�f�rentiel des infrastructures de service d'urgence</h1>
	</div>
	<a href="/easyessoft/ihm/ref/equip/createForm">Cr�ation d'un �quipement</a>
	<a href="/easyessoft/ihm/ref/infra/createForm">Cr�ation d'une infrastructure</a>
</div>
<jsp:include page="../../include/footer.jsp" />



