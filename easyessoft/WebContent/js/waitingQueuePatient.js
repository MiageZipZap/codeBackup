
   //
   $(document).ready(function() {
	   //
	   $('link[rel=stylesheet][href~="/easyessoft/dist/css/style.css"]').remove();
	   //
	   $("nav").remove();

	   //
	   updateClock();
		   
	   //
	   setInterval('updateClock()', 1000);
	   setInterval("location.reload();", 60000);
	   
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