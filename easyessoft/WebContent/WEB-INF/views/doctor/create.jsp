<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation Medecin" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation d'un medecin</h1>
	</div>
	<form:form id="doctorForm" method="post"
		action="/IhmSpringMVC/ihm/doctor/create" commandName="doctor"
		onsubmit="return false;">
		<fieldset>
			<legend>Informations Medecin</legend>
			<p>
				<label>Nom</label> :
				<form:input path="surname" type="text" id="surname" />
			</p>
			<p>
				<label>Prenom</label> :
				<form:input path="firstname" type="text" id="firstname" />
			</p>
		</fieldset>
		
		<p>
			<input type="submit" value="create" id="createBut">
		</p>
	</form:form>
</div>
<jsp:include page="../include/footer.jsp" />