<jsp:include page="../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title"/>
</jsp:include>

<div class="container" id="content">

	<br />
	
	<div id="staffDisplay">
	
		<p>Le m�decin ${staffMember.firstName} ${staffMember.lastName} a bien �t� ajout� avec le matricule N� ${staffMember.staffNumber}.</p>
		
		<a href="/easyessoft/ihm/ref/staffAdmin/member/createForm">Ajouter une autre personne</a>
		
	</div>
	
<jsp:include page="../../include/footer.jsp"/>