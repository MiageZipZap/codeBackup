<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Infrastructure" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation d'une infrastructure</h1>
	</div>
	<form:form id="infraForm" method="post"
		action="/easyessoft/ihm/ref/infra/create" commandName="infrastructure"
		onsubmit="return false;">
		<fieldset>
			<legend>Informations Infrastructure</legend>
			<p>
				<label>code</label> :
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
			<input type="hidden" path="disabledFacilities" value="true" />
		</fieldset>
		
		<p>
			<input type="submit" value="create" id="createBut">
		</p>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />