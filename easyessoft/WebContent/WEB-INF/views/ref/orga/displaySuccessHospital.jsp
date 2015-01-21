<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>
<div id="orgaDisplay">
	<p>L'organisation ${hospital.name} a bien été ajouté avec le numéro
		${hospital.id}</p>
	<div class="well app-menu">
		<form:form action="/easyessoft/ihm/ref/orga/chooseService"
			method="POST" commandName="cmd">

			<input type="hidden" name="name" value="${hospital.name}" />
			<input type="hidden" name="id" value="${hospital.id}" />
			<button type="submit" class="btn btn-default btn-app" role="button">
				<i class="glyphicon glyphicon-plus-sign"></i>Ajouter des services
			</button>
		</form:form>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />