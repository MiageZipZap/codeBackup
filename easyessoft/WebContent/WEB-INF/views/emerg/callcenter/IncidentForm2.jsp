<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Organisme" />
</jsp:include>
<script type="text/javascript" src="/easyessoft/js/location.js"></script>
<style type="text/css">
/* Adjust feedback icon position */
.form-horizontal .has-feedback .form-control-feedback {
	right: 30px;
}
</style>

<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Traiter un appel</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h1 class="page-header">Ouverture du ticket</h1>
							<form:form id="orgaForm" role="form" class="form-horizontal"
								method="POST"
								action="/easyessoft/ihm/emerg/callcenter/createIncidentContact"
								commandName="caller">
								<fieldset>
									<legend>Contact de Liaison</legend>
									<div class="form-group has-error has-feedback">
										<label class="col-sm-2 control-label">Nom</label>
										<div class="col-sm-4">
											<input type="text" id="surname" name="surname" class="form-control"
												placeholder=" Nom de Famille" data-toggle="tooltip"
												data-placement="bottom" title="Nom">
										</div>
										<label class="col-sm-2 control-label">Prénom</label>
										<div class="col-sm-4">
											<input type="text" id="name" name="name" class="form-control"
												placeholder="nom" data-toggle="tooltip"
												data-placement="bottom" title="nom">
										</div>
									</div>
									<div class="form-group has-error has-feedback">
										<label class="col-sm-2 control-label">Tél.</label>
										<div class="col-sm-2">
											<input type="text" id="tel" name="tel" class="form-control" placeholder="Téléphone">
											<span class="fa fa-frown-o txt-danger form-control-feedback"></span>
										</div>
									</div>
									<div class="form-group has-warning has-feedback">
										<label class="col-sm-2 control-label">Age</label>
										<div class="col-sm-4">
											<input type="text" id="age" name="age" class="form-control" placeholder="Age">
											<span class="fa fa-key txt-warning form-control-feedback"></span>
										</div>
										<label class="col-sm-2 control-label">Genre</label>
										<div class="col-sm-2">
											<select id="sex" name="sex" multiple="multiple"
												class="populate placeholder">
												<option>Homme</option>
												<option>Femme</option>
											</select>
										</div>
									</div>
									<div class="form-group col-sm-8">
										<div class="col-sm-offset-2 col-sm-2">
											<button type="cancel" class="btn btn-default btn-label-left">
												<span><i class="fa fa-clock-o txt-danger"></i></span> Cancel
											</button>
										</div>
										<div class="col-sm-2">
											<button type="submit" class="btn btn-primary btn-label-left">
												<span><i class="fa fa-clock-o"></i></span> Next
											</button>
										</div>
									</div>
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>