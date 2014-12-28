/**
 * Control manager for new equipment form
 * @author GKA,PFR,ODI,MCH
 */

$(function() {
	$("#createButEquip").click(function() {
		controlManager.reset();
		String.check("label", 2, 255);
		String.check("serialNumber",10, 10);
		if (controlManager.hasNoError()) {
			$("#equipForm").removeAttr("onsubmit");
			$("#equipForm").submit();
		}
	});
});