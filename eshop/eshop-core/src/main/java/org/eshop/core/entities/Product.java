package org.eshop.core.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="products")
public class Product {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
  
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="price", nullable=false)
    private BigDecimal price = new BigDecimal("0.0");
    
    @Column(name="imageUrl")
    private String imageUrl;
    
    @Column(name="disabled")
    private boolean disabled;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdOn")
    private Date createdOn = new Date();
     
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category category;

    public Product() {
    	
    }
    
	public Product(Integer id, String name, String description, BigDecimal price, String imageUrl, boolean disabled,
			Date createdOn, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.disabled = disabled;
		this.createdOn = createdOn;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
    

}
