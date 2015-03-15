<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../include/header.jsp">
	<jsp:param name="title" value="Interaction Network" />
</jsp:include>
<link type="text/css" href="/easyessoft/css/base.css" rel="stylesheet" />
<script type="text/javascript"
	src="/easyessoft/js/interactionNetwork.js"></script>
<script type="text/javascript" src="/easyessoft/js/graph.js"></script>
<script type="text/javascript" src="/easyessoft/js/jit.js"></script>
<script type="text/javascript">
	$(function() {
		var json = "";
		<c:forEach items="${interactionNetwork.interactions}" var="item" varStatus="cpt">
		if ("${cpt.index}" != "0") {
			json = json + ',';
		}
		var name = "${item.key.name}";
		name.replace("'", "\'");
		var prefixPerson = "Person_";
		var dim = ${fn:length(item.value)};
		dim += 3;
		
		json = json + '{' + '"id" : "' + prefixPerson + '${item.key.id}",'
				+ '"name" : "' + name + '",' + '"data" : {'
				+ '"$color": "#70A35E",' + '"$type": "star", "$dim":"' + dim
				+ '"},' + '"adjacencies" : [';
		<c:forEach items="${item.value}" var="item2" varStatus="cpt2">
		if ("${cpt2.index}" != "0") {
			json = json + ',';
		}
		var adjacenciesPrefix = "${item2.itemWithInteract['class'].simpleName}"
		json = json + '{' + '"nodeFrom" : "' + prefixPerson
				+ '${item.key.id}",' + '"nodeTo" : "' + adjacenciesPrefix
				+ '_${item2.itemWithInteract.id}",' + '"data" : {}' + '}';
		</c:forEach>
		json = json + ']' + '}';
		</c:forEach>
		var prefix = "Medicine_";
		<c:forEach items="${interactionNetwork.medicines}" var="item" varStatus="cpt">
			var name = "${item.key.label}";
			var dim = ${item.value};
			dim += 3;
			name.replace("'", "\'");
			json = json + ',' + '{"id" : "' + prefix + '${item.key.id}",'
					+ '"name" : "' + name + '",' + '"data" : {'
					+ '"$color": "#940001",' + '"$type": "square", "$dim":"' + dim
					+ '"}' + '}';
		</c:forEach>
		var prefix = "Infrastructure_";
		<c:forEach items="${interactionNetwork.infrastructures}" var="item" varStatus="cpt">
			var name = "${item.key.label}";
			var dim = ${item.value};
			dim += 3;
			name.replace("'", "\'");
			json = json + ',' + '{"id" : "' + prefix + '${item.key.id}",'
					+ '"name" : "' + name + '",' + '"data" : {'
					+ '"$color": "#83548B",' + '"$type": "circle", "$dim":"' + dim
					+ '"}' + '}';
		</c:forEach>
		var prefix = "Disease_";
		<c:forEach items="${interactionNetwork.diseases}" var="item" varStatus="cpt">
			var name = "${item.key.name}";
			var dim = ${item.value};
			dim += 3;
			name.replace("'", "\'");
			json = json + ',' + '{"id" : "' + prefix + '${item.key.id}",'
					+ '"name" : "' + name + '",' + '"data" : {'
					+ '"$color": "#83548B",' + '"$type": "square", "$dim":"' + dim
					+ '"}' + '}';
		</c:forEach>
		json = '[' + json + ']';
		init(JSON.parse(json));
	});
</script>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Réseau d'interaction</h1>
					</div>
					<div class="panel-body">
						<div class="box-content" id="containerInteractionNetwork">
							<div id="left-container">
								<div id="id-list"></div>
								<div style="text-align: center;">Affichage</div>
								<input type="checkbox" checked="checked" id="displayLabel" /><label>Afficher
									les libellé des points</label>
								<div style="text-align: center;">Liste des filtres</div>
								<br /> <br />
								<div>
									<button id="fullScreenBtn">Plein écran</button>
								</div>
							</div>

							<div id="center-container">
								<div id="infovis"></div>
							</div>

							<div id="right-container">
								<div style="text-align: center;">Légende</div>
								<ul>
									<li>Carré rouge : Médicament</li>
									<li>Carré Violet : Maladie</li>
									<li>Etoile : Personne</li>
									<li>Rond : Infrastructure</li>
								</ul>
								<br /> <br />
								<div id="inner-details"></div>
							</div>

							<div id="log"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />