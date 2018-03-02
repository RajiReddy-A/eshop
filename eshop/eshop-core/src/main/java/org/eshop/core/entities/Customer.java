package org.eshop.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
	
    @Column(name="firstname", nullable=false)
    @NotEmpty
    private String firstName;
    
    @Column(name="lastname")
    private String lastName;
    
    @NotEmpty
    @Email
    @Column(name="email", nullable=false, unique=true)
    private String email;
    
    @JsonIgnore
    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;
    
    @NotEmpty
    @Column(name="phone", nullable=false, unique=true)
    private String phone;

    public Customer() {
    	
    }
    
	public Customer(Integer id, String firstName, String lastName, String email, String password, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    
}
