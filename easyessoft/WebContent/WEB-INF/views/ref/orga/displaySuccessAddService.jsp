<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Type Service" name="title" />
</jsp:include>
<div id="serviceAddedDisplay">
	Les Services :
		<ul>
			<c:forEach var="selectionType" items="${services}">
				<li><b>${selectionType.code}-${selectionType.label}</b></li>
			</c:forEach>
		</ul>
		
	à l'organization <b>${name}</b>

</div>
<jsp:include page="../../include/footer.jsp" />