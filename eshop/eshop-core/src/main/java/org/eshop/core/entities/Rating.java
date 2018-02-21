package org.eshop.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class Rating {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name="productId")
    private Product product;
	
	@ManyToOne
    @JoinColumn(name="customerId")
    private Customer customerId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="review")
	private String review;

	public Rating() {
		
	}
	
	public Rating(Integer id, Product product, Customer customerId, int rating, String review) {
		super();
		this.id = id;
		this.product = product;
		this.customerId = customerId;
		this.rating = rating;
		this.review = review;
	}
	
	

}
