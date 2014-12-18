<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<label>Code</label> :
				<form:input path="code" type="text" id="code" />
			</p>
			<p>
				<label>Libellé</label> :
				<form:input path="label" type="text" id="label" />
			</p>

			<p>
				<label>Type</label> : <form:select path="typeRefInfra.id">
					<c:forEach items="${lstOfType}" var="item">
						<form:option value="${item.id}">${item.label}</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				Capacité d'accueil : <form:input type="text" id="capacity" path="capacity" />
			</p>
			<p>
				Accessibilité PMR : <form:checkbox path="disabledFacilities" />
			</p>

		</fieldset>

		<p>
			<input type="submit" value="create" id="createButInfra">
		</p>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />