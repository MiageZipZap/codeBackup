<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation rendez-vous" name="title" />
</jsp:include>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="tagline">Confirmation rendez-vous</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
				
					<th>Nom patient</th>
					<th>Prénom patient</th>
					<th>Date de naissance</th>
					<th>Motif</th>
					<th>Date rendez-vous</th>
					<th>Heure</th>
					<th>Médecin</th>
					<th>Nouveau patient<th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${appointment.patient.lastName}</td>
					<td>${appointment.patient.firstName}</td>
					<td>${appointment.patient.birthdate}</td>
					<td>${appointment.appointmentReason.label}</td>
					<td>${appointment.appointmentDate}</td>
					<td>${appointment.appointmentHour}</td>
					<td>${appointment.doctorName}</td>
					<td><c:if test="${appointment.newPatient}">oui
			</c:if> <c:if test="${appointment.newPatient}">non
			</c:if></td>
				</tr>
			</tbody>
		</table>
		
		<h1 class=tagline>Liste des Actes</h1>
		
		<table border="1">
            <thead>
                <tr>
                    <th>Actes</th>
               
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${acts}" var="acts">
                    <tr>
                        <td><c:out value="${acts}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />