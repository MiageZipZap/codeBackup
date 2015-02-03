<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Type d'organisation" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-14">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="boderline">Type d'organisation</h1>
					</div>
					<div class="panel-body">
						<div class="box-content">
							<h2>${orgaType.label}</h2>
							<dl class="dl-horizontal">
								<dt>Le Type d'organisation</dt>
								<dd>: ${orgaType.label}</dd>
								<dt>a été rajouté avec le numéro</dt>
								<dd>: ${orgaType.id}</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />