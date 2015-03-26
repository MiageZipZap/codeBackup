
   //
   $(document).ready(function() {	
	   //
	   $('link[rel=stylesheet][href~="/easyessoft/dist/css/style.css"]').remove();
	   
	   //
	   if(($("#formLoadScreenDemo_idService").val() > 0) && ($("#formLoadScreenDemo_idOrganization").val() > 0)) {
		   $("#listServiceType").val($("#formLoadScreenDemo_idService").val()); 
	   	   $("#listOrganization").val($("#formLoadScreenDemo_idOrganization").val()); 
	   	   
	   	   $('#listOrganization').prop("disabled", false);
	   	   $('select').removeAttr("disabled");
  	       $('a').removeAttr("disabled");
  	        
	   	   $("#listOrganization option").hide();
   	       $("#listOrganization .serviceType" + $("#listServiceType option:selected").val() + "").show();
   	   
   	       //$('input[disabled="false"]').removeAttr("disabled");​​​
	   }
	   	   
	   $("select").focus(function() {
		    $(this).find("option").eq(0).hide();
	   });

	   //
	   $("#listServiceType").change(function() {
		   
		   if($("#listServiceType").val() == 1) {
	   	       
			    $('#listOrganization').prop("disabled", false);
	   	       
	   	        $("#listOrganization option").hide();
	   	       
	   	        $("#listOrganization .serviceType" + $("#listServiceType option:selected").val() + "").show();
	   	        	
	   	    }
	   	    else {
	   	    	$('#listOrganization').prop("disabled", true);
	   	    }
	   	});
	   
	
	   //
	   $("#btnLoadService").click(function() {
		   //
		   if(($("#listServiceType").val() > 0) && ($("#listOrganization").val() > 0)) {
			   $("#formLoadScreenDemo_idService").val($("#listServiceType").val());
			   $("#formLoadScreenDemo_idOrganization").val($("#listOrganization").val());
			   $("#formLoadScreenDemo").submit();
		   }
	   });
	   	   
	   //
	   $("#btnAddPatient").click(function() {
		   //
		   $('#tableInsertPatient tr:first-child').clone(true).insertAfter('#tableInsertPatient tr:last-child');
		   $('#tableInsertPatient tr:last-child').find('.patientMinutes').find('input').val('');
	   });
	
	   //
	   $(".btnShufflePatient").click(function() {
		   //
		   //$(this).parent().parent().find('.patientMedicalProcedure select').removeAttr("selected");
		   $(this).parent().parent().find('.patientMedicalProcedure').find('option').val(3);
		   $(this).parent().parent().find('.patientMedicalProcedure').find('option').val(Math.floor(Math.random()*(5-1+1)+1));
		   //$(this).parent().parent().find('.patientMedicalProcedure').find('option[value=4]').attr('selected',true);
		   $(this).parent().parent().find('.patientPriority select').val(Math.floor(Math.random()*(2-0+5)+0));
		   //$(this).parent().parent().find('.patientMinutes').find('select').val(Math.floor(Math.random()*(1-0+5)+0));
		   $(this).parent().parent().find('.patientMinutes').find('input').val(-1 * Math.floor(Math.random()*(360-0+1)+0));
	   });
	   
	   //
	   $(".btnLoadPatient").click(function() {
		   //
		   alert($(this).parent().parent());
	   });

	   //
	   $("#btnTestInsert1").click(function() {
		   $("#formTestWaitingQueue_typeInjection").val("insert");
		   $("#formTestWaitingQueue_number").val(1);
		   $("#formTestWaitingQueue").submit();
	   });

	   //
	   $("#btnTestInsert5").click(function() {
		   $("#formTestWaitingQueue_typeInjection").val("insert");
		   $("#formTestWaitingQueue_number").val(5);
		   $("#formTestWaitingQueue").submit();
	   });
	   
	   //
	   $("#btnTestInsert10").click(function() {
		   $("#formTestWaitingQueue_typeInjection").val("insert");
		   $("#formTestWaitingQueue_number").val(10);
		   $("#formTestWaitingQueue").submit();
	   });
	   
	   //
	   $("#btnTestTreatment").click(function() {
		   $("#formTestWaitingQueue_typeInjection").val("treatment");
		   $("#formTestWaitingQueue").submit();
	   });
	   
	   //
	   $("#btnTestExit").click(function() {
		   $("#formTestWaitingQueue_typeInjection").val("exit");
		   $("#formTestWaitingQueue").submit();
	   });
	   
});