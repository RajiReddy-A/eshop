$(document).ready(function(){
	$.urlParam = function(name){
		var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		return results[1] || 0;
	}
	
	var theProduct = $.urlParam('product');
	theProduct = decodeURIComponent(theProduct);
	var theUrl = window.location.protocol + "//" + window.location.host +"/api/product/"+theProduct;
	var theCategory = "";
	
	var allCategoriesUrl = window.location.protocol + "//" + window.location.host +"/api/allcategories/";
	function ajax3(allCategoriesUrl){
		
		$.ajax({
			type: "GET",
			url: allCategoriesUrl,
			success: function(data3){
				for(let value of data3){
					if(value.name !== theCategory){
						for(let eachProduct of value.products){
							$("#otherProducts").append('\
									<div class="single-product">\
	                                    <div class="product-f-image">\
	                                        <img src="'+eachProduct.imageUrl+'" alt="">\
	                                        <div class="product-hover">\
	                                            <a href="" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>\
	                                            <a href="/products?product='+eachProduct.name+'" class="view-details-link"><i class="fa fa-link"></i> See details</a>\
	                                        </div>\
	                                    </div>\
	                                    <h2><a href="/products?product='+eachProduct.name+'">'+eachProduct.name+'</a></h2>\
	                                    \
	                                    <div class="product-carousel-price">\
	                                        <ins>Rs. '+eachProduct.price+'</ins>\
	                                    </div>\
	                                </div>\
									');
						}
					}
										
		
				}
				
				mainJs();
			},
			error: function(){
				mainJs();
				console.log("ajax3 error");
			}
		});
		
	}
	
	function ajax2(relatedUrl){
		
		$.ajax({
			type: "GET",
			url: relatedUrl,
			success: function(data2){
				var i=1;
				for(let value of data2.products){
					if(i===6){
						break;
					}
					i=i+1;
					
					$("#sidebarProducts").append('\
							<div class="thubmnail-recent">\
				                <img src="'+value.imageUrl+'" class="recent-thumb" alt="">\
				                <h2><a href="/products?product='+value.name+'">'+value.name+'</a></h2>\
				                <div class="product-sidebar-price">\
				                    <ins>Rs. '+value.price+'</ins>\
				                </div>\
							</div>\
					');
				}
				
				ajax3(allCategoriesUrl);
			},
			error: function(){
				ajax3(allCategoriesUrl);
				console.log("ajax2 error");
			}
		});
	}
	
	
		$.ajax({
			type: "GET",
			url: theUrl,
			success: function(data){
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
				$("#descriptionText").append(data.description);
						
				theCategory = data.category.name;
				var relatedUrl = window.location.protocol + "//" + window.location.host +"/api/category/"+theCategory;
				ajax2(relatedUrl);
			},
			error: function(){
				ajax3(allCategoriesUrl);
				console.log("ajax error");
			}
		});
		
		
		
			
		});