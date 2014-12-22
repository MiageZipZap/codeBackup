$(function() {
	$("#createButOrga").click(function() {
		controlManager.reset();
		console.log("begin control");
		String.check("name", 2, 45);
		/*String.check("siret", 2, 45);
		String.check("streetNumber", 2, 45);
		String.check("streetName", 2, 45);
		String.check("city", 2, 45);
		String.check("zipCode", 2, 45);
		String.check("department", 2, 45);
		String.check("siret", 2, 45);*/
		console.log('en control');
		if (controlManager.hasNoError()) {
			console.log("has no error");
			$("#orgaForm").removeAttr("onsubmit");
			$("#orgaForm").submit();
		}
	});
});