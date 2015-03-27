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
		var mapOfPerson2Interact = {};
		var mapOfPersonInteract = {};
		var json = "";
		<c:forEach items="${interactionNetwork.interactions}" var="item" varStatus="cpt">
			var adjacenciesPrefix = "${item.person2Interact['class'].simpleName}";
			// second person who is in interaction
			if (!mapOfPerson2Interact[adjacenciesPrefix + "_" + "${item.person2Interact.id}"]) {
				// create item if not exist in map
				var lbl = "${item.person2Interact.firstName}";
				lbl.replace("'", "\'");
				mapOfPerson2Interact[adjacenciesPrefix + "_" + "${item.person2Interact.id}"]
					= {"label" : lbl, "count" : 1};
			} else {
				// add one at count variable (item appears again)
				mapOfPerson2Interact[adjacenciesPrefix + "_" + "${item.person2Interact.id}"].count += 1;
			}
			
			// person interact
			var personPrefix = "${item.personInteract['class'].simpleName}";
			if (!mapOfPersonInteract[personPrefix + "_" + "${item.personInteract.id}"]) {
				// create person if not exist in map
				var lbl = "${item.personInteract.firstName}";
				lbl.replace("'", "\'");
				mapOfPersonInteract[personPrefix + "_" + "${item.personInteract.id}"]
					= {"label" : lbl, "count" : 1, "adjacencies" : {}};
				mapOfPersonInteract[personPrefix + "_" + "${item.personInteract.id}"].adjacencies[adjacenciesPrefix + "_" + "${item.person2Interact.id}"]
					= {"id" : adjacenciesPrefix + "_" + "${item.person2Interact.id}", "infrastructure" : "${item.infrastructure.label}"};
			} else {
				// add adjacencies
				mapOfPersonInteract[personPrefix + "_" + "${item.personInteract.id}"].adjacencies[adjacenciesPrefix + "_" + "${item.person2Interact.id}"]
					= {"id" : adjacenciesPrefix + "_" + "${item.person2Interact.id}", "infrastructure" : "${item.infrastructure.label}"};
				mapOfPersonInteract[personPrefix + "_" + "${item.personInteract.id}"].count += 1;
			}
			
			
		</c:forEach>
		var cpt = 0;
		for (var item in mapOfPersonInteract) {
			if (cpt != 0) {
				json = json + ',';
			}
			cpt += 1;
			var name = mapOfPersonInteract[item].label;
			name.replace("'", "\'");
			var dim = mapOfPersonInteract[item].count;
			dim += 3;
			var type = "square";
			var color = "#83548B";
			// Change type and color according to person (if the person is Patient or Staff)
			if (item.startsWith("Patient")) {
				type = "circle";
				color = "#83548B";
			} else if (item.startsWith("StaffMember")) {
				type = "square";
				color = "#940001";
			}
			json = json + '{' + '"id" : "' + item + '",'
					+ '"name" : "' + name + '",' + '"data" : {'
					+ '"$color": "'+color+'",' + '"$type": "'+type+'", "$dim":"' + dim
					+ '"},' + '"adjacencies" : [';
			var cpt2 = 0;
			for (var item2 in mapOfPersonInteract[item].adjacencies) {
				if (cpt2 != 0) {
					json = json + ',';
				}
				cpt2 += 1;
				json = json + '{' + '"nodeFrom" : "' + item + '",' + '"nodeTo" : "' + item2 + '",' + '"data" : {"infrastructure":"'+mapOfPersonInteract[item].adjacencies[item2].infrastructure+'"}' + '}';
			}
			json = json + ']' + '}';
		}
		for (var item in mapOfPerson2Interact) {
			var type = "square";
			var color = "#83548B";
			// Change type and color according to person (if the person is Patient or Staff)
			if (item.startsWith("Patient")) {
				type = "circle";
				color = "#83548B";
			} else if (item.startsWith("StaffMember")) {
				type = "square";
				color = "#940001";
			}
			var name = mapOfPerson2Interact[item].label;
			var dim = mapOfPerson2Interact[item].count;
			dim += 3;
			json = json + ',' + '{"id" : "' + item + '",'
					+ '"name" : "' + name + '",' + '"data" : {'
					+ '"$color": "' + color + '",' + '"$type": "' + type + '", "$dim":"' + dim
					+ '"}' + '}';
		}
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
									<li>Carré rouge : Personnel</li>
									<li>Rond Violet : Patient</li>
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