<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Organisme" />
</jsp:include>
<div id="content">
	<div>
		<h1>Creation d'un organisme</h1>
	</div>
	<div class="box-content">
		<form:form id="orgaForm" class="form-horizontal" method="post"
			action="/easyessoft/ihm/ref/orga/create" commandName="Organization"
			onsubmit="return false;">
			<fieldset>
				<legend>Type d'organisme</legend>
				<div class="form-group">
					<label class="col-sm-3 control-label">Choisir le type
						d'organisme</label>
					<div class="col-sm-5">
						<select class="form-control" name="OrgaType" id="OrgaType">

							<c:forEach items="${list}" var="selectionType">
								<option value="${selectionType.id}"><c:out
										value="${selectionType.description}" /></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-3">
						<div class="checkbox">
							<label> <input type="checkbox" name="acceptTerms" />
								Merci de cocher cette case <i class="fa fa-square-o small"></i>
							</label>
						</div>
					</div>
				</div>
			</fieldset>
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" class="btn btn-primary">Créer</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />