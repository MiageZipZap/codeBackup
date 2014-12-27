/**
 * View controller for medicine creation page
 */

$(function() {
	$("#createButMedicine").click(function() {
		controlManager.reset();
		String.check("label", 2, 255);
		String.check("ucdCode", 2, 7);
		Integer_check("quantity",true,2, 50);
		if (controlManager.hasNoError()) {
			$("#medicForm").removeAttr("onsubmit");
			$("#medicForm").submit();
		}
	});
});