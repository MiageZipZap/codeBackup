
   //
   $(document).ready(function() {
	   //
	   $('link[rel=stylesheet][href~="/easyessoft/dist/css/style.css"]').remove();
	   
	   $("nav").remove();
	   //$("nav").attr("class", "navbar navbar-inverse");
	   // $("nav").slideUp("slow");
	   
	   //$("nav").prependTo("#frameWelcomeTop");
	   //$("nav").replaceWith(function() { return "<div class='navbar navbar-inverse navbar-fixed-top'>" + this.innerHTML + "</div>"; });
	   

	   
	   if($("#navigationScreen").text() == "welcome"){
		   $("#frameWelcomeBottom").hide(); 
	   } else {
		   //
		   $("#frameWelcomeTop").hide();

		   //
		   updateClock();
		   
		   //
		   setInterval('updateClock()', 1000);
		   setInterval("location.reload();", 60000);
	   }
	   
	   $('.carousel').carousel({
		   interval: $('#tableRows').text() * 800
	   });   
	  
   });
   
   
   function updateClock() {
	   var currentTime = new Date ( );
	   var currentHours = currentTime.getHours ( );
	   var currentMinutes = currentTime.getMinutes ( );
	   var currentSeconds = currentTime.getSeconds ( );
	
	   // Pad the minutes and seconds with leading zeros, if required
	   currentMinutes = ( currentMinutes < 10 ? "0" : "" ) + currentMinutes;
	   currentSeconds = ( currentSeconds < 10 ? "0" : "" ) + currentSeconds;
	
	   // Compose the string for display
	   var currentTimeString = currentHours + ":" + currentMinutes + ":" + currentSeconds;
	    
	    
	   $("#clock").html(currentTimeString);    
   }

   $(function() {

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
	   
	   $("#showButton").click(function() {
		   
		   if(($("#listServiceType").val() != 0) && ($("#listOrganization").val() != 0)) {
			   $("#frameWelcomeBottom").show();
		
			   $("#frameWelcomeTop").slideUp( "slow", function() {
				   $("#formWelcome").submit();
			   });
		   }
	   });
		   

		/*
		.slideUp(1200, function() {
			
		  });
		});
		*/
		/*
		controlManager.reset();
		String.check("label", 2, 50);
		String.check("code", 2, 50);
		if (controlManager.hasNoError()) {
		
		
			$("form").removeAttr("onsubmit");
		
		}
		*/

   });