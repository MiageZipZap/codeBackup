$(function() {
	$("#createBut").click(function() {
		controlManager.reset();
		String.check("label", 2, 50);
		String.check("code", 2, 50);
		if (controlManager.hasNoError()) {
			$("#infraForm").removeAttr("onsubmit");
			$("#infraForm").submit();
		}
	});
});