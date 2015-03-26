<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Organisme" />
</jsp:include>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta charset="utf-8" />
<script type="text/javascript" src="/easyessoft/js/location.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places"></script>
<script>
	// This example adds a search box to a map, using the Google Place Autocomplete
	// feature. People can enter geographical searches. The search box will return a
	// pick list containing a mix of places and predicted search terms.
</script>

<style type="text/css">
/* Adjust feedback icon position */
.form-horizontal .has-feedback .form-control-feedback {
	right: 0px; /*30px*/
}

.has-feedback .form-control {
	padding-right: 2.5px;
}

#submit-btn {
	display: none;
}

#target {
	width: 50%;
}
</style>
</head>
<body>
	<div class="container">
		<div id="content">
			<div class="row">
				<div class="col-lg-14">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1 class="boderline">Traiter un appel</h1>
						</div>
						<div class="panel-body">
							<div class="box-content">
								<h1 class="page-header">Ouverture du ticket</h1>
								<div id="map_container" class="col-md-8">
									<div id="map-canvas" class="map_canvas"></div>
								</div>
								<form:form id="orgaForm" role="form" class="form-horizontal"
									method="POST"
									action="/easyessoft/ihm/emerg/callcenter/createLocationTraitement"
									commandName="location">
									<div class="form-group">
										<fieldset>
											<legend> Localisation </legend>

											<input id="pac-input" class="controls" type="text"
												placeholder="Saisir l'adresse">
											<div class="form-group has-error has-feedback">
												<div class="col-sm-6">
													<input id="addressText" type="hidden" name="incidentAddress" path="incidentAddress" />
												</div>
											</div>
											<div class="form-group has-error has-feedback">
												<label class="col-sm-4 control-label">Latitude</label>
												<div class="col-sm-4">
													<input type="text" id="latitude" path="latitude"
														id="streetNumber" class="form-control" name="latitude" />
												</div>
											</div>
											<div class="form-group has-error has-feedback">
												<label class="col-sm-4 control-label">Longitude</label>
												<div class="col-sm-4">
													<input type="text" id="longitude" path="longitude"
														id="streetType" class="form-control" name="longitude" />
												</div>
												<table id="address">
													<tr>
														<td class="label">Street number</td>
														<td class="slimField"><input class="field"
															id="street_number" disabled="true"></input></td>
													</tr>
													<tr>
														<td class="label">Street address</td>
														<td class="wideField" colspan="2"><input
															class="field" id="route" disabled="true"></input></td>
													</tr>
													<tr>
														<td class="label">City</td>
														<td class="wideField" colspan="3"><input
															class="field" id="locality" disabled="true"></input></td>
													</tr>
													<tr>
														<td class="label">State</td>
														<td class="slimField"><input class="field"
															id="administrative_area_level_1" disabled="true"></input></td>
													</tr>
													<tr>
														<td class="label">Zip code</td>
														<td class="wideField"><input class="field"
															id="postal_code" disabled="true"></input></td>
													</tr>
													<tr>
														<td class="label">Country</td>
														<td class="wideField" colspan="3"><input
															class="field" id="country" disabled="true"></input></td>
													</tr>
												</table>
											</div>
										</fieldset>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-2">
												<button type="cancel" class="btn btn-default btn-label-left">
													<span><i class="fa fa-clock-o txt-danger"></i></span>
													Cancel
												</button>
												<button id="submit" type="submit" hidden="true"
													class="btn btn-primary btn-label-left">
													<span><i class="fa fa-clock-o"></i></span> Next
												</button>
											</div>
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
</body>