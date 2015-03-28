<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation tri" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation de données de tri d'un patient</h1>
	</div>
	<form:form id="sortForm" method="post"
		action="/easyessoft/ihm/sorting/createSort" commandName="sort">
		<fieldset>
			<legend>Informations tri</legend>
			<p>
				<label>Nom</label> :
				<form:input path="surname" type="text" id="surname" />
			</p>
			<p>
				<label>Prenom</label> :
				<form:input path="firstname" type="text" id="firstname" />
			</p>
			
 			<p>
				<label>Date de reception</label> :
				<form:input path="receptiondate" type="text" id="receptiondate" />
			</p>
			<p>
				<label>Category de tri </label> :
				<form:input path="sortingcategory" type="text" id="sortingcategory" />
			</p>
			<p>
				<label>Service de tri</label> :
				<form:input path="sortingservice" type="text" id="sortingservice" />
			</p>
		</fieldset>
		
		
		<p>
			<input type="submit" value="create" id="createBut"/>
		</p>
	</form:form>
</div>
<jsp:include page="../include/footer.jsp" />