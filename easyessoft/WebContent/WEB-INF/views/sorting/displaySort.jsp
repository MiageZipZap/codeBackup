<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation tri" name="title"/>
</jsp:include>
	<div>
		<p>
				Donn�es du tri:
				Nom: ${sort.surname},
				Pr�nom: ${sort.firstname},
				Cat�gorie de tri: ${sort.sortingcategory}
				Service d'orientation: ${sort.sortingservice}
		</p>
	</div>
<jsp:include page="../include/footer.jsp"/>