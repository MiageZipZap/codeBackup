/**
 * Control manager for new equipment form
 * @author GKA,PFR,ODI,MCH
 */

$(function() {
	$("#createBut").click(function() {
		controlManager.reset();
		String.check("label", 2, 50);
		String.check("code", 2, 50);
		//Faire un check sur des listes déroulante-> modifier controManager
		//String.check("category", 2, 50);
		//String.check("type", 2, 50);
		if (controlManager.hasNoError()) {
			$("#equipForm").removeAttr("onsubmit");
			$("#equipForm").submit();
		}
	});
});