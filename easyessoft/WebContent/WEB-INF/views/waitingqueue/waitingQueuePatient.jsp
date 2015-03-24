<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.esiag.isies.pds.model.waitingqueue.WaitingQueue" %>

<c:set var="tableRows" value="${tableRows}"/>
<c:set var="listPatient" value="${listPatient}"/>

<% 
	List<WaitingQueue> listPatient = (List<WaitingQueue>) pageContext.getAttribute("listPatient");
	Integer tableRows = (Integer) pageContext.getAttribute("tableRows");
%>

<jsp:include page="../include/header.jsp">
	<jsp:param value="Waiting Queue Patient" name="title" />
</jsp:include>

<script type="text/javascript" src="../../js/waitingQueuePatient.js"></script>

<style>
	html, body {
		margin: 0;
	    height: 100%;
	    background-color: #000000;
	}
	 
	body {
		background-image:url('../../dist/img/waitingqueue/waitingqueue_background.jpg');
		background-size: 100% 100%;
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
	
	#mainFrame {
		position: absolute;
		top: 0px;
	}
	
	#tablePatients {
		padding-top: 50px;
	}
	
	#timeSpan {
		background-color: rgba(255, 255, 255, 0.5);
	}
	
	#formWelcome {
		width: 80%;
	}
	
	#showButton {
		width: 60%;
	}
</style>

	<div class="hiddenParams" id="navigationScreen">${navigationScreen}</div>
	<div class="hiddenParams" id="tableRows">${tableRows}</div>
	<div class="frame" id="mainFrame">		
		<div id="tablePatients" class="container">							
			<form:form id="form" method="post" action="/easyessoft/ihm/ref/staffAdmin/member/createAction" commandName="staffMember2" >	
				<fieldset>
					<legend style="vertical-align: middle;">Prochains passages <span id="timeSpan" style="float: right;"><img src="http://icons.iconarchive.com/icons/alecive/flatwoken/128/Apps-Clock-icon.png" style="float: left; width: 28px; height: 28px; margin-right: 10px;"/><div id="clock" style="float: left; width: 92px;"></div></span></legend>
					<%	if(listPatient != null) {; %>
					<div class="form-group" >
						<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			        		<ol class="carousel-indicators" style="bottom: -20px;">
			        			<%  for(int i = 0; i < Math.ceil((double) listPatient.size() / (double) tableRows.intValue()); i+=1) { 	%>
			          					<li  class="<% if(i == 0) { %>active <% } %>" data-target="#carousel-example-generic" data-slide-to="i"></li>
			          			<%  }  %>
			        		</ol>
			   				<div class="carousel-inner" role="listbox" >
				   				<%  for(int iTable = 0; iTable < Math.ceil((double) listPatient.size() / (double) tableRows.intValue()); iTable+=1) { 	%>	
					          			<div class="item <% if(iTable == 0) { %>active <% } %>">
						          			<table class="table table-striped">  				
						            			<thead>
						              				<tr style="background-color: #222; color: #FFFFFF">
						                				<th>#</th>
										                <th>Nom</th>
										                <th>Pr&eacute;nom</th>
										                <th>Temps d'attente estimé</th>
						              				</tr>
						            			</thead>
						            			<tbody>
						              				<%  for(int iPatient = 0; iPatient < tableRows.intValue() ; iPatient+=1) {  %>
						              						<tr style="background-color: rgba(255, 255, 255, 0.9);">
						              							<% if((iPatient + 1 + (tableRows.intValue() * iTable)) <= listPatient.size()) { %>
						                						<td><%=iPatient + 1 + (tableRows.intValue() * iTable)%></td>
						                						<td>NOM_PATIENT_<%=listPatient.get(iPatient + (tableRows.intValue() * iTable)).getIdPatient()%></td>
						                						<td>PRENOM_PATIENT_<%=listPatient.get(iPatient + (tableRows.intValue() * iTable)).getIdPatient()%></td>
						                						<td><%=tableRows.intValue()%></td>
						                						<% } else { %>
						                						 <td colspan="4">&nbsp</td>
						                						 <% } %>
						             						</tr>
						             				<%  }  %>
										        </tbody>
											</table>
					          			</div>	
				          		<%  }  %>	
			        		</div>
					        <a class="left carousel-control" style="visibility: hidden;" href="#carousel-example-generic" role="button" data-slide="prev">
					          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					          <span class="sr-only">Previous</span>
					        </a>
					        <a class="right carousel-control" style="visibility: hidden;" href="#carousel-example-generic" role="button" data-slide="next">
					          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					          <span class="sr-only">Next</span>
					        </a>
			      		</div>
					</div>
					<%	} %>;		 
				</fieldset>
			</form:form>
  		</div>
  	</div>

<jsp:include page="../include/footer.jsp" />