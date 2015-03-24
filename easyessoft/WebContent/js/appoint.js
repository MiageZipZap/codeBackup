/**
 * /**
 * View controller for appointment creation page
 */
$(function() {
	$("#createButAppoint").click(function() {
		controlManager.reset();
		String.check("patientLastName", 2, 255);
		String.check("patientFirstName", 2, 255);
		if (controlManager.hasNoError()) {
			$("#appointmrntForm").removeAttr("onsubmit");
			$("#appointmentForm").submit();
		}
	});
});

$(document).ready(function() {
    $("#lstReason").change(function() {
 
    	$('#lstReasonSpeciality').val(0);
    	
        if($("#lstReason").val() != 1 || $("lstReason").val()!=2 ) {
        	$("#lstReasonSpeciality").prop("disabled", true);
        }else{
        	$("#lstReasonSpeciality").prop("disabled", false);
        	$("#lstReasonSpeciality ." + $("#lstReason option:selected").attr('class') + "").show();
        }
        	
	    	if($("#lstlstReason").val() == 1 || $("#lstlstReason").val() == 2) {
    	    	$("#ap1").hide();		
    	    	$("#ap2").hide();
    	    	$("#ap3").hide();
	    	} else {
	    		$("#ap1").show();		
    	    	$("#ap2").show();
    	    	$("#ap3").show();	
	    	}
	    	
	    	
    });
});


 