<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="fr.esiag.isies.pds.model.waitingqueue.WaitingQueue" %>

<c:set var="navigationScreen" value="${navigationScreen}"/>
<c:set var="listPatient" value="${listPatient}"/>

<% 
	String[] priorityColor = new String[]{"danger","danger","warning","success", "info"};
	String[] priorityLabel = new String[]{"Vitale","&nbsp;&nbsp;Critique &nbsp;&nbsp;","&nbsp;&nbsp;&nbsp;Urgent&nbsp;&nbsp;&nbsp;&nbsp;","&nbsp;Standard&nbsp;&nbsp;", "Non urgent"};
	String[] progressBarColor = new String[]{"info","info","success","success", "success", "success","warning","warning","warning","danger"};
	SimpleDateFormat dateFormat_hour = new SimpleDateFormat("HH:mm");
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
		<div class="alert alert-warning" role="alert"><strong>Consultation :</strong> Le Dr. House est appelé au Box 3</div>
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
					<%  for(int iPatient = 0; iPatient < listPatient.size() ; iPatient+=1) {  %>
						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						    <td><%=iPatient+1 %></td>
							<td style="text-align: center;"><span class="label label-<%=priorityColor[listPatient.get(iPatient).getPriority()-1] %>" style="font-size: 14px;"><%=priorityLabel[listPatient.get(iPatient).getPriority()-1] %></span></td>
						    <td><%=listPatient.get(iPatient).getPatient().getFirstName() %> (n° <%=listPatient.get(iPatient).getIdPatient()%>)</td>
						    <td><%=listPatient.get(iPatient).getPatient().getLastName() %></td>
						    <td><%=dateFormat_hour.format(listPatient.get(iPatient).getTimeQueueState()) %></td>
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
					<%  for(int iPatient = 0; iPatient < listPatient.size() ; iPatient+=1) {  %>
						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						    	<td>Dr. House</td>
						        <td><%=listPatient.get(iPatient).getPatient().getFirstName() + " " + listPatient.get(iPatient).getPatient().getLastName() %> (n° <%=listPatient.get(iPatient).getIdPatient()%>)</td>
						        <td><%=listPatient.get(iPatient).getIdBox() %></td>
						        <td>Consultation</td>
						        <td>
						        	<% 
						        		float percentageMedicalProcedure =  (float) ((TimeUnit.MILLISECONDS.toMinutes((long ) (new Date().getTime() - listPatient.get(iPatient).getTimeQueueState().getTime()))) / (float) 15) * 100;
						        		if(percentageMedicalProcedure >= 100) { percentageMedicalProcedure = 100; }
						        		if(percentageMedicalProcedure <= 10) { percentageMedicalProcedure = 10; } 
						        	%>
						     
						        	<p style="float: left; width: 12%;"><%=dateFormat_hour.format(listPatient.get(iPatient).getTimeQueueState()) %></p>
									<div style="float: left; width: 76%"><div class="progress"><div class="progress-bar progress-bar-<%=progressBarColor[(int) (percentageMedicalProcedure)/10 -1 ] %> progress-bar-striped active" role="progressbar" style="width: <%=percentageMedicalProcedure %>%">
										<p><%=dateFormat_hour.format( new Date().getTime() - listPatient.get(iPatient).getTimeQueueState().getTime() - (60 * 60 * 1000)) %> mn</p>
									</div></div></div>
									<p style="float: right; width: 12%; text-align: right;"><%=dateFormat_hour.format(new Date(listPatient.get(iPatient).getTimeQueueState().getTime() + (15 * 60 * 1000))) %></p>
								</td>
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
					<%  for(int iPatient = 0; iPatient < listPatient.size() ; iPatient+=1) {  %>
						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						    <td><%=listPatient.get(iPatient).getPatient().getFirstName() + " " + listPatient.get(iPatient).getPatient().getLastName() %>  (n° <%=listPatient.get(iPatient).getIdPatient()%>)</td>
						    <td>Dr. House</td>
						    <td></td>
						    <td>Consultation</td>
						    <td>&nbsp;</td>
						    <td>&nbsp;</td>
						    <td><%=dateFormat_hour.format(listPatient.get(iPatient).getTimeQueueState()) %></td>
						    <td style="text-align: center;"><span class="label label-warning" style="font-size: 14px;">? mn</span></td>
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