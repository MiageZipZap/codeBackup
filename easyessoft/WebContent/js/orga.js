$(function() {
	$("#createButOrga").click(function() {
		controlManager.reset();
		String.check("name", 2, 45);
		String.check("code", 2, 45);
		if (controlManager.hasNoError()) {
			$("#orgaForm").removeAttr("onsubmit");
			$("#orgaForm").submit();
		}
	});
});