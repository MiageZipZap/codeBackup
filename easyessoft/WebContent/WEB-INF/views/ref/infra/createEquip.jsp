<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Equipement" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Création d'un équipement</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<form:form id="equipForm" class="form-horizontal" method="post"
								action="/easyessoft/ihm/ref/equip/create"
								commandName="equipment" onsubmit="return false;">
								<fieldset>
									<legend>Informations équipement</legend>
									<p class="form-group">
										<label class="col-sm-3 control-label">Numéro de série :</label>
										<form:input path="serialNumber" type="text" id="serialNumber" />
									</p>
									<p class="form-group">
										<label class="col-sm-3 control-label">Libellé :</label>
										<form:input path="label" value="${label}" type="text"
											id="label" />
									</p>
									<div class="form-group">
										<label class="col-sm-3 control-label">Type :</label>
										<div class="col-sm-5">
											<form:select class="form-control" path="typeRefInfra.id">
												<c:forEach items="${lstOfType}" var="item">
													<form:option value="${item.id}">${item.label}</form:option>
												</c:forEach>
											</form:select>
											<form:hidden path="typeRefInfra.category.code"
												value="${lstOfType[0].category.code}" />
										</div>
									</div>
									<div class="form-group">
										<c:choose>
											<c:when test="${empty idHospital}">
												<label class="col-sm-3 control-label">Hôpital :</label>
												<div class="col-sm-5">
													<form:select class="form-control" path="hospital.id">
														<c:forEach items="${lstHospital}" var="item">
															<form:option value="${item.id}">${item.name}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</c:when>
											<c:otherwise>
												<form:hidden path="hospital.id" value="${idHospital}" />
											</c:otherwise>
										</c:choose>
									</div>
								</fieldset>

								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3">
										<input type="submit" value="création de l'équipement"
											class="btn btn-primary" id="createButEquip">
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />



