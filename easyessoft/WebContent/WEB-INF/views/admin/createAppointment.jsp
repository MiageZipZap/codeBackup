<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation Appointment" name="title" />
</jsp:include>
<div id="content">	
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Prendre un rendez-vous</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">

							<form:form id="appointmentForm" class="form-horizontal" method="post"
								action="/easyessoft/ihm/admin/appointment/create"
								commandName="appointment" onsubmit="return false;">
								<fieldset>
									<legend>Renseignements</legend>
									<p class="form-group">
										<label class="col-sm-3 control-label">Nom de famille :</label>
										<form:input path="patientLastName" type="text" id="patientLastName" />
									</p>
									<p class="form-group">
										<label class="col-sm-3 control-label">Prénom:</label>
										<form:input path="patientFirstName" type="text" id="patientFirstName" />
									</p >
									<p class="form-group">
										<label class="col-sm-3 control-label">Sexe :</label>
									
										<label class="radio-inline">
										<form:radiobutton name="patientGender" id="patientGenderM" path="patientGender" value="M" />Homme 
										</label>
										<label class="radio-inline">
										<form:radiobutton name="patientGender" id="patientGenderF" path="patientGender" value="F" />Femme
										</label>
									</p>
									
									<p>
					<label class="col-sm-3 control-label">Date de naissance :</label>
					<form:input type="date" id="patientBithDate" class="form-control" path="patientBirthDate" placeholder="01/01/1970" />
				</p>
									<legend>Rendez-vous</legend>
									
									<label class="col-sm-3 control-label">Motif: </label>
							<form:select disabled="true" id="lstReason" class="form-control" path="appointmentReason" >
							<form:option value='0' label='<Selectionnez>' />
									<c:forEach items="${lstReason}" var="lstReason">
									<form:option  value="${lstReason}">${lstReason}</form:option>
								</c:forEach>
							</form:select>
									
									
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
		
									
							<p class="form-group">
							
							<label class="col-sm-3 control-label">Médecin: </label>
							<form:select disabled="true" id="lstDoctor" class="form-control" path="doctorName" >
							<form:option value='0' label='<Selectionnez>' />
									<c:forEach items="${lstDoctor}" var="lstDoctor">
									<form:option  value="${lstDoctor}">${lstDoctor}</form:option>
								</c:forEach>
							</form:select>
							</p>
							
							<p class="form-group">
							<label class="col-sm-3 control-label">Date du rendez-vous: </label>
							<form:select disabled="true" id="lstDate" class="form-control" path="appointmentDate" >
							<form:option value='0' label='<Selectionnez>' />
									<c:forEach items="${lstDate}" var="lstDate">
									<form:option  value="${lstDate}">${lstDate}</form:option>
								</c:forEach>
							</form:select>
							</p>
							
							<p class="form-group">
							<label class="col-sm-3 control-label">Heure du rendez-vous: </label>
							<form:select disabled="true" id="lstHour" class="form-control" path="appointmentHour" >
							<form:option value='0' label='<Selectionnez>' />
									<c:forEach items="${lstHour}" var="lstHour">
									<form:option  value="${lstHour}">${lstHour}</form:option>
								</c:forEach>
							</form:select>
							</p>
									
									

								<p class="form-group">
								<div class="col-sm-9 col-sm-offset-3">
									<input type="submit" value="Valider"
										class="btn btn-primary" id="createButAppoint">
								</div>
								</p>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />