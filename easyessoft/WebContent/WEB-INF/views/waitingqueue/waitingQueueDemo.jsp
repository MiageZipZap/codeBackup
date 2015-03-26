<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.esiag.isies.pds.model.waitingqueue.WaitingQueue" %>
<%@ page import="fr.esiag.isies.pds.model.referential.organization.Organization" %>
<%@ page import="fr.esiag.isies.pds.model.referential.person.staff.StaffMember" %>

<c:set var="idService" value="${idService}"/>
<c:set var="idOrganization" value="${idOrganization}"/>
<c:set var="listOrganization" value="${listOrganization}"/>
<c:set var="listPatient" value="${listPatient}"/>
<c:set var="listMedicalProcedure" value="${listMedicalProcedure}"/>
<c:set var="listDoctors" value="${listDoctors}"/>

<% 
	Integer idService = (Integer) pageContext.getAttribute("idService");
	Integer idOrganization = (Integer) pageContext.getAttribute("idOrganization");
	List<Organization> listOrganization = (List<Organization>) pageContext.getAttribute("listOrganization");
	List<WaitingQueue> listPatient = (List<WaitingQueue>) pageContext.getAttribute("listPatient");
	List<StaffMember> listDoctors = (List<StaffMember>) pageContext.getAttribute("listDoctors");
%>

<jsp:include page="../include/header.jsp">
	<jsp:param value="Waiting Queue Patient" name="title" />
</jsp:include>

<script type="text/javascript" src="../../js/waitingQueueDemo.js"></script>

<style>
	html, body {
		margin: 0;
	    height: 100%;
	}
	 
	body {
		      background: 
    /* top, transparent red, faked with gradient */ 
    linear-gradient(
      rgba(0, 0, 0, 0.75), 
      rgba(0, 0, 0, 0.75)
    ),
    /* bottom, image */
    url('../../dist/img/waitingqueue/waitingqueue_background.jpg');
			 background-size: 100%;
		padding: 0;
	}
	
	label {
		width: 100%;
		font-weight: normal;
		color: white;
	}
	
	.hiddenParams {
		visibility: hidden;
	}
		
	#mainFrame .container {
		padding-top: 50px;
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
	
	.btnRight {
		float: right;
		width: 20%;
		margin-left: 1%;
	}
	
	.panel-body {
		color: #000;
	}
	
	#btnRefresh {
		float: right;
	}
		
	#formWelcome {
		width: 80%;
	}
	
	#showScreenPanel a {
		width: 49%;
	}
	
	#btnShowScreenStaff {
		float: left;
	}
	
	#btnShowScreenPatient {
		float: right;
	}

</style>

	<div class="frame" id="mainFrame">	
		<div class="container">		
		    <div class="jumbotron">
		 		<a id="btnRefresh" href="/easyessoft/ihm/waitingQueue/screenDemo">Actualiser</a>
		 		<br /><br />
  				<h1>D&eacute;mo IT3 - File d'attente</h1>
		    	<br />
		    	<p>Cette page est uniquement déstinée à présenter l'UC Organiser une file d'attente.</p>
		 		<br /><br /><br />	
				<div class="form-group">
					<p>
						<label>Type de Service</label>
						<select id="listServiceType" class="form-control" name="idService">
							<option value='0' selected="selected">S&eacute;lectionnez</option>
							<option value="1">Urgence</option>
						</select>
					</p>
					<p>
						<label>&Eacute;tablissement</label>
						<select id="listOrganization" class="form-control" name="idOrganization" disabled="disabled" >
							<option value='0' selected="selected">S&eacute;lectionnez</option>
							<%  for(int iOrganization = 0; iOrganization < 50 ; iOrganization+=1) {  %>
								<option class="serviceType<%=listOrganization.get(iOrganization).getOrgaType().getId()%>" value="<%=listOrganization.get(iOrganization).getId()%>"><%=listOrganization.get(iOrganization).getName()%></option>
						    <%  }  %>
						</select>
					</p>
					<a id="btnLoadService" class="btn btn-primary btn-lg center-block btnRight" href="#">S&eacute;lectionner</a>
					<br /><br /><br /><br /><br /><br />
					<p id="showScreenPanel">
						<label>Ecran d'affichage</label>
						<a id="btnShowScreenStaff" class="btn btn-primary btn-lg center-block" disabled="disabled" href="/easyessoft/ihm/waitingQueue/screenStaff?navigationScreen=waitingRoom&idService=${idService}&idOrganization=${idOrganization}" target="_blank"'>Ecran Personnel</a>
						<a id="btnShowScreenPatient" class="btn btn-primary btn-lg center-block" disabled="disabled" href="/easyessoft/ihm/waitingQueue/screenPatient?idService=${idService}&idOrganization=${idOrganization}" target="_blank"'>Ecran Patient</a>
					</p>
					<br /><br /><br /><br /><br />
					<p>
						<label>Insertion d'un patient</label>
						<table id="tableInsertPatient" class="table table-striped">  				
						    <tbody>
						    	<tr class="rowInsertPatient" style="background-color: rgba(255, 255, 255, 0.2);">
						    		<td style="width: 5%;">
										<button type="button" class="btn btn-default btnLoadPatient" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %>>
  											<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
										</button>
										<input type="hidden" value=""/>
									</td>
						        	<td style="width: 15%;"><input type="text" class="form-control" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %> placeholder="Nom"/></td>
						        	<td style="width: 15%;"><input type="text" class="form-control" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %> placeholder="Pr&eacute;nom"/></td>
						        	<td style="width: 15%;">
						        		<button type="button" class="btn btn-default btnShufflePatient" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %> style="float: right;">
  											<span class="glyphicon glyphicon-random" aria-hidden="true"></span>
										</button>
						        	</td>
						        	<td class="patientMedicalProcedure" style="width: 20%;">
						     			<select class="form-control" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %> name="idMedicalProcedure">
											<option value='0' selected="selected">Acte m&eacute;dical</option>
											<option value="1">Vitale</option>
											<option value="2">Nom1</option>
											<option value="3">Nom2</option>
											<option value="4">Nom3</option>
											<option value="5">Non urgente</option>
										</select>  
									</td> 	
						        	<td class="patientPriority" style="width: 20%;">
						        		<select class="form-control" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %> name="idPriority">
											<option value='0' selected="selected">Priorit&eacute;</option>
											<option value="1">Vitale</option>
											<option value="2">Nom1</option>
											<option value="3">Nom2</option>
											<option value="4">Nom3</option>
											<option value="5">Non urgente</option>
										</select>
									</td>
						        	<td class="patientMinutes" style="width: 10%;"><input type="text" class="form-control" <% if((idOrganization == 0) && (idService == 0)) { %> disabled="disabled" <% } %> placeholder="- Minutes" val=""/></td>
								</tr>
							</tbody>
					</table>
					</p>
					<a id="btnInsertPatient" class="btn btn-primary btn-lg center-block btnRight" disabled="disabled" href="#">Ins&eacute;rer tout</a>
					<a id="btnAddPatient"    class="btn btn-primary btn-lg center-block btnRight" disabled="disabled">Ajouter</a>
					<br /><br /><br /><br />
					<p>
						<label>Random</label>
					</p>	
					<a id="btnTestExit" class="btn btn-primary btn-lg center-block btnRight" style="width: 18%;" disabled="disabled" href="#">Sortie</a>	
					<a id="btnTestTreatment" class="btn btn-primary btn-lg center-block btnRight" style="width: 18%;" disabled="disabled" href="#">Prise en charge</a>
					<a id="btnTestInsert10" class="btn btn-primary btn-lg center-block btnRight" style="width: 18%;" disabled="disabled" href="#">Insert 10</a>
					<a id="btnTestInsert5" class="btn btn-primary btn-lg center-block btnRight" style="width: 18%;" disabled="disabled" href="#">Insert 5</a>
					<a id="btnTestInsert1" class="btn btn-primary btn-lg center-block btnRight" style="width: 18%;" disabled="disabled" href="#" >Insert 1</a>
					<br /><br /><br /><br />
					<p>
						<label>Disponibilit&eacute; des m&eacute;decins</label>
					</p>
					<table id="tableUpdateDoctor" class="table table-striped">  				
						<tbody>
						<%  if((idOrganization == 0) && (idService == 0)) {
								for(int iDoctor = 0; iDoctor < listDoctors.size() ; iDoctor+=1) {  %>
								<tr style="background-color: rgba(255, 255, 255, 0.2);">
							        <td>
										<div class="input-group">
								        	<span class="input-group-addon">
								            	<input aria-label="Radio button for following text input" name="<%=listDoctors.get(iDoctor).getId() %>" type="radio" />
								          	</span>
								          	<span class="input-group-addon" style="width: 100%; text-align: left;"><%=listDoctors.get(iDoctor).getFirstName()%></span>
								          	<span class="input-group-addon" style="width: 15%; text-align: right;">
								            	<span class="label label-danger" style="font-size: 14px;"><%=listDoctors.get(iDoctor).getAvailability()%></span>
								          	</span>
								        </div>
							        </td>
								</tr>
						<%  }}  %>
						</tbody>
					</table>
					<a id="btnSetOff" class="btn btn-primary btn-lg center-block btnRight" disabled="disabled" href="#" >Absent</a>
					<a id="btnSetBreak" class="btn btn-primary btn-lg center-block btnRight" disabled="disabled" href="#">En pause</a>
					<a id="btnSetBreak" class="btn btn-primary btn-lg center-block btnRight" disabled="disabled" href="#">En consultation</a>
					<a id="btnSetAvailable" class="btn btn-primary btn-lg center-block btnRight" disabled="disabled" href="#">Disponible</a>
					<br /><br /><br /><br />
					<p>
						<label>Etat des boxs</label>
						<div class="panel panel-default">
 							<div class="panel-body">Le service est équipé de 8 boxs, dont 5 actuellement occup&eacute;(s).</div>
						</div>
					</p>
				</div>
		    </div>
	 	</div>
  	</div>

  	<form:form id="formLoadScreenDemo" method="post" action="/easyessoft/ihm/waitingQueue/screenDemo">		
		<input type="hidden" id="formLoadScreenDemo_idService" name="idService" value="${idService}"/>
		<input type="hidden" id="formLoadScreenDemo_idOrganization" name="idOrganization" value="${idOrganization}"/>
	</form:form>	
	  	
  	<form:form id="formTestWaitingQueue" method="post" action="/easyessoft/ihm/waitingQueue/testDemo">		
		<input type="hidden" id="formTestWaitingQueue_idService" name="idService" value="${idService}"/>
		<input type="hidden" id="formTestWaitingQueue_idOrganization" name="idOrganization" value="${idOrganization}"/>
		<input type="hidden" id="formTestWaitingQueue_typeInjection" name="typeInjection" value=""/>
		<input type="hidden" id="formTestWaitingQueue_number" name="number" value=""/>
	</form:form>

<jsp:include page="../include/footer.jsp" />