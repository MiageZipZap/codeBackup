<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation d'un nouveau équipement</h1>
	</div>
	<form:form id="equipForm" method="post"
		action="/easyessoft/ihm/ref/equip/create" commandName="equipment"
		onsubmit="return false;">
		<fieldset>
			<legend>Informations équipement</legend>
			<p>
				<label>Numéro de série</label> :
				<form:input path="serialNumber" type="text" id="serialNumber" />
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
					
		</fieldset>
		
		<p>
			<input type="submit" value="create" id="createButEquip">
		</p>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />



