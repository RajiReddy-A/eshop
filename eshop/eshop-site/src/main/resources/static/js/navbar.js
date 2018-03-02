$(document).ready(function() {
	
	var email = $("#getEmail").text();
	console.log("navbarjs");
	console.log(email);
	var theUrl = window.location.protocol + "//" + window.location.host +"/api/customer/"+email;
		
		if(email){
			$.ajax({
				url: theUrl
			}).then(function(data){
				
				$("#setEmail").text("Welcome "+data.firstName);
					
				});
		}
			 
		
});