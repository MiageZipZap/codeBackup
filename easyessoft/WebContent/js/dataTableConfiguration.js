/****Configuration Datatable****/
$(document)
.ready(function() {
	$('#table_id').DataTable({
		"language" : {
			"lengthMenu" : "Affichage _MENU_ lignes par page",
			"search" : "Rechercher:",
			"zeroRecords" : "Aucun enregistrement - d&eacute;sol&eacute;",
			"info" : "Affiche page _PAGE_ of _PAGES_",
			"infoEmpty" : "Aucune donn&eacute;e disponible",
			"infoFiltered" : "(trier &agrave; partir de _MAX_ enregistrements au total)",
			"emptyTable" : "Aucune donn&eacute;e dans la table",
			"infoPostFix" : "",
			"thousands" : ",",
			"lengthMenu" : "Affiche _MENU_ entr&eacute;es",
			"loadingRecords" : "Chargement...",
			"processing" : "Traitement...",
			"paginate" : {
				"first" : "Premier",
				"last" : "Dernier",
				"next" : "Suivant",
				"previous" : "Pr&eacute;c&eacute;dant"
			},
			"aria" : {
				"sortAscending" : ": Tri croissant de la colonne",
				"sortDescending" : ": Tri d&eacute;croissant de la colonne"
			}

		}
	});
});