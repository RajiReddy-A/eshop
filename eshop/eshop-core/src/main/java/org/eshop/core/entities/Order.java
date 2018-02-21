package org.eshop.core.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;
	
    @Column(name="orderNumber", nullable=false, unique=true)
    private String orderNumber;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    private Set<OrderItem> items;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="customerId")
    private Customer customerId;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="deliveryAddressId")
    private Address deliveryAddressId;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="billingAddressId")
    private Address billingAddressId;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="paymentId")
    private Payment paymentId;
    
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private OrderStatus status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdOn")
    private Date createdOn;

    public Order() {
    	
    }
    
	public Order(Integer id, String orderNumber, Customer customerId, Address deliveryAddressId,
			Address billingAddressId, Payment paymentId, Date createdOn) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.customerId = customerId;
		this.deliveryAddressId = deliveryAddressId;
		this.billingAddressId = billingAddressId;
		this.paymentId = paymentId;
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Address getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Address deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Address getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(Address billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public Payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
    
    

}
