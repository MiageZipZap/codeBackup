<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Patient Record" name="title" />
</jsp:include>


<div class="container" id="content">
	<div>
		<h1>Associer un patient � son dossier</h1>
	</div>

	<br />
	<form:form id="form_staffMember" method="post"
		action="/easyessoft/ihm/ref/medicalRecord/relateToPatient"
		commandName="patient">
		<fieldset>
			<fieldset>
				<legend>Identification du patient � associer</legend>
				<div class="form-group">
					<p>
						<label>Num�ro de s�curit� sociale</label>
						<form:input type="text" id="nir" class="form-control"
							path="nir" placeholder="Numero de s�curit� sociale" />
					</p>
				</div>
			</fieldset>
		</fieldset>
		<input class="btn btn-primary btn-lg" type="submit"
			value="createRelation" id="createRelationToPatient" />
		<br></br>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />