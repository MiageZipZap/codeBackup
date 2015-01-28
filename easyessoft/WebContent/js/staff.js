//$(document).on('change', '#listOrganizationType', function(e) {
//    alert(this.options[e.target.selectedIndex].val());
//});



       $(document).ready(function() {
    	    $("#listOrganizationType").change(function() {
    	        if($("#listOrganizationType").val() != 0) {
    	        	$('#listOrganization').prop("disabled", false);
    	        	$("#listOrganization option").hide();
    	        	$("#listOrganization ." + $("#listOrganizationType option:selected").attr('class') + "").show();
    	        }
    	        else {
    	        	$('#listOrganization').prop("disabled", true);
    	        	$('#listService').prop("disabled", true);
    	        }
    	    });
    	});
       
       $(document).ready(function() {
   	    $("#listOrganization").change(function() {
   	        if($("#listOrganization").val() != 0) {
   	        	$('#listService').prop("disabled", false);
   	        	$("#listService option").hide();
   	        	//$("#listOrganization ." + $("#listOrganizationType option:selected").attr('class') + "").show();
   	        }
   	        else {
   	        	$('#listService').prop("disabled", true);
   	        }
   	    	alert("okok" + $("#listOrganization").val());
   	        //$(".yourDropDownClass").change();
   	    });
   	});
/*

$(function() {
	$("#createButton").click(function() {
		
		/*
		controlManager.reset();
		String.check("label", 2, 50);
		String.check("code", 2, 50);
		if (controlManager.hasNoError()) {
		
		
			$("form").removeAttr("onsubmit");
			$("#form").submit();
		//}
	});
});

*/