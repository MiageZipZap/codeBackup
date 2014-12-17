<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation Staff" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Create Staff</h1>
	</div>
	<form:form id="doctorForm" method="post"
		action="/IhmSpringMVC/ihm/doctor/create" commandName="doctor"
		onsubmit="return false;">
		<fieldset>
			<legend>Data Staff</legend>
			<p>
				<label>Nom</label> :
				<form:input path="surname" type="text" id="surname" />
			</p>
			<p>
				<label>Prénom</label> :
				<form:input path="firstname" type="text" id="firstname" />
			</p>
			<p>
				<label>Birth date</label> :
				<form:input path="birthDate" type="text" id="birthdate" />
			</p>
			<p>
				<label>Adresse</label> :
				<form:input path="adress" type="text" id="address" />
			</p>
		</fieldset>
		<p>
			<yyy hbyinput type="submit" value="create" id="createStaffBut">
		</p>
	</form:form>
</div>
<jsp:include page="../include/footer.jsp" />