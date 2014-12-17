<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation d'un nouveau équipement</h1>
	</div>
	<form:form id="equipForm" method="post"
		action="/easyessoft/ihm/ref/infra/create" commandName="equipment"
		onsubmit="return false;">
		<fieldset>
			<legend>Informations équipement</legend>
			<p>
				<label>Code</label> :
				<form:input path="code" type="text" id="code" />
			</p>
			<p>
				<label>Libellé</label> :
				<form:input path="label" type="text" id="label" />
			</p>
			<p>
				<label>Catégorie</label> :
				<form:input path="typeRefInfra.category.code" type="text" id="category" />
			</p>
			<p>
				<label>Type</label> :
				<form:input path="typeRefInfra.code" type="text" id="type" />
			</p>
				<p>
				
				Accéssiblité PMR<br />				
				<form:input type="checkbox" path="disabledFacilities" name="oui" id="oui" />
				<label for="oui">Oui</label><br />
				<form:input type="checkbox" path="disabledFacilities" name="non" id="non" />
				<label for="oui">Non</label><br />
					
				</p>
		</fieldset>
		
		<p>
			<input type="submit" value="create" id="createBut">
		</p>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />



