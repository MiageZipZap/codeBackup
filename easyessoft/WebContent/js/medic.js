/**
 * View controller for medicine creation page
 */

$(function() {
	$("#createButMedicine").click(function() {
		controlManager.reset();
		String.check("label", 2, 255);
		String.check("ucdCode", 7, 7);
		Integer_check("quantity",true,1);
		Integer_check("ucdCode",true,0);
		if (controlManager.hasNoError()) {
			$("#medicForm").removeAttr("onsubmit");
			$("#medicForm").submit();
		}
	});
});