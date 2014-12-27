<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="tagline">R�f�rentiel des infrastructures d'un service d'urgences</h1>
				</div>
			</div>
		</div>
	<ul class="nav nav-pills nav-stacked">
		<li><a href="/easyessoft/ihm/ref/equip/createForm">Cr�ation
				d'un �quipement</a></li>
		<li><a href="/easyessoft/ihm/ref/infra/createForm">Cr�ation
				d'une infrastructure</a></li>
		<li><a href="/easyessoft/ihm/ref/infra/createForm">Cr�ation
				d'un m�dicament</a></li>
	</ul>
</div>
<jsp:include page="../../include/footer.jsp" />



