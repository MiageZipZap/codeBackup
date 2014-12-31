/**
 * Control manager for new type ref infra form
 * @author GKA,PFR,ODI,MCH
 */

$(function() {
	$("#createButTypeRefInfra").click(function() {
		controlManager.reset();
		String.check("label", 2, 255);
		String.check("code",10, 10);
		if (controlManager.hasNoError()) {
			$("#typerefinfraForm").removeAttr("onsubmit");
			$("#typerefinfraForm").submit();
		}
	});
});