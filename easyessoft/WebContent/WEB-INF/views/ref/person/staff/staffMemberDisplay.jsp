<jsp:include page="../../../include/header.jsp">
	<jsp:param value="Creation Staff" name="title"/>
</jsp:include>

<div class="container" id="content">

	<br />
	
	<br />
			
	<div>
		<h1>Confirmation</h1>
	</div>
			
	<br />
	
	<div id="staffDisplay">
	
		<p>${staffMember.name} ${staffMember.surname} a bien été ajouté avec le matricule N° ${staffMember.id}.</p>
		
		<br />
		
		<a href="/easyessoft/ihm/ref/staffAdmin/member/createForm" class="btn btn-primary btn-lg active" role="button">Ajouter une autre personne</a>
		
	</div>
	
<jsp:include page="../../../include/footer.jsp"/>