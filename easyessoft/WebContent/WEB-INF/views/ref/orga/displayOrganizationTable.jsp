<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation organisation" name="title" />
</jsp:include>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-usd"></i>
					<span>The World's billionaries</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
					<a class="expand-link">
						<i class="fa fa-expand"></i>
					</a>
					<a class="close-link">
						<i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead>
						<tr>
							<c:forEach var = "listValue" items = "${tableView.tableHeaders}">
							
							</c:forEach>
							<th>fields</th>
						</tr>
					</thead>
					<tbody>
					<!-- Start: list_row -->
						<tr>
							<c:forEach var = "listValue" items = "${tableView.tableValues}">
							</c:forEach>				
							<td>value</td>
						</tr>
					<!-- End: list_row -->
					</tbody>
					<tfoot>
						<tr>
							<th>fields</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../include/footer.jsp" />