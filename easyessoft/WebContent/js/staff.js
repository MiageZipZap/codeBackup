       $(document).ready(function() {
    	    $("#listProfessionType").change(function() {
    	    	
	        	$('#listProfession').val(0);
	        	$('#listSpeciality').val(0);
	        	
    	        if($("#listProfessionType").val() != 0) {
    	        	$("#listProfession").prop("disabled", false);
    	        	
        	    	if($("#listProfessionType").val() == 1) {
            	    	$("#rppsField").show();		
            	    	$("#adeliField").hide();	
        	    	} else {
            	    	$("#rppsField").hide();	
            	    	$("#adeliField").show(); 	
        	    	}
        	    	
        	    	if(($("#listProfessionType").val() == 1) || ($("#listProfessionType").val() == 2)) {
        	        	$('#listSpeciality').prop("disabled", false);
           	        	$("#listSpeciality option").hide();
           	        	$("#listSpeciality ." + $("#listProfessionType option:selected").attr('class') + "").show();
           	        }
           	        else {
           	        	$('#listSpeciality').prop("disabled", true);
           	        }
        	    	
    	        	$("#listProfession option").hide();
    	        	$("#listProfession ." + $("#listProfessionType option:selected").attr('class') + "").show();
    	        	//$("#listOrganization").find('option:visible:first').css('background','blue');
    	        }
    	        else {
    	        	$('#listProfession').prop("disabled", true);
    	        	$('#listSpeciality').prop("disabled", true);
        	    	$("#rppsField").hide();	
        	    	$("#adeliField").hide(); 	
    	        }
    	    });
    	});


       $(document).ready(function() {
    	    $("#listOrganizationType").change(function() {
    	    	
	        	$('#listOrganization').val(0);
	        	$('#listService').val(0);
	        	
    	        if($("#listOrganizationType").val() != 0) {
    	        	$("#listOrganization").prop("disabled", false);
    	        	$("#listOrganization option").hide();
    	        	$("#listOrganization ." + $("#listOrganizationType option:selected").attr('class') + "").show();
    	        	//$("#listOrganization").find('option:visible:first').css('background','blue');
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
   	        	$("#listService ." + $("#listOrganization option:selected").attr('class') + "").show();
   	        	
   	        	if($("#listService ." + $("#listOrganization option:selected").attr('class') + " :hidden").length){
   	        		$('#listService').prop("disabled", true);
   	        	}
   	        }
   	        else {
   	        	$('#listService').prop("disabled", true);
   	        }
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