$(document).ready(function() {
  
	console.log("js loaded");
	$.ajax({
		url: window.location.protocol + "//" + window.location.host +"/api/allcategories"
	}).then(function(data){
		console.log(data);
		for(let value of data){
			var imgUrl = "";
			if(value.name === "Speakers"){
				imgUrl = "https://goo.gl/xy7K3y";
			}
			else if(value.name === "Televisions"){
				imgUrl = "https://goo.gl/JoNmWE";
			}
			$("#categories").append(
					'<div class="container-fluid bg-white marginbtm3">\
						<h3 class="text-center"><a href="#">View All '+value.name+'</a></h3>\
						<div class="row text-center" id="'+value.name+'">\
						</div>\
					</div>'
			);
			
			for(i=0;i<=3;i++){
				$("#"+value.name).append(
						'<div class="col-lg-3 col-md-4 col-xs-6">\
				          <a href="#" class="d-block mb-4 h-100">\
				            <img class="img-fluid img-thumbnail" src="'+imgUrl+'" alt="">\
				          	<p>'+value.products[i].name+'</p>\
				          	<p>Rs. '+value.products[i].price+'</p>\
				          </a>\
				        </div>'
				);
			}
		}

		/*for(i=0;i<=3;i++){
			console.log(data[i]);
			$("#products").append(
					'<div class="col-lg-3 col-md-4 col-xs-6">\
			          <a href="#" class="d-block mb-4 h-100">\
			            <img class="img-fluid img-thumbnail" src="http://placehold.it/400x300" alt="">\
			          	<p>'+data[i].name+'</p>\
			          	<p>Rs. '+data[i].price+'</p>\
			          </a>\
			        </div>'
			);
		}*/
		
	});
	
});