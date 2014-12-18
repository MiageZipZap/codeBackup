$(function() {
	$("#createButInfra").click(function() {
		controlManager.reset();
		String.check("label", 2, 50);
		String.check("code", 2, 50);
		Integer_check("capacity",true, 0);
		if (controlManager.hasNoError()) {
			$("#infraForm").removeAttr("onsubmit");
			$("#infraForm").submit();
		}
	});
	
//	$("#cbxDisabledFacilities").click(function() {
//		$("#disabledFacilities")
//	});
});