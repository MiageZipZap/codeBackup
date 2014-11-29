$(function() {
	$("#resultGeoloc").hide();
	$("#getGeo").click(function() {
		$.ajax({
			type : 'GET',
			dataType : "json",
			url : "http://localhost:8080/MockGeolocWS/rest/geoloc/getGeoloc",
			success : function(geoloc) {
				$("#resultGeoloc").show();
				$("#longitudeValue").text(geoloc.longitude);
				$("#latitudeValue").text(geoloc.latitude);
			},
			error : function(xhr, ajaxOptions, thrownError) {
				console.log(xhr.status);
				console.log(thrownError);
				console.log(xhr.responseText);
				console.log(xhr);
			}
		});
	});
});