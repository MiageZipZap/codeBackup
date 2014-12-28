$(function() {
	$("#createButInfra").click(function() {
		controlManager.reset();
		String.check("label", 2, 255);
		String.check("code", 10, 10);
		Integer_check("capacity",true, 0);
		if (controlManager.hasNoError()) {
			$("#infraForm").removeAttr("onsubmit");
			$("#infraForm").submit();
		}
	});
});