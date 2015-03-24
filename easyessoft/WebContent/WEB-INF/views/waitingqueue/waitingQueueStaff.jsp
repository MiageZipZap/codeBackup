<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.esiag.isies.pds.model.waitingqueue.WaitingQueue" %>

<c:set var="navigationScreen" value="${navigationScreen}"/>
<c:set var="listPatient" value="${listPatient}"/>

<% 
	String navigationScreen = (String) pageContext.getAttribute("navigationScreen");
	List<WaitingQueue> listPatient = (List<WaitingQueue>) pageContext.getAttribute("listPatient");
%>

<jsp:include page="../include/header.jsp">
	<jsp:param value="Waiting Queue Staff" name="title"/>
</jsp:include>

<script type="text/javascript" src="../../js/waitingQueueStaff.js"></script>

<style>

	body {
		padding-top: 0px;
	}
	
	label {
		font-weight: normal;
		color: white;
	}
	
	.hiddenParams {
		visibility: hidden;
	}
		
	.frame {
		width: 100%;
		height: 100%;
	}
	
	.carousel-indicators li {
	    border: 1px solid #000;
	}
		
	.carousel-indicators .active {
		background-color: #000000;
	}
	
	.jumbotron {
		background-color: transparent;
		color: white;
	}
	
	h1 {
		padding-top: 20px;
		padding-bottom: 10px;
	}
	
	#navigationSelector li {
		background-color: #DEDEDE;
	}
	
	#active {
	
	}
	
	#tablePatients {
		padding-top: 50px;
	}
	
	#formWelcome {
		width: 80%;
	}
	
	#showButton {
		width: 60%;
	}
</style>

<div class="container" id="content">
	<div class="hiddenParams" id="navigationScreen">${navigationScreen}</div>
	<div class="hiddenParams" id="tableRows">${tableRows}</div>
	<div class="frame" id="mainFrame">	
		<h1>Activit&eacute; du service</h1>
		<br />
		<div class="alert alert-warning" role="alert"><strong>Consultation :</strong> Le Dr. Zlatan est appelé au Box 3</div>
		<br/>
	    <ul id="navigationScreen" class="nav nav-pills nav-justified">
	      <li role="presentation" <% if(navigationScreen.compareTo("waitingRoom") == 0) { %>class="active"<% } %>><a href="/easyessoft/ihm/waitingQueue/screenStaff?navigationScreen=waitingRoom&idService=${idService}&idOrganization=${idOrganization}">Salle d'attente</a></li>
	      <li role="presentation" <% if(navigationScreen.compareTo("boxs") == 0) { %>class="active"<% } %>><a href="/easyessoft/ihm/waitingQueue/screenStaff?navigationScreen=boxs&idService=${idService}&idOrganization=${idOrganization}">Boxs</a></li>
	      <li role="presentation" <% if(navigationScreen.compareTo("exits") == 0) { %>class="active"<% } %>><a href="/easyessoft/ihm/waitingQueue/screenStaff?navigationScreen=exits&idService=${idService}&idOrganization=${idOrganization}">Sorties</a></li>
	    </ul>
		<br /><br />
		<% if(navigationScreen.compareTo("waitingRoom") == 0) { %>
			<table class="table table-striped">  				
				<thead>
					<tr style="background-color: #222; color: #FFFFFF">
						<th style="width: 5%">#</th>
						<th style="width: 10%">Priorit&eacute;</th>
						<th style="width: 17%">Nom</th>
						<th style="width: 17%">Pr&eacute;nom</th>
						<th style="width: 15%">Heure d'arriv&eacute;e</th>
						<th style="width: 25%">Acte m&eacute;dical</th>
						<th style="width: 11%">Durée estimée</th>
					</tr>
				</thead>
				<tbody>
					<%  for(int iPatient = -1; iPatient < listPatient.size() ; iPatient+=1) {  %>
						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						    <td>1</td>
						    <td>Vitale</td>
						    <td>Modric</td>
						    <td>Lucas</td>
						    <td>14:00</td>
						    <td>Consultation</td>
						    <td>15 mn</td>
						</tr>
					<%  }  %>
				</tbody>
			</table>
		<% }
		   else if(navigationScreen.compareTo("boxs") == 0) { %>
			<table class="table table-striped">  				
				<thead>
					<tr style="background-color: #222; color: #FFFFFF">
						<th style="width: 15%">Docteur</th>
						<th style="width: 20%">Patient</th>
						<th style="width: 5%">Box</th>
						<th style="width: 20%">Acte m&eacute;dical</th>
						<th style="width: 40%">Dur&eacute;e de la prise en charge</th>
					</tr>
				</thead>
				<tbody>
					<%  for(int iPatient = -1; iPatient < listPatient.size() ; iPatient+=1) {  %>
						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						    	<td>Dr. Mario</td>
						        <td>Jack Wilshere</td>
						        <td>5</td>
						        <td>Consultation</td>
						        <td>
						        	<p style="float: left; width: 12%;">14:00</p>
						        	<div style="float: left; width: 76%">
						        	<div class="progress">
  										<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
											<p>20 mn</p>
  										</div>
									</div>
									</div>
									<p style="float: right; width: 12%; text-align: right;">14:30</p>
						</tr>
					<%  }  %>
				</tbody>
			</table>
		<% }
		   else if(navigationScreen.compareTo("exits") == 0) { %>
			<table class="table table-striped">  				
				<thead>
					<tr style="background-color: #222; color: #FFFFFF">
						<th style="width: 20%">Patient</th>
						<th style="width: 15%">Docteur</th>
						<th style="width: 5%">Box</th>
						<th style="width: 20%">Acte m&eacute;dical</th>
						<th style="width: 10%">Arriv&eacute;e</th>
						<th style="width: 10%">Traitement</th>
						<th style="width: 10%">Sortie</th>
						<th style="width: 10%">Retard</th>
					</tr>
				</thead>
				<tbody>
					<%  for(int iPatient = -1; iPatient < listPatient.size() ; iPatient+=1) {  %>
						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						    <td>John Terry</td>
						    <td>Dr Mario</td>
						    <td>4</td>
						    <td>Consultation</td>
						    <td>13:00</td>
						    <td>13:30</td>
						    <td>14:05</td>
						    <td style="text-align: center;"><span class="label label-danger" style="font-size: 14px;">15 mn</span></td>
						</tr>
					<%  }  %>
				</tbody>
			</table>
		<% }
		   else { %>
		   
		   
		<% } %>
  		</div>
  	</div>
  	
<jsp:include page="../include/footer.jsp"/>