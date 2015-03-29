<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation intervention" name="title" />
</jsp:include>
<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/easyessoft/js/dataTableConfiguration.js"></script>
<style>
<!--
.selected {
	color: #fff;
	background-color: #5a8db6;
	border-color: rgba(0, 0, 0, 0.3);
}
-->
</style>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Choisir un véhicule d'intervention</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<p>Le ticket Numéro ${interventionTicket.id} a bien été créé</p>
							<div class="well app-menu">
								<div class="panel-body">
									<div class="box-content">
										<div class="form-group">
											<label class="col-sm-3 control-label selectContainer">Données
												des véhicules</label>
											<div class="box-content no-padding">
												<form:form id="vehiculeChoice" class="form-horizontal"
													method="post"
													action="/easyessoft/ihm/emerg/callcenter/VehiculeChoiceTraitement"
													commandName="InterventionVehicule">
													<fieldset>
														<legend>List de véhicules optimaux</legend>
														<div class="form-group">
															<label class="col-sm-3 control-label selectContainer">Contacter
																un véhicule</label>
															<div class="col-sm-5">
																<form:select path="id" class="form-control" name="id"
																	id="id">
																	<form:option value='-1' label='<Selectionnez>' />
																	<c:forEach items="${vehicules}" var="selectionVehicule"
																		varStatus="loopOp">
																		<form:option value="${selectionVehicule.id}">${selectionVehicule.category.label} (5 min)</form:option>
																	</c:forEach>
																</form:select>
															</div>
														</div>
													</fieldset>
													<div class="form-group">
														<div class="col-sm-2">
															<button type="submit"
																class="btn btn-primary btn-label-left">
																<span><i class="fa fa-clock-o"></i></span> Envoyer
															</button>
														</div>
													</div>
												</form:form>
												<table
													class="table table-bordered table-striped table-hover table-heading table-datatable"
													id="table_id">
													<thead>
														<tr>
															<th>id</th>
															<th>Véhicule</th>
															<th>Coords</th>
															<th>Allongement</th>
															<th>nb Places</th>
															<th>Délai de liaison</th>
															<th>Attribuer</th>
														</tr>
													</thead>
													<tbody>
														<!-- Start: list_row -->
														<c:forEach var="selectionType" items="${vehicules}"
															varStatus="loop">
															<tr>
																<td>${selectionType.id}</td>
																<td><img class="img-rounded"
																	src="/easyessoft/dist/img/ambulance50x50.png" alt="">${selectionType.category.code}
																	${selectionType.category.label}</td>
																<td>lat:${selectionType.latitude} |
																	lng:${selectionType.longitude}</td>
																<td><c:if test="${selectionType.stretcher}">
																		oui
																	</c:if></td>
																<td>${selectionType.nbPlaces}</td>
																<td>5 min</td>
																<td><button type="button" class="btn btn-info"
																		id="vehicule${loop.index}">Attribuer</button>
																	</div></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../../include/footer.jsp" />