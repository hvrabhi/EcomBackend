package org.spring.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Category {

	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	@OneToMany(targetEntity=Product.class, fetch = FetchType.EAGER, mappedBy = "category", cascade =CascadeType.ALL)
	 private Set<Product> products = new HashSet<Product>(0);
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getId() {
		return cid;
	}
	public void setId(int id) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
