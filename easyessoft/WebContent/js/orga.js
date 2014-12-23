$(function() {
	var orgaTypeVar=document.getElementById('OrgaType').value;
	$("#createButOrga").click(function() {
		controlManager.reset();
		String.check("name", 2, 45);
		String.check("siret", 14, 14);
		Integer_check("streetNumber", 1, 6);
		String.check("streetType", 2, 45);
		String.check("streetName", 2, 45);
		String.check("city", 2, 45);
		String.check("zipCode", 2, 45);
		String.check("department", 2, 45);

		//Hospital fields check
		if( orgaTypeVar != 0){
			if(orgaTypeVar==2){
				String.check("finess", 2, 45);
			}
		}
		if (controlManager.hasNoError()) {
			$("#orgaForm").removeAttr("onsubmit");
			$("#orgaForm").submit();
		}
	});



	$("#OrgaType").on('change', function (e) {
	    var valueSelected = this.value;
	    alert(valueSelected);
	    if (valueSelected==2){
			$('#OrgaType').append('<div class="container include-contact">'+	
					'testestestte</div>');
		}
	});
});