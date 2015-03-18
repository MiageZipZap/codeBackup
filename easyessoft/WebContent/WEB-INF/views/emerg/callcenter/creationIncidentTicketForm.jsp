<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param name="title" value="Creation Organisme" />
</jsp:include>
<script type="text/javascript" src="/easyessoft/js/orga.js"></script>
<script type="text/javascript"
	src="/easyessoft/dist/tinymce/tinymce.min.js"></script>
<script type="text/javascript">
	tinymce.init({
		selector : "textarea"
	});
</script>
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
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<fieldset>
										<legend>Localisation</legend>
										<div class="form-group">
											<label class="col-sm-3 control-label">Numéro de rue</label>
											<div class="col-sm-5">
												<input type="text" path="streetNumber" id="streetNumber"
													class="form-control" name="streetNumber" />
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-3 control-label">Type de voie </label>
											<div class="col-sm-5">
												<input type="text" path="streetType" id="streetType"
													class="form-control" name="streetType" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Nom de rue</label>
											<div class="col-sm-5">
												<input type="text" path="streetName" id="streetName"
													class="form-control" name="streetName" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Ville</label>
											<div class="col-sm-5">
												<input type="text" path="city" id="city"
													class="form-control" name="city" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Zip code</label>
											<div class="col-sm-5">
												<input type="text" path="zipCode" id="zipCode"
													class="form-control" name="zipCode" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Département</label>
											<div class="col-sm-5">
												<input type="text" path="department" id="department"
													class="form-control" name="department" />
											</div>
										</div>
										<legend>Contact de liaison</legend>
										<label class="col-sm-2 control-label">First name</label>
										<div class="col-sm-4">
											<input type="text" class="form-control"
												placeholder="First name" data-toggle="tooltip"
												data-placement="bottom" title="Tooltip for name">
										</div>
										<label class="col-sm-2 control-label">Last name</label>
										<div class="col-sm-4">
											<input type="text" class="form-control"
												placeholder="Last name" data-toggle="tooltip"
												data-placement="bottom" title="Tooltip for last name">
										</div>
									</fieldset>
								</div>
								<div class="form-group has-success has-feedback">
									<label class="col-sm-2 control-label">Company</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" placeholder="Company">
									</div>
									<label class="col-sm-2 control-label">Address</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" placeholder="Address">
										<span
											class="fa fa-check-square-o txt-success form-control-feedback"></span>
									</div>
								</div>
								<div class="form-group has-warning has-feedback">
									<label class="col-sm-2 control-label">Residence</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" placeholder="City">
										<span class="fa fa-key txt-warning form-control-feedback"></span>
									</div>
									<div class="col-sm-2">
										<input type="text" class="form-control" placeholder="Country">
										<span class="fa fa-frown-o txt-danger form-control-feedback"></span>
									</div>
									<label class="col-sm-1 control-label">CODE</label>
									<div class="col-sm-2">
										<input type="text" class="form-control"
											placeholder="Another info" data-toggle="tooltip"
											data-placement="top" title="Hello world!">
									</div>
									<div class="col-sm-2">
										<div class="checkbox">
											<label> <input type="checkbox" checked> No
												exist <i class="fa fa-square-o small"></i>
											</label>
										</div>
									</div>
								</div>
								<div class="form-group has-warning has-feedback">
									<label class="col-sm-2 control-label">Select you OS</label>
									<div class="col-sm-4">
										<select id="s2_with_tag" multiple="multiple"
											class="populate placeholder">
											<option>Linux</option>
											<option>Windows</option>
											<option>OpenSolaris</option>
											<option>FirefoxOS</option>
											<option>MeeGo</option>
											<option>Android</option>
											<option>Sailfish OS</option>
											<option>Plan9</option>
											<option>DOS</option>
											<option>AIX</option>
											<option>HP/UP</option>
										</select>
									</div>
									<label class="col-sm-2 control-label">Tooltip for
										inputs</label>
									<div class="col-sm-2">
										<input type="text" class="form-control"
											placeholder="Another info" data-toggle="tooltip"
											data-placement="top" title="Hello world!">
									</div>
									<span class="help-inline col-xs-12 col-sm-2"> <span
										class="middle txt-default">only example</span>
									</span>
								</div>
								<div class="form-group has-error has-feedback">
									<label class="col-sm-2 control-label">Date</label>
									<div class="col-sm-2">
										<input type="text" id="input_date" class="form-control"
											placeholder="Date"> <span
											class="fa fa-calendar txt-danger form-control-feedback"></span>
									</div>
									<div class="col-sm-2">
										<input type="text" id="input_time" class="form-control"
											placeholder="Time"> <span
											class="fa fa-clock-o txt-danger form-control-feedback"></span>
									</div>
									<label class="col-sm-2 control-label">Disabled input</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" placeholder="No info"
											data-toggle="tooltip" data-placement="top"
											title="Hello world!" disabled>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-styles">Relative
										Sizing</label>
									<div class="col-sm-10">
										<div class="row">
											<div class="col-sm-2">
												<input class="form-control" id="form-styles"
													placeholder=".col-sm-2" type="text">
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<p>
													<small>Dynamic resizing col</small>
												</p>
												<div class="progress progress-ui">
													<div
														class="progress-bar progress-bar-success slider-style slider-range-min"
														style="width: 100%;"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-styles">Textarea</label>
									<div class="col-sm-10">
										<textarea class="form-control" rows="5" id="wysiwig_simple"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="form-styles">Extreme
										Textarea</label>
									<div class="col-sm-10">
										<textarea class="form-control" rows="5" id="wysiwig_full"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Input groups</label>
									<div class="col-sm-2">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-github-square"></i></span> <input type="text"
												class="form-control" placeholder="GitHub">
										</div>
									</div>
									<div class="col-sm-2">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="Group">
											<span class="input-group-addon"><i class="fa fa-group"></i></span>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-money"></i></span>
											<input type="text" class="form-control" placeholder="Money">
											<span class="input-group-addon"><i class="fa fa-usd"></i></span>
										</div>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-2">
										<button type="cancel" class="btn btn-default btn-label-left">
											<span><i class="fa fa-clock-o txt-danger"></i></span> Cancel
										</button>
									</div>
									<div class="col-sm-2">
										<button type="submit" class="btn btn-warning btn-label-left">
											<span><i class="fa fa-clock-o"></i></span> Send later
										</button>
									</div>
									<div class="col-sm-2">
										<button type="submit" class="btn btn-primary btn-label-left">
											<span><i class="fa fa-clock-o"></i></span> Submit
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />