$(document).ready(function(){
	
	$.ajax({
		type: "GET",
		url: window.location.protocol + "//" + window.location.host +"/api/allproducts",
		success: function(data){
			
			for(let value of data){
				$("#bxslider-home4").append('\
						<li>\
						<img src="'+value.imageUrl+'" style="width:700px;height:365px;" alt="Slide">\
						<div class="caption-group">\
							<h2 class="caption title">\
								<span class="primary"><strong>'+value.name+'</strong></span>\
							</h2>\
							<h4 class="caption subtitle">Rs. '+value.price+'</h4>\
							<a class="caption button-radius" href="products?product='+value.name+'"><span class="icon"></span>Shop now</a>\
						</div>\
					</li>\
				');
			}
			
			scriptSlider();
			mainJs();
			
		},
		error: function(){
			scriptSlider();
			mainJs();
		}
	});
	
	
	
});
