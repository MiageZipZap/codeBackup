<jsp:include page="../include/header.jsp">
	<jsp:param value="Geolocalisation" name="title"/>
</jsp:include>
	<div>
		<h1>Obtenir une géolocalisation</h1>
	</div>
	
	<div>
		<input type="submit" value="Obtenir" id="getGeo">
	</div>
	
	<div id = "resultGeoloc">
		longitude : <span id="longitudeValue"></span><br/>
		latitude : <span id="latitudeValue"></span>
	</div>

<jsp:include page="../include/footer.jsp"/>