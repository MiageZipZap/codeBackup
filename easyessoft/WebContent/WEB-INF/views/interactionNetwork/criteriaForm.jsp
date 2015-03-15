<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp">
	<jsp:param name="title" value="Interaction Network Form" />
</jsp:include>
<link rel="stylesheet" type="text/css" href="/easyessoft/css/jquery.datetimepicker.css"/ >
<script type="text/javascript" src="/easyessoft/js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="/easyessoft/js/interactionNetworkForm.js"></script>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Critères du réseau d'interaction</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<form:form id="interactionNetworkForm" class="form-horizontal" method="post"
								action="/easyessoft/ihm/interactionNetwork/view"
								commandName="interactionNetworkCriteria">
								<fieldset>
									<legend>Information du réseau</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label">Date de début</label>
										<div class="col-sm-3">
											<form:input type="text" path="beginDateStr" id="beginDate"
												class="form-control" name="beginDate" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Date de fin</label>
										<div class="col-sm-3">
											<form:input type="text" path="endDateStr" id="endDate"
												class="form-control" name="endDate" />
										</div>
									</div>
									
								</fieldset>
								<fieldset>
									<legend>Information du point d'entrée</legend>
								</fieldset>
								<div class="form-group">
									<div class="col-sm-5 col-sm-offset-4" id="finish">
										<button type="submit" style="width:100px" class="btn btn-primary btn-form"
											id="btnDisplayInteractionNetwork">Visualiser</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />