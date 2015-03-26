<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation MedicalRecord" name="title" />
</jsp:include>
<link rel="stylesheet" type="text/css" href="C:\Users\Lionel\git\easyes_soft\easyessoft\WebContent\css\js-graph-it.css">
<script type="text/javascript" src="C:\Users\Lionel\git\easyes_soft\easyessoft\WebContent\js\js-graph-it.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body onload="initPageObjects();">
	<div class="container" id="content">
		<div>
			<h1>Confirmation</h1>
		</div>

		<br /> <br />
		<script type="text/javascript">
			function updateStatusAJAX() {
				$.ajax({
						url : '/easyessoft/ihm/healthPaths/healthPath/updateStatus.html',
						success : function(data) {
						$('#result').html(data);
						initPageObjects();
							}
						});
			}
		</script>

		<script type="text/javascript">
			var intervalId = 0;
			intervalId = setInterval(updateStatusAJAX, 3000);
		</script>
		<br />
		<div class="canvas" id="mainCanvas"
			style="width: 350px; height: 250px; border: 1px solid black;">
			<br />
			<div id="result"></div>
			<br>
			<p>
			</p>
		</div>
	</div>
</body>
<jsp:include page="../../include/footer.jsp" />