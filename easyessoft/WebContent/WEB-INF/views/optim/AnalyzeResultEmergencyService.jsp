<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Visualisation situation service d'urgence" name="title" />
</jsp:include>
<link href="/easyessoft/dist/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript"
	src="/easyessoft/dist/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/easyessoft/js/dataTableConfiguration.js"></script>
<script 
	src="/easyessoft/js/highcharts.js"></script>
<script 
	src="/easyessoft/js/exporting.js"></script>
	<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
			<div class="panel-heading">
				<h4 class="boderline">Nombre de box d'examen : ${BoxNumber}</h4>
			</div>
	<div class="panel-heading">
				<h4 class="boderline">Capacité des salles d'attentes du service d'urgence de ${organization.name}: ${totalCapacityOfWaitingSalle} places</h4>
			</div>
			<div class="panel-heading">
				<h5 class="boderline">La pic de fréquentation a été relevé le :${dateMinDate} de ${hourMinDate} à ${hourMaxDate}</h5>
			</div>
			  <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<!--<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        title: {
            text: 'Monthly Average Temperature',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Patient en attente',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }]
    });
});
</script>-->
			</div>
		</div>
	</div>
	</div>
<jsp:include page="../include/footer.jsp" />