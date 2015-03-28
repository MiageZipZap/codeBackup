<jsp:include page="../include/header.jsp">
	<jsp:param value="Creation tri" name="title"/>
</jsp:include>
	<div>
		<p>
				Données du tri:
				Nom: ${sort.surname},
				Prénom: ${sort.firstname},
				Catégorie de tri: ${sort.sortingcategory}
				Service d'orientation: ${sort.sortingservice}
		</p>
	</div>
<jsp:include page="../include/footer.jsp"/>