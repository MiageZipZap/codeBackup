$(function() {
	$("#createBut").click(function() {
		controlManager.reset();
		String.check("surname", 2, 50);
		String.check("firstname", 2, 50);
		if (controlManager.hasNoError()) {
			$("#doctorForm").removeAttr("onsubmit");
			$("#doctorForm").submit();
		}
	});
});