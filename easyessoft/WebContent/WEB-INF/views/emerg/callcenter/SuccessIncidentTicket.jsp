<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation intervention" name="title" />
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
							<p>Le ticket Num�ro ${interventionTicket.id} a bien �t� cr��</p>
							<div class="well app-menu">
								<div class="panel-body">
									<div class="box-content">
										<div id="OptimalsVehiculesDisplay">
											Les V�hicules disponibles :
											<ul>
												<select multiple>
													<c:forEach var="selectionType" items="${vehicules}">
														<option value=${selectionType.id}>id
															:${selectionType.id} | cat�gory
															:${selectionType.category} | d�lais :5 min| latitude
															:${selectionType.latitude} | longitude
															:${selectionType.longitude} | Allongement :
															${selectionType.stretcher}| Nb places :
															${selectionType.nbPlaces}</option>
													</c:forEach>
												</select>
											</ul>
										</div>
									</div>

								</div>
								<form action="/easyessoft/ihm/emerg/callcenter/CallHome">
									<button type="submit" class="btn btn-warning " role="button">
										<i class="glyphicon glyphicon-plus-sign"></i>Envoyer!
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../../include/footer.jsp" />