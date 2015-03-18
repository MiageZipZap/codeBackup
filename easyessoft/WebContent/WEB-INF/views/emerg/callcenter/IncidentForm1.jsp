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

	function initialize() {

		var markers = [];
		var mapOptions = {
			zoom : 11,
			center : new google.maps.LatLng(48.8602, 2.3386),
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		/* var defaultBounds = new google.maps.LatLngBounds(
		        new google.maps.LatLng(48.5000, 2.5150),
		        new google.maps.LatLng(48.5000, 2.5140));
		map.fitBounds(defaultBounds); */

		// Create the search box and link it to the UI element.
		var input = /** @type {HTMLInputElement} */
		(document.getElementById('pac-input'));
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

		// text input
		var region = 'Ile de France';
		input.onkeypress = function(e) {
			if (!e)
				e = window.event;
			var keyCode = e.keyCode || e.which;
			if(input.value.slice(-13)!=region){
				if (keyCode == '13') {
					input.value = document.getElementById('pac-input').value + ' '
					+ region;	
				}
			}
		};
		var searchBox = new google.maps.places.SearchBox(/** @type {HTMLInputElement} */
		(input));

		// [START region_getplaces]
		// Listen for the event fired when the user selects an item from the
		// pick list. Retrieve the matching places for that item.
		google.maps.event.addListener(searchBox, 'places_changed', function() {
			var latitude = document.getElementById('latitude');
			var longitude = document.getElementById('longitude');
			
			var places = searchBox.getPlaces();
			if (places.length == 0) {
				return;
			}
			for (var i = 0, marker; marker = markers[i]; i++) {
				marker.setMap(null);
			}

			// For each place, get the icon, place name, and location.
			markers = [];
			var bounds = new google.maps.LatLngBounds();
			for (var i = 0, place; place = places[i]; i++) {
				var image = {
					url : place.icon,
					size : new google.maps.Size(71, 71),
					origin : new google.maps.Point(0, 0),
					anchor : new google.maps.Point(17, 34),
					scaledSize : new google.maps.Size(25, 25)
				};
				
				// Create a marker for each place.
				var marker = new google.maps.Marker({
					map : map,
					icon : image,
					title : place.name,
					position : place.geometry.location
				});

				markers.push(marker);

				bounds.extend(place.geometry.location);
				latitude.value = place.geometry.location.lat();
				longitude.value = place.geometry.location.lng();
				latitude.value=latitude.value.substring(1,8);
				longitude.value=latitude.value.substring(1,8);
			}

			map.fitBounds(bounds);
			map.setZoom(16);
		});
		// [END region_getplaces]

		// Bias the SearchBox results towards places that are within the bounds of the
		// current map's viewport.
		google.maps.event.addListener(map, 'bounds_changed', function() {
			var bounds = map.getBounds();
			searchBox.setBounds(bounds);
		});
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<style type="text/css">
/* Adjust feedback icon position */
.form-horizontal .has-feedback .form-control-feedback {
	right: 0px ;/*30px*/
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
											<legend>
												Localisation
												<button id="search-button" class="btn btn-mini btn-info"
													type="button">Mini button</button>
											</legend>
											<input id="pac-input" class="controls" type="text"
												placeholder="Saisir l'adresse" name="incidentAddress">
											<!-- on change or input constuct a string and set maps input -->
											<div class="form-group has-error has-feedback">
												<label class="col-sm-4 control-label">Latitude</label>
												<div class="col-sm-4">
													<input type="text" id="latitude" path="streetNumber" id="streetNumber"
														class="form-control" name="latitude" />
												</div>
											</div>
											<div class="form-group has-error has-feedback">
												<label class="col-sm-4 control-label">Longitude</label>
												<div class="col-sm-4">
													<input type="text" id="longitude" path="streetType" id="streetType"
														class="form-control" name="longitude" />
												</div>
											</div>
										</fieldset>
									</div>
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
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>