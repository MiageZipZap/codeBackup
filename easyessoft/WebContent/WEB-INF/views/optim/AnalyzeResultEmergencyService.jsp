<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.esiag.isies.pds.model.optimisation.*"%>
<%@ page import="fr.esiag.isies.pds.model.referential.organization.*"%>
<%@ page import="java.util.*"%>
<% ArrayList<AnalyzeResultEmergencyService> resultOfFrequentation;
resultOfFrequentation = (ArrayList<AnalyzeResultEmergencyService>) request.getAttribute("resultOfFrequentation");
Object totalCapacityOfWaitingSalle = request.getAttribute("totalCapacityOfWaitingSalle"); 
%>


<jsp:include page="../include/header.jsp">
	<jsp:param value="Visualisation situation service d'urgence"
		name="title" />
</jsp:include>
<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/easyessoft/js/dataTableConfiguration.js"></script>
<script src="/easyessoft/js/highcharts.js"></script>
<script src="/easyessoft/js/exporting.js"></script>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-heading">
					<h4 class="boderline">Nombre de box d'examen : ${BoxNumber}</h4>
				</div>
				<div class="panel-heading">
					<h4 class="boderline">Un pic de fréquentation chronique a été detecté le
						:${dateMinDate} de ${hourMinDate} à ${hourMaxDate}</h4>
				</div>
				<div id="container"
					style="min-width: 310px; height: 400px; margin: 0 auto"></div>
				<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        title: {
            text: 'Analyse du service d\'urgence',
            x: -20 //center
        },
        subtitle: {
            text: 'représentation graphique',
            x: -20
        },
        xAxis: {
            categories: 
<%
out.println("[");
for(int i=0; i<resultOfFrequentation.size() ; i++)
{

 out.println("'"+resultOfFrequentation.get(i).gethourOfPassage()+"'");

	if(i != resultOfFrequentation.size()-1)
	{
	  out.println(",");
	}
}//end for
out.println("]");
%>
        },
        yAxis: {
            title: {
                text: 'Patient en attente de prise en charge'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ' patients'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Patient en attente',
            data: 
            <%out.println("[");
        for(int i=0; i<resultOfFrequentation.size() ; i++){

 	out.println(resultOfFrequentation.get(i).getNbwaitingPatient());


	if(i != resultOfFrequentation.size()-1)
	{
	  out.println(",");
	}
}//end for
out.println("]");
%>
        },{
        	name:'capacité salle d\'attente',
        	data:
        		 <%out.println("[");
            for(int i=0; i<resultOfFrequentation.size() ; i++){

     	out.println(totalCapacityOfWaitingSalle);
     	if(i != resultOfFrequentation.size()-1)
    	{
    	  out.println(",");
    	}
    }//end for
    out.println("]}");  
    %>   
        ]
    });
});
</script>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />