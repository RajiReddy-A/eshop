$(document).ready(function(){
	$.urlParam = function(name){
		var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		return results[1] || 0;
	}
	
	var theProduct = $.urlParam('product');
	theProduct = decodeURIComponent(theProduct);
	
	var theUrl = window.location.protocol + "//" + window.location.host +"/api/product/"+theProduct;
	var theCategory = "";	
		$.ajax({
			url: theUrl
		}).then(function(data){
			
			$(".product-breadcroumb").append('\
					<a href="">'+data.category.name+'</a>\
                    <a href="">'+data.name+'</a>\
			');
			
			$("#productMain").append('\
					<img src="'+data.imageUrl+'" alt="">\
					');
			
			$("#productThumb").append('\
					<img src="'+data.imageUrl+'" alt="">\
					<img src="'+data.imageUrl+'" alt="">\
					<img src="'+data.imageUrl+'" alt="">\
					');
			
			$("#productName").append(data.name);
			$("#productPrice").append('\
					<ins>Rs. '+data.price+'</ins>\
					');
			$("#categoryLink").append(data.category.name);
					
			theCategory = data.category.name;
			var relatedUrl = window.location.protocol + "//" + window.location.host +"/api/category/"+theCategory;
			$.ajax({
				url: relatedUrl
			}).then(function(data){
				
				var i=1;
				for(let value of data.products){
					if(i===6){
						break;
					}
					i=i+1;
					
					$("#sidebarProducts").append('\
							<div class="thubmnail-recent">\
				                <img src="'+value.imageUrl+'" class="recent-thumb" alt="">\
				                <h2><a href="">'+value.name+'</a></h2>\
				                <div class="product-sidebar-price">\
				                    <ins>Rs. '+value.price+'</ins>\
				                </div>\
							</div>\
					');
				}
				
			});
			
		});
		
});