$(document).ready(function() {
//	$("#incidentLocationForm").one("change", ":input", function() {
//	document.getElementById('pac-input').value = inputBox.value;
//	$('#saveButton').show();
//	});
	initialize();
});

function initialize() {
	var componentForm = {
			street_number: 'short_name',
			route: 'long_name',
			locality: 'long_name',
			administrative_area_level_1: 'short_name',
			country: 'long_name',
			postal_code: 'short_name'
	};

	var markers = [];
	var mapOptions = {
			zoom : 11,
			center : new google.maps.LatLng(48.8602, 2.3386),
			mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById('map-canvas'),mapOptions);
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
				geolocate();
			}
		}
	};
	var searchBox = new google.maps.places.SearchBox(/** @type {HTMLInputElement} */
			(input),{ types: ['geocode'] });


	// [START region_getplaces]
	// Listen for the event fired when the user selects an item from the
	// pick list. Retrieve the matching places for that item.
	google.maps.event.addListener(searchBox, 'places_changed', function() {
		var latitude = document.getElementById('latitude');
		var longitude = document.getElementById('longitude');
		
		var places = searchBox.getPlaces();
		if (places.length == 0) {
			alert("L'adresse est impr\u00E9cise, veuillez r\u00E9essayer");
			return;
		}
		if (places.length > 1) {
			alert("L'adresse est impr\u00E9cise, veuillez r\u00E9essayer");
			return;
		}
		
		for (var i = 0, marker; marker = markers[i]; i++) {
			marker.setMap(null);
		}

		// For each place, get the icon, place name, and location.
		markers = [];
		var bounds = new google.maps.LatLngBounds();
		for (var i = 0, place; place = places[i]; i++) {
			
			//filter country
			if(place.address_components[5]['long_name']!='France'){
				alert("La recherche est limit\u00E9e \u00E0 la France");
				return;
			}
			//filter region
			if(place.address_components[4]['short_name']!='IDF'){
				alert("La recherche est limit\u00E9e \u00E0 l'\u00CEle de France");
				return;
			}
			
			var image = {
					url : place.icon,
					size : new google.maps.Size(71, 71),
					origin : new google.maps.Point(0, 0),
					anchor : new google.maps.Point(17, 34),
					scaledSize : new google.maps.Size(25, 25)
			};		
			
			
			for (var component in componentForm) {
				document.getElementById(component).value = '';
				document.getElementById(component).disabled = false;
			}
			for (var i = 0; i < place.address_components.length; i++) {
				var addressType = place.address_components[i].types[0];
				if (componentForm[addressType]) {
					var val = place.address_components[i][componentForm[addressType]];
					document.getElementById(addressType).value = val;
				}
			}

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

	function fillInAddress() {
		// Get the place details from the autocomplete object.
		var place = searchBox.getPlace();

		for (var component in componentForm) {
			document.getElementById(component).value = '';
			document.getElementById(component).disabled = false;
		}

		// Get each component of the address from the place details
		// and fill the corresponding field on the form.
		for (var i = 0; i < place.address_components.length; i++) {
			var addressType = place.address_components[i].types[0];
			if (componentForm[addressType]) {
				var val = place.address_components[i][componentForm[addressType]];
				document.getElementById(addressType).value = val;
			}
		}
	}
	// Bias the autocomplete object to the user's geographical location,
	// as supplied by the browser's 'navigator.geolocation' object.
	function geolocate() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var geolocation = new google.maps.LatLng(
						position.coords.latitude, position.coords.longitude);
				var circle = new google.maps.Circle({
					center: geolocation,
					radius: position.coords.accuracy
				});
				searchBox.setBounds(circle.getBounds());
			});
		}
	}
}
//google.maps.event.addDomListener(window, 'load', initialize);