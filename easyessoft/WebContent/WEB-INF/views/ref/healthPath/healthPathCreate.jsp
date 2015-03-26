<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Patient Record" name="title" />
</jsp:include>


<div class="container" id="content">
	<div>
		<h1>Ajouter un parcours de soins</h1>
	</div>

	<br />
	<form:form id="form_staffMember" method="post"
		action="/easyessoft/ihm/healthPaths/healthPath/healthPaths/healthPathCreateAction"
		commandName="healthPathCreate">
		<fieldset>
			<fieldset>

				<legend>Ajouter une étape du parcours</legend>
				<div class="form-group">
					<p>
						<label>Statut du patient</label>
						<form:select id="principalActList" class="form-control"
							path="currentState">
							<form:options items="${principalActList}"></form:options>
						</form:select>
					</p>
				</div>
			</fieldset>
		</fieldset>
		<input class="btn btn-primary btn-lg" type="submit" value="create"
			id="createStaffButton" />
		<br></br>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />