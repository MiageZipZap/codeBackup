<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title"/>
</jsp:include>
	<div id="staffDisplay">
		<p>
			Le m�decin ${staff.surname} ${staff.firstname}
			a bien �t� ajout� avec le num�ro ${staff.id}
		</p>
	</div>
<jsp:include page="../../include/footer.jsp"/>